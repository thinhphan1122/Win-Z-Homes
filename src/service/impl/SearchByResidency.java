package service.impl;

import entity.*;
import service.ISearch;

import java.util.Scanner;

public class SearchByResidency implements ISearch {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void search(String buildingName) {
        System.out.println("Room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();
        for (User user : UserService.users) {
            if (user instanceof Customer) {
                if (((Customer) user).getBuildingName().equals(buildingName)
                 && ((Customer) user).getRoom().getRoomNumber() == roomNumber) {
                    System.out.println(user);
                }
            }
        }
    }
}