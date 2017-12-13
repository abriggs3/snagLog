package edu.matc.contoller;

import edu.matc.service.GetLogList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Generic list log reversed.
 */
@WebServlet(
        urlPatterns = {"/genericListLogReversed"}
)

public class GenericListLogReversed extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        GetLogList getLogList = new GetLogList();
        // call the get log service to set the list of logs in reverse order to the session
        String jsonReversedLogList = getLogList.getLogListReversed();
        response.getWriter().write(jsonReversedLogList);
    }
}