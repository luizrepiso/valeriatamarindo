package valeriatamarindo.loja.dto;

import java.io.Serializable;
import java.time.Instant;

import valeriatamarindo.loja.entities.Order;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant date;
	private String status;
	private Double price;
	private Double sum;

	public OrderDTO() {

	}

	public OrderDTO(Long id, Instant date, String status, Double price, Double sum) {
		this.id = id;
		this.date = date;
		this.status = status;
		this.price = price;
		this.sum = sum;
	}

	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.date = entity.getDate();
		this.status = entity.getStatus();
		this.price = entity.getPrice();
		this.sum = entity.getSum();

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

}
