package model;

import java.util.Date;

public class Absence {
	
	private int idEtudiant;
	private int idEnseignant;
	private int idMatiere;
	private int numSeance;
	private Date dateAbsence;
	private String etat;
	
	public Absence(int idEtudiant, int idEnseignant, int idMatiere, int numSeance, Date dateAbsence, String etat) {
		this.idEtudiant = idEtudiant;
		this.idEnseignant = idEnseignant;
		this.idMatiere = idMatiere;
		this.numSeance = numSeance;
		this.dateAbsence = dateAbsence;
		this.etat = etat;
	}

	public Absence() {
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
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

	public int getNumSeance() {
		return numSeance;
	}

	public void setNumSeance(int numSeance) {
		this.numSeance = numSeance;
	}

	public Date getDateAbsence() {
		return dateAbsence;
	}

	public void setDateAbsence(Date dateAbsence) {
		this.dateAbsence = dateAbsence;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Absence [idEtudiant=" + idEtudiant + ", idEnseignant=" + idEnseignant + ", idMatiere=" + idMatiere
				+ ", numSeance=" + numSeance + ", dateAbsence=" + dateAbsence + ", etat=" + etat + "]";
	}

	
	
	
		
}
