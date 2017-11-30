package edu.matc.contoller;

import edu.matc.entity.Log;
import edu.matc.entity.Snag;
import edu.matc.entity.User;
import edu.matc.entity.UserRoles;
import edu.matc.HibernateUtil;
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
import java.util.List;

@WebServlet(
        urlPatterns = {"/genericListAll"}
)

public class GenericListAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = null;
        UserRoles userRoles = null;
        Log log = null;
        Snag snag = null;

        IGenericService<User> userService = new GenericServiceImpl<User>(
                User.class, HibernateUtil.getSessionFactory());
        IGenericService<UserRoles> userRolesService = new GenericServiceImpl<UserRoles>(
                UserRoles.class, HibernateUtil.getSessionFactory());
        IGenericService<Snag> snagService = new GenericServiceImpl<Snag>(
                Snag.class, HibernateUtil.getSessionFactory());
        IGenericService<Log> logService = new GenericServiceImpl<Log>(
                Log.class, HibernateUtil.getSessionFactory());


        response.setContentType("text/html");


        List<User> userList = userService.getAll();
        if (userList != null) {
         //   request.setAttribute("users", userList);
            session.setAttribute("users", userList);
        }



        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/results.jsp");
        dispatcher.forward(request, response);
    }
}