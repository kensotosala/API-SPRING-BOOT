package com.dominio.CRUD.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // @Query("Select * From product p where p.name = ?1")
    Optional<Product> findProductByName(String name);
}
