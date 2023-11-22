package model;

public class Enseignant {
	
	private int idEnseignant;
	private String nomEnseignant;
	private String prenomEnseignant;
	private String loginEnseignant;
	private String pwdEnseignant;
	
	public Enseignant(String nomEnseignant, String prenomEnseignant, String loginEnseignant, String pwdEnseignant) {
		this.nomEnseignant = nomEnseignant;
		this.prenomEnseignant = prenomEnseignant;
		this.loginEnseignant = loginEnseignant;
		this.pwdEnseignant = pwdEnseignant;
	}

	public Enseignant() {
	}

	public int getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public String getNomEnseignant() {
		return nomEnseignant;
	}

	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}

	public String getPrenomEnseignant() {
		return prenomEnseignant;
	}

	public void setPrenomEnseignant(String prenomEnseignant) {
		this.prenomEnseignant = prenomEnseignant;
	}

	public String getLoginEnseignant() {
		return loginEnseignant;
	}

	public void setLoginEnseignant(String loginEnseignant) {
		this.loginEnseignant = loginEnseignant;
	}

	public String getPwdEnseignant() {
		return pwdEnseignant;
	}

	public void setPwdEnseignant(String pwdEnseignant) {
		this.pwdEnseignant = pwdEnseignant;
	}
	
}
