package valeriatamarindo.loja.services;

import java.util.*;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import valeriatamarindo.loja.dto.AddressDTO;
import valeriatamarindo.loja.dto.CategoryDTO;
import valeriatamarindo.loja.entities.Address;
import valeriatamarindo.loja.entities.Category;
import valeriatamarindo.loja.repositories.AddressRepository;
import valeriatamarindo.loja.services.exceptions.DatabaseException;
import valeriatamarindo.loja.services.exceptions.ResourceNotFoundException;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Transactional(readOnly = true)
    public Page<AddressDTO> findAllPaged(String street, Pageable pageable) {
        Page<Address> page = repository.find(street, pageable);
        return page.map(AddressDTO::new);

    }

    @Transactional(readOnly = true)
    public AddressDTO findById(Long id) {
        Optional<Address> obj = repository.findById(id);
        Address entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return new AddressDTO(entity);

    }

    @Transactional
    public AddressDTO insert(AddressDTO dto) {
        Address entity = new Address();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new AddressDTO(entity);
    }

    @Transactional
    public Set<AddressDTO> insertFromSet(Set<AddressDTO> listAddressDto) {
        Set<AddressDTO> setAddress = new HashSet<>();
        for (AddressDTO addressDto : listAddressDto) {
            AddressDTO addDto = insert(addressDto);
            setAddress.add(addDto);
        }
        return setAddress;
    }

    @Transactional
    public AddressDTO update(Long id, AddressDTO dto) {
        try {
            Address entity = repository.getOne(id);
            entity.setStreet(dto.getStreet());
            copyDtoToEntity(dto, entity);
            return new AddressDTO(entity);
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

    public void copyDtoToEntity(AddressDTO dto, Address entity) {
        entity.setId(dto.getId());
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        entity.setDistrict(dto.getDistrict());
        entity.setCity(dto.getCity());
        entity.setPostalCode(dto.getPostalCode());
        entity.setComplement(dto.getComplement());

    }

}
