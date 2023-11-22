package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Absence;
import model.Matiere;

public class AbsenceDao {
	
	public static int addNbAbs(Absence abs)
	{
		int res=0;
		try
		{
			Connection connection = ConnectionBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("insert into absence values (?,?,?,?,?,?)");
			ps.setInt(1, abs.getIdEtudiant());
			ps.setInt(2, abs.getIdEnseignant());
			ps.setInt(3, abs.getIdMatiere());
			ps.setInt(4, abs.getNumSeance());
			java.sql.Date sqlDate = new java.sql.Date(abs.getDateAbsence().getTime());
			ps.setDate(5,sqlDate);
			ps.setString(6, abs.getEtat());
			res=ps.executeUpdate();
			ps.close();
		}catch(SQLException e )
		{
			System.out.print(e.getMessage());
		}
		return res;
	}
	
	public static int verfiAbsenceBySeanceAndClasse(int classe,int matiere,int numSeance) {
		Connection connection = ConnectionBD.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select count(*) from absence join etudiant on etudiant.id_etudiant "
					+ "= absence.id_etudiant where id_matiere = ? and numseance = ? and etudiant.id_classe = ? ");
			ps.setInt(1,matiere);
			ps.setInt(2,numSeance);		
			ps.setInt(3,classe);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static ArrayList<Integer> getEtudiantAbsent(int classe,int matiere,int numSeance) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Integer> array = new ArrayList<Integer>();
		try {
			PreparedStatement ps = connection.prepareStatement("select absence.id_etudiant from absence join etudiant on etudiant.id_etudiant "
					+ "= absence.id_etudiant where id_matiere = ? and numseance = ? and etudiant.id_classe = ? and absence.etat = 'true' ");
			ps.setInt(1,matiere);
			ps.setInt(2,numSeance);		
			ps.setInt(3,classe);
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
	
	public static ArrayList<String> getAbsence(int ens,int matiere,int numSeance,int id_classe) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<String> array = new ArrayList<String>();
		try {
			PreparedStatement ps = connection.prepareStatement("select e.id_etudiant,e.nom,e.prenom,a.numseance,a.dates,a.etat from etudiant e "
					+ "join absence a on a.id_etudiant = e.id_etudiant where a.id_enseignant = ? and a.id_matiere = ? and a.numseance = ? and e.id_classe = ?");
			ps.setInt(1,ens);
			ps.setInt(2,matiere);		
			ps.setInt(3,numSeance);
			ps.setInt(4,id_classe);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				array.add(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+",seance "+rs.getInt(4)+","+rs.getDate(5)+","+rs.getString(6));
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getAbsenceByEtudiant(int etd,int matiere) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<String> array = new ArrayList<String>();
		try {
			PreparedStatement ps = connection.prepareStatement("select e.id_etudiant,e.nom,e.prenom,a.numseance,a.dates,a.etat from etudiant e join absence a on a.id_etudiant = e.id_etudiant where a.id_etudiant = ? and a.id_matiere = ?");
			ps.setInt(1,etd);
			ps.setInt(2,matiere);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				array.add(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+",seance "+rs.getInt(4)+","+rs.getDate(5)+","+rs.getString(6));
			}
			ps.close();
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int removeAbs(int ens, int matiere, int seance,int id_etudiant)
	{
		int res=0;
		try
		{
			Connection connection = ConnectionBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("delete from absence where id_enseignant = ? and id_matiere = ? and numseance = ? and id_etudiant = ?  ");
			ps.setInt(1, ens);
			ps.setInt(2, matiere);
			ps.setInt(3, seance);
			ps.setInt(4, id_etudiant);
			res=ps.executeUpdate();
			ps.close();
		}catch(SQLException e )
		{
			System.out.print(e.getMessage());
		}
		return res;
	}
	
	

}
