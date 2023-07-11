package valeriatamarindo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.PaymentItem;

@Repository
public interface PaymentItemRepository extends JpaRepository<PaymentItem, Long>{

}
