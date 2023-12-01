package valeriatamarindo.loja.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.Address;
import valeriatamarindo.loja.entities.Category;
import valeriatamarindo.loja.entities.Client;
import valeriatamarindo.loja.entities.Product;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

    @Query("SELECT DISTINCT obj FROM Client obj INNER JOIN obj.addresses address WHERE "
            + "(:address IS NULL OR  :address IN address) AND "
            + "(LOWER (obj.name) LIKE LOWER (CONCAT('%', :name, '%')))")
    Page<Client> find(Address address, String name, Pageable pageable);

    @Query("SELECT obj FROM Client obj JOIN FETCH obj.addresses WHERE obj IN :Clients")
    List<Client> findClientsWithAddresses(List<Client> Clients);


}
