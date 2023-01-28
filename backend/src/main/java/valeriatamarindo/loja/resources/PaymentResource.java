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

import valeriatamarindo.loja.dto.PaymentDTO;
import valeriatamarindo.loja.services.PaymentService;

@RestController
@RequestMapping(value = "/payment")
public class PaymentResource {

	@Autowired
	private PaymentService service;

	@GetMapping
	public ResponseEntity<Page<PaymentDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<PaymentDTO> list = service.findAllPaged(pageRequest);

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{clientId}")
	public ResponseEntity<PaymentDTO> findById(@PathVariable Long clientId) {
		PaymentDTO dto = service.findById(clientId);
		return ResponseEntity.ok().body(dto);

	}

	@PostMapping
	public ResponseEntity<PaymentDTO> insert(@RequestBody PaymentDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{clientId}").buildAndExpand(dto.getClientId()).toUri();
		return ResponseEntity.created(uri).body(dto);

	}

	@PutMapping(value = "/{clientId}")
	public ResponseEntity<PaymentDTO> insert(@PathVariable Long clientId, @RequestBody PaymentDTO dto) {
		dto = service.update(clientId, dto);
		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping(value = "/{clientId}")
	public ResponseEntity<PaymentDTO> delete(@PathVariable Long clientId) {
		service.delete(clientId);
		return ResponseEntity.noContent().build();

	}
}