import entity.User;
import service.impl.TestService;
import service.impl.UserService;

public class Main {
    public static void main(String[] args) {
        TestService.createDev();
        TestService.createTester();

        UserService userService = new UserService();
        userService.chooseLoginOptions();
    }
}