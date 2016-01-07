package net.coderland.javaee;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Author: zhangxin
 * Date:   16-1-6
 */
public class TestServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent var1) {
        System.out.println("ServletContextListener: contextInitialized method ... ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent var1) {
        System.out.println("ServletContextListener: contextDestroyed method ... ");
    }
}
