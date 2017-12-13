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
 * The type Logout.
 */
@WebServlet(
        urlPatterns = {"/logout"}
)

public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession();

        session.invalidate();
        request.setAttribute("loggedInUsersName", null);
        request.setAttribute("userLoggedOut", request.getRemoteUser() + " has been logged out.");

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/logout.jsp");
        dispatcher.forward(request, response);
    }
}
