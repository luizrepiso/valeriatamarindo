package valeriatamarindo.loja.dto;

import valeriatamarindo.loja.entities.Adress;

public class AdressDTO {

	private String street;
	private String number;
	private String district;

	public AdressDTO() {

	}

	public AdressDTO(String street, String number, String district) {
		this.street = street;
		this.number = number;
		this.district = district;
	}

	public AdressDTO(Adress entity) {
		this.street = entity.getStreet();
		this.number = entity.getNumber();
		this.district = entity.getDistrict();
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
