package valeriatamarindo.loja.dto;

import valeriatamarindo.loja.entities.Address;
import valeriatamarindo.loja.entities.Category;
import valeriatamarindo.loja.entities.Client;
import valeriatamarindo.loja.entities.Product;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddressDTO {

	private Long id;
	private String street;
	private String number;
	private String district;

	private String city;

	private String postalCode;

	private String complement;


	public AddressDTO() {

	}


	public AddressDTO(Long id, String street, String number, String district, String city, String postalCode, String complement) {
		this.id =id;
		this.street = street;
		this.number = number;
		this.district = district;
		this.city = city;
		this.postalCode = postalCode;
		this.complement = complement;

	}

	public AddressDTO(Address entity) {
		this.id = entity.getId();
		this.street = entity.getStreet();
		this.number = entity.getNumber();
		this.district = entity.getDistrict();
		this.city = entity.getCity();
		this.postalCode = entity.getPostalCode();
		this.complement = entity.getComplement();

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}


}

