package by.kosya;

import by.kosya.dao.UserDAO;
import by.kosya.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.atomic.AtomicReference;

public class ContextListener implements ServletContextListener {
    AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
       dao = new AtomicReference<UserDAO>();
//        dao.get().add(new User(1,"Dasha",19, "qwerty", User.Role.ADMIN, "kosya" ));
//        dao.get().add(new User(2,"Arseni",19, "ytrewq", User.Role.USER, "Capitoska" ));
//        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.err.println("Closed contextListener");
        dao = null;
    }
}
