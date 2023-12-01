package valeriatamarindo.loja.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import valeriatamarindo.loja.entities.Category;
import valeriatamarindo.loja.entities.Product;
import valeriatamarindo.loja.entities.Role;
import valeriatamarindo.loja.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "campo obrigatório")
	private String name;
	private String email;

	@NotEmpty(message= "Usuário sem função não é permitido")
	private List<RoleDTO> roles = new ArrayList<>();

	public UserDTO() {

	}

	public UserDTO(Long id, String name, String email) {
		this.id = id;
		this.name = name;

		this.email = email;

	}

	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();


	}

	public UserDTO(User entity, Set<Role> roles) {
		this(entity);
		roles.forEach(role -> this.roles.add(new RoleDTO(role)));
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

	public String getEmail() {
		return email;
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
}