package edu.matc.contoller;


import edu.matc.HibernateUtil;
import edu.matc.entity.User;
import edu.matc.entity.UserRoles;
import edu.matc.persistence.SessionFactoryProvider;
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


@WebServlet(
        urlPatterns = {"/test"}
)

public class GenericDaoTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        User user = null;
        UserRoles userRoles = null;

        IGenericService<User> userService = new GenericServiceImpl<User>(
                User.class, HibernateUtil.getSessionFactory());
        IGenericService<UserRoles> userRolesService = new GenericServiceImpl<UserRoles>(
                UserRoles.class, HibernateUtil.getSessionFactory());
        userService.deleteAll();

        user = new User();
        user.setFirstName("Mulberry");
        user.setLastName("Briggs");
        user.setUserPassword("coolPassword");
        user.setUserName("starUser");
        userService.save(user);







        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/results.jsp");
        dispatcher.forward(request, response);
    }
}
