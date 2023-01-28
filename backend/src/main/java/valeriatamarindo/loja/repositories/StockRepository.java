package valeriatamarindo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

}
