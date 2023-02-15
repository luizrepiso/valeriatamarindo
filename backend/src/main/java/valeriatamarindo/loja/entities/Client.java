package valeriatamarindo.loja.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@NotNull(message = "CPF não pode ser nulo")
	private String cpf;
	
	private String phone;
	
	@OneToMany
	@JoinColumn(name = "client_id")
	private Set<Order> order = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "tb_client_adress", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "adress_id"))
	Set<Adress> adress = new HashSet<>();
	

	public Client() {

	}
	
	public Client(Long id, String name, String cpf, String phone) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;		
		this.phone = phone;
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Order> getOrder() {
		return order;
	}
	
	public Set<Adress> getAdress() {
		return adress;
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
