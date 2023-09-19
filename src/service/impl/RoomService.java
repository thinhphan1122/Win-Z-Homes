package service.impl;

import entity.Customer;
import entity.Room;
import entity.User;

import java.util.ArrayList;

public class RoomService {
    protected static final ArrayList<Room> roomList = new ArrayList<>();

    public static void addRoomToRoomList() {
        int index = 1;
        while (index <= 10) {
            Room room = new Room();
            addRoomInformation(room, index);
            addRoomToRoomListProcess(room);
            index++;
        }
    }

    public static void addRoomInformation(Room room, int index) {
        room.setRoomNumber(createRoomName());
        room.setId(index);
    }

    protected static int createRoomName() {
        int number = 1;
        for (int i = 1; i <= roomList.size(); i++) {
            number++;
        }
        return number;
    }

    protected static void addRoomToRoomListProcess(Room room) {
        roomList.add(room);
    }

    //Cần fix:
    public static void checkRoomTotalResident() {
        for (Room room : roomList) {
            int count = 0;
            for (User user : UserService.users) {
                if (user instanceof Customer) {
                    if (room.equals(((Customer) user).getRoom())) {
                        count++;
                        room.setResidentCount(count);
                    }
                }
            }
        }
    }
}

