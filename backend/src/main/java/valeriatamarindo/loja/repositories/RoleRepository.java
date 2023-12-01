package valeriatamarindo.loja.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.Category;
import valeriatamarindo.loja.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT DISTINCT obj FROM Role obj WHERE "
            + "(LOWER (obj.authority) LIKE LOWER (CONCAT('%', :authority, '%')))")
    Page<Role> find(String authority, Pageable pageable);
}
