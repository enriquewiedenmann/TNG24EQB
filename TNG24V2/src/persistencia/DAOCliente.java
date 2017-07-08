package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import core.Cliente;
import core.Domicilio;
import core.Provincia;
import core.TipoDocumento;

public class DAOCliente {
	private static DAOCliente	instancia;

	private DAOCliente()
	{

	}

	public static DAOCliente getInstancia()
	{
		if (instancia == null)
			instancia = new DAOCliente();
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

	public ArrayList<Cliente> select() {
		ArrayList<Cliente> list = new ArrayList<Cliente>();
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT en.IDENTE,en.NOMBRE,en.APELLIDO,en.CODTIPODOCUMENTO,en.NRODOCUMENTO,en.ESTADO,cl.TELEFONO,cl.MAIL,cl.IDDOMICILIO,cl.ESTADO FROM TNG24V1.dbo.CT_CLIENTE cl join TNG24V1.dbo.TG_ENTE en on en.IDENTE = cl.IDCLIENTE");
							/*
							en.IDENTE,
							en.NOMBRE,
							en.APELLIDO,
							en.CODTIPODOCUMENTO,
							en.NRODOCUMENTO,
							en.ESTADO,
							cl.TELEFONO,
							cl.MAIL,
							cl.IDDOMICILIO,
							cl.ESTADO
							*/

			ResultSet rs = s.executeQuery();
			 Map<String, TipoDocumento> tipodocumento = DAOTipoDocumento.getInstancia().selectAllWithTipoDocumento();
			 Map<Integer,Domicilio> domicilios = DAODomicilio.getInstancia().selectAllWithDomicilio();
			PoolConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				
				int id = rs.getInt("idente");
				
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String tipoDoc= rs.getString("codtipodocumento");
				String nroDoc= rs.getString("nrodocumento");
				String estado= rs.getString("estado");
				String telefono= rs.getString("telefono");
				String mail= rs.getString("mail");
				int domicilio= rs.getInt("iddomicilio");
				char e = estado.charAt(0);
				Domicilio dom = domicilios.get(domicilio);
				TipoDocumento td = tipodocumento.get(tipoDoc);
				list.add(new Cliente(id, nombre,apellido, td,nroDoc, e,telefono, mail,dom));
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL CLIENTE" + e.getMessage());
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
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
	}*/
	
}
