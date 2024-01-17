package com.dominio.CRUD.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity<Object> newProduct(Product product) {
        Optional<Product> existingProduct = productRepository.findProductByName(product.getName());
        if (existingProduct.isPresent()) {
            return new ResponseEntity<>(
                    "Product with name " + product.getName() + " already exists",
                    HttpStatus.CONFLICT
            );
        }

        productRepository.save(product);
        return new ResponseEntity<>(
                "Product created successfully",
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> updateProduct(Product product) {
        Optional<Product> existingProduct = productRepository.findById(product.getId());

        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();

            updatedProduct.setName(product.getName());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setDate(product.getDate());

            productRepository.save(updatedProduct);

            return new ResponseEntity<>(
                    "Product updated successfully",
                    HttpStatus.OK
            );

        }
        return new ResponseEntity<>(
                "Product not found for id: " + product.getId(),
                HttpStatus.NOT_FOUND
        );
    }

    public ResponseEntity<Object> deleteProduct(Product product) {
        Optional<Product> existingProduct = productRepository.findById(product.getId());

        if (existingProduct.isPresent()) {
            productRepository.deleteById(product.getId());
            return new ResponseEntity<>(
                    "Product deleted successfully",
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
                "Product not found for id: " + product.getId(),
                HttpStatus.NOT_FOUND
        );
    }
}
