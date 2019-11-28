package by.kosya.filter;


import by.kosya.dao.UserDAO;
import by.kosya.dao.UserHikariDAO;
import by.kosya.model.User;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        String login = request.getParameter("login");
        String password = request.getParameter("password");


        @SuppressWarnings("unchecked") final AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) request.getServletContext().getAttribute("dao");

        final HttpSession session = request.getSession();

//
//        if (session != null && session.getAttribute("login") != null &&
//                session.getAttribute("password") != null) {
//            final User.Role role = (User.Role) session.getAttribute("role");
//            moveToMenu(request, response, role);
//        } else if (dao.get().userIsExist(login, password)) {
//            User.Role role = UserHikariDAO.getByLoginAndPassword(login, password).getRole();
//            request.getSession().setAttribute("password", password);
//            request.getSession().setAttribute("login", login);
//            request.getSession().setAttribute("role", role);
//            moveToMenu(request, response, role);
//        } else {
//            moveToMenu(request, response, User.Role.UNKNOWN);
//        }
//    }
//
//    private void moveToMenu(final ServletRequest servletRequest, final ServletResponse servletResponse,
//                            final User.Role role) {
//        if (role.equals(User.Role.USER)) {
//            servletRequest.getRequestDispatcher("/WEB-INF/view/user-menu.jsp");
//        } else if (role.equals(User.Role.ADMIN)) {
//            servletRequest.getRequestDispatcher("/WEB-INF/view/admin-menu.jsp");
//        } else if (role.equals(User.Role.VIP)) {
//            servletRequest.getRequestDispatcher("/WEB-INF/view/vip-menu.jsp");
//        } else if (role.equals(User.Role.UNKNOWN)) {
//            servletRequest.getRequestDispatcher("/WEB-INF/view/index.jsp");
//        }
//    }
//
//
    }

    @Override
    public void destroy() {

    }
}
