package edu.matc.contoller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/login"}
)

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        System.out.println("type = " + request.getUserPrincipal().getClass());


        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/login_success.jsp");
        dispatcher.forward(request, response);
    }
}