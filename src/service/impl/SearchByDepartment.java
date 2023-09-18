package service.impl;

import entity.Employee;
import entity.User;
import service.ISearch;

public class SearchByDepartment implements ISearch {
    @Override
    public void search(String input) {
        for (User user : UserService.users)
            if (user instanceof Employee) {
                if (((Employee) user).getDepartment().equals(input)) {
                    System.out.println(user);
                }
            }
    }
}