package edu.matc.contoller;


import edu.matc.service.GetLogList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * The type Generic list log.
 */
@WebServlet(
        urlPatterns = {"/genericListLog"}
)

public class GenericListLog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetLogList getLogList = new GetLogList();
        // call the get log service to set the list of logs to the session
        getLogList.getLogList(request);



        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/results_log.jsp");
        dispatcher.forward(request, response);
    }
}