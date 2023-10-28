package org.example;

public class EqualType implements SplitType{

    SplitService splitService;

    @Override
    public double getPart(User user,double amount) {
        return amount/splitService.getAllUsers().size();
    }
    public EqualType(SplitService splitService) {
        this.splitService = splitService;
    }

}
