package com.rtr.api.application.service.implementation;
import com.rtr.api.application.domain.model.Product;
import com.rtr.api.application.repository.abstraction.ProductRepository;
import com.rtr.api.web.service.abstraction.ProductServiceInterface;
import org.springframework.stereotype.Component;

@Component
public class ProductService implements ProductServiceInterface {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
