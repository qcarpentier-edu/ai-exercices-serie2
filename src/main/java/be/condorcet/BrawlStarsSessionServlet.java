package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/brawlstars-session")
public class BrawlStarsSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BrawlStarsSessionServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        // Vérifier si l'utilisateur veut réinitialiser la session
        if (request.getParameter("reset") != null) {
            session.invalidate(); // Invalider la session existante
            session = request.getSession(true); // Créer une nouvelle session
            out.println("<h1>La session a été réinitialisée.</h1>");
        }

        // Récupérer les informations de la session
        String character = (String) session.getAttribute("character");
        String gameMode = (String) session.getAttribute("gameMode");

        if (character == null || gameMode == null) {
            // Si les informations ne sont pas dans la session, afficher le formulaire
            out.println("<h1>Bienvenue dans Brawl Stars !</h1>");
            out.println("<form action='brawlstars-session' method='post'>");
            out.println("Choisissez un personnage :<br>");
            out.println("<input type='text' name='character' required><br><br>");
            out.println("Choisissez un mode de jeu :<br>");
            out.println("<input type='text' name='gameMode' required><br><br>");
            out.println("<input type='submit' value='Commencer'></form>");
        } else {
            // Afficher les informations de la session
            out.println("<h1>Rebonjour ! Vous êtes toujours dans Brawl Stars.</h1>");
            out.println("<p>Personnage : " + character + "</p>");
            out.println("<p>Mode de jeu : " + gameMode + "</p>");
            out.println("<a href='brawlstars-session?reset=true'>Réinitialiser la session</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les paramètres envoyés par le formulaire
        String character = request.getParameter("character");
        String gameMode = request.getParameter("gameMode");

        // Stocker les informations dans la session
        HttpSession session = request.getSession();
        session.setAttribute("character", character);
        session.setAttribute("gameMode", gameMode);

        // Rediriger vers la méthode GET pour afficher les informations de la session
        response.sendRedirect("brawlstars-session");
    }
}
