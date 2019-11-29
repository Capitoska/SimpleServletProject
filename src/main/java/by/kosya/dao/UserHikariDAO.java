package by.kosya.dao;

import by.kosya.model.Role;
import by.kosya.model.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserHikariDAO {

    @SneakyThrows
    public static void addUser(User user) {
        String SQL_QUERY = "insert into users(name, login, password, phone) values(?,?,?,?)";
        try (Connection connection = HikariDatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.execute();
        }
    }

    @SneakyThrows
    public static boolean checkUserByLoginAndPassword(String login, String password) {
        String SQL_QUERY = "SELECT EXISTS (SELECT * FROM users WHERE users.login =(?) AND users.password = (?) ) as amount";
        int answer = 0;
        Connection connection = HikariDatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1) > 0;
    }

    @SneakyThrows
    public static User getById(int id) {
        String SQL_QUERY = "select * from users where id =(?)";
        User user = new User();
        try (Connection connection = HikariDatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            userFilling(user, resultSet);
        }
        return user;
    }

    @SneakyThrows
    public static User getByLoginAndPassword(String login, String password) {
        String SQL_QUERY = "select * from users where login = (?) and password = (?)";
        User user = new User();
        try (Connection connection = HikariDatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            userFilling(user, resultSet);
        }

        return user;
    }

    @SneakyThrows
    private static void userFilling(User user, ResultSet resultSet) {
        user.setName(resultSet.getString("name"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setPhone(resultSet.getString("phone"));
        user.setRole(Role.getById(Role.values(),resultSet.getInt("role_id")));
        //user.setRole((resultSet.getInt("role_id"));
    }

    @SneakyThrows
    public static List<User> getAllData() {
        String SQL_QUERY = "select * from users";
        List<User> users = null;
        try (Connection con = HikariDatabaseConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SQL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            users = new ArrayList<>();
            User user;
            while (resultSet.next()) {
                user = new User();
                userFilling(user, resultSet);
                users.add(user);
            }
        }
        return users;
    }
}