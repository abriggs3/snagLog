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
 * The type Test page.
 */
@WebServlet(
        urlPatterns = {"/testPage"}
)

public class TestPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");



        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/test_page.jsp");
        dispatcher.forward(request, response);
    }
}