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

import valeriatamarindo.loja.dto.PaymentDTO;
import valeriatamarindo.loja.entities.Payment;
import valeriatamarindo.loja.repositories.PaymentRepository;
import valeriatamarindo.loja.services.exceptions.DatabaseException;
import valeriatamarindo.loja.services.exceptions.ResourceNotFoundException;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;

	@Transactional(readOnly = true)
	public Page<PaymentDTO> findAllPaged(PageRequest pageRequest) {
		Page<Payment> list = repository.findAll(pageRequest);
		return list.map(x -> new PaymentDTO(x));

	}

	@Transactional(readOnly = true)
	public PaymentDTO findById(Long id) {
		Optional<Payment> obj = repository.findById(id);
		Payment entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new PaymentDTO(entity);

	}

	@Transactional
	public PaymentDTO insert(PaymentDTO dto) {
		Payment entity = new Payment();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new PaymentDTO(entity);
	}

	@Transactional
	public PaymentDTO update(Long id, PaymentDTO dto) {
		try {
			Payment entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new PaymentDTO(entity);
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

	private void copyDtoToEntity(PaymentDTO dto, Payment entity) {
		entity.setClientId(dto.getClientId());
		entity.setName(dto.getName());
		entity.setDate(dto.getDate());
		entity.setType(dto.getType());

	}
}
