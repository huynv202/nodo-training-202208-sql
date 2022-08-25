package com.example.spring_core.Unit1_SpringCore;



import java.util.logging.Logger;

public class HelloWorld {
    private final static Logger LOGGER = Logger.getLogger(HelloWorld.class.getName());
    private String message;

    public void sayHello() {
        LOGGER.info("From HelloWorld " + message);
    }
}