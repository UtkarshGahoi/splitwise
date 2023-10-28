package org.example;

import java.util.List;
import java.util.Map;

public class PercentType implements SplitType{
    SplitService splitService;


    public  PercentType(SplitService splitService){
        this.splitService=splitService;
    }
    @Override
    public double getPart(User user, double amount) {
        Map<User, Double> userShare = splitService.getUserShare();
        List<User> allUsers = splitService.getAllUsers();
                return user.getBalance()+((amount*userShare.get(user))/100);
            }

}
