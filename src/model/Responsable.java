package model;

public class Responsable {
	
	private int idResponsable;
	private String nomResponsable;
	private String prenomResponsable;
	private String loginResponsable;
	private String pwdResponsable;
	private String emailResponsable;
	
	public Responsable() {
	}
	
	public Responsable(String nomResponsable, String prenomResponsable, String loginResponsable, String pwdResponsable, String emailResponsable) {
		this.nomResponsable = nomResponsable;
		this.prenomResponsable = prenomResponsable;
		this.loginResponsable = loginResponsable;
		this.pwdResponsable = pwdResponsable;
		this.emailResponsable = emailResponsable;
	}

	public int getIdResponsable() {
		return idResponsable;
	}

	public void setIdResponsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}

	public String getNomResponsable() {
		return nomResponsable;
	}

	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}

	public String getPrenomResponsable() {
		return prenomResponsable;
	}

	public void setPrenomResponsable(String prenomResponsable) {
		this.prenomResponsable = prenomResponsable;
	}

	public String getLoginResponsable() {
		return loginResponsable;
	}

	public void setLoginResponsable(String loginResponsable) {
		this.loginResponsable = loginResponsable;
	}

	public String getPwdResponsable() {
		return pwdResponsable;
	}

	public void setPwdResponsable(String pwdResponsable) {
		this.pwdResponsable = pwdResponsable;
	}

	public String getEmailResponsable() {
		return emailResponsable;
	}

	public void setEmailResponsable(String emailResponsable) {
		this.emailResponsable = emailResponsable;
	}
	
	
	
}
