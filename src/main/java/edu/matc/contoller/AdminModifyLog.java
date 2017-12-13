package edu.matc.contoller;

import edu.matc.HibernateUtil;
import edu.matc.entity.Log;
import edu.matc.service.GenericServiceImpl;
import edu.matc.service.IGenericService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The type Admin modify log.
 */
@WebServlet(
        urlPatterns = {"/adminModifyLog"}
)

public class AdminModifyLog extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        response.setContentType("text/html");
        String changeAction = request.getParameter("submitButton");
        String IdOfRecord = request.getParameter("logCheck");
        Integer IdOfRecordAsInteger = Integer.parseInt(IdOfRecord);

        if(IdOfRecordAsInteger == 0) {
            session.setAttribute("logList", request.getParameter("logs"));
            request.setAttribute("noLogSelectedError", "Select a log record then click a button");

            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/results_log.jsp");
            dispatcher.forward(request, response);
        }


        IGenericService<Log> logService = new GenericServiceImpl<Log>(
                Log.class, HibernateUtil.getSessionFactory());

        if (changeAction.equalsIgnoreCase("delete")) {
            Log logToDelete = logService.get(Log.class, IdOfRecordAsInteger);
            request.setAttribute("changeAction", changeAction);
            request.setAttribute("IdOfRecord", IdOfRecord);
            request.setAttribute("log", logToDelete);
            logService.delete(logToDelete);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/adminModifyRecord_confirm.jsp");
        dispatcher.forward(request, response);
    }
}
