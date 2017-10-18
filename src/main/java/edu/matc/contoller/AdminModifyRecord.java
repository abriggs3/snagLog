package edu.matc.contoller;

import edu.matc.HibernateUtil;
import edu.matc.entity.User;
import edu.matc.service.GenericServiceImpl;
import edu.matc.service.IGenericService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/adminModifyRecord"}
)

public class AdminModifyRecord extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String changeAction = request.getParameter("submitButton");
        String IdOfRecord = request.getParameter("userCheck");
        Integer IdOfRecordAsInteger = Integer.parseInt(IdOfRecord);

        IGenericService<User> userService = new GenericServiceImpl<User>(
                User.class, HibernateUtil.getSessionFactory());

        if (changeAction.equalsIgnoreCase("delete")) {
            request.setAttribute("changeAction", changeAction);
            request.setAttribute("IdOfRecord", IdOfRecord);
            request.setAttribute("user", userService.get(Class<User>, IdOfRecordAsInteger));
            User userToDelete = userService.get();
            userService.delete(userToDelete);

        }
        if (changeAction.equalsIgnoreCase("update")) {
            request.setAttribute("changeAction", changeAction);
            request.setAttribute("IdOfRecord", IdOfRecord);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/adminModifyRecord_confirm.jsp");
        dispatcher.forward(request, response);
    }
}
