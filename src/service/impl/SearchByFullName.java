package service.impl;

import entity.*;
import service.ISearch;

public class SearchByFullName implements ISearch {
    @Override
    public void search(String input) {
        for (User user : UserService.users) {
//            if (user.getFullName().equals(input)) {
            if (input.equals(user.getFullName())) {
                System.out.println(user);
                break;
            }
        }
    }
}
