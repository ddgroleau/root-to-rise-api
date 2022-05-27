package com.rtr.api.api.service.abstraction;

public interface ServiceBase {
    public Object handleQuery(Object request);
    public void handleCommand(Object request);

}
