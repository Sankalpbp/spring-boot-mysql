package io.sankalp.springboot.mysql.repository;

import io.sankalp.springboot.mysql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);
}
