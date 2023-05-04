package com.kodilla.spring.basic.spring_dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleApplication {



    //2. wstrzykiwanie zaleznosci poprzez pole
//    @Autowired
    private SkypeMessageService messageService;

    //3. wstrzykiwanie zaleznosci poprzez setter
    @Autowired
    public SimpleApplication setMessageService(SkypeMessageService messageService) {
        this.messageService = messageService;
        return this;
    }
    //1. wstrzykiwanie zaleznosci poprzez konstruktor
//    private SkypeMessageService messageService;
//
//    public SimpleApplication(SkypeMessageService messageService) {
//        this.messageService = messageService;
//    }

    public String processMessage(String message, String receiver) {
        if (checkReceiver(receiver)) {
            return this.messageService.send(message, receiver);
        }
        return null;
    }

    private boolean checkReceiver(String receiver) {
        return receiver != null && !receiver.isEmpty();
    }
}
