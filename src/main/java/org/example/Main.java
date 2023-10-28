package org.example;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //we have maintained in this way if the balance is negative then user has to pay this much of amount and if hae has a postive
        // amount then he will  get this amount

        User user = new User("utkarsh", "12", "7078667617", 0);
        User user1 = new User("rajershi", "13", "9711291961", 0);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        ExpenseGroup expenseGroup = new ExpenseGroup("party", userList);

        List<User> allUsers = expenseGroup.getAllUsers();
        for(User user2:allUsers){
            System.out.println(user2.getName()+" "+" "+user2.getBalance());

        }

        Map<User,Double>map=new HashMap<>();
        map.put(user1,87.2);
        SplitService splitService=new SplitService("PERCENT",map,expenseGroup,user,10000);
        splitService.addExpenseForUsers();
        for(User user2:allUsers){
            System.out.println(user2.getName()+" "+" "+user2.getBalance());

        }
        splitService.setSplittype("EQUAL");
        splitService.setAmount(5000);
        splitService.addExpenseForUsers();

        for(User user2:allUsers){
            System.out.println(user2.getName()+" "+" "+user2.getBalance());

        }
        splitService.setSplittype("EQUAL");
        splitService.setUser(user1);
        splitService.addExpenseForUsers();

        for(User user2:allUsers){
            System.out.println(user2.getName()+" "+" "+user2.getBalance());

        }


    }

}