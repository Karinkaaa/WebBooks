package controllers;

import jsp.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/temp-controller")
public class TempController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = new Person("Karinkaaa", 22);
        req.setAttribute("person", person);

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        req.setAttribute("list", list);

        Map<String, String> map = new HashMap<>();
        map.put("one", "1");
        map.put("two", "2");;
        req.setAttribute("map", map);

        RequestDispatcher rd = req.getRequestDispatcher("/jsp/temp-jsp.jsp");
        rd.forward(req, resp);

    }
}
