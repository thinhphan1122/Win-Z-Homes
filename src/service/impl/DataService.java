package service.impl;

import constant.EDepartment;
import constant.EPosition;
import entity.*;

import java.io.*;
import java.util.ArrayList;

public class DataService {
    private static final String PATH_CUSTOMER = "src/data/user.txt";

    public static void createBuilding() {
        BuildingService.addBuildingToBuildingList();
        RoomService.addRoomToRoomList();
        for (Building building : BuildingService.buildingList) {
            building.setRoomList(RoomService.roomList);
        }
    }

    public static void createDev() {
        User user = new Employee()
                .id(0)
                .username("Dev")
                .password("dev")
                .fullName("None")
                .employeeCode("E")
                .department(String.valueOf(EDepartment.INFORMATION_TECHNOLOGY))
                .position(String.valueOf(EPosition.ADMIN))
                .salary(100000000);
        UserService.users.add(user);
    }

    public static void createTester() {
        Employee user = new Employee()
                .employeeCode("E1")
                .department(String.valueOf(EDepartment.INFORMATION_TECHNOLOGY))
                .position(String.valueOf(EPosition.HEAD_OF_THE_DEPARTMENT));
        user.setId(1);
        user.setUsername("Tester");
        user.setPassword("test");
        user.setSalary(EmployeeService.calculateEmployeeSalary(user));
        UserService.users.add(user);
    }

    public static void createCustomer1() {
        User user = new Customer()
                .id(2)
                .username("Thinh")
                .password("test")
                .fullName("Thinh Phan")
                .phoneNumber("0123456789")
                .address("21A Nguyen Van Troi")
                .buildingName(BuildingService.buildingList.get(1).getBuildingName())
                .room(BuildingService.buildingList.get(1).getRoomList().get(1));
        UserService.users.add(user);
    }

    public static void createCustomer2() {
        User user = new Customer()
                .id(3)
                .username("Dat")
                .password("test")
                .fullName("Dat Villa")
                .phoneNumber("0987654321")
                .email("dat@gmail.com")
                .address("21B Nguyen Van Troi")
                .buildingName(BuildingService.buildingList.get(2).getBuildingName())
                .room(BuildingService.buildingList.get(2).getRoomList().get(2));
        UserService.users.add(user);
    }

    public static void createCustomer3() {
        User user = new Customer()
                .id(4)
                .username("Nhan")
                .password("test")
                .fullName("Nhan Tran")
                .phoneNumber("0123454321")
                .email("nhan@gmail.com")
                .address("21B Nguyen Van Troi")
                .buildingName(BuildingService.buildingList.get(2).getBuildingName())
                .room(BuildingService.buildingList.get(2).getRoomList().get(2));
        UserService.users.add(user);
    }

    public static void createCustomer4() {
        User user = new Customer()
                .id(5)
                .username("Thang")
                .password("test")
                .fullName("Thang Lon")
                .phoneNumber("0123451234")
                .email("thang@gmail.com")
                .address("21C Nguyen Van Troi")
                .buildingName(BuildingService.buildingList.get(3).getBuildingName())
                .room(BuildingService.buildingList.get(3).getRoomList().get(2));
        UserService.users.add(user);
    }

    public static void writeData(ArrayList<User> users) {
        final File filePath = new File(PATH_CUSTOMER);
        try {
            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(users);
                objectOutputStream.flush();
            }
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.out.println(System.err);
        }
    }

    public static void readData() {
        File filePath = new File(PATH_CUSTOMER);
        try {
            try (FileInputStream fileInputStream = new FileInputStream(filePath);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                Object user = objectInputStream.readObject();
                UserService.users = (ArrayList<User>) user;
            }
        } catch (ClassNotFoundException | IOException e) {
//            throw new RuntimeException(e);
            System.out.println(System.err);
        }
//        System.out.println(UserService.users);
    }

    protected static void clearData() {
        File filePath = new File(PATH_CUSTOMER);
        filePath.delete();
    }
}
