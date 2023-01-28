package valeriatamarindo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
