package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Statistiques;

public class StatistiqueDao {
	
	public static ArrayList<Statistiques> statNbAbsByClasse() {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Statistiques> array = new ArrayList<Statistiques>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select count(a.id_etudiant) as nbAbs,c.libelle from absence a join etudiant et on a.id_etudiant = et.id_etudiant join classe c on et.id_classe = c.id_classe where a.etat = 'true' GROUP by c.libelle order by c.id_classe desc");		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Statistiques s = new Statistiques();
				s.setNombreAbs(rs.getInt("nbAbs"));
				s.setClasse(rs.getString("libelle"));
				array.add(s);
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Statistiques> statNbAbsByNiveau() {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Statistiques> array = new ArrayList<Statistiques>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select count(a.id_etudiant) as nbAbs,c.niveau from absence a join etudiant et on a.id_etudiant = et.id_etudiant join classe c on et.id_classe = c.id_classe where a.etat = 'true' GROUP by c.libelle order by c.niveau desc;");		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Statistiques s = new Statistiques();
				s.setNombreAbs(rs.getInt("nbAbs"));
				s.setClasse(rs.getString("niveau"));
				array.add(s);
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Statistiques> statNbAbsByFiliere() {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Statistiques> array = new ArrayList<Statistiques>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select count(a.id_etudiant) as nbAbs,c.fliere from absence a join etudiant et on a.id_etudiant = et.id_etudiant join classe c on et.id_classe = c.id_classe where a.etat = 'true' GROUP by c.libelle order by c.fliere desc;");		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Statistiques s = new Statistiques();
				s.setNombreAbs(rs.getInt("nbAbs"));
				s.setClasse(rs.getString("fliere"));
				array.add(s);
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> nbSeanceByClasse() {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<String> array = new ArrayList<String>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select count( DISTINCT numseance) as nums,c.libelle from absence a join etudiant on etudiant.id_etudiant = a.id_etudiant join classe c on c.id_classe = etudiant.id_classe GROUP by c.libelle order by c.id_classe desc;");		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				array.add(rs.getString("nums")+","+rs.getString("libelle"));
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> nbSeanceByFliere() {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<String> array = new ArrayList<String>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select count( DISTINCT numseance) as nums,c.fliere from absence a join etudiant on etudiant.id_etudiant = a.id_etudiant join classe c on c.id_classe = etudiant.id_classe GROUP by c.fliere order by c.id_classe desc;");		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				array.add(rs.getString("nums")+","+rs.getString("fliere"));
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> nbSeanceByNiveau() {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<String> array = new ArrayList<String>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select count( DISTINCT numseance) as nums,c.niveau from absence a join etudiant on etudiant.id_etudiant = a.id_etudiant join classe c on c.id_classe = etudiant.id_classe GROUP by c.niveau order by c.id_classe desc;");		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				array.add(rs.getString("nums")+","+rs.getString("niveau"));
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
