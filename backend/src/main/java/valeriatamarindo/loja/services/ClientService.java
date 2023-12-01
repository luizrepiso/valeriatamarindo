package valeriatamarindo.loja.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import valeriatamarindo.loja.dto.AddressDTO;
import valeriatamarindo.loja.dto.CategoryDTO;
import valeriatamarindo.loja.dto.ClientDTO;
import valeriatamarindo.loja.dto.ProductDTO;
import valeriatamarindo.loja.entities.Address;
import valeriatamarindo.loja.entities.Category;
import valeriatamarindo.loja.entities.Client;
import valeriatamarindo.loja.entities.Product;
import valeriatamarindo.loja.repositories.AddressRepository;
import valeriatamarindo.loja.repositories.ClientRepository;
import valeriatamarindo.loja.services.exceptions.DatabaseException;
import valeriatamarindo.loja.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(Long addressId, String name, Pageable pageable) {
        Address address = (addressId == 0) ? null : addressRepository.getOne(addressId);
        Page<Client> page = repository.find(address,name, pageable);
        repository.findClientsWithAddresses(page.getContent());
        return page.map(x -> new ClientDTO(x, x.getAddresses()));


//    public Page<ClientDTO> findAllPaged(
//            String name, Pageable pageable) {
//        Page<Client> page = repository.find(name, pageable);
//        return page.map(ClientDTO::new);

    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> obj = repository.findById(id);
        Client entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return new ClientDTO(entity, entity.getAddresses());

    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity, entity.getAddresses());
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientDTO(entity);
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

    private void copyDtoToEntity(ClientDTO dto, Client entity) {

        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());

        for (AddressDTO addressDto : dto.getAddresses()) {
            Address address = addressRepository.getOne(addressDto.getId());
            entity.getAddresses().add(address);
        }


    }


}



