package com.rtr.api.application.service.implementation;

import com.rtr.api.application.dto.ProductDto;
import com.rtr.api.application.repository.abstraction.ProductRepository;
import com.rtr.api.web.service.abstraction.ServiceBase;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class ProductService implements ServiceBase {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Object handleQuery(Object request) {
        if (request instanceof ProductDto) return this.getProductByIdQuery((String) request);
        else return this.getAllProductsQuery();
    }
    public void handleCommand(Object request) {

    }

    private Iterable<ProductDto> getAllProductsQuery() {
        return new ArrayList<ProductDto>();
    }

    private ProductDto getProductByIdQuery(String id) {
        return new ProductDto();
    }
}
