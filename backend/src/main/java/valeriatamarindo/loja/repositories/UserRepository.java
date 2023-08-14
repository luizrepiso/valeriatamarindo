package valeriatamarindo.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
