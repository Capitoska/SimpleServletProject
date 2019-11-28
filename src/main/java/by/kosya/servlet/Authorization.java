package by.kosya.servlet;

import by.kosya.dao.UserHikariDAO;
import by.kosya.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Authorization extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/authorization.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user;

        String login = req.getParameter("login");

        String password = req.getParameter("password");
        System.out.println(password + "  " + login);
        if(UserHikariDAO.checkUserByLoginAndPassword(login, password)){
            user = UserHikariDAO.getByLoginAndPassword(login,password);
            HttpSession session = req.getSession();
            session.setAttribute("login", user.getLogin());
            session.setAttribute("password", user.getPassword());
            session.setAttribute("role",user.getRole());
        } else {
            req.setAttribute("answer","Ошибка ввода! Перепроверьте ваш логин и пароль!");
            doGet(req, resp);
        }
    }

}
