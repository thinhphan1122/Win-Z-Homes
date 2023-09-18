package entity;

import java.io.Serializable;

public class Room implements Serializable {
    private int id;
    private int roomNumber;
    private int residentCount;

    public Room(int id, int roomNumber, int residentCount) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.residentCount = residentCount;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getResidentCount() {
        return residentCount;
    }

    public void setResidentCount(int residentCount) {
        this.residentCount = residentCount;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", residentCount=" + residentCount +
                '}';
    }
}
