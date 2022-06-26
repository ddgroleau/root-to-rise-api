package com.rtr.api.application.service.implementation;

import com.rtr.api.application.service.abstraction.ServiceMediator;
import com.rtr.api.application.domain.model.Product;
import com.rtr.api.application.event.command.Command;
import com.rtr.api.application.event.query.AllProductsQuery;
import com.rtr.api.application.dto.ProductDto;
import com.rtr.api.application.event.query.Query;
import com.rtr.api.application.repository.abstraction.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;

@Service("product")
public class ProductService implements ServiceMediator {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    public ProductService(ProductRepository productRepository) {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        this.productRepository = productRepository;
    }
    public Object handleQuery(Query query) {
        if(query instanceof AllProductsQuery) return this.getAllProductsQuery();
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }
    public void handleCommand(Command command) {
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }
    private Iterable<ProductDto> getAllProductsQuery() {
        Iterable<Product> products = productRepository.findAll();
        ArrayList<ProductDto> productDtos = new ArrayList<ProductDto>();
        for (Product product: products) {
            ProductDto productDto = modelMapper.map(product,ProductDto.class);
            productDtos.add(productDto);
        }
        return productDtos;
    }
}
