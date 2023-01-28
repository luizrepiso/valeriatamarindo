package valeriatamarindo.loja.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long clientId;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;
	
	private String name;
	private String formPayment;
	
	public Payment() {

	}
	
	public Payment(Long clientId, Instant date, String name, String formPayment) {
		this.clientId = clientId;
		this.date = date;
		this.name = name;
		this.formPayment = formPayment;
		
	}



	public Long getClientId() {
		return clientId;
	}



	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}



	public Instant getDate() {
		return date;
	}



	public void setDate(Instant date) {
		this.date = date;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getFormPayment() {
		return formPayment;
	}



	public void setFormPayment(String formPayment) {
		this.formPayment = formPayment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(clientId, other.clientId);
	}

}
