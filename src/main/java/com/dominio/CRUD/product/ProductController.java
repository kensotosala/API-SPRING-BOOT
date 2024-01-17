package com.dominio.CRUD.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return this.productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        return productService.newProduct(product);
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("productId") Product product) {
        return productService.deleteProduct(product);
    }
}
