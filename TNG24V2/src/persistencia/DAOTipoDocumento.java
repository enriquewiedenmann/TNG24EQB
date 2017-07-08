package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import core.Ciudad;
import core.CodigoPostal;
import core.Provincia;
import core.TipoDocumento;

public class DAOTipoDocumento {


	
	private static DAOTipoDocumento	instancia;

	private DAOTipoDocumento()
	{

	}

	public static DAOTipoDocumento getInstancia()
	{
		if (instancia == null)
			instancia = new DAOTipoDocumento();
		return instancia;
	}
	
	
	

	public ArrayList<TipoDocumento> select() {
		ArrayList<TipoDocumento> list = new ArrayList<TipoDocumento>();
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_TIPODOCUMENTO");

			ResultSet rs = s.executeQuery();
			
			PoolConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				
				String cod = rs.getString("CODTIPODOCUMENTO");
				String desc = rs.getString("DESCTIPODOCUMENTO");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
				list.add(new TipoDocumento(cod,desc, e));
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL TG_TIPODOCUMENTO" + e.getMessage());
		}
		return list;
	}
	
	public Map<String, TipoDocumento> selectAllWithTipoDocumento()
	{
		Map<String, TipoDocumento> map = new HashMap<String,TipoDocumento>();
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_TIPODOCUMENTO");

			ResultSet rs = s.executeQuery();
			
			PoolConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				String cod = rs.getString("CODTIPODOCUMENTO");
				String desc = rs.getString("DESCTIPODOCUMENTO");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
				
				TipoDocumento td = new TipoDocumento(cod,desc, e);
				
				map.put(cod,td);
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL TG_TIPODOCUMENTO" + e.getMessage());
		}
		return map;
	}	




	
	
}
