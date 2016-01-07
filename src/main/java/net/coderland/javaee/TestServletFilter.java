package net.coderland.javaee;

import javax.servlet.*;
import java.io.IOException;

/**
 * Author: zhangxin
 * Date:   16-1-7
 */
public class TestServletFilter implements Filter {

    @Override
    public void init(FilterConfig var1) throws ServletException {
        System.out.println("Filter: init method ... ");
    }

    @Override
    public void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3) throws IOException, ServletException {
        System.out.println("Filter: doFilter method ... ");
        var3.doFilter(var1, var2);
    }

    @Override
    public void destroy() {
        System.out.println("Filter: destroy method ... ");
    }
}
