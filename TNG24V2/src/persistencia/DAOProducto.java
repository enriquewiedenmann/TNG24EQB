package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import core.Producto;

public class DAOProducto {
	private static DAOProducto	instancia;

	private DAOProducto()
	{

	}

	public static DAOProducto getInstancia()
	{
		if (instancia == null)
			instancia = new DAOProducto();
		return instancia;
	}
	
	
	
	public ArrayList<Producto> selectAll()
	{
		ArrayList<Producto> lista = new ArrayList<Producto>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT *FROM TNG24V1.dbo.ST_PRODUCTO");

			ResultSet rs = s.executeQuery();
			
			DBConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				
				             
				
			
			
				 int id =rs.getInt("IDPRODUCTO");
				 String cod=rs.getString("CODPRODUCTO");
				 String desc=rs.getString("DESCPRODUCTO");                                                                                                                                                                                             
				 int stock=rs.getInt("STOCK");      
				 int pto=rs.getInt("PTOPEDIDO"); 
				 int precio=rs.getInt("PRECIO");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
				
				Producto p= new Producto(  id,cod,desc,stock,pto,precio,e);
				lista.add(p);
				
			}

		} catch (Exception e)
		{
			System.out.println("ERROR EN SELECT PRODUCTO" + e.getMessage());
		}
		return lista;
	}	


	public  Map<String, Producto> selectAllWhithProduto()
	{
		 Map<String, Producto> map = new  HashMap<String, Producto>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT *FROM TNG24V1.dbo.ST_PRODUCTO");

			ResultSet rs = s.executeQuery();
			
			DBConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				
				             
				
			
			
				 int id =rs.getInt("IDPRODUCTO");
				 String cod=rs.getString("CODPRODUCTO");
				 String desc=rs.getString("DESCPRODUCTO");                                                                                                                                                                                             
				 int stock=rs.getInt("STOCK");      
				 int pto=rs.getInt("PTOPEDIDO"); 
				 int precio=rs.getInt("PRECIO");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
				
				Producto p= new Producto(  id,cod,desc,stock,pto,precio,e);
				map.put(cod,p);
				
			}

		} catch (Exception e)
		{
			System.out.println("ERROR EN SELECT PRODUCTO" + e.getMessage());
		}
		return map;
	
	}	
	
}
