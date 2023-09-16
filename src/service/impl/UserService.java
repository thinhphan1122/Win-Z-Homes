package service.impl;

import entity.*;

import java.util.*;

import static constant.Constants.*;

public class UserService {
    public static ArrayList<User> users;
    private static final Scanner scanner;
    private final CustomerService customerService = new CustomerService();
    private final EmployeeService employeeService = new EmployeeService();

    static {
        users = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void chooseLoginOptions() {
        while (true) {
            System.out.println("Welcome! Would you like to login or register as a new customer?"
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
                    userRegister();
                    break;
                case CONSTANT_CANCEL:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
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
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                System.out.println("Welcome " + username);
                checkUserLoginAccountType(user);
                break;
            } else if (user.getUsername().equals(username)
                    && !user.getPassword().equals(password)) {
                System.out.println("Wrong password!");
                userLogin();
                break;
            }
        }
    }

    public void checkUserLoginAccountType(User user) {
        if (user instanceof Customer) {
            System.out.println("Customer");

            //Vào CustomerService:
            // - Chỉnh sửa thông tin khách hàng cơ bản
            // - Tìm kiếm thông tin cơ bản của tòa nhà
            // - Kiểm tra hóa đơn

        } else if (user instanceof Employee) {
            System.out.println("Employee");

            //Vào EmployeeService:
            // - Chỉnh sửa thông tin nhân viên cơ bản
            // - Kiểm tra và sửa thông tin khách hàng
            // - Tìm được thông tin chi tiết của tòa nhà (phòng, số lượng người ở, etc.)

        }
    }

    public void userRegister() {
        System.out.println("Do you want to register a new user? (Y/N)");
        String answer = scanner.nextLine();
        if (answer.equals("y") || answer.equals("Y")) {
            User user;
            System.out.println("Choose an option:"
                    + "\n" + "1 - Customer"
                    + "\n" + "2 - Employee");
            int flag = scanner.nextInt();
            scanner.nextLine();
            switch (flag) {
                case CONSTANT_CUSTOMER:
                    user = new Customer();
                    addUserRegisterInformation(user);
                    return;
                case CONSTANT_EMPLOYEE:
                    user = new Employee();
                    addUserRegisterInformation(user);
                    return;
                default:
            }
        } else if (answer.equals("n") || answer.equals("N")) {
            chooseLoginOptions();
        } else {
            System.out.println("Invalid answer! Try again!");
            userLogin();
        }
    }

    public void addUserRegisterInformation(User user) {
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

        user.setId(createNewCustomerId());
        checkUserRegisterAccountType(user);
        addUserToUserList(user);
    }

    private int createNewCustomerId() {
        int id = 1;
        for (User user : users) {
            user.setId(id);
            id++;
        }
        return id;
    }

    public void checkUserRegisterAccountType(User user) {
        if (user instanceof Customer) {
            System.out.println("Add customer information: ");
            customerService.addCustomerInformation(user);
            System.out.println("Registered completed!");
        } else if (user instanceof Employee) {
            System.out.println("Add employee information: ");
            employeeService.addEmployeeInformation(user);
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