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

import valeriatamarindo.loja.dto.OrderDTO;
import valeriatamarindo.loja.entities.Order;
import valeriatamarindo.loja.repositories.OrderRepository;
import valeriatamarindo.loja.services.exceptions.DatabaseException;
import valeriatamarindo.loja.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Transactional(readOnly = true)
	public Page<OrderDTO> findAllPaged(PageRequest pageRequest) {
		Page<Order> list = repository.findAll(pageRequest);
		return list.map(x -> new OrderDTO(x));

	}

	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		Order entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new OrderDTO(entity);

	}

	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order entity = new Order();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new OrderDTO(entity);
	}

	@Transactional
	public OrderDTO update(Long id, OrderDTO dto) {
		try {
			Order entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new OrderDTO(entity);
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
	

	private void copyDtoToEntity(OrderDTO dto, Order entity) {
		
		entity.setDate(dto.getDate());
		entity.setStatus(dto.getStatus());
		entity.setTotalOrder(dto.getTotalOrder());
		entity.setTypePayment(dto.getTypePayment());
		
	}

}
