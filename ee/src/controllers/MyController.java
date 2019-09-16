package controllers;

import jsp.MyModel;
import jsp.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/my-controller")
public class MyController extends HttpServlet {

    MyModel model = new MyModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = model.getPerson();

        // <jsp:useBean id="person" class="jsp.Person" scope="request"/>
        req.setAttribute("person", person);

        //  <jsp:useBean id="person" class="jsp.Person" scope="session"/>
        //req.getSession().setAttribute("person", person);

        // <jsp:useBean id="person" class="jsp.Person" scope="application"/>
        //req.getSession().getServletContext().setAttribute("person", person);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/temp-jsp.jsp");
        requestDispatcher.forward(req, resp);
    }
}
