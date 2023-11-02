package service.impl;

import constant.EPosition;
import entity.*;

import java.util.*;

import static constant.Constants.*;

public class UserService {
    protected static ArrayList<User> users;
    private static final Scanner scanner;

    static {
        //
        users = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void loginSetup() {
        DataService.createBuilding();

//        createDefaultAccount();

        RoomService.checkRoomTotalResident();
        UserService.displayUserList();
    }

    public static void createDefaultAccount() {
        DataService.createDev();
        DataService.createTester();
        DataService.createCustomer1();
        DataService.createCustomer2();
        DataService.createCustomer3();
        DataService.createCustomer4();
    }

    public static void loginMenu() {
        while (true) {
            loginSetup();
            DataService.readData();
            System.out.println("Welcome to WinZHomes! Would you like to login or register as a new customer?"
                    + "\n" + "1. Login"
                    + "\n" + "2. Register"
                    + "\n" + "3. Cancel");
            int flag = scanner.nextInt();
            scanner.nextLine();
            switch (flag) {
                case CONSTANT_LOGIN:
                    userLogin();
                    break;
                case CONSTANT_REGISTER:
                    userRegisterByCustomer();
                    break;
                case CONSTANT_CANCEL:
                    DataService.clearData();
                    DataService.writeData(users);
                    System.out.println(users);
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }

    protected static void userLogin() {
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        loginCheck(username, password);
    }

    protected static void loginCheck(String username, String password) {
        if (users.stream().noneMatch(user -> user.getUsername().equals(username))) {
            System.out.println("User not found!");
        } else {
            checkUserPassword(username, password);
        }
    }

    protected static void checkUserPassword(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                System.out.println("Welcome " + username);
                checkUserLoginAccountType(user);
                break;
            } else if (user.getUsername().equals(username)
                    && !user.getPassword().equals(password)) {
                System.out.println("Wrong password!");
                loginMenu();
                break;
            }
        }
    }

    protected static void checkUserLoginAccountType(User user) {
        if (user instanceof Customer) {
            CustomerService.operateCustomerServices(user);
        } else if (user instanceof Employee) {
            if (((Employee) user).getPosition().equals(String.valueOf(EPosition.ADMIN))) {
                userRegisterByAdmin(user);
                EmployeeService.operateEmployeeServices(user);
            } else {
                EmployeeService.operateEmployeeServices(user);
            }
        }
    }

    protected static void userRegisterByCustomer() {
        System.out.println("Do you want to register as a new user? (Y/N)");
        String answer = scanner.nextLine();
        if (answer.equals("y") || answer.equals("Y")) {
            User user;
            user = new Customer();
            addUserRegisterInformation(user);
        } else if (answer.equals("n") || answer.equals("N")) {
            loginMenu();
        } else {
            System.out.println("Invalid answer! Try again!");
            userLogin();
        }
    }

    private static void userRegisterByAdmin(User user) {
        System.out.println("Do you want to register a new user? (Y/N)");
        String answer = scanner.nextLine();
        if (answer.equals("y") || answer.equals("Y")) {
            User newUser;
            System.out.println("Choose an option:"
                    + "\n" + "1 - Customer"
                    + "\n" + "2 - Employee"
                    + "\n" + "3 - Cancel");
            int flag = scanner.nextInt();
            scanner.nextLine();
            switch (flag) {
                case CONSTANT_CUSTOMER:
                    newUser = new Customer();
                    addUserRegisterInformation(newUser);
                    break;
                case CONSTANT_EMPLOYEE:
                    newUser = new Employee();
                    addUserRegisterInformation(newUser);
                    break;
                case CONSTANT_CANCEL:
                        break;
            }
        } else if (answer.equals("n") || answer.equals("N")) {
            EmployeeService.operateEmployeeServices(user);
        } else {
            System.out.println("Invalid answer! Try again!");
            userLogin();
        }
    }

    protected static void addUserRegisterInformation(User newUser) {
        System.out.println("Username: ");
        String username = scanner.nextLine();

        if (users.stream().noneMatch(user -> user.getUsername().equals(username))) {
            newUser.setId(createNewCustomerId());
            newUser.setUsername(username);

            editUserBasicInformation(newUser);
            addSpecificInformationByUserRegisterAccountType(newUser);
            addUserToUserList(newUser);

            DataService.clearData();
            DataService.writeData(users);

        } else {
            System.out.println("Username existed!");
            addUserRegisterInformation(newUser);
        }
    }

    protected static void editUserBasicInformation(User newUser) {
        System.out.println("Password: ");
        String password = scanner.nextLine();
        newUser.setPassword(password);

        System.out.println("Full name: ");
        String fullName = scanner.nextLine();
        newUser.setFullName(fullName);

        System.out.println("Phone number: ");
        String phoneNumber = scanner.nextLine();
        newUser.setPhoneNumber(phoneNumber);

        System.out.println("Email: ");
        String email = scanner.nextLine();
        newUser.setEmail(email);
    }

    private static int createNewCustomerId() {
        int id = 1;
        for (User user : users) {
            user.setId(id);
            id++;
        }
        return id;
    }

    protected static void addSpecificInformationByUserRegisterAccountType(User user) {
        if (user instanceof Customer) {
//            System.out.println("Add employee information: ");
            CustomerService.addCustomerInformation(user);
            System.out.println("Registered completed!");
        } else if (user instanceof Employee) {
            System.out.println("Add employee information: ");
            EmployeeService.addEmployeeInformation(user);
            System.out.println("Registered completed!");
        }
    }

    protected static void addUserToUserList(User user) {
        users.add(user);
    }

    public static void displayUserList() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}