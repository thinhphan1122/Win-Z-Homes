package service.impl;

import entity.*;
import service.ISearch;

public class SearchByUsername implements ISearch {
    @Override
    public void search(String input) {
        for (User user : UserService.users) {
            if (user.getUsername().equals(input) && !input.equals("Admin")) {
                System.out.println(user);
            }
        }
    }
}
