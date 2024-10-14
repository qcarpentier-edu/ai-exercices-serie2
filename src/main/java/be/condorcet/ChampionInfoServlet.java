package be.condorcet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChampionInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChampionInfoServlet() {
        super();
    }

    private String championName;
    private String championRole;
    private String championDifficulty;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        // Récupération des paramètres de configuration définis dans web.xml
        championName = config.getInitParameter("championName");
        championRole = config.getInitParameter("championRole");
        championDifficulty = config.getInitParameter("championDifficulty");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Paramétrage du type de contenu de la réponse
        response.setContentType("text/html");
        
        // Construction de la réponse HTML
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Informations sur le champion</h1>");
        response.getWriter().println("<p><strong>Champion :</strong> " + championName + "</p>");
        response.getWriter().println("<p><strong>Rôle :</strong> " + championRole + "</p>");
        response.getWriter().println("<p><strong>Difficulté :</strong> " + championDifficulty + "</p>");
        response.getWriter().println("</body></html>");
    }
}
