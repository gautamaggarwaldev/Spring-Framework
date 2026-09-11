package in.ggklass.service;

import in.ggklass.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<Integer, User> userdb;

    public UserService() {
        userdb = new HashMap<>();
    }

    public User createUser(User reqUser) {
        userdb.put(reqUser.getId(), reqUser);
        return reqUser;
    }

    public List<User> getAllUsers() {
        List<User> userResp = new ArrayList<>();
        for(User u : userdb.values()) {
            userResp.add(u);
        }
        return userResp;
    }

    public User getUserById(Integer id) {
        return userdb.getOrDefault(id, null);
    }

    public User updateUser(User user) {
        userdb.put(user.getId(), user);
        return user;
    }

    public void deleteUser(Integer id) {
        userdb.remove(id);
    }

}
