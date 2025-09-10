package com.sarunasbend.github.logic.movevalidator;

import com.sarunasbend.github.bridge.IPCLogic;
import com.sarunasbend.github.bridge.IPCEvents;

public class MoveValidator {
    public MoveValidator(){

    }

    public void init(){
        addValidators();
    }

    private void addValidators(){
        IPCLogic.handle(IPCEvents.Validator.CHECK_VALID, (args) -> {
            
            return null;
        });
    }
}
