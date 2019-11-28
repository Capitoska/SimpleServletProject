package by.kosya.dao;

import by.kosya.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private List<User> users = new ArrayList<>();

    public User getById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.initializeDatabase();
        User result = new User();
        result.setId(-1);
        for (User user : users) {
            if (user.getId() == id)
                result = user;
        }
        return null;
    }


    public User getUserByLoginAndPassword(String login, String password) {
        for (User user : users) {
            User result = new User();
            result.setId(-1);
            if (user.getPassword().equals(password) && user.getLogin().equals(login))
                result = user;
        }
        return null;
    }

    public boolean add(User user) {
        for (User u : users) {
            if (u.getLogin().equals(user.getLogin()) || u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }
        return users.add(user);
    }


    //  TODO Переписать роли

//    public User.Role getRoleByLoginPassword(String login, String password) {
//        User.Role role = User.Role.UNKNOWN;
//        for (User u : users) {
//            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
//                role = u.getRole();
//            }
//        }
//        return role;
//    }

    public boolean userIsExist(String login, String password) {
        boolean result = false;
        for (User u : users) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
