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
	public PaymentDTO findById(Long clientId) {
		Optional<Payment> obj = repository.findById(clientId);
		Payment entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new PaymentDTO(entity);

	}

	@Transactional
	public PaymentDTO insert(PaymentDTO dto) {
		Payment entity = new Payment();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new PaymentDTO(entity);
	}

	@Transactional
	public PaymentDTO update(Long clientId, PaymentDTO dto) {
		try {
			Payment entity = repository.getOne(clientId);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new PaymentDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + clientId);
		}
	}

	public void delete(Long clientId) {
		try {
			repository.deleteById(clientId);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(" Id not found " + clientId);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}

	}

}
