package valeriatamarindo.loja.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	private Double cpf;
	private String adress;
	private Double phone;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;

	@ManyToMany
	@JoinTable(name = "tb_product_client", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "client_id"))

	Set<Category> categories = new HashSet<>();

	public Client() {

	}

	
	public Client(Long id, String name, Double cpf, String adress, Double phone, Instant date) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.adress = adress;
		this.phone = phone;
		this.date = date;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getCpf() {
		return cpf;
	}


	public void setCpf(Double cpf) {
		this.cpf = cpf;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public Double getPhone() {
		return phone;
	}


	public void setPhone(Double phone) {
		this.phone = phone;
	}


	public Instant getDate() {
		return date;
	}


	public void setDate(Instant date) {
		this.date = date;
	}


	public Set<Category> getCategories() {
		return categories;
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
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}

}
