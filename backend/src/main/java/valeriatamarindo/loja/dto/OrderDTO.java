package valeriatamarindo.loja.dto;

import java.io.Serializable;
import java.time.Instant;

import valeriatamarindo.loja.entities.Order;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant date;
	private String status;
	private Double totalOrder;
	private String typePayment;
	private Long clientId;

	public OrderDTO() {

	}

	public OrderDTO(Long id, Instant date, String status, Double totalOrder, String typePayment, Long clientId) {
		this.id = id;
		this.date = date;
		this.status = status;
		this.totalOrder = totalOrder;
		this.typePayment = typePayment;
		this.clientId = clientId;
	}

	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.date = entity.getDate();
		this.status = entity.getStatus();
		this.totalOrder = entity.getTotalOrder();
		this.typePayment = entity.getTypePayment();
		this.clientId = entity.getClient().getId();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(Double totalOrder) {
		this.totalOrder = totalOrder;
	}

	public String getTypePayment() {
		return typePayment;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setSum(String typePayment) {
		this.typePayment = typePayment;
	}

}
