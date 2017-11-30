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
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static javafx.scene.input.KeyCode.T;

@WebServlet(
        urlPatterns = {"/adminModifyRecord"}
)

public class AdminModifyRecord extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        response.setContentType("text/html");
        String changeAction = request.getParameter("submitButton");
        String IdOfRecord = request.getParameter("userCheck");
        Integer IdOfRecordAsInteger = Integer.parseInt(IdOfRecord);

        if(IdOfRecordAsInteger == 0) {
            session.setAttribute("userList", request.getParameter("users"));
            request.setAttribute("noUserSelectedError", "Select a user then click a button");

            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/results.jsp");
            dispatcher.forward(request, response);
        }


        IGenericService<User> userService = new GenericServiceImpl<User>(
                User.class, HibernateUtil.getSessionFactory());

        if (changeAction.equalsIgnoreCase("delete")) {
            User userToDelete = userService.get(User.class, IdOfRecordAsInteger);
            request.setAttribute("changeAction", changeAction);
            request.setAttribute("IdOfRecord", IdOfRecord);
            request.setAttribute("user", userToDelete);
            userService.delete(userToDelete);
        }
        if (changeAction.equalsIgnoreCase("update")) {
            User userToUpdate = userService.get(User.class, IdOfRecordAsInteger);
            request.setAttribute("changeAction", changeAction);
            request.setAttribute("IdOfRecord", IdOfRecord);
            request.setAttribute("user", userToUpdate);

            userToUpdate.setFirstName(request.getParameter("firstName" + IdOfRecord));
            userToUpdate.setLastName(request.getParameter("lastName" + IdOfRecord));
            userToUpdate.setUserPassword(request.getParameter("password" + IdOfRecord));

            userService.update(userToUpdate);

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/adminModifyRecord_confirm.jsp");
        dispatcher.forward(request, response);
    }
}
