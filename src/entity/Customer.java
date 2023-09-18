package entity;

import java.io.Serializable;

public class Customer extends User implements Serializable {
    private String customerCode;
    private String buildingName;
    private Room room;

    public Customer(int id, String username, String password, String fullName, String address, String phoneNumber, String email, String customerCode, String buildingName, Room room) {
        super(id, username, password, fullName, address, phoneNumber, email);
        this.customerCode = customerCode;
        this.buildingName = buildingName;
        this.room = room;
    }

    public Customer() {}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", room=" + room +
                '}';
    }

    //Builder
    public Customer id(int id) {
        this.id = id;
        return this;
    }

    public Customer username(String username) {
        this.username = username;
        return this;
    }

    public Customer password(String password) {
        this.password = password;
        return this;
    }

    public Customer fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Customer address(String address) {
        this.address = address;
        return this;
    }

    public Customer phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Customer email(String email) {
        this.email = email;
        return this;
    }

    public Customer customerCode(String customerCode) {
        this.customerCode = customerCode;
        return this;
    }

    public Customer buildingName(String buildingName) {
        this.buildingName = buildingName;
        return this;
    }

    public Customer room(Room room) {
        this.room = room;
        return this;
    }

    public Customer createCustomer() {
        return new Customer(id, username, password, fullName, address, phoneNumber, email, customerCode, buildingName, room);
    }
}