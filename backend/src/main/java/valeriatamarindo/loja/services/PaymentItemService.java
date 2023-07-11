package valeriatamarindo.loja.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import valeriatamarindo.loja.dto.PaymentItemDTO;
import valeriatamarindo.loja.entities.PaymentItem;
import valeriatamarindo.loja.repositories.PaymentItemRepository;
import valeriatamarindo.loja.services.exceptions.DatabaseException;
import valeriatamarindo.loja.services.exceptions.ResourceNotFoundException;

@Service
public class PaymentItemService {
	
	@Autowired
	private PaymentItemRepository repository;

	@Transactional(readOnly = true)
	public Page<PaymentItemDTO> findAllPaged(PageRequest pageRequest) {
		Page<PaymentItem> list = repository.findAll(pageRequest);
		return list.map(x -> new PaymentItemDTO(x));

	}

	@Transactional(readOnly = true)
	public PaymentItemDTO findById(Long id) {
		Optional<PaymentItem> obj = repository.findById(id);
		PaymentItem entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new PaymentItemDTO(entity);

	}

	@Transactional
	public PaymentItemDTO insert(PaymentItemDTO dto) {
		PaymentItem entity = new PaymentItem();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new PaymentItemDTO(entity);
	}

	@Transactional
	public PaymentItemDTO update(Long id, PaymentItemDTO dto) {
		try {
			PaymentItem entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new PaymentItemDTO(entity);
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

	private void copyDtoToEntity(PaymentItemDTO dto, PaymentItem entity) {

		entity.setId(dto.getId());
		entity.setTotalInstallments(dto.getTotalInstallments());
		entity.setPayment(dto.getPayment());
		entity.setPaymentStatus(dto.getPaymentStatus());
		entity.setType(dto.getType());
	}
	
	public Double sumInstallments(List<PaymentItemDTO> items) {
		Double total = 0.0;
		items.forEach(item -> {
			Double.sum(total, item.getTotalInstallments());
		});
		return total;
	}

}
