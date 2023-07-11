package valeriatamarindo.loja.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import valeriatamarindo.loja.dto.AdressDTO;
import valeriatamarindo.loja.entities.Address;
import valeriatamarindo.loja.repositories.AdressRepository;
import valeriatamarindo.loja.services.exceptions.DatabaseException;
import valeriatamarindo.loja.services.exceptions.ResourceNotFoundException;

@Service
public class AdressService {

	@Autowired
	private AdressRepository repository;

	@Transactional(readOnly = true)
	public Page<AdressDTO> findAllPaged(PageRequest pageRequest) {
		Page<Address> list = repository.findAll(pageRequest);
		return list.map(x -> new AdressDTO(x));

	}

	@Transactional(readOnly = true)
	public AdressDTO findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		Address entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new AdressDTO(entity);

	}

	@Transactional
	public AdressDTO insert(AdressDTO dto) {
		Address entity = new Address();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AdressDTO(entity);
	}

	@Transactional
	public AdressDTO update(Long id, AdressDTO dto) {
		try {
			Address entity = repository.getOne(id);
			entity.setStreet(dto.getStreet());
			copyDtoToEntity(dto, entity);
			return new AdressDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(" Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}

	}
	private void copyDtoToEntity(AdressDTO dto, Address entity) {
		
		entity.setStreet(dto.getStreet());
		entity.setNumber(dto.getNumber());
		entity.setDistrict(dto.getDistrict());
		
	}

}
