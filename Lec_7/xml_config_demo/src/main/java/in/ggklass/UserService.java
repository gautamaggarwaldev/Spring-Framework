package in.ggklass;

import java.util.List;

public class UserService {
//    private List<String> usernames;
//
//    public UserService(List<String>usernames) {
//        this.usernames = usernames;
//    }
//
//    public List<String> getUsernames() {
//        return usernames;
//    }

    public UserService() {
        System.out.println("UserService Created.");
    }

    public void init() {
        System.out.println("Post Construct phase.");
    }

    public void destroy() {
        System.out.println("Pre Destroy phase.");
    }
}
