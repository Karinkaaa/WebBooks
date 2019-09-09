package web.servlet;

import JSP.MyModel;
import JSP.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("MyController")
public class MyController extends HttpServlet {

    MyModel myModel = new MyModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = myModel.getPerson();
        req.setAttribute("Student", person);
        req.getSession().setAttribute("Student", person);
    }
}
