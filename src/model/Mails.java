package model;

public class Mails {

	private int id_mail;
	private int id_expd;
	private int id_dest;
	private String contenu;

	public Mails( int id_expd, int id_dest, String contenu) {
		this.id_expd = id_expd;
		this.id_dest = id_dest;
		this.contenu = contenu;
	}

	public Mails() {

	}

	public int getId_mail() {
		return id_mail;
	}

	public void setId_mail(int id_mail) {
		this.id_mail = id_mail;
	}

	public int getId_expd() {
		return id_expd;
	}

	public void setId_expd(int id_expd) {
		this.id_expd = id_expd;
	}

	public int getId_dest() {
		return id_dest;
	}

	public void setId_dest(int id_dest) {
		this.id_dest = id_dest;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
