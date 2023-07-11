package valeriatamarindo.loja.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import valeriatamarindo.loja.dto.PaymentItemDTO;
import valeriatamarindo.loja.services.PaymentItemService;

@RestController
@RequestMapping(value = "/paymentItem")
public class PaymentItemResource {

	@Autowired
	private PaymentItemService service;

	@GetMapping
	public ResponseEntity<Page<PaymentItemDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "paymentId") String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<PaymentItemDTO> list = service.findAllPaged(pageRequest);

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{clientId}")
	public ResponseEntity<PaymentItemDTO> findById(@PathVariable Long clientId) {
		PaymentItemDTO dto = service.findById(clientId);
		return ResponseEntity.ok().body(dto);

	}

	@PostMapping
	public ResponseEntity<PaymentItemDTO> insert(@RequestBody PaymentItemDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PaymentItemDTO> insert(@PathVariable Long id, @RequestBody PaymentItemDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PaymentItemDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
}