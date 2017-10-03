package edu.matc.contoller;


import edu.matc.persistence.UserHibernateDao;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(
        urlPatterns = {"/adminMain"}
)

public class AdminMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        RequestDispatcher dispatcher = request.getRequestDispatcher("pages_secure/admin_main.jsp");
        dispatcher.forward(request, response);
    }
}
