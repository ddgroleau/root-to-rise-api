package com.rtr.api.application.service.implementation;

import com.rtr.api.application.domain.model.Product;
import com.rtr.api.application.dto.ProductDto;
import com.rtr.api.application.repository.abstraction.ProductRepository;
import com.rtr.api.api.service.abstraction.ServiceBase;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;

@Service
@Qualifier("product")
public class ProductService implements ServiceBase {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Object handleQuery(Object request) {
        if(request == null) return this.getAllProductsQuery();
        if (request instanceof ProductDto) return this.getProductByIdQuery((String) request);
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }
    public void handleCommand(Object request) {

    }
    private Iterable<ProductDto> getAllProductsQuery() {
        Iterable<Product> products = productRepository.findAll();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        ArrayList<ProductDto> productDtos = new ArrayList<ProductDto>();
        for (Product product: products) {
            ProductDto productDto = modelMapper.map(product,ProductDto.class);
            productDtos.add(productDto);
        }
        return productDtos;
    }
    private ProductDto getProductByIdQuery(String id) {
        return new ProductDto();
    }
}
