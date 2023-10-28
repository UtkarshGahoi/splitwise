package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpenseGroup {
    private String groupName;
    private List<User> userList = new ArrayList<>();

    private double amount;

    public ExpenseGroup(String groupName, List<User> userList) {
        this.groupName = groupName;
        this.userList = userList;
    }

    public void addUserToGroup(User user) {
        userList.add(user);
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public int getSizeOfExpenseGroup() {
        return userList.size();
    }
}
