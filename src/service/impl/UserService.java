package service.impl;

import entity.*;

import java.util.*;

import static constant.Contants.*;

public class UserService {
    public static ArrayList<User> users;
    private static final Scanner scanner;
    private final CustomerService customerService = new CustomerService();

    static {
        users = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void userLogin() {
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        loginCheck(username, password);
    }

    public void loginCheck(String username, String password) {
        if (users.stream().noneMatch(user -> user.getUsername().equals(username))) {
            System.out.println("User not found!");
        } else {
            checkUserPassword(username, password);
        }
    }

    public void checkUserPassword(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Welcome " + username);
                checkUserLoginAccountType(user);
                break;
            } else if (user.getUsername().equals(username) && !user.getPassword().equals(password)) {
                System.out.println("Wrong password!");
                userLogin();
                break;
            }
        }
    }

    public void checkUserLoginAccountType(User user) {
        if (user instanceof Customer) {
            CustomerService customerService = new CustomerService();
            System.out.println("Customer"); //Vào thẳng CustomerService
        } else if (user instanceof Employee) {
            EmployeeService employeeService = new EmployeeService();
            System.out.println("Employee"); //Vào thẳng EmployeeService
        }
    }

    public User userRegister() {
        System.out.println("Do you want to register a new user? (Y/N)");
        String answer = scanner.nextLine();

        if (answer.equals("y") || answer.equals("Y")) {
            System.out.println("Choose an option:"
                    + "\n" + "1 - Customer"
                    + "\n" + "2 - Employee");
            int flag = scanner.nextInt();
            scanner.nextLine();
            switch (flag) {
                case CONSTANT_CUSTOMER:
                    User customer = new Customer();
                    addUserRegisterInformation(customer);
                    return customer;
                case CONSTANT_EMPLOYEE:
                    User employee = new Employee();
                    addUserRegisterInformation(employee);
                    return employee;
                default:
                    return null;
            }
        } else if (answer.equals("n") || answer.equals("N")) {
            return null;
        } else {
            System.out.println("Invalid answer! Try again!");
            return null;
        }
    }

    private int createNewCustomerId() {
        int id = 1;
        for (User user : users) {
            user.setId(id);
            id++;
        }
        return id;
    }

    public void addUserRegisterInformation(User user) {
        user.setId(createNewCustomerId());

        System.out.println("Username: ");
        String username = scanner.nextLine();
        user.setUsername(username);

        System.out.println("Password: ");
        String password = scanner.nextLine();
        user.setPassword(password);

        System.out.println("Full name: ");
        String fullName = scanner.nextLine();
        user.setFullName(fullName);

        System.out.println("Phone number: ");
        String phoneNumber = scanner.nextLine();
        user.setPhoneNumber(phoneNumber);

        System.out.println("Email: ");
        String email = scanner.nextLine();
        user.setEmail(email);

        checkUserRegisterAccountType(user);
        addUserToUserList(user);
    }

    public void checkUserRegisterAccountType(User user) {
        if (user instanceof Customer) {
            System.out.println("Add customer information: ");

            customerService.addCustomerInformation(user);
            System.out.println("Registered completed!");
        } else if (user instanceof Employee) {
            System.out.println("Add employee information: ");
            EmployeeService.addEmployeeInformation(user);
            System.out.println("Registered completed!");
        }
    }

    public void addUserToUserList(User user) {
        users.add(user);
    }

    public void displayUserList() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}