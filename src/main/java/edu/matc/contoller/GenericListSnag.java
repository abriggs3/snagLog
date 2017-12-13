package edu.matc.contoller;

import edu.matc.HibernateUtil;
import edu.matc.entity.Snag;
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

/**
 * The type Generic list snag.
 */
@WebServlet(
        urlPatterns = {"/genericListSnag"}
)

public class GenericListSnag extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Snag snag = null;

        IGenericService<Snag> snagService = new GenericServiceImpl<Snag>(
                Snag.class, HibernateUtil.getSessionFactory());

        response.setContentType("text/html");


        List<Snag> snagList = snagService.getAll();
        if (snagList != null) {
            session.setAttribute("snags", snagList);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/results_snag.jsp");
        dispatcher.forward(request, response);
    }
}