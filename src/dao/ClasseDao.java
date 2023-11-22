package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Classe;
import model.Matiere;


public class ClasseDao {
	
	public static ArrayList<String> getNiveauByEnseignant(int id_enseignant) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<String> array = new ArrayList<>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select niveau from classe join correspondance on "
					+ "classe.id_classe = correspondance.id_classe join enseignant on "
					+ "enseignant.id_enseignant = correspondance.id_enseignant where correspondance.id_enseignant = ? order by niveau");
			ps.setInt(1,id_enseignant);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				array.add(rs.getString("niveau"));
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getFiliereByEnseignantAndNiveau(int id_enseignant,String niveau) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<String> array = new ArrayList<>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select fliere from classe join correspondance on classe.id_classe = correspondance.id_classe join enseignant on enseignant.id_enseignant = correspondance.id_enseignant where correspondance.id_enseignant = ? and niveau = ?");
			ps.setInt(1,id_enseignant);		
			ps.setString(2,niveau);	
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				array.add(rs.getString("fliere"));
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Classe> getClasse(int id_enseignant,String niveau,String filiere) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Classe> array = new ArrayList<Classe>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select classe.* from classe join correspondance on "
					+ "classe.id_classe = correspondance.id_classe join enseignant "
					+ "on enseignant.id_enseignant = correspondance.id_enseignant where correspondance.id_enseignant = ? and "
					+ "niveau = ? and fliere = ?");
			ps.setInt(1,id_enseignant);		
			ps.setString(2,niveau);	
			ps.setString(3,filiere);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Classe c = new Classe();
				c.setIdClasse(rs.getInt("id_classe"));
				c.setLibelleClasse(rs.getString("libelle"));
				c.setNiveau(rs.getString("niveau"));
				c.setFiliere(rs.getString("fliere"));
				array.add(c);
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Classe> getClasseByEnsignant(int id_enseignant) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Classe> array = new ArrayList<Classe>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select classe.* from classe join correspondance on "
					+ "classe.id_classe = correspondance.id_classe join enseignant "
					+ "on enseignant.id_enseignant = correspondance.id_enseignant where correspondance.id_enseignant = ?");
			ps.setInt(1,id_enseignant);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Classe c = new Classe();
				c.setIdClasse(rs.getInt("id_classe"));
				c.setLibelleClasse(rs.getString("libelle"));
				c.setNiveau(rs.getString("niveau"));
				c.setFiliere(rs.getString("fliere"));
				array.add(c);
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Matiere> getMatiere(int id_enseignant,int id_classe) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Matiere> array = new ArrayList<Matiere>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select matiere.* from matiere join correspondance on matiere.id_matiere = correspondance.id_matiere join enseignant on enseignant.id_enseignant = correspondance.id_enseignant where correspondance.id_enseignant = ? and correspondance.id_classe = ?");
			ps.setInt(1,id_enseignant);		
			ps.setInt(2,id_classe);	
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Matiere m = new Matiere();
				m.setIdMatiere(rs.getInt("id_matiere"));
				m.setLibelleMatiere(rs.getString("libelle"));
				array.add(m);
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static ArrayList<Classe> getClasseByEnsignantAndMatiere(int id_enseignant, int id_matiere) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Classe> array = new ArrayList<Classe>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select classe.* from classe join correspondance on "
					+ "classe.id_classe = correspondance.id_classe join enseignant "
					+ "on enseignant.id_enseignant = correspondance.id_enseignant where correspondance.id_enseignant = ? and correspondance.id_matiere = ?");
			ps.setInt(1,id_enseignant);		
			ps.setInt(2,id_matiere);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Classe c = new Classe();
				c.setIdClasse(rs.getInt("id_classe"));
				c.setLibelleClasse(rs.getString("libelle"));
				c.setNiveau(rs.getString("niveau"));
				c.setFiliere(rs.getString("fliere"));
				array.add(c);
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
