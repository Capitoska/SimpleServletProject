package by.kosya.servlet;

import by.kosya.dao.UserDAO;
import by.kosya.dao.UserHikariDAO;
import by.kosya.model.Role;
import by.kosya.model.User;
import by.kosya.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class RegisterUserServlet extends HttpServlet {
    private AtomicInteger id = new AtomicInteger(2);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/registration.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if (Utils.requestIsValid(req)) {

            UserDAO userDAO = (UserDAO) req.getSession().getAttribute("dao");
            final String name = req.getParameter("name");
            final String age = req.getParameter("age");
            final String password = req.getParameter("password");
            final String login = req.getParameter("login");
            final String phone = req.getParameter("phone");
            final Role role = Role.USER;
            Cookie userCookie = new Cookie(login, phone);
            userCookie.setMaxAge(60 * 3);
            resp.addCookie(userCookie);
            User user = new User();
            user.setAge(Integer.valueOf(age));
            user.setName(name);
            user.setPhone(phone);
            user.setPassword(password);
            user.setRole(role);
            user.setLogin(login);
            UserHikariDAO.addUser(user);
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
