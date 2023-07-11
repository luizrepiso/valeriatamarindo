package valeriatamarindo.loja.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import valeriatamarindo.loja.entities.Order;
import valeriatamarindo.loja.entities.OrderItem;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant date;
	private Double totalOrder;
	private Long clientId;

	private List<OrderItemDTO> orderItem = new ArrayList<>();

	public OrderDTO() {

	}

	public OrderDTO(Long id, Instant date, Double totalOrder, Long clientId) {
		this.id = id;
		this.date = date;
		this.totalOrder = totalOrder;
		this.clientId = clientId;

	}

	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.date = entity.getDate();
		this.totalOrder = entity.getTotalOrder();

	}

	public OrderDTO(Order entity, Set<OrderItem> orderItem) {
		this(entity);
		orderItem.forEach(ord -> this.orderItem.add(new OrderItemDTO(ord)));
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

	public Double getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(Double totalOrder) {
		this.totalOrder = totalOrder;
	}

	public Long getClientId() {
		return clientId;
	}

	public List<OrderItemDTO> getOrderItem() {
		return orderItem;
	}

}
