package com.rtr.api.api.service.abstraction;

import com.rtr.api.application.event.command.Command;
import com.rtr.api.application.event.query.Query;

public interface ServiceMediator {
    public Object handleQuery(Query query);
    public void handleCommand(Command request);
}
