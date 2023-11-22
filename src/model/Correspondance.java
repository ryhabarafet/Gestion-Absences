package model;

public class Correspondance {

	private int idEnseignant;
	private int idMatiere;
	private int idClasse;

	public Correspondance(int idEnseignant, int idMatiere, int idClasse) {
		this.idEnseignant = idEnseignant;
		this.idMatiere = idMatiere;
		this.idClasse = idClasse;
	}

	public Correspondance() {
	}

	public int getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public int getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

}
