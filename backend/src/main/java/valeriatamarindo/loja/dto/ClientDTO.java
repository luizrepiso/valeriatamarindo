package valeriatamarindo.loja.dto;

import java.io.Serializable;
import java.util.*;

import valeriatamarindo.loja.entities.Address;
import valeriatamarindo.loja.entities.Category;
import valeriatamarindo.loja.entities.Client;
import valeriatamarindo.loja.entities.Product;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    private String cpf;
    private String phone;

    private String email;


    private Set<AddressDTO> addresses= new HashSet<>();


    public ClientDTO() {

    }


    public ClientDTO(Long id, String name, String cpf, String phone, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.email = email;



    }

    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cpf = entity.getCpf();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();


    }

    public ClientDTO(Client entity, Set<Address> addresses) {
        this(entity);
        addresses.forEach(add -> this.addresses.add(new AddressDTO(add)));
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressDTO> addresses) {
        this.addresses = addresses;
    }
}
