package valeriatamarindo.loja.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import valeriatamarindo.loja.enuns.PaymentStatus;
import valeriatamarindo.loja.enuns.Type;

@Entity
@Table(name = "paymentItem")
public class PaymentItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double totalInstallments;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentStatus paymentStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Type type;

	@ManyToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
	

	public PaymentItem() {

	}

	public PaymentItem(Long id, Type type, PaymentStatus paymentStatus, Double totalInstallments, Payment payment) {

		this.id = id;		
		this.payment = payment;
		this.paymentStatus= paymentStatus;
		this.type = type;
		this.totalInstallments = totalInstallments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotalInstallments() {
		return totalInstallments;
	}

	public void setTotalInstallments(Double totalInstallments) {
		this.totalInstallments = totalInstallments;
	}

	public Payment getPayment() {
		return payment;
	}	
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Type getType() {
		return type;
	}	

	public void setType(Type type) {
		this.type = type;
	}	

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
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
		PaymentItem other = (PaymentItem) obj;
		return Objects.equals(id, other.id);
	}

}
