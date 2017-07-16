package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistencia.DBConnection;

public class TstConexionSql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("TstConexionSql");
		Connection con = DBConnection.getPoolConnection().getConnection();
		PreparedStatement s;
		try {
			s = con
					.prepareStatement("select concat(USER_NAME(),'   conexion establecida')");
			ResultSet rs = s.executeQuery();
			while (rs.next())
			{
				
				String info = rs.getNString(1);
				System.out.println("usuario: "+info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		DBConnection.getPoolConnection().realeaseConnection(con);
	}

}
