package valeriatamarindo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
