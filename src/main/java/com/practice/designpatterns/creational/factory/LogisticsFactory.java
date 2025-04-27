package com.practice.designpatterns.creational.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class LogisticsFactory {

    private static final Map<String, Logistic> LOGISTICS = new HashMap<>();
    
    @Autowired
    private List<Logistic> logistics;
    
    @PostConstruct
    public void init() {
        for(Logistic logistic : logistics) {
            LOGISTICS.put(logistic.getType(), logistic);
        }
    }
    
    public static Logistic getFactory(String type) throws Exception {
        return LOGISTICS.get(type);
    }
    
}
