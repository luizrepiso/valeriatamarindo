package valeriatamarindo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
