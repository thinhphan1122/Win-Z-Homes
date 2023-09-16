package service.impl;

import constant.EDepartment;
import constant.EPosition;
import entity.Employee;
import entity.User;

import java.util.Scanner;

import static constant.Constants.*;

public class EmployeeService {
    private final Scanner scanner = new Scanner(System.in);

    public void addEmployeeInformation(User user) {
        registerEmployeeCode(user);
        registerEmployeeDepartment(user);
        registerEmployeePosition(user);
        calculateEmployeeSalary(user);
    }

    protected void registerEmployeeCode(User user) {
        ((Employee) user).setEmployeeCode(generateRandomEmployeeCode());
    }

    protected String generateRandomEmployeeCode() {
        StringBuilder employeeCode = new StringBuilder("E"); //E = Employee
        int length = 6;
        for (int i = 0; i < length; i++) {
            int random = 1 + (int) (Math.random() * 10);
            employeeCode.append(random);
        }
        return employeeCode.toString();
    }

    protected void registerEmployeeDepartment(User user) {
        System.out.println("Department: "
                + "\n" + "1. Finance"
                + "\n" + "2. Sales & Marketing"
                + "\n" + "3. Legal"
                + "\n" + "4. Information Technology"
                + "\n" + "5. Human Resources"
                + "\n" + "6. House Keeping"
                + "\n" + "7. Security"
                + "\n" + "8. Management"
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
            case CONSTANT_MANAGEMENT:
                ((Employee) user).setDepartment(String.valueOf(EDepartment.MANAGEMENT));
                break;
        }
    }

    protected void registerEmployeePosition(User user) {
        System.out.println("Position: "
                + "\n" + "1. Head of The Department"
                + "\n" + "2. Employee"
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
            default:
                System.out.println("Invalid input!");
                registerEmployeeCode(user);
                break;
        }
    }

    protected void calculateEmployeeSalary(User user) {
        long salary = 10000000;
        if (((Employee) user).getPosition().equals(String.valueOf(EPosition.HEAD_OF_THE_DEPARTMENT))) {
            salary *= 2;
            ((Employee) user).setSalary(salary);
        } else ((Employee) user).setSalary(salary);
    }
}