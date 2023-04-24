package com.example.RetoFractalBackend.product;

import com.example.RetoFractalBackend.product.errorHandlers.ProductNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "http://34.95.219.44:3000/")
@RestController
public class ProductController {
    private final ProductRepository repository;

    public ProductController (ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping ("/products")
    List<Product> all () {
        return repository.findAll ();
    }

    @PostMapping ("/products")
    Product newProduct (@RequestBody Product newProduct) {
        return repository.save (newProduct);
    }

    @GetMapping ("/products/{id}")
    Product one (@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException (id));
    }

    @PutMapping ("/products/{id}")
    Product replaceProduct (@RequestBody Product newProduct, @PathVariable Long id) {
        return repository.findById(id).map(product -> {
            product.setName (newProduct.getName());
            product.setUnitPrice (newProduct.getUnitPrice ());
            product.setStock (newProduct.getStock());
            product.setTotalPrice(newProduct.getTotalPrice());
            return repository.save (product);
        })
        .orElseGet(() -> {
            newProduct.setId (id);
            return repository.save (newProduct);
        });
    }

    @DeleteMapping ("/products/{id}")
    void deleteProduct (@PathVariable Long id) {
        repository.deleteById(id);
    }
}
