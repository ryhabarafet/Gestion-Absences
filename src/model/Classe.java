package model;

public class Classe {
	
	private int idClasse;
	private String libelleClasse;
	private String niveau;
	private String filiere;
	
	public Classe(String libelleClasse, String niveau, String filiere) {
		this.libelleClasse = libelleClasse;
		this.niveau = niveau;
		this.filiere = filiere;
	}

	public Classe() {
	}

	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public String getLibelleClasse() {
		return libelleClasse;
	}

	public void setLibelleClasse(String libelleClasse) {
		this.libelleClasse = libelleClasse;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	
}
