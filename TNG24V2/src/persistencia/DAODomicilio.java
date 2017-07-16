package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import core.Ciudad;
import core.CodigoPostal;
import core.Domicilio;
import core.Provincia;

public class DAODomicilio {


	
	private static DAODomicilio	instancia;

	private DAODomicilio()
	{

	}

	public static DAODomicilio getInstancia()
	{
		if (instancia == null)
			instancia = new DAODomicilio();
		return instancia;
	}
	
	
	

	public ArrayList<Domicilio> select() {
		ArrayList<Domicilio> list = new ArrayList<Domicilio>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_DOMICILIO");

			ResultSet rs = s.executeQuery();
			 Map<String, Provincia> provincias = DAOProvincia.getInstancia().selectAllWithcodProv();
			 Map<String,Ciudad> ciudades = DAOCiudad.getInstancia().selectAllWithCodCiudad();
			 Map<String, CodigoPostal> codigosPostales = DAOCodigoPostal.getInstancia().selectAllWithCodigoPostal();
			DBConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				
				int id = rs.getInt("IDDOMICILIO");
				String calle = rs.getString("CALLE");
				int nro= rs.getInt("NUMERO");
				String piso= rs.getString("PISO");
				String dpto = rs.getString("DPTO");
				String tel = rs.getString("TELEFONO");
				String codp = rs.getString("CODPROVINCIA");
				String codc = rs.getString("CODCIUDAD");
				String codcp = rs.getString("CODIGOPOSTAL");
					
				String desc = rs.getString("DESCLOCALIDAD");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
				Provincia p = provincias.get(codp);
				Ciudad c = ciudades.get(codc);
				CodigoPostal cp = codigosPostales.get(codcp);
						list.add(new Domicilio(id,calle,Integer.toString(nro),piso
								,dpto,tel,p,c,cp,desc, e));
			}
			
		
		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL DOMICILIO" + e.getMessage());
		}
		return list;
	}
	
	public Map<Integer, Domicilio> selectAllWithDomicilio()
	{
		Map<Integer, Domicilio> map = new HashMap<Integer,Domicilio>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.TG_DOMICILIO");

			ResultSet rs = s.executeQuery();
			 Map<String, Provincia> provincias = DAOProvincia.getInstancia().selectAllWithcodProv();
			 Map<String,Ciudad> ciudades = DAOCiudad.getInstancia().selectAllWithCodCiudad();
			 Map<String, CodigoPostal> codigosPostales = DAOCodigoPostal.getInstancia().selectAllWithCodigoPostal();
			DBConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				
				int id = rs.getInt("IDDOMICILIO");
				String calle = rs.getString("CALLE");
				int nro= rs.getInt("NUMERO");
				String piso= rs.getString("PISO");
				String dpto = rs.getString("DPTO");
				String tel = rs.getString("TELEFONO");
				String codp = rs.getString("CODPROVINCIA");
				String codc = rs.getString("CODCIUDAD");
				String codcp = rs.getString("CODIGOPOSTAL");
					
				String desc = rs.getString("DESCLOCALIDAD");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
				Provincia p = provincias.get(codp);
				Ciudad c = ciudades.get(codc);
				CodigoPostal cp = codigosPostales.get(codcp);
				Domicilio dom = new Domicilio(id,calle,Integer.toString(nro),piso,dpto,tel,p,c,cp,desc, e);
				map.put(id, dom);
			}
			
		
		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL DOMICILIO" + e.getMessage());
		}
		return map;
	}




	
	
}
