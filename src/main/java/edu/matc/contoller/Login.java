package edu.matc.contoller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The type Login.
 */
@WebServlet(
        urlPatterns = {"/login"}
)

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // get access to the current HTTP session
        HttpSession session = request.getSession();
        // add an attribute to the session so that JSTL can be used to toggle the login and out menu bar
        session.setAttribute("loggedInUsersName", request.getRemoteUser());
        // remove disabled form fields for logged in users
        session.setAttribute("disabledByDefault", "stopDisablingTheForm");

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/login_success.jsp");
        dispatcher.forward(request, response);
    }
}