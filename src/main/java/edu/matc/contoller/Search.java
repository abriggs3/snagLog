package edu.matc.contoller;


import edu.matc.HibernateUtil;
import edu.matc.entity.Log;
import edu.matc.entity.Snag;
import edu.matc.entity.User;
import edu.matc.entity.UserRoles;
import edu.matc.persistence.UserDao;
import edu.matc.service.GenericServiceImpl;
import edu.matc.service.IGenericService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


/**
 * The type Search.
 */
@WebServlet(
        urlPatterns = {"/search"}
)

public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

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


        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");
        String tableToSearch = request.getParameter("tableToSearch");
        UserDao userDao = new UserDao();









        if (searchType.equalsIgnoreCase("all")) {
            List<User> userList = userService.getAll();
            if (userList != null) {
                request.setAttribute("users", userList);
            }

        }



        if (searchType.equalsIgnoreCase("lastName") ||
                    searchType.equalsIgnoreCase("firstName") ||
                    searchType.equalsIgnoreCase("userName")) {
            request.setAttribute("users", userDao.getRecordBySearchType(searchTerm, searchType, tableToSearch));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/results.jsp");
        dispatcher.forward(request, response);
    }
}
