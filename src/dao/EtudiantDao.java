package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Etudiant;
import model.Mails;

public class EtudiantDao {
	
	public static Etudiant chercherEtudiant(String login,String password) {
		Connection connection = ConnectionBD.getConnection();
		Etudiant etudiant = new Etudiant();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from etudiant where login = ? and pwd = ? ");
			ps.setString(1,login);
			ps.setString(2,password);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				etudiant.setIdEtudiant(rs.getInt("id_etudiant"));
				etudiant.setNomEtudiant(rs.getString("nom"));
				etudiant.setPrenomEtudiant(rs.getString("prenom"));
				etudiant.setLoginEtudiant(rs.getString("login"));
				etudiant.setPwdEtudiant(rs.getString("pwd"));
				etudiant.setIdClasse(rs.getInt("id_classe"));
				return etudiant;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Etudiant> getEtudiantByClasse(int id_classe) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Etudiant> array = new ArrayList<Etudiant>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from etudiant where id_classe = ?");
			ps.setInt(1,id_classe);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Etudiant etudiant = new Etudiant();
				etudiant.setIdEtudiant(rs.getInt("id_etudiant"));
				etudiant.setNomEtudiant(rs.getString("nom"));
				etudiant.setPrenomEtudiant(rs.getString("prenom"));
				etudiant.setLoginEtudiant(rs.getString("login"));
				etudiant.setPwdEtudiant(rs.getString("pwd"));
				etudiant.setIdClasse(rs.getInt("id_classe"));
				array.add(etudiant);
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Integer> getIdEtudiantByClasse(int id_classe) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select id_etudiant from etudiant where id_classe = ?");
			ps.setInt(1,id_classe);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				array.add(rs.getInt(1));
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Etudiant getEtudiantByEmail(String email) {
		Connection connection = ConnectionBD.getConnection();
		Etudiant etudiant = new Etudiant();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from etudiant where email = ? ");
			ps.setString(1,email);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				etudiant.setIdEtudiant(rs.getInt("id_etudiant"));
				etudiant.setNomEtudiant(rs.getString("nom"));
				etudiant.setPrenomEtudiant(rs.getString("prenom"));
				etudiant.setLoginEtudiant(rs.getString("login"));
				etudiant.setPwdEtudiant(rs.getString("pwd"));
				etudiant.setIdClasse(rs.getInt("id_classe"));
				return etudiant;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Mails> getMailsByEtudiant(int id) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Mails> array = new ArrayList<Mails>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from mails where destinataire = ? ");
			ps.setInt(1,id);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Mails m = new Mails();
				m.setId_mail(rs.getInt("id"));
				m.setId_expd(rs.getInt("expediteur"));
				m.setId_dest(rs.getInt("destinataire"));
				m.setContenu(rs.getString("contenu"));
				array.add(m);
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
