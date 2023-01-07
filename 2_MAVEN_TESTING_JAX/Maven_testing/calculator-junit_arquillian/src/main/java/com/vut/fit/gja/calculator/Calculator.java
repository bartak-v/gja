package com.vut.fit.gja.calculator;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Calculator {
 
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int divide(int a, int b) {
        return a/b;
    }
}
