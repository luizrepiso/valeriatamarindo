package valeriatamarindo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.Address;

@Repository
public interface AdressRepository extends JpaRepository<Address, Long>{

}
