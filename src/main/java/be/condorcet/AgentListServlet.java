package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AgentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AgentListServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	// Initialiser nos agents
    	List<Agent> agents = new ArrayList<>();
    	agents.add(new Agent("Jett", "Duelist", "Corée"));
    	agents.add(new Agent("Sova", "Initiateur", "Russie"));
    	agents.add(new Agent("Sage", "Sentinel", "Chine"));
    
    	// Stocker la liste des agents dans le contexte
    	getServletContext().setAttribute("agentList", agents);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Agent> agents = (List<Agent>)getServletContext().getAttribute("agentList");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
        out.println("<h1>Liste des agents de Valorant</h1>");
        out.println("<table>");
        out.println("<tr><th>Nom</th><th>Rôle</th><th>Nationalité</th></tr>");
        
        for (Agent agent : agents) {
        	out.println("<tr><td>" + agent.getName() + "</td><td>" + agent.getRole() + "</td><td>" + agent.getNationality() + "</td><tr>");
        }
        
        out.println("</table>");
        
        // Formulaire de modifier d'un Agent
        out.println("<form action='update-agent' method='post'>");
        out.println("    <input type='text' name='name' placeholder='Nom' required></br>");
        out.println("    <input type='text' name='newName' placeholder='Nouveau nom' required></br>");
        out.println("    <input type='text' name='newNationality' placeholder='Nouvelle nationalité' required></br>");
        out.println("    <input type='text' name='newRole' placeholder='Nouveau rôle' required></br>");
        out.println("    <input type='submit' value='Mettre à jour' />");
        out.println("</form>");
        
        out.println("</body></html>");
	}
}
