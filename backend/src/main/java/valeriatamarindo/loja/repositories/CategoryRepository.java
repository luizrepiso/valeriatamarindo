package valeriatamarindo.loja.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import valeriatamarindo.loja.entities.Category;
import valeriatamarindo.loja.entities.Product;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query("SELECT DISTINCT obj FROM Category obj  WHERE "
           + "(LOWER (obj.name) LIKE LOWER (CONCAT('%', :name, '%')))")
    Page<Category> find(String name, Pageable pageable);



}
