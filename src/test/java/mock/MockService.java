package mock;

import com.rtr.api.application.dto.IngredientDto;
import com.rtr.api.application.dto.ProductDto;
import com.rtr.api.application.dto.PropertyDto;
import com.rtr.api.application.dto.TraitDto;
import com.rtr.api.application.event.command.Command;
import com.rtr.api.application.event.query.*;
import com.rtr.api.application.service.abstraction.ServiceMediator;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class MockService implements ServiceMediator {
    public Object handleQuery(Query query) {
        if(query instanceof AllProductsQuery)
            return new ArrayList<ProductDto>(){{add(new ProductDto(){{setName("Test ProductDto");}});}};
        if(query instanceof DistinctIngredientNamesQuery)
            return new ArrayList<String>(){{add("TestIngredientDto");}};
        if(query instanceof DistinctPropertyNamesQuery)
            return new ArrayList<String>(){{add("PropertyDto");}};
        if(query instanceof DistinctTraitNamesQuery)
            return new ArrayList<String>(){{add("TraitDto");}};
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }

    public void handleCommand(Command command) {
        throw new UnsupportedOperationException();
    }
}
