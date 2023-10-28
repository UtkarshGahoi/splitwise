package org.example;

public class ExactType implements SplitType{
    SplitService splitService;

    public ExactType(SplitService splitService) {
        this.splitService= splitService;
    }

    @Override
    public double getPart(User user, double amount) {
        return 0;
    }
}
