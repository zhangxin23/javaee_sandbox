package net.coderland.javaee;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: zhangxin
 * Date:   16-1-6
 */
public class TestServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try{
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Test Servlet</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h2>Hello world!</h2>");
            writer.println("</body>");
            writer.println("</html>");
        } finally {
            writer.close();
        }
    }
}
