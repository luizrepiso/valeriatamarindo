package valeriatamarindo.loja.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Instant date;

	private String status;
	private Double totalOrder;
	private String typePayment;
	
	@OneToMany(mappedBy = "order")
    Set<Product> product = new HashSet<>();
	
	@OneToMany(mappedBy = "order") 
	Set<Payment> payment = new HashSet<>();
	
	 @ManyToOne
	 private Client client;
	
	public Order() {

	}

	public Order(Long id, Instant date, String status, Double totalOrder, String typePayment) {
		this.id = id;
		this.date = date;
		this.status = status;
		this.totalOrder = totalOrder;
		this.typePayment = typePayment;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTypePayment() {
		return typePayment;
	}

	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}
	
//	public Set<Product> getProduct() {
//		return product;
//	}
//	
	public Set<Payment> getPayment() {
		return payment;
	}
		
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
