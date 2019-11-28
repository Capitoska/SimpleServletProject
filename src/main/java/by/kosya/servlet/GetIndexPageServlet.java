package by.kosya.servlet;

import by.kosya.dao.UserHikariDAO;
import by.kosya.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GetIndexPageServlet extends HttpServlet {
    private Map<Integer, User> users;
    private static String index = "/WEB-INF/view/index.jsp";


    @Override
    public void init() throws ServletException {
        final Object users = getServletContext().getAttribute("users");
        if (users == null || !(users instanceof ConcurrentHashMap)) {
            throw new IllegalStateException("You're repo does not initialized");
        } else {
            this.users = (ConcurrentHashMap<Integer, User>) users;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("Работает DoPost");
        // TODO: 11/13/2019 спросить про то, как избавиться от try/catch             !!!Решение LomBok!!!
        for (User user: UserHikariDAO.getAllData()
             ) {
            System.out.println(user + "\n\n");
        }
        final String dataFromUser = req.getParameter("data");
        HttpSession session = req.getSession();
        System.out.println(session.getAttributeNames());
        final String currentSession = (String) session.getAttribute("state");
        if (currentSession != null) {
            session.setAttribute("state", currentSession + dataFromUser);
        } else {
            session.setAttribute("state", dataFromUser);
        }

        doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.err.println("Работает DoGet");
        HttpSession session = req.getSession();
        ServletContext contextListener;
        final String state = (String) session.getAttribute("state");
        if (state != null) {
            req.setAttribute("output", session.getAttribute("state"));
        }
        req.setAttribute("users", users.values());
        req.getRequestDispatcher(index).forward(req, resp);
    }
}
