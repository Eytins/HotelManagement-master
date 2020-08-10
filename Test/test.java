import com.HotelManagement.service.user.UserService;
import com.HotelManagement.service.user.UserServiceImpl;
import org.junit.Test;

public class test {
    @Test
    public void test1() {

        UserService userService = new UserServiceImpl();
        System.out.println(userService.login("xiaoming", "0000000"));

    }
}
