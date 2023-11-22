package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Mails;

public class MailDao {
	
	public static int envoyerMail(Mails mail)
	{
		int res=0;
		try
		{
			Connection connection = ConnectionBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("insert into mails (expediteur,destinataire,contenu) values (?,?,?)");
			ps.setInt(1, mail.getId_expd());
			ps.setInt(2, mail.getId_dest());
			ps.setString(3, mail.getContenu());
			res=ps.executeUpdate();
			ps.close();
		}catch(SQLException e )
		{
			System.out.print(e.getMessage());
		}
		return res;
	}

}
