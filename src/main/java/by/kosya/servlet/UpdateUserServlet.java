package by.kosya.servlet;

import by.kosya.model.User;
import by.kosya.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UpdateUserServlet extends HttpServlet {
    private Map<Integer, User> users;


    @Override
    public void init() throws ServletException {
        final Object users = getServletContext().getAttribute("users");
        if (users == null || !(users instanceof ConcurrentHashMap)) {
            throw new IllegalStateException("Exception in Update User Servlet");
        } else {
            this.users = (ConcurrentHashMap<Integer, User>) users;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = this.users.get(Integer.valueOf(req.getParameter("id")));
        user.setName(req.getParameter("name"));

        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = req.getParameter("id");

        if (Utils.idIsInvalid(id, users)) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        final User user = users.get(Integer.parseInt(id));
        req.setAttribute("user", user);

        req.getRequestDispatcher("/WEB-INF/view/update.jsp")
                .forward(req, resp);
    }
}

