package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import complementos.Cliente;
import complementos.DAOCliente;
import core.Provincia;

public  class DAOProvincia {

	private static DAOProvincia	instancia;

	private DAOProvincia()
	{

	}

	public static DAOProvincia getInstancia()
	{
		if (instancia == null)
			instancia = new DAOProvincia();
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

	public ArrayList<Provincia> select() {
		ArrayList<Provincia> list = new ArrayList<Provincia>();
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_PROVINCIA");

			ResultSet rs = s.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				int id = rs.getInt("idprovincia");
				String cod = rs.getString("codprovincia");
				String desc = rs.getString("descprovincia");
				String estado =  rs.getString("estado");
				char e = estado.charAt(0);
				 
				list.add(new Provincia(id,cod,desc,e));
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL PROVINICA" + e.getMessage());
		}
		return list;
	}
	
	
	public Map<String, Provincia> selectAllWithcodProv()
	{
		Map<String, Provincia> map = new HashMap<String,Provincia>();
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_PROVINCIA");

			ResultSet rs = s.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			
			while (rs.next())
			{
				
					int id = rs.getInt("idprovincia");
					String cod = rs.getString("codprovincia");
					String desc = rs.getString("descprovincia");
					String estado =  rs.getString("estado");
					char e = estado.charAt(0);
				
				Provincia c = new Provincia(id,cod,desc,e);
				
				map.put(cod,c);
			}

		} catch (Exception e)
		{
			System.out.println("ERROR MAP TG_PROVINCIA" + e.getMessage());
		}
		return map;
	}
	
	

}
