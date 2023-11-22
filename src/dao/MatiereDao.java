package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Matiere;

public class MatiereDao {
	
	public static ArrayList<Matiere> getMatiere(int id_etudiant) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Matiere> array = new ArrayList<Matiere>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select matiere.* from matiere join correspondance on correspondance.id_matiere = matiere.id_matiere join etudiant on etudiant.id_classe = correspondance.id_classe where etudiant.id_etudiant = ?");
			ps.setInt(1,id_etudiant);		
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
	
	public static ArrayList<Matiere> getMatiereByEnseignant(int id_enseignant) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Matiere> array = new ArrayList<>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select DISTINCT matiere.* from matiere join correspondance on correspondance.id_matiere = matiere.id_matiere "
					+ "where correspondance.id_enseignant = ?");
			ps.setInt(1,id_enseignant);		
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

}
