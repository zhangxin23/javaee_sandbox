package net.coderland.javaee;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Author: zhangxin
 * Date:   16-1-6
 */
public class TestServletRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent var1) {
        System.out.println("ServletRequestListener: requestDestroyed method ... ");
    }

    @Override
    public void requestInitialized(ServletRequestEvent var1) {
        System.out.println("ServletrequestListener: requestInitialized method ... ");
    }
}
