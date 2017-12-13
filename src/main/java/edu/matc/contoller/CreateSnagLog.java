package edu.matc.contoller;

        import edu.matc.HibernateUtil;
        import edu.matc.entity.Log;
        import edu.matc.entity.User;
        import edu.matc.io.weatherbit.DataItem;
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
        import java.text.DateFormat;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

/**
 * The type Create snag log.
 */
@WebServlet(
        urlPatterns = {"/createSnagLog"}
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

        //get date from form and covert to usable data type
        String dateFromFormAsString = request.getParameter("datepicker");
        Date dateFromFormParsed = new Date();
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            dateFromFormParsed = formatter.parse(dateFromFormAsString);

        } catch (ParseException e) {
            logger.error("date from form was unable to be parsed.");
            dateFromFormParsed = null;
        }

        int tripLength = Integer.parseInt(request.getParameter("tripLength"));

        Double startLocationLat = Double.parseDouble(request.getParameter("startPointLat"));
        Double startLocationLon = Double.parseDouble(request.getParameter("startPointLon"));
        Double endLocationLat = Double.parseDouble(request.getParameter("endPointLat"));
        Double endLocationLon = Double.parseDouble(request.getParameter("endPointLon"));
        String waterBodyName = request.getParameter("waterBodyName");
        String waterBodyType = request.getParameter("waterBodyType");
        String waterSubChoice = request.getParameter("waterSubChoice");
        String logText = request.getParameter("logText");


        //call the weather service to get additional info
        WeatherApi weatherApi = new WeatherApi();
        DataItem dataItem = weatherApi.callWeatherApi(startLocationLat, startLocationLon);
        System.out.println("this is the dataItem " + dataItem.toString());

        // use the weather service data
        String city = dataItem.getCityName();
        String state = dataItem.getStateCode();
        String weatherDescription = dataItem.getWeather().getDescription();
        // get the temp and convert from C to F
        Double temperature = ((dataItem.getTemp()) * 1.8) + 32;

        Log log = new Log(dateFromFormParsed, tripLength, startLocationLat, startLocationLon, endLocationLat, endLocationLon, waterBodyName, waterBodyType, waterSubChoice, logText, city, state, weatherDescription, temperature, user);


        logService.save(log);
        request.setAttribute("logData", log);


        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/makeLogConfirmation.jsp");
        dispatcher.forward(request, response);

    }
}
