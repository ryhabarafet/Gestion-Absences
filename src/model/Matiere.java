package model;

public class Matiere {
	
	private int idMatiere;
	private String libelleMatiere;
	
	public Matiere(String libelleMatiere) {
		this.libelleMatiere = libelleMatiere;
	}
	
	public Matiere() {
	}

	public int getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public String getLibelleMatiere() {
		return libelleMatiere;
	}
	public void setLibelleMatiere(String libelleMatiere) {
		this.libelleMatiere = libelleMatiere;
	}
	
}
