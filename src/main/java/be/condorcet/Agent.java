package be.condorcet;

public class Agent {
	private String name;
	private String role;
	private String nationality;
	
	public Agent(String name, String role, String nationality) {
		this.name = name;
		this.role = role;
		this.nationality = nationality;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
