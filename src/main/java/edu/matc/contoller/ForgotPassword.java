package edu.matc.contoller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Forgot password.
 */
@WebServlet(
        urlPatterns = {"/forgotPassword"}
)

public class ForgotPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/forgotPassword.jsp");
        dispatcher.forward(request, response);
    }
}
