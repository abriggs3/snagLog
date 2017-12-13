package edu.matc.contoller;

import edu.matc.HibernateUtil;
import edu.matc.entity.Snag;
import edu.matc.entity.User;
import edu.matc.service.GenericServiceImpl;
import edu.matc.service.IGenericService;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Mark snag.
 */
@WebServlet(
        urlPatterns = {"/markSnag"}
)

public class MarkSnag extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Logger logger = Logger.getLogger(this.getClass());
        IGenericService<Snag> snagService = new GenericServiceImpl<Snag>(
                Snag.class, HibernateUtil.getSessionFactory());
        IGenericService<User> userService = new GenericServiceImpl<User>(
                User.class, HibernateUtil.getSessionFactory());

        response.setContentType("text/html");

        //get the info on the current user
        String userNameOfCurrentUser = request.getRemoteUser();
        Map<String, Object> params = new HashMap<>();
        List<User> users = userService.query("FROM User where userName = '" + userNameOfCurrentUser + "'", params);
        User user = users.get(0);

        Double locationLat = Double.parseDouble(request.getParameter("latitudeClicked"));
        Double locationLon = Double.parseDouble(request.getParameter("longitudeClicked"));
        String blockageType = request.getParameter("blockageType");
        String hazard = request.getParameter("hazardOrNot");
        Integer estimatedDelay = Integer.parseInt(request.getParameter("timeDelay"));
        String additionalInformation = request.getParameter("additionalBlockageInformation");

        Snag snag = new Snag(locationLat, locationLon, blockageType, hazard, estimatedDelay, additionalInformation, user);


            snagService.save(snag);
            request.setAttribute("snagMarked", snag);


        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/markSnagConfirmation.jsp");
        dispatcher.forward(request, response);

    }
}
