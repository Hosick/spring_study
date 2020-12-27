package me.hosick;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextInitialized");
        sce.getServletContext().setAttribute("name", "hosick");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextDestroyed");
    }
}