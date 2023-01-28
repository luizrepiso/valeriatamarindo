package valeriatamarindo.loja.dto;

import java.io.Serializable;
import java.time.Instant;

import valeriatamarindo.loja.entities.Payment;

public class PaymentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long clientId;
	private String name;
	private Instant date;
	private String formPayment;

	public PaymentDTO(Long clientId, String name, Instant date, String formPayment) {
		this.clientId = clientId;
		this.name = name;
		this.date = date;
		this.formPayment = formPayment;
	}
	
	public PaymentDTO(Payment entity) {
		this.clientId = entity.getClientId();
		this.name = entity.getName();
		this.date = entity.getDate();
		this.formPayment = entity.getFormPayment();
		
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

	public String getFormPayment() {
		return formPayment;
	}

	public void setFormPayment(String formPayment) {
		this.formPayment = formPayment;
	}
}
