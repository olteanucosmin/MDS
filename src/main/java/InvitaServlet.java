import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class InvitaServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ideveniment = request.getParameter("ideveniment3");
        getServletContext().removeAttribute("ideveniment");
        getServletContext().setAttribute("ideveniment", ideveniment);
        RequestDispatcher rd = request.getRequestDispatcher("invitaform.jsp");
        rd.forward(request, response);

    }

}
