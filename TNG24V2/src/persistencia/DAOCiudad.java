package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import core.Ciudad;
import core.Provincia;

public class DAOCiudad {

	
	private static DAOCiudad	instancia;

	private DAOCiudad()
	{

	}

	public static DAOCiudad getInstancia()
	{
		if (instancia == null)
			instancia = new DAOCiudad();
		return instancia;
	}
	
	
	public int insert(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Object d) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Ciudad> select() {
		ArrayList<Ciudad> list = new ArrayList<Ciudad>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_CIUDAD");

			ResultSet rs = s.executeQuery();
			 Map<String, Provincia> provincias = DAOProvincia.getInstancia().selectAllWithcodProv();
			DBConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				int id = rs.getInt("idciudad");
				String cod = rs.getString("codciudad");
				String desc = rs.getString("descciudad");
				String codp = rs.getString("codProvincia");
				String estado =  rs.getString("estado");
				char e = estado.charAt(0);
				Provincia p = provincias.get(codp);
				list.add(new Ciudad(id,cod,desc,p, e));
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL CIUDAD" + e.getMessage());
		}
		return list;
	}
	
	public Map<String, Ciudad> selectAllWithCodCiudad()
	{
		Map<String, Ciudad> map = new HashMap<String,Ciudad>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_CIUDAD");

			ResultSet rs = s.executeQuery();
			 Map<String, Provincia> provincias = DAOProvincia.getInstancia().selectAllWithcodProv();
			DBConnection.getPoolConnection().realeaseConnection(con);
			
			while (rs.next())
			{
				int id = rs.getInt("idciudad");
				String cod = rs.getString("codciudad");
				String desc = rs.getString("descciudad");
				String codp = rs.getString("codProvincia");
				String estado =  rs.getString("estado");
				char e = estado.charAt(0);
				Provincia p = provincias.get(codp);
				Ciudad c = new Ciudad(id,cod,desc,p, e);
				
				map.put(cod,c);
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL CIUDAD" + e.getMessage());
		}
		return map;
	}	
}
