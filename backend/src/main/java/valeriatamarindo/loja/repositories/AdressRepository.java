package valeriatamarindo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long>{

}
