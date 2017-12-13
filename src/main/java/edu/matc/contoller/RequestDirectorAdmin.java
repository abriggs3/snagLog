package edu.matc.contoller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Request director admin.
 */
@WebServlet(
        urlPatterns = {"/requestDirectorAdmin"}
)

public class RequestDirectorAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        if (request.getParameter("destination").equalsIgnoreCase("adminMain")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/admin_main.jsp");
            dispatcher.forward(request, response);
        }
    }
}