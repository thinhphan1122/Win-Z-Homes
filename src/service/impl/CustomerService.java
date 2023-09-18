package service.impl;

import entity.*;

import java.util.Scanner;

import static constant.Constants.*;

public class CustomerService {
    private static final Scanner scanner = new Scanner(System.in);

    protected static void addCustomerInformation(User user) {
        registerCustomerCode(user);
    }

    protected static void registerCustomerCode(User user) {
        ((Customer) user).customerCode(generateRandomCustomerCode());
    }

    protected static String generateRandomCustomerCode() {
        StringBuilder customerCode = new StringBuilder("C"); //C = Customer
        int length = 6;
        for (int i = 0; i < length; i++) {
            int random = 1 + (int) (Math.random() * 10);
            customerCode.append(random);
        }
        return customerCode.toString();
    }

    protected static void operateCustomerServices(User user) {
        System.out.println("Would you like to: "
                + "\n" + "1. Edit basic information"
                + "\n" + "2. Search residency information"
                + "\n" + "3. Cancel"
        );

        int flag = scanner.nextInt();
        scanner.nextLine();
        switch (flag) {
            case CONSTANT_EDIT_BASIC_INFORMATION:
                UserService.editUserBasicInformation(user);
                operateCustomerServices(user);
                break;
            case CONSTANT_SEARCH_RESIDENCY_INFORMATION:
                checkRoomResident(user);
                operateCustomerServices(user);
                break;
            case CONSTANT_CANCEL:
                return;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }

    public static void checkRoomResident(User user) {
        Room room = ((Customer) user).getRoom();
        String buildingName = ((Customer) user).getBuildingName();
        for (User user1 : UserService.users) {
            if (user1 instanceof Customer) {
                if (buildingName.equals(((Customer) user1).getBuildingName())
                        && room.equals(((Customer) user1).getRoom()))
                    System.out.println(user1);
            }
        }
    }
}
