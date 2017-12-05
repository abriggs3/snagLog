package edu.matc.contoller;

        import edu.matc.HibernateUtil;
        import edu.matc.entity.Log;
        import edu.matc.entity.User;
        import edu.matc.service.GenericServiceImpl;
        import edu.matc.service.IGenericService;
        import org.apache.log4j.Logger;

        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

@WebServlet(
        urlPatterns = {"/markSnag"}
)

public class CreateSnagLog extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Logger logger = Logger.getLogger(this.getClass());
        IGenericService<Log> logService = new GenericServiceImpl<Log>(
                Log.class, HibernateUtil.getSessionFactory());
        IGenericService<User> userService = new GenericServiceImpl<User>(
                User.class, HibernateUtil.getSessionFactory());

        response.setContentType("text/html");

        //get the info on the current user
        String userNameOfCurrentUser = request.getRemoteUser();
        Map<String, Object> params = new HashMap<>();
        List<User> users = userService.query("FROM User where userName = '" + userNameOfCurrentUser + "'", params);
        User user = users.get(0);

        Double startLocationLat = Double.parseDouble(request.getParameter("startPointLat"));
        Double startLocationLon = Double.parseDouble(request.getParameter("startPointLon"));
        Double endLocationLat = Double.parseDouble(request.getParameter("endPointLat"));
        Double endLocationLon = Double.parseDouble(request.getParameter("endPointLon"));
        String waterBodyName = request.getParameter("waterBodyName");
        String waterBodyType = request.getParameter("waterBodyType");
        String waterSubChoice = request.getParameter("waterSubChoice");
        String logText = request.getParameter("logText");
        //TODO get weather data
        //Double weather variables go here

        // TODO fix constructor to match Log-- log = new Log(startLocationLat, startLocationLon, endLocationLat, endLocationLon, waterBodyName, waterBodyType, waterSubChoice, logText);


        // need new constructor -- logService.save(log);
        // need new constructor -- request.setAttribute("snagMarked", log);


        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/markSnagConfirmation.jsp");
        dispatcher.forward(request, response);

    }
}
