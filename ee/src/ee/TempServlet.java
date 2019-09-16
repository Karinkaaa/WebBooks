package ee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

@WebServlet("/temp")
public class TempServlet extends HttpServlet {

    // Servlets and Multithreading
//    public static void main(String[] args) {
//
//        for (int i = 0; i < 2; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    try {
//                        URLConnection urlConnection = new URL("http://localhost:8080/ee_war/temp").openConnection();
//                        urlConnection.getInputStream();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }.start();
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Servlets and Multithreading

//        int i = 0;
//        synchronized (this) {
//            for (int j = 0; j < 1_000_000; j++) {
//                i++;
//            }
//            System.out.println(i);
//            System.out.println(Thread.currentThread().getName());
//        }


        // URL parameters

//        String one = req.getParameter("one");
//        System.out.println(one);
//
//        String two = req.getParameter("two");
//        System.out.println(two);


//        String[] ones = req.getParameterValues("one");
//        for (String s : ones)
//            System.out.println(s);


//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//
//            String parameter = parameterNames.nextElement();
//            System.out.print(parameter + ": ");
//            System.out.println(req.getParameter(parameter));
//        }
//        Map<String, String[]> map = req.getParameterMap();


//        System.out.println("RequestURL: " + req.getRequestURL());
//        System.out.println("RequestURI: " + req.getRequestURI());
//        System.out.println("ServletPath: " + req.getServletPath());
//        System.out.println("RemoteHost: " + req.getRemoteHost());
//        System.out.println("LocalPort: " + req.getLocalPort());
//        System.out.println("QueryString: " + req.getQueryString());
//        System.out.println("Protocol: " + req.getProtocol());


//        String one = req.getParameter("one");
//        String two = req.getParameter("two");
//
//        resp.getWriter().write("<html> " +
//                "<head></head>" +
//                "<body>" +
//                "<p>one = " + one + "</p>" +
//                "<p>two = " + two + "</p>" +
//                "<form action='temp' method='post'>" +
//                "<input type='text' name='one' />" +
//                "<input type='text' name='two' />" +
//                "<input type='submit' name='submit' />" +
//                "</form>" +
//                "</body> " +
//                "</html");


        // XSS - Cross Site Scripting

//        String one = req.getParameter("one");
//        one = one == null ? "" : one.replaceAll("<", "&lt;").replaceAll(">", "&gt");
//
//        resp.getWriter().write("<html> " +
//                "<head></head>" +
//                "<body>" +
//                "<p>one = " + one + "</p>" +
//                "<form action='temp' method='post'>" +
//                "<textarea name='one'></textarea>" +
//                "<input type='submit' name='submit' />" +
//                "</form>" +
//                "</body> " +
//                "</html");


        // Headers

//        Enumeration<String> headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String s = headerNames.nextElement();
//            System.out.println(s + ": " + req.getHeader(s));
//        }
//        System.out.println("AuthType: " + req.getAuthType());
//        System.out.println("Protocol: " + req.getProtocol());


        // GZip

//        if (req.getHeader("Accept-Encoding").contains("gzip")) {
//
//            PrintWriter printWriter = new PrintWriter(new GZIPOutputStream(resp.getOutputStream()));
//            printWriter.write("Hello, Karina!");
//        }


        // Return Status

//        resp.setStatus(HttpServletResponse.SC_OK);
//        resp.sendRedirect("/ee_war/hello");
//        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "bla-bla-bla");

//        resp.getWriter().write("Hallo, Deutsch!");
//        resp.setHeader("Refresh", "1");
//        System.out.println("refreshing...");

//        resp.setHeader("Refresh", "5;URL=https://google.com");


        // Cookies

//        Cookie cookie = new Cookie("testCookie", "own-cookie");
//        resp.addCookie(cookie);
//
//        // cookie только для этого пути
//        cookie.setPath("/temp");
//
//        // на своем localhost можно прописывать, какие домены будут видеть этот cookie
//        cookie.setDomain("second.my.localhost");
//
//        // true - cookies будут видны только при HTTPS соединении
//        cookie.setSecure(true);
//
//        Cookie cookie2 = new Cookie("testCookie2", "own-cookie2");
//        resp.addCookie(cookie2);
//        cookie2.setMaxAge(5);    // удалится через 5 секунд
//
//        Cookie[] cookies = req.getCookies();
//        for (Cookie c : cookies) {
//            System.out.println("Cookie name: " + c.getName());
//            System.out.println("Cookie value: " + c.getValue());
//            System.out.println("Cookie max age: " + c.getMaxAge());
//        }


        // Session

//        HttpSession session = req.getSession();
//        Enumeration<String> attributeNames = session.getAttributeNames();
//
//        while (attributeNames.hasMoreElements()) {
//            String attributeName = attributeNames.nextElement();
//            System.out.println(attributeName + " = " + session.getAttribute(attributeName));
//        }
//
//        session.setAttribute("one", "two");
//        System.out.println("Max inactive interval: " + session.getMaxInactiveInterval() + " seconds");
//
//        // очищается сессия
//        session.invalidate();

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        doGet(req, resp);
//    }
}

