package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/character-visit")
public class CharacterVisitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Vérifier si un cookie 'visitCount' existe
        Cookie[] cookies = request.getCookies();
        int visitCount = 0;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("visitCount".equals(cookie.getName())) {
                    visitCount = Integer.parseInt(cookie.getValue());
                }
            }
        }

        // Incrémenter le compteur de visites
        visitCount++;

        // Créer ou mettre à jour le cookie 'visitCount'
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
        visitCookie.setMaxAge(60 * 60 * 24 * 365); // Le cookie dure un an
        response.addCookie(visitCookie);

        // Préparer la réponse HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Page des personnages de One Piece</h1>");

        // Afficher le message en fonction du nombre de visites
        if (visitCount == 1) {
            out.println("<p>Bienvenue pour la première fois sur la page One Piece !</p>");
        } else {
            out.println("<p>C'est votre " + visitCount + "ème visite sur la page One Piece ! Merci de revenir.</p>");
        }

        out.println("</body></html>");
    }

}
