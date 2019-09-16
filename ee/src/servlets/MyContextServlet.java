package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/context")
public class MyContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ServletContext servletContext = req.getSession().getServletContext();
//        servletContext.setAttribute("servlet-1", "context-1");

        ServletContext servletContext = req.getSession().getServletContext();
        Enumeration<String> attributeNames = servletContext.getAttributeNames();

        while (attributeNames.hasMoreElements()) {
            String s = attributeNames.nextElement();
            System.out.println(s + " = " + servletContext.getAttribute(s));
        }
    }
}
