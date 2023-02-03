package valeriatamarindo.loja.dto;

import java.io.Serializable;
import java.time.Instant;

import valeriatamarindo.loja.entities.Payment;

public class PaymentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long clientId;
	private String name;
	private Instant date;
	private String type;

	public PaymentDTO() {
	}

	public PaymentDTO(Long id, Long clientId, String name, Instant date, String type) {
		this.id = id;
		this.clientId = clientId;
		this.name = name;
		this.date = date;
		this.type = type;
	}

	public PaymentDTO(Payment entity) {
		this.id = entity.getId();
		this.clientId = entity.getClientId();
		this.name = entity.getName();
		this.date = entity.getDate();
		this.type = entity.getType();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}