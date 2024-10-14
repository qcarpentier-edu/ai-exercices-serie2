package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UpdateAgent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateAgent() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer les infos
		String agentName = request.getParameter("name");
		String agentNewName = request.getParameter("newName");
		String agentNewRole = request.getParameter("newRole");
		String agentNewNationality = request.getParameter("newNationality");
	
		// Récupérer la liste des agents du contexte
		List<Agent> agents = (List<Agent>)getServletContext().getAttribute("agentList");
		
		if (agents.isEmpty()) {
			throw new ServletException("La liste est vide !");
		}
		
		// Modifier la nationalité d'un agent
		for (Agent agent : agents) {
			if (agent.getName().equals(agentName)) {
				agent.setName(agentNewName);
				agent.setNationality(agentNewNationality);
				agent.setRole(agentNewRole);
				break;
			}
		}
		
		// Re-stocker la liste des agents dans le contexte
		getServletContext().setAttribute("agentList", agents);
	}
}
