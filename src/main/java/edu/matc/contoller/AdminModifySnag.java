package edu.matc.contoller;

import edu.matc.HibernateUtil;
import edu.matc.entity.Snag;
import edu.matc.entity.User;
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
 * The type Admin modify snag.
 */
@WebServlet(
        urlPatterns = {"/adminModifySnag"}
)

public class AdminModifySnag extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        response.setContentType("text/html");
        String changeAction = request.getParameter("submitButton");
        String IdOfRecord = request.getParameter("snagCheck");
        Integer IdOfRecordAsInteger = Integer.parseInt(IdOfRecord);

        if(IdOfRecordAsInteger == 0) {
            session.setAttribute("snagList", request.getParameter("snags"));
            request.setAttribute("noSnagSelectedError", "Select a snag then click delete");

            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/results_snag.jsp");
            dispatcher.forward(request, response);
        }


        IGenericService<Snag> snagService = new GenericServiceImpl<Snag>(
                Snag.class, HibernateUtil.getSessionFactory());

        if (changeAction.equalsIgnoreCase("delete")) {
            Snag snagToDelete = snagService.get(Snag.class, IdOfRecordAsInteger);
            request.setAttribute("changeAction", changeAction);
            request.setAttribute("IdOfRecord", IdOfRecord);
            request.setAttribute("snag", snagToDelete);
            snagService.delete(snagToDelete);
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/adminModifyRecord_confirm.jsp");
        dispatcher.forward(request, response);
    }
}
