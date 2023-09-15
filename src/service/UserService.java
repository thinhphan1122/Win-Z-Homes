package service;

import entity.Customer;
import entity.Employee;
import entity.User;

import javax.swing.plaf.PanelUI;
import java.util.*;

import static constant.Contants.*;

public class UserService {
    private static ArrayList<User> users;
    private static Scanner scanner;

    static {
        users = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void userLogin() {
    }

    public static User userRegister() {
        System.out.println("Do you want to register a new user? (Y/N)");
        String answer = new Scanner(System.in).nextLine();

        if (answer.equals("y") || answer.equals("Y")) {
            System.out.println("Choose an option:"
                    + "\n" + "1 - Customer"
                    + "\n" + "2 - Employee");
            int flag = scanner.nextInt();
            scanner.nextLine();
            switch (flag) {
                case CONSTANT_CUSTOMER:
                    return new Customer();
                case CONSTANT_EMPLOYEE:
                    return new Employee();
                default:
                    return null;
            }
        } else if (answer.equals("n") || answer.equals("N")) {
            return null;
        } else
            System.out.println("Invalid answer! Try again!");
        return null;
    }

    private static int createNewCustomerId() {
        int id = 0;
        for (User user : users) {
            user.setId(id);
            id++;
        }
        return id;
    }

    public static User addUserInformation() {
        User user = userRegister();

        createNewCustomerId();

        System.out.println("Username: ");
        String username = scanner.nextLine();
        user.setUsername(username);

        System.out.println("Password: ");
        String password = scanner.nextLine();
        user.setPassword(password);

        System.out.println("Full name: ");
        String fullName = scanner.nextLine();
        user.setFullName(fullName);

        System.out.println("National Identification Number: ");
        String nationalId = scanner.nextLine();
        user.setNationalId(nationalId);

        System.out.println("Hometown: ");
        String hometown = scanner.nextLine();
        user.setHometown(hometown);

        System.out.println("Age: ");
        int age = scanner.nextInt();
        user.setAge(age);

        System.out.println("Sex");
        String sex = scanner.nextLine();
        user.setSex(sex);

        System.out.println();
        String occupation = scanner.nextLine();
        user.setOccupation(occupation);

        System.out.println("Address: ");
        String address = scanner.nextLine();
        user.setAddress(address);

        System.out.println("Phone number: ");
        String phoneNumber = scanner.nextLine();
        user.setPhoneNumber(phoneNumber);

        System.out.println("Email: ");
        String email = scanner.nextLine();
        user.setEmail(email);

        checkUserRegistrationType(user);
        return user;
    }

    public static void checkUserRegistrationType(User user) {
        if (user instanceof Customer) {
            System.out.println();
        } else if (user instanceof Employee) {
            System.out.println("Add employee information: ");
            EmployeeService.registerEmployeeDepartment(user);
            EmployeeService.registerEmployeePosition(user);
        }
    }


    public static void addUserToList() {
        users.add(addUserInformation());
        System.out.println(users);
    }
}
