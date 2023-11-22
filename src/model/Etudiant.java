package model;

public class Etudiant {
	
	private int idEtudiant;
	private String nomEtudiant;
	private String prenomEtudiant;
	private String loginEtudiant;
	private String pwdEtudiant;
	private String mailEtudiant;
	private int idClasse;
	
	public Etudiant(String nomEtudiant, String prenomEtudiant, String loginEtudiant, String pwdEtudiant, String mailEtudiant, int idClasse) {
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.loginEtudiant = loginEtudiant;
		this.pwdEtudiant = pwdEtudiant;
		this.mailEtudiant= mailEtudiant;
		this.idClasse = idClasse;
	}

	public Etudiant() {
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNomEtudiant() {
		return nomEtudiant;
	}

	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}

	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}

	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}

	public String getLoginEtudiant() {
		return loginEtudiant;
	}

	public void setLoginEtudiant(String loginEtudiant) {
		this.loginEtudiant = loginEtudiant;
	}

	public String getPwdEtudiant() {
		return pwdEtudiant;
	}

	public void setPwdEtudiant(String pwdEtudiant) {
		this.pwdEtudiant = pwdEtudiant;
	}

	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public String getMailEtudiant() {
		return mailEtudiant;
	}

	public void setMailEtudiant(String mailEtudiant) {
		this.mailEtudiant = mailEtudiant;
	}
	
	
	
}
