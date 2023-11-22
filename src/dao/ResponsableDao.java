package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Responsable;

public class ResponsableDao {
	
	public static Responsable chercherResponsable(String login,String password) {
		Connection connection = ConnectionBD.getConnection();
		Responsable responsable = new Responsable();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from responsable where login = ? and pwd = ? ");
			ps.setString(1,login);
			ps.setString(2,password);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				responsable.setIdResponsable(rs.getInt("id_responsable"));
				responsable.setNomResponsable(rs.getString("nom"));
				responsable.setPrenomResponsable(rs.getString("prenom"));
				responsable.setLoginResponsable(rs.getString("login"));
				responsable.setPwdResponsable(rs.getString("pwd"));
				return responsable;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
