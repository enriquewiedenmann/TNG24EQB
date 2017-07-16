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


public class DAOCodigoPostal  {

	
	private static DAOCodigoPostal	instancia;

	private DAOCodigoPostal()
	{

	}

	public static DAOCodigoPostal getInstancia()
	{
		if (instancia == null)
			instancia = new DAOCodigoPostal();
		return instancia;
	}
	
	
	

	public ArrayList<CodigoPostal> select() {
		ArrayList<CodigoPostal> list = new ArrayList<CodigoPostal>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_CODIGOPOSTAL");

			ResultSet rs = s.executeQuery();
			 Map<String, Provincia> provincias = DAOProvincia.getInstancia().selectAllWithcodProv();
			 Map<String,Ciudad> ciudades = DAOCiudad.getInstancia().selectAllWithCodCiudad();
			DBConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				int id = rs.getInt("IDCODIGOPOSTAL");
				String cod = rs.getString("CODIGOPOSTAL");
				String desc = rs.getString("DESCCODIGOPOSTAL");
				String codp = rs.getString("CODPROVINCIA");
				String codc = rs.getString("CODCIUDAD");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
				Provincia p = provincias.get(codp);
				Ciudad c = ciudades.get(codc);
				list.add(new CodigoPostal(id,cod,desc,p,c, e));
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL CODIGOPOSTAL" + e.getMessage());
		}
		return list;
	}
	
	public Map<String, CodigoPostal> selectAllWithCodigoPostal()
	{
		Map<String, CodigoPostal> map = new HashMap<String,CodigoPostal>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_CODIGOPOSTAL");

			ResultSet rs = s.executeQuery();
			 Map<String, Provincia> provincias = DAOProvincia.getInstancia().selectAllWithcodProv();
			 Map<String,Ciudad> ciudades = DAOCiudad.getInstancia().selectAllWithCodCiudad();
			DBConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				int id = rs.getInt("IDCODIGOPOSTAL");
				String cod = rs.getString("CODIGOPOSTAL");
				String desc = rs.getString("DESCCODIGOPOSTAL");
				String codp = rs.getString("CODPROVINCIA");
				String codc = rs.getString("CODCIUDAD");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
				Provincia p = provincias.get(codp);
				Ciudad c = ciudades.get(codc);
				CodigoPostal cp = new CodigoPostal(id,cod,desc,p,c, e);
				
				map.put(cod,cp);
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL CODIGOPOSTAL" + e.getMessage());
		}
		return map;
	}	
}


