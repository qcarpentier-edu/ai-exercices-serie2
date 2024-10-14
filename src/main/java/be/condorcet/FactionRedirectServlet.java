package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/faction-redirect")
public class FactionRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Récupérer le choix de faction de l'utilisateur
        String faction = request.getParameter("faction");

        // Rediriger en fonction de la faction choisie
        if ("Jedi".equals(faction)) {
            response.sendRedirect("jedi-welcome.html");
        } else if ("Sith".equals(faction)) {
            response.sendRedirect("sith-welcome.html");
        } else {
            response.sendRedirect("error.html"); // Redirection en cas de choix non valide
        }
    }

}
