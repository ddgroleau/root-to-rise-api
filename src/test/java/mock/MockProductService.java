package mock;

import com.rtr.api.api.service.abstraction.ServiceBase;
import com.rtr.api.application.dto.ProductDto;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class MockProductService implements ServiceBase {
    public Object handleQuery(Object request) {
        if(request == null) return new ArrayList<ProductDto>(){{
            add(new ProductDto(){{
                setName("Test ProductDto");
            }});
        }};
        if (request instanceof ProductDto) return new ProductDto();
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }

    public void handleCommand(Object request) {
        return;
    }
}
