package valeriatamarindo.loja.dto;

import java.io.Serializable;

import valeriatamarindo.loja.entities.Payment;
import valeriatamarindo.loja.entities.PaymentItem;
import valeriatamarindo.loja.enuns.PaymentStatus;
import valeriatamarindo.loja.enuns.Type;

public class PaymentItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Payment payment;
	private PaymentStatus paymentStatus;
	private Type type;
	private Double totalInstallments;


	public PaymentItemDTO() {
	}

	public PaymentItemDTO(Long id, Type type, PaymentStatus paymentStatus, Double totalInstallments, Payment payment) {

		this.id = id;		
		this.payment = payment;
		this.paymentStatus= paymentStatus;
		this.type = type;
		this.totalInstallments = totalInstallments;
	}
	
	
	public PaymentItemDTO(PaymentItem entity) {
		this.id = entity.getId();
		this.payment = entity.getPayment();
		this.paymentStatus = entity.getPaymentStatus();
		this.type = entity.getType();
		this.totalInstallments = entity.getTotalInstallments();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Double getTotalInstallments() {
		return totalInstallments;
	}

	public void setTotalInstallments(Double totalInstallments) {
		this.totalInstallments = totalInstallments;
	}

}
