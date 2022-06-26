package mock;

import com.rtr.api.application.dto.ProductDto;
import com.rtr.api.application.event.command.Command;
import com.rtr.api.application.event.query.AllProductsQuery;
import com.rtr.api.application.event.query.Query;
import com.rtr.api.application.service.abstraction.ServiceMediator;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class MockProductService implements ServiceMediator {
    public Object handleQuery(Query query) {
        if(query instanceof AllProductsQuery) return new ArrayList<ProductDto>(){{
            add(new ProductDto(){{
                setName("Test ProductDto");
            }});
        }};
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }

    public void handleCommand(Command command) {
        return;
    }
}
