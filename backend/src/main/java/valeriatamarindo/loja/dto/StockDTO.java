package valeriatamarindo.loja.dto;

import java.io.Serializable;
import java.time.Instant;

import valeriatamarindo.loja.entities.Stock;

public class StockDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long productId;
	private Instant date;
	private Integer quantity;

	public StockDTO() {

	}

	public StockDTO(Long id, Long productId, Instant date, Integer quantity) {
		this.id = id;
		this.productId = productId;
		this.date = date;
		this.quantity = quantity;
	}

	public StockDTO(Stock entity) {
		this.id = entity.getId();
		this.productId = entity.getProductId();
		this.date = entity.getDate();
		this.quantity = entity.getQuantity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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