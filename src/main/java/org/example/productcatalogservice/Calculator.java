package org.example.productcatalogservice;

public class Calculator {

    int add(int a,int b) {
        return a+b;
    }

    int divide(int a,int b) {
        try {
            return a/b;
        }catch (ArithmeticException ex) {
            throw ex;
        }
    }
}
