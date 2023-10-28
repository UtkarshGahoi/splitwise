package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SplitService {
    String splittype;
    private Map<User,Double> userShare;

    private ExpenseGroup expenseGroup;

    private SplitType splitType;
    private User user;
    double amount;

    public SplitService(String splittype, Map<User, Double> userShare, ExpenseGroup expenseGroup, User user, double amount) {
        this.splittype = splittype;
        this.userShare = userShare;
        this.expenseGroup = expenseGroup;
        this.user = user;
        this.amount = amount;
    }

    public String getSplittype() {
        return splittype;
    }

    public void setSplittype(String splittype) {
        this.splittype = splittype;
    }

    public void setUserShare(Map<User, Double> userShare) {
        this.userShare = userShare;
    }

    public ExpenseGroup getExpenseGroup() {
        return expenseGroup;
    }

    public void setExpenseGroup(ExpenseGroup expenseGroup) {
        this.expenseGroup = expenseGroup;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void addExpenseForUsers( ){
        List<User>allUsers= expenseGroup.getAllUsers();

        if(splittype.equalsIgnoreCase("EXACT")) {
            System.out.println("we are here");
            this.splitType = new ExactType(this);
        } else if (splittype.equals("PERCENT")) {
            this.splitType = new PercentType(this);
        } else if (splittype.equals("EQUAL")) {
            System.out.println("we are equal");
            this.splitType = new EqualType(this);
        } else {
            throw new IllegalArgumentException("Invalid splittype given");
        }
        if (this.splitType instanceof EqualType) {
            double part = splitType.getPart(user, amount);
            System.out.println("the part is"+part);
            for (User user1 : allUsers) {
                if (user1.getId() != user.getId()) {
                    System.out.println(user1.getBalance());
                    user1.setBalance(user1.getBalance() - part);
                }
            }
            user.setBalance(user.getBalance() + (amount - part));

        }
        else if(this.splitType instanceof ExactType){
            System.out.println("the part is"+1111);
            for(User user1:allUsers){
                if(userShare.containsKey(user1)){
                    user1.setBalance(user1.getBalance()+userShare.get(user1));
                }
            }

        }
        else if(this.splitType instanceof PercentType){
            System.out.println("the part is"+222);
            for(User user1:allUsers){
                if(userShare.containsKey(user1)){
                    double part = splitType.getPart(user1, amount);
                    System.out.println(part);
                    System.out.println(user1.getBalance());
                    user1.setBalance(user1.getBalance()-part);
                }

            }
        }
    }
    public List<User>getAllUsers(){
        return expenseGroup.getAllUsers();
    }
    public  Map<User,Double>getUserShare(){
        return userShare;
    }

}
