import service.impl.RoomService;
import service.impl.DataService;
import service.impl.UserService;

public class Main {
    public static void main(String[] args) {
        DataService.createBuilding();
//        TestService.createDev();
//        TestService.createTester();
//        TestService.createCustomer1();
//        TestService.createCustomer2();
//        TestService.createCustomer3();
//        TestService.createCustomer4();

        RoomService.checkTotalRoomResident();
        UserService.displayUserList();
        UserService.chooseLoginOptions();
    }
}