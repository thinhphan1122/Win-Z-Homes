package service.impl;

import entity.*;
import service.ISearch;

public class SearchByEmail implements ISearch {

    @Override
    public void search(String input) {
        for (User user : UserService.users) {
            if (user.getEmail().equals(input)) {
                System.out.println(user);
            }
        }
    }
}
