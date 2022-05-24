package com.rtr.api.web.service.abstraction;

import com.rtr.api.application.domain.model.Product;

import java.util.Optional;

public interface ServiceBase<T> {
    public Object handleQuery(Object request);
    public void handleCommand(Object request);

}
