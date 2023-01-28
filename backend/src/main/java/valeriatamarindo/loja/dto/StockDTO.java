package valeriatamarindo.loja.dto;

import java.io.Serializable;
import java.time.Instant;

import valeriatamarindo.loja.entities.Stock;

public class StockDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String payment;
	private Instant date;
	private String status;

	public StockDTO() {

	}

	public StockDTO(Long id, String payment, Instant date, String status) {
		this.id = id;
		this.payment = payment;
		this.date = date;
		this.status = status;
	}
	
	public StockDTO (Stock entity) {
		this.id = entity.getId();
		this.payment = entity.getPayment();
		this.date = entity.getDate();
		this.status = entity.getStatus();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
