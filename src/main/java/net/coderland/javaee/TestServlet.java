package net.coderland.javaee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * Author: zhangxin
 * Date:   16-1-6
 */
public class TestServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cookieDemo(request, response);
    }

    private void htmlResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        String initValue = getServletConfig().getInitParameter("second");
        PrintWriter writer = response.getWriter();
        try{
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Test Servlet</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h2>Now: " + new Date().toString()+ "</h2>");
            writer.println("<h3>key: </h3>" + key);
            writer.println("<h3>value: </h3>" + value);
            writer.println("<h3>initName: second, value = " + initValue + "</h3>");
            writer.println("</body>");
            writer.println("</html>");
        } finally {
            writer.close();
        }
    }

    private void downloadFile(HttpServletRequest request, HttpServletResponse response,
                              String fileName) throws IOException {
        final int LEN = 1024;
        int length = 0;

        ServletOutputStream outStream = response.getOutputStream();
        ServletContext context = getServletConfig().getServletContext();

        String mimeType = context.getMimeType(fileName);
        response.setContentType(mimeType != null ? mimeType : "text/plain");
//        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        //this.getClass().getResource获取当前class文件的目录位置
        String classPath = this.getClass().getResource("hi.txt").getPath();

        //this.getClass().getClassLoader().getResource获取当前classloader的执行目录，就是在包路径的上一层目录
        String classLoaderPath = this.getClass().getClassLoader().getResource("test.txt").getPath();

        InputStream inStream = context.getResourceAsStream("/WEB-INF/classes/" + fileName);
        byte[] buf = new byte[LEN];
        while((inStream != null) && ((length = inStream.read(buf)) != -1)) {
            outStream.write(buf, 0, length);
        }

        outStream.flush();
        outStream.close();
    }

    private void forwordDemo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/another"); //填servlet-mapping对应的url-pattern的值
        rd.forward(request, response);

//        getServletContext().getNamedDispatcher("another-test").forward(request, response); //填servlet的名字
    }

    private void redirectDemo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("www.baidu.com");
    }

    private void cookieDemo(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("cookiedemo", "123abc");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
    }
}
