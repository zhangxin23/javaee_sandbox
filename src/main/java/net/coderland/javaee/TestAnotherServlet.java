package net.coderland.javaee;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Author: zhangxin
 * Date:   16-1-7
 */
public class TestAnotherServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        htmlResponse(request, response);
    }

    private void htmlResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try{
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Test Another Servlet</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h2>Now: " + new Date().toString()+ "</h2>");
            writer.println("<h3>Another Servlet</h3>");
            writer.println("</body>");
            writer.println("</html>");
        } finally {
            writer.close();
        }
    }
}
