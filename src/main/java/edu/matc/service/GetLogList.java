package edu.matc.service;

import com.google.gson.Gson;
import edu.matc.HibernateUtil;
import edu.matc.entity.Log;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

public class GetLogList {
    final Logger logger = Logger.getLogger(this.getClass());

    public void getLogList(HttpServletRequest request) {
        HttpSession session = request.getSession();

        IGenericService<Log> snagService = new GenericServiceImpl<Log>(
                Log.class, HibernateUtil.getSessionFactory());

        List<Log> logList = snagService.getAll();
        if (logList != null) {
            session.setAttribute("logs", logList);
        }
    }
       /* works but looking for better way using json
    public String getLogListReversed(HttpServletRequest request) {
        HttpSession session = request.getSession();

        IGenericService<Log> snagService = new GenericServiceImpl<Log>(
                Log.class, HibernateUtil.getSessionFactory());

        List<Log> logList = snagService.getAll();
        Collections.reverse(logList);

        try {
            for (int i = 0; i < 7; i++) {
                session.setAttribute("logs" + i, logList.get(i));
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            logger.error("there are not enough logs to fill all spots, which is no big deal", indexOutOfBoundsException);
        }
        */

    public String getLogListReversed() {

        IGenericService<Log> snagService = new GenericServiceImpl<Log>(
                Log.class, HibernateUtil.getSessionFactory());

        List<Log> logList = snagService.getAll();
        Collections.reverse(logList);
        Gson gson = new Gson();
        return gson.toJson(logList);
    }
}