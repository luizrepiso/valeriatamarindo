package valeriatamarindo.loja.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.Address;
import valeriatamarindo.loja.entities.Category;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

    @Query("SELECT DISTINCT obj FROM Address obj  WHERE "
            + "(LOWER (obj.street) LIKE LOWER (CONCAT('%', :street, '%')))")
    Page<Address> find(String street, Pageable pageable);

}
