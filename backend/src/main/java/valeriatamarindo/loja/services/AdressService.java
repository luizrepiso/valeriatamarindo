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
import valeriatamarindo.loja.entities.Adress;
import valeriatamarindo.loja.repositories.AdressRepository;
import valeriatamarindo.loja.services.exceptions.DatabaseException;
import valeriatamarindo.loja.services.exceptions.ResourceNotFoundException;

@Service
public class AdressService {

	@Autowired
	private AdressRepository repository;

	@Transactional(readOnly = true)
	public Page<AdressDTO> findAllPaged(PageRequest pageRequest) {
		Page<Adress> list = repository.findAll(pageRequest);
		return list.map(x -> new AdressDTO(x));

	}

	@Transactional(readOnly = true)
	public AdressDTO findById(Long id) {
		Optional<Adress> obj = repository.findById(id);
		Adress entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new AdressDTO(entity);

	}

	@Transactional
	public AdressDTO insert(AdressDTO dto) {
		Adress entity = new Adress();
		entity.setStreet(dto.getStreet());
		entity = repository.save(entity);
		return new AdressDTO(entity);
	}

	@Transactional
	public AdressDTO update(Long id, AdressDTO dto) {
		try {
			Adress entity = repository.getOne(id);
			entity.setStreet(dto.getStreet());
			entity = repository.save(entity);
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

}
