package com.rtr.api.application.service.implementation;

import com.rtr.api.application.event.query.ProductByIdQuery;
import com.rtr.api.application.service.abstraction.ServiceMediator;
import com.rtr.api.application.domain.model.Product;
import com.rtr.api.application.event.command.Command;
import com.rtr.api.application.event.query.AllProductsQuery;
import com.rtr.api.application.dto.ProductDto;
import com.rtr.api.application.event.query.Query;
import com.rtr.api.application.repository.abstraction.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        if(query instanceof AllProductsQuery) return this.getAllProducts();
        if(query instanceof ProductByIdQuery) return this.getProductById((ProductByIdQuery) query);
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }
    public void handleCommand(Command command) {
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }
    private Iterable<ProductDto> getAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        ArrayList<ProductDto> productDtos = new ArrayList<ProductDto>();
        for (Product product: products) {
            ProductDto productDto = modelMapper.map(product,ProductDto.class);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    private ProductDto getProductById(ProductByIdQuery productByIdQuery) {
        if(productByIdQuery.getProductId() <= 0) throw new InvalidParameterException("Invalid product ID.");

        Optional<Product> product = productRepository.findById(productByIdQuery.getProductId());

        if(product.isPresent()) return modelMapper.map(product,ProductDto.class);

        throw new NoSuchElementException(
                String.format("Could not find element with ID: %s.",productByIdQuery.getProductId())
        );
    }
}
