package valeriatamarindo.loja.dto;

import java.io.Serializable;
import java.time.Instant;

import valeriatamarindo.loja.entities.Stock;

public class StockDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant date;
	private Integer quantity;

	public StockDTO() {

	}

	public StockDTO(Long id, Instant date, Integer quantity) {
		this.id = id;
		this.date = date;
		this.quantity = quantity;
	}

	public StockDTO(Stock entity) {
		this.id = entity.getId();
		this.date = entity.getDate();
		this.quantity = entity.getQuantity();
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}