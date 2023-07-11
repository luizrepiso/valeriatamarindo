package valeriatamarindo.loja.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String street;
	private String number;
	private String district;
	
	@OneToMany
    @JoinColumn(name = "adress_id") 
    private List<Client> client;

	
	public Address() {

	}

	public Address(Long id, String street, String number, String district) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.district = district;
		
	}

	
	public Long getId() {
		return id;

	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public List<Client> getClient() {
		return client;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(street, other.street);
	}

}
