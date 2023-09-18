package service.impl;

import constant.EDepartment;
import constant.EPosition;
import entity.Customer;
import entity.Employee;
import entity.Building;
import entity.Room;
import entity.User;
import factory.UserSearching;
import service.ISearch;

import java.util.Scanner;

import static constant.Constants.*;

public class EmployeeService {
    private static final Scanner scanner = new Scanner(System.in);

    protected static void addEmployeeInformation(User user) {
        registerEmployeeCode(user);
        registerEmployeeDepartment(user);
        registerEmployeePosition(user);
        calculateEmployeeSalary(user);
    }

    protected static void registerEmployeeCode(User user) {
        ((Employee) user).setEmployeeCode(generateRandomEmployeeCode());
    }

    protected static String generateRandomEmployeeCode() {
        StringBuilder employeeCode = new StringBuilder("E"); //E = Employee
        int length = 6;
        for (int i = 0; i < length; i++) {
            int random = 1 + (int) (Math.random() * 10);
            employeeCode.append(random);
        }
        return employeeCode.toString();
    }

    protected static void registerEmployeeDepartment(User user) {
        System.out.println("Department: "
                + "\n" + "1. Finance"
                + "\n" + "2. Sales & Marketing"
                + "\n" + "3. Legal"
                + "\n" + "4. Information Technology"
                + "\n" + "5. Human Resources"
                + "\n" + "6. House Keeping"
                + "\n" + "7. Security"
                + "\n" + "8. Management"
                + "\n" + "9. Cancel"
        );

        int flag = scanner.nextInt();
        scanner.nextLine();
        switch (flag) {
            case CONSTANT_FINANCE:
                ((Employee) user).setDepartment(String.valueOf(EDepartment.FINANCE));
                break;
            case CONSTANT_SALES_AND_MARKETING:
                ((Employee) user).setDepartment(String.valueOf(EDepartment.SALES_AND_MARKETING));
                break;
            case CONSTANT_LEGAL:
                ((Employee) user).setDepartment(String.valueOf(EDepartment.LEGAL));
                break;
            case CONSTANT_INFORMATION_TECHNOLOGY:
                ((Employee) user).setDepartment(String.valueOf(EDepartment.INFORMATION_TECHNOLOGY));
                break;
            case CONSTANT_HUMAN_RESOURCES:
                ((Employee) user).setDepartment(String.valueOf(EDepartment.HUMAN_RESOURCES));
                break;
            case CONSTANT_HOUSE_KEEPING:
                ((Employee) user).setDepartment(String.valueOf(EDepartment.HOUSE_KEEPING));
                break;
            case CONSTANT_SECURITY:
                ((Employee) user).setDepartment(String.valueOf(EDepartment.SECURITY));
                break;
            case CONSTANT_CUSTOMER_SERVICE:
                ((Employee) user).setDepartment(String.valueOf(EDepartment.CUSTOMER_SERVICE));
                break;
            case CONSTANT_CANCEL_1:
                break;
        }
    }

    protected static void registerEmployeePosition(User user) {
        System.out.println("Position: "
                + "\n" + "1. Head of The Department"
                + "\n" + "2. Staff"
                + "\n" + "3. Cancel"
        );

        int flag = scanner.nextInt();
        scanner.nextLine();
        switch (flag) {
            case CONSTANT_HEAD_OF_THE_DEPARTMENT:
                ((Employee) user).setPosition(String.valueOf(EPosition.HEAD_OF_THE_DEPARTMENT));
                break;
            case CONSTANT_STAFF:
                ((Employee) user).setPosition(String.valueOf(EPosition.STAFF));
                break;
            case CONSTANT_CANCEL:
                break;
            default:
                System.out.println("Invalid input!");
                registerEmployeeCode(user);
                break;
        }
    }

    protected static long calculateEmployeeSalary(User user) {
        long salary = 10000000;
        if (((Employee) user).getPosition().equals(String.valueOf(EPosition.HEAD_OF_THE_DEPARTMENT))) {
            salary *= 2;
            ((Employee) user).setSalary(salary);
        } else {
            ((Employee) user).setSalary(salary);
        }
        return salary;
    }

    protected static void operateEmployeeServices(User user) {
        System.out.println("Welcome " + user.getUsername() + "!" + " Would you like to:"
                + "\n" + "1. Edit basic information"
                + "\n" + "2. Search for other Customer or Employee"
                + "\n" + "3. Cancel"
        );

        int flag = scanner.nextInt();
        scanner.nextLine();
        switch (flag) {
            case CONSTANT_EDIT_BASIC_INFORMATION:
                UserService.editUserBasicInformation(user);
                break;
            case CONSTANT_SEARCH_USER:
                searchInformation();
                break;
            case CONSTANT_CANCEL:
                return;
            default:
                System.out.println("Invalid input!");
                break;
        }

        if (((Employee) user).getPosition().equals(String.valueOf(EPosition.ADMIN))) {
            editOtherUserInformationByAdmin(user);
        }
    }

    protected static void searchInformation() {
        System.out.println(" Would you like to:"
                + "\n" + "1. Search by Username"
                + "\n" + "2. Search by Full name"
                + "\n" + "3. Search by Email"
                + "\n" + "4. Search by Department"
                + "\n" + "5. Search by Residency (Building - Room)"
                + "\n" + "6. Cancel"
        );

        ISearch iSearch;
        int flag = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Type in the information according to the choosing option:");
        String input = scanner.nextLine();
        switch (flag) {
            case SEARCH_BY_USERNAME:
                iSearch = UserSearching.createISEARCH(SEARCH_BY_USERNAME);
                assert iSearch != null;
                iSearch.search(input);
                break;
            case SEARCH_BY_FULL_NAME:
                iSearch = UserSearching.createISEARCH(SEARCH_BY_FULL_NAME);
                assert iSearch != null;
                iSearch.search(input);
                break;
            case SEARCH_BY_EMAIL:
                iSearch = UserSearching.createISEARCH(SEARCH_BY_EMAIL);
                assert iSearch != null;
                iSearch.search(input);
                break;
            case SEARCH_BY_DEPARTMENT:
                iSearch = UserSearching.createISEARCH(SEARCH_BY_DEPARTMENT);
                assert iSearch != null;
                iSearch.search(input);
                break;
            case SEARCH_BY_RESIDENCY:
                iSearch = UserSearching.createISEARCH(SEARCH_BY_RESIDENCY);
                assert iSearch != null;
                iSearch.search(input);
                break;
            case CONSTANT_CANCEL_2:
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }

    private static void editOtherUserInformationByAdmin(User admin) {
        System.out.println("Do you want to edit a user information? (Y/N)");
        String answer = scanner.nextLine();
        if (answer.equals("y") || answer.equals("Y")) {
            editOtherUserInformation();
        } else if (answer.equals("n") || answer.equals("N")) {
            operateEmployeeServices(admin);
        } else {
            System.out.println("Invalid answer! Try again!");
            editOtherUserInformationByAdmin(admin);
        }
    }

    private static void editOtherUserInformation() {
        System.out.println("Username: ");
        String userName = scanner.nextLine();
        for (User user : UserService.users) {
            if (user.getUsername().equals(userName)) {
                editOtherUserInformationProcess(user);
            }
        }
    }

    private static void editOtherUserInformationProcess(User user) {
        System.out.println(user);
        System.out.println("Do you want to edit this user basic information? (Y/N)");
        String answer = scanner.nextLine();
        if (answer.equals("y") || answer.equals("Y")) {
            UserService.editUserBasicInformation(user);
            editOtherUserSpecialInformation(user);
            System.out.println(user);
        } else if (answer.equals("n") || answer.equals("N")) {
            editOtherUserSpecialInformation(user);
        } else {
            System.out.println("Invalid answer! Try again!");

        }
    }

    private static void editOtherUserSpecialInformation(User user) {
        if (user instanceof Customer) {

            System.out.println("Building: ");
            String buildingName = scanner.nextLine();
            for (Building building : BuildingService.buildingList) {
                if (building.getBuildingName().equals(buildingName)) {
                    ((Customer) user).setBuildingName(buildingName);
                }
            }

            System.out.println("Room: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine();
            for (Room room : RoomService.roomList) {
                if (room.getRoomNumber() == roomNumber) {
                    ((Customer) user).setRoom(room);
                }
            }

        } else if (user instanceof Employee) {
            registerEmployeeDepartment(user);
            registerEmployeePosition(user);
        }
    }
}