package com.rtr.api.web.service.abstraction;

import com.rtr.api.application.domain.model.Product;
import com.rtr.api.application.repository.abstraction.ProductRepository;

public interface ProductServiceInterface {
    public Iterable<Product> getAllProducts();
}
