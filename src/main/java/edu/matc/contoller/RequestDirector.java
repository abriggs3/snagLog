package edu.matc.contoller;

        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.annotation.*;
        import java.io.IOException;


@WebServlet(
        urlPatterns = {"/requestDirector"}
)

public class RequestDirector extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        if (request.getParameter("destination").equalsIgnoreCase("register_new_user")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/register.jsp");
            dispatcher.forward(request, response);
        }
        if (request.getParameter("destination").equalsIgnoreCase("log")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("log.jsp");
            dispatcher.forward(request, response);
        }
    }
}
