package mock;

import com.rtr.api.application.event.query.AllIngredientsQuery;
import com.rtr.api.application.event.query.AllProductsQuery;
import com.rtr.api.application.event.query.AllPropertiesQuery;
import com.rtr.api.application.event.query.AllTraitsQuery;
import com.rtr.api.application.dto.IngredientDto;
import com.rtr.api.application.dto.PropertyDto;
import com.rtr.api.application.dto.TraitDto;
import com.rtr.api.api.service.abstraction.ServiceMediator;
import com.rtr.api.application.dto.ProductDto;

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
