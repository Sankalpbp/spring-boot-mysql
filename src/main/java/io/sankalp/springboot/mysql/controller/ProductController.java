package io.sankalp.springboot.mysql.controller;

import io.sankalp.springboot.mysql.entity.Product;
import io.sankalp.springboot.mysql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct (@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts (@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts () {
        return productService.getProducts();
    }

    @GetMapping("/getProductById/{id}")
    public Product getProduct (@PathVariable Integer id) {
        return productService.getProduct(id);
    }

    @GetMapping("/getProductByName/{name}")
    public Product getProduct (@PathVariable String name) {
        return productService.getProduct(name);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct (@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/updateProduct")
    public String updateProduct (@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}
