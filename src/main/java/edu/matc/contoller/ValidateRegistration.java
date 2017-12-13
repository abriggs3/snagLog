package edu.matc.contoller;

import edu.matc.HibernateUtil;
import edu.matc.entity.User;
import edu.matc.entity.UserRoles;
import edu.matc.service.GenericServiceImpl;
import edu.matc.service.IGenericService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Validate registration.
 */
@WebServlet(
        urlPatterns = {"/validateRegistration"}
)

public class ValidateRegistration extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        IGenericService<User> userService = new GenericServiceImpl<User>(User.class, HibernateUtil.getSessionFactory());
        IGenericService<UserRoles> userRolesService = new GenericServiceImpl<>(UserRoles.class, HibernateUtil.getSessionFactory());
        boolean registrationValid = false;

        response.setContentType("text/html");
        User userToRegister = new User();
        userToRegister.setFirstName(request.getParameter("firstName"));
        userToRegister.setLastName(request.getParameter("lastName"));
        userToRegister.setUserName(request.getParameter("userName"));
        userToRegister.setUserPassword(request.getParameter("password"));

        request.setAttribute("userToRegister", userToRegister);
        request.setAttribute("userEnteredFirstName", userToRegister.getFirstName());
        request.setAttribute("userEnteredLastName", userToRegister.getLastName());


        switch (userNameTest(userService, userToRegister)) {
            case "username unavailable" :
                request.setAttribute("userNameAvailabilityError", "username in use, please try again");
                registrationValid = false;
                break;

            case "username available" :
                request.setAttribute("userEnteredUserName", userToRegister.getUserName());
                registrationValid = true;
                break;
            default:
                logger.error("failure in username availability check");

        }

        // if the user entered no password, reject it
        if (request.getParameter("password").equals("")) {
            request.setAttribute("passwordMatchError", "please enter a password");
            registrationValid = false;
        }

        // if the passwords don't match, reject form
        if (!request.getParameter("password").equals(request.getParameter("password_confirmation"))) {
            request.setAttribute("passwordMatchError", "passwords must match");
            registrationValid = false;
        }

        // if the info in form is valid, add the user to db and go to confirmation page, else show registration page again
        if (registrationValid) {
            //add the new user to the Users table
            userService.save(userToRegister);
            //add the new user to the User_roles table
            UserRoles userRoles = new UserRoles(userToRegister.getUserName(), "contributor", userToRegister);
            userRolesService.save(userRoles);
            request.setAttribute("userToRegister", userToRegister);
            request.setAttribute("userRoles", userRoles);

            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/register_result.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/register.jsp");
            dispatcher.forward(request, response);
        }
    }

    private String userNameTest(IGenericService<User> userService, User userToRegister) {
        String resultOfUserNameTest = "";
        String userNameToTest = userToRegister.getUserName();
        List<User> userList = userService.getAll();
        for (User user : userList) {
            String userNameInDataBase = user.getUserName();
            if (userNameInDataBase.equals(userNameToTest.trim())) {
                return resultOfUserNameTest = "username unavailable";
            }
        }
        return resultOfUserNameTest = "username available";
    }
}