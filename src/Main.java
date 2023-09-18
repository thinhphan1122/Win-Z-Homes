import service.impl.RoomService;
import service.impl.TestService;
import service.impl.UserService;

public class Main {
    public static void main(String[] args) {
        TestService.createBuilding();
        TestService.createDev();
        TestService.createTester();
        TestService.createCustomer1();
        TestService.createCustomer2();
        TestService.createCustomer3();

        RoomService.checkTotalRoomResident();
        UserService.displayUserList();
        UserService.chooseLoginOptions();
    }
}