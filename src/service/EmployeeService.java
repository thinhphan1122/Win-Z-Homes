package service;

import constant.EDepartment;
import constant.EPosition;
import entity.Employee;
import entity.User;

import java.util.Scanner;

import static constant.Contants.*;

public class EmployeeService {
    private static Scanner scanner = new Scanner(System.in);

    public static void registerEmployeeDepartment(User user) {
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

    public static void registerEmployeePosition(User user) {
        System.out.println("Position: "
                + "\n" + "1. Head of The Department"
                + "\n" + "2. Employee"
        );

        int flag = scanner.nextInt();
        scanner.nextLine();
        switch (flag) {
            case CONSTANT_HEAD_OF_THE_PARTMENT:
                ((Employee) user).setPosition(String.valueOf(EPosition.HEAD_OF_THE_DEPARTMENT));
                break;
            case CONSTANT_STAFF:
                ((Employee) user).setPosition(String.valueOf(EPosition.STAFF));
                break;
        }
    }
}