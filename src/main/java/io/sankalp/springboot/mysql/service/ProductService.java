package io.sankalp.springboot.mysql.service;

import io.sankalp.springboot.mysql.entity.Product;
import io.sankalp.springboot.mysql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct (Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts (List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts () {
        return productRepository.findAll();
    }

    public Product getProduct (Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProduct (String name) {
        return productRepository.findByName (name);
    }

    public String deleteProduct (Integer id) {
        productRepository.deleteById(id);
        return "Product Removed : " + id;
    }

    public String updateProduct (Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);

        if (Objects.nonNull(existingProduct)) {
            productRepository.deleteById(existingProduct.getId());
            productRepository.save(product);
        } else {
            return "Product not found!";
        }

        return "Product updated! New Id is: " + product.getId();
    }
}
