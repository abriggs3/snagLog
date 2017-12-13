package edu.matc.contoller;

import edu.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Generic search.
 */
@WebServlet(
        urlPatterns = {"/genericSearch"}
)

public class GenericSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");
        String tableToSearch = request.getParameter("tableToSearch");




        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/results.jsp");
        dispatcher.forward(request, response);
    }
}