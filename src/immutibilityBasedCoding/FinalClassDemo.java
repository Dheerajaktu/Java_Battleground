package immutibilityBasedCoding;

import java.util.ArrayList;
import java.util.List;

public class FinalClassDemo {

    public static void main(String[] args) {
        User user = new User();
        user.names.add("Dheeraj");
        user.names.add("Sinch");
        user.names.add("Cisco");
        user.names.add("Palo Alto");
        System.out.println("List::"+ user.names);
    }
}

final class User {
    List<String> names = new ArrayList<>();
}