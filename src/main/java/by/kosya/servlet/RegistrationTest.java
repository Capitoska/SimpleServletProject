package by.kosya.servlet;

import by.kosya.dao.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/InsertData")
public class RegistrationTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/authorization.jsp")
                .forward(req, resp);
        System.err.println("Организовал вставку данных");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Connection connection = DatabaseConnection.initializeDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(name, login, password, phone) values(?,?,?,?)");
            preparedStatement.setString(1, req.getParameter("name"));
            preparedStatement.setString(2, req.getParameter("login"));
            preparedStatement.setString(3, req.getParameter("password"));
            preparedStatement.setString(4, req.getParameter("phone"));
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            System.out.println("Good!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Problems in doPost RegistrationTest");
            e.printStackTrace();
        }
    }
}
