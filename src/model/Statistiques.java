package model;

public class Statistiques {
	
	private int nombreAbs;
	private String classe;
	
	public Statistiques(int nombreAbs, String classe) {
		this.nombreAbs = nombreAbs;
		this.classe = classe;
	}

	public Statistiques() {
		
	}

	public int getNombreAbs() {
		return nombreAbs;
	}

	public void setNombreAbs(int nombreAbs) {
		this.nombreAbs = nombreAbs;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	

}
