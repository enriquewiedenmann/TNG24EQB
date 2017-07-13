package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import core.RollEmpleado;
import core.Usuario;

public class DAORollEmpleado {
	private static DAORollEmpleado	instancia;

	private DAORollEmpleado()
	{

	}

	public static DAORollEmpleado getInstancia()
	{
		if (instancia == null)
			instancia = new DAORollEmpleado();
		return instancia;
	}
	
	
	
	public ArrayList<RollEmpleado> selectAll()
	{
		ArrayList<RollEmpleado> lista = new ArrayList<RollEmpleado>();
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_ROLLEMPPLEADO");

			ResultSet rs = s.executeQuery();
			
			PoolConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
			
			
				String cod = rs.getString("CODROLLEMPPLEADO");
				String desc = rs.getString("DESCROLLEMPPLEADO");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
				
				RollEmpleado rol = new RollEmpleado(cod,desc, e);
				lista.add(rol);
				
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL ROLES" + e.getMessage());
		}
		return lista;
	}	


	public Map<String, RollEmpleado> selectAllWithRoll()
	{
		Map<String, RollEmpleado> map = new HashMap<String,RollEmpleado>();
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_ROLLEMPPLEADO");

			ResultSet rs = s.executeQuery();
			
			PoolConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
			
			
				String cod = rs.getString("CODROLLEMPPLEADO");
				String desc = rs.getString("DESCROLLEMPPLEADO");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
				
				RollEmpleado rol = new RollEmpleado(cod,desc, e);
				
				map.put(cod,rol);
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL ROLES" + e.getMessage());
		}
		return map;
	}	
	
	

}
