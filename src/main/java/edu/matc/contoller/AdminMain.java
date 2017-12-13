package edu.matc.contoller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;


/**
 * The type Admin main.
 */
@WebServlet(
        urlPatterns = {"/adminMain"}
)

public class AdminMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/admin_main.jsp");
        dispatcher.forward(request, response);
    }
}
