package mock;

import com.rtr.api.application.dto.request.AllIngredientsQuery;
import com.rtr.api.application.dto.request.AllProductsQuery;
import com.rtr.api.application.dto.request.AllPropertiesQuery;
import com.rtr.api.application.dto.request.AllTraitsQuery;
import com.rtr.api.application.dto.response.IngredientDto;
import com.rtr.api.application.dto.response.PropertyDto;
import com.rtr.api.application.dto.response.TraitDto;
import com.rtr.api.api.service.abstraction.ServiceMediator;
import com.rtr.api.application.dto.response.ProductDto;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class MockProductService implements ServiceMediator {
    public Object handleQuery(Object request) {
        if(request instanceof AllProductsQuery) return new ArrayList<ProductDto>(){{
            add(new ProductDto(){{
                setName("Test ProductDto");
            }});
        }};
        if(request instanceof AllIngredientsQuery) return new ArrayList<IngredientDto>(){{
            add(new IngredientDto(){{
                setName("Test IngredientDto");
            }});
        }};
        if(request instanceof AllPropertiesQuery) return new ArrayList<PropertyDto>(){{
            add(new PropertyDto(){{
                setName("Test PropertyDto");
            }});
        }};
        if(request instanceof AllTraitsQuery) return new ArrayList<TraitDto>(){{
            add(new TraitDto(){{
                setName("Test TraitDto");
            }});
        }};
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }

    public void handleCommand(Object request) {
        return;
    }
}
