package com.rtr.api.application.service.implementation;

import com.rtr.api.application.domain.model.Product;
import com.rtr.api.application.dto.request.AllProductsQuery;
import com.rtr.api.application.dto.response.ProductDto;
import com.rtr.api.application.repository.abstraction.IngredientRepository;
import com.rtr.api.application.repository.abstraction.ProductRepository;
import com.rtr.api.api.service.abstraction.ServiceMediator;
import com.rtr.api.application.repository.abstraction.PropertyRepository;
import com.rtr.api.application.repository.abstraction.TraitRepository;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;

@Service
@Qualifier("product")
public class ProductService implements ServiceMediator {
    private final ProductRepository productRepository;
    private final IngredientRepository ingredientRepository;
    private final PropertyRepository propertyRepository;
    private final TraitRepository traitRepository;
    private final ModelMapper modelMapper;
    public ProductService(
            ProductRepository productRepository,
            IngredientRepository ingredientRepository,
            PropertyRepository propertyRepository,
            TraitRepository traitRepository) {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        this.productRepository = productRepository;
        this.ingredientRepository = ingredientRepository;
        this.propertyRepository = propertyRepository;
        this.traitRepository = traitRepository;
    }
    public Object handleQuery(Object request) {
        if(request instanceof AllProductsQuery) return this.getAllProductsQuery();
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }
    public void handleCommand(Object request) {

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
