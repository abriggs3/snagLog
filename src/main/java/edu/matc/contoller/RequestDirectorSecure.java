package edu.matc.contoller;

        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.annotation.*;
        import java.io.IOException;

/**
 * The type Request director secure.
 */
@WebServlet(
        urlPatterns = {"/requestDirectorSecure"}
)

public class RequestDirectorSecure extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        if (request.getParameter("destination").equalsIgnoreCase("markSnag")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/markSnag/markSnag.jsp");
            dispatcher.forward(request, response);
        }
    }
}
