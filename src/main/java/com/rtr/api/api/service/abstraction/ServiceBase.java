package com.rtr.api.api.service.abstraction;

public interface ServiceBase<T> {
    public Object handleQuery(Object request);
    public void handleCommand(Object request);

}
