package valeriatamarindo.loja.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import valeriatamarindo.loja.entities.Payment;
import valeriatamarindo.loja.entities.PaymentItem;

public class PaymentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant date;
	private Double Installments;
	private Double totalAmount;
	
	private List<PaymentItemDTO> paymentItem = new ArrayList<>();

	public PaymentDTO() {
	}	

	public PaymentDTO(Long id, Long client, Instant date, Double installments, Double totalAmount, Long order) {
		this.id = id;
		this.date = date;
		this.Installments = installments;
		this.totalAmount = totalAmount;
	}
	
	public PaymentDTO(Payment entity) {
		this.id = entity.getId();
		this.date = entity.getDate();
		this.Installments = entity.getInstallments();
		this.totalAmount = entity.getTotalAmount();
				
		}
	
	public PaymentDTO(Payment entity, Set<PaymentItem> paymentItem) {
		this(entity);
		paymentItem.forEach(pay -> this.paymentItem.add(new PaymentItemDTO(pay)));
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



	public Double getInstallments() {
		return Installments;
	}



	public void setInstallments(Double installments) {
		Installments = installments;
	}
	

	public Double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<PaymentItemDTO> getPaymentItem() {
		return paymentItem;
	}
	
	

}