package com.rtr.api.api.service.abstraction;

public interface ServiceMediator {
    public Object handleQuery(Object request);
    public void handleCommand(Object request);
}
