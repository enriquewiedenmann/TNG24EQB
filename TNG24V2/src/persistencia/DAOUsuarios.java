package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import core.TipoDocumento;
import core.Usuario;

public class DAOUsuarios {

	private static DAOUsuarios	instancia;

	private DAOUsuarios()
	{

	}

	public static DAOUsuarios getInstancia()
	{
		if (instancia == null)
			instancia = new DAOUsuarios();
		return instancia;
	}
	
	
	public Map<Integer, Usuario> selectAllWithUsuario()
	{
		Map<Integer, Usuario> map = new HashMap<Integer,Usuario>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_USUARIO");

			ResultSet rs = s.executeQuery();
			
			DBConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				
				int id = rs.getInt("IDUSUARIO");
				String cod = rs.getString("USERNAME");
				String desc = rs.getString("PASS");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
				
				Usuario user = new Usuario(cod,desc, e);
				
				map.put(id,user);
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL USUARIO" + e.getMessage());
		}
		return map;
	}	
	
	public String login(String usuario, String contraseña)
	{
		String logged = null;
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT e.CODROLLEMPPLEADO FROM TNG24V1.dbo.TG_USUARIO u JOIN TNG24V1.dbo.CT_EMPLEADO e on u.IDUSUARIO = e.IDEMPLEADO " + 
										"WHERE u.USERNAME = ? AND u.PASS = ?;");
			
			s.setString(1, usuario);
			s.setString(2, contraseña);
			ResultSet rs = s.executeQuery();
			
			DBConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				String cod= rs.getString("CODROLLEMPPLEADO");
				logged= cod;
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL USUARIO " + e.getMessage());
			e.printStackTrace();
		}
		return logged;
	}
	
	

}
