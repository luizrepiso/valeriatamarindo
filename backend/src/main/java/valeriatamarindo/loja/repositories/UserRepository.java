package valeriatamarindo.loja.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.Category;
import valeriatamarindo.loja.entities.Product;
import valeriatamarindo.loja.entities.Role;
import valeriatamarindo.loja.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	@Query("SELECT DISTINCT obj FROM User obj INNER JOIN obj.roles rols WHERE "
			+ "(:role IS NULL OR  :role IN rols) AND "
			+ "(LOWER (obj.name) LIKE LOWER (CONCAT('%', :name, '%')))")
	Page<User> find(Role role, String name, Pageable pageable);

	@Query("SELECT obj FROM User obj JOIN FETCH obj.roles WHERE obj IN :users")
	List<User> findUsersWithRoles(List<User> users);


}
