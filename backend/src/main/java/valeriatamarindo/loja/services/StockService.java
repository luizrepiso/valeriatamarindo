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

import valeriatamarindo.loja.dto.StockDTO;
import valeriatamarindo.loja.entities.Stock;
import valeriatamarindo.loja.repositories.StockRepository;
import valeriatamarindo.loja.services.exceptions.DatabaseException;
import valeriatamarindo.loja.services.exceptions.ResourceNotFoundException;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;

	@Transactional(readOnly = true)
	public Page<StockDTO> findAllPaged(PageRequest pageRequest) {
		Page<Stock> list = repository.findAll(pageRequest);
		return list.map(x -> new StockDTO(x));

	}

	@Transactional(readOnly = true)
	public StockDTO findById(Long id) {
		Optional<Stock> obj = repository.findById(id);
		Stock entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new StockDTO(entity);

	}

	@Transactional
	public StockDTO insert(StockDTO dto) {
		Stock entity = new Stock();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new StockDTO(entity);
	}

	@Transactional
	public StockDTO update(Long id, StockDTO dto) {
		try {
			Stock entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new StockDTO(entity);
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

	private void copyDtoToEntity(StockDTO dto, Stock entity) {

		entity.setDate(dto.getDate());
		entity.setQuantity(dto.getQuantity());

	}

}
