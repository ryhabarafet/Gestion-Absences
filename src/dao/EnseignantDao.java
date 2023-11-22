package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Enseignant;

public class EnseignantDao {
	
	public static Enseignant chercherEnseignant(String login,String password) {
		Connection connection = ConnectionBD.getConnection();
		Enseignant enseignant = new Enseignant();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from enseignant where login = ? and pwd = ? ");
			ps.setString(1,login);
			ps.setString(2,password);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				enseignant.setIdEnseignant(rs.getInt("id_enseignant"));
				enseignant.setNomEnseignant(rs.getString("nom"));
				enseignant.setPrenomEnseignant(rs.getString("prenom"));
				enseignant.setLoginEnseignant(rs.getString("login"));
				enseignant.setPwdEnseignant(rs.getString("pwd"));
				return enseignant;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Enseignant> getEnseignant() {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Enseignant> array = new ArrayList<Enseignant>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from enseignant");		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Enseignant enseignant = new Enseignant();
				enseignant.setIdEnseignant(rs.getInt("id_enseignant"));
				enseignant.setNomEnseignant(rs.getString("nom"));
				enseignant.setPrenomEnseignant(rs.getString("prenom"));
				enseignant.setLoginEnseignant(rs.getString("login"));
				enseignant.setPwdEnseignant(rs.getString("pwd"));
				array.add(enseignant);
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
