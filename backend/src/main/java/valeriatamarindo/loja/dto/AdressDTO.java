package valeriatamarindo.loja.dto;

import valeriatamarindo.loja.entities.Address;

public class AdressDTO {

	private Long id;
	private String street;
	private String number;
	private String district;

	public AdressDTO() {

	}

	public AdressDTO(Long id, String street, String number, String district) {
		this.id =id;
		this.street = street;
		this.number = number;
		this.district = district;
	}

	public AdressDTO(Address entity) {
		this.id = entity.getId();
		this.street = entity.getStreet();
		this.number = entity.getNumber();
		this.district = entity.getDistrict();
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

}
