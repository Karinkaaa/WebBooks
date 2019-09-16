package ee;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Initialization...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println("DoGet method()");
//
//        String s = "<html>" +
//                "<header><title>LiveCycle</title></header>" +
//                "<body>Hello, Dnipro!</body>" +
//                "</html>";
//        resp.getWriter().write(s);

        resp.getWriter().write("Hello Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("DoPost method()");
        resp.getWriter().write("do post");
        doGet(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Service method()");
        super.service(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method()");
        super.destroy();
    }
}
