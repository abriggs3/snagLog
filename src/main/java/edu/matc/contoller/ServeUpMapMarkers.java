package edu.matc.contoller;


import com.fasterxml.jackson.databind.ObjectMapper;

import edu.matc.HibernateUtil;
import edu.matc.entity.Snag;
import edu.matc.service.GenericServiceImpl;
import edu.matc.service.IGenericService;
import org.apache.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


/**
 * The type Serve up map markers.
 */
@WebServlet(
        urlPatterns = {"/serveUpMapMarkers"}
)

public class ServeUpMapMarkers extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        IGenericService<Snag> snagService = new GenericServiceImpl<Snag>(
                Snag.class, HibernateUtil.getSessionFactory());

        List<Snag> snagList = snagService.getAll();
        if (snagList != null) {
            ObjectMapper objectMapper = new ObjectMapper();

            //convert list of snags to json
            String snagListToJson = objectMapper.writeValueAsString(snagList);
            objectMapper.writeValue(response.getOutputStream(), snagList);
        }
    }
}