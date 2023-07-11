package valeriatamarindo.loja.dto;

import valeriatamarindo.loja.entities.Order;
import valeriatamarindo.loja.entities.OrderItem;
import valeriatamarindo.loja.entities.Product;

public class OrderItemDTO {

	private Long id;
	private Integer quantity;
	private Double value;
	
	public OrderItemDTO() {

	}

	public OrderItemDTO(Long id, Integer quantity, Double value) {
		this.id = id;
		this.quantity = quantity;
		this.value = value;
		
	}
	
	public OrderItemDTO(OrderItem entity) {
		this.id = entity.getId();
		this.quantity = entity.getQuantity();
		this.value = entity.getValue();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}


}
