package persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import core.Cliente;
import core.Domicilio;
import core.Provincia;
import core.TipoDocumento;
import core.Usuario;

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
	
	
	public int insert(String nombre,String apellido, String tipoDoc, String doc, String tel, String mail, int dom) {
		
		Connection con = DBConnection.getPoolConnection().getConnection();
		CallableStatement sp;
		try {
			sp = con.prepareCall("{CALL TNG24V1.dbo.SP_ALTACLIENTE(?,?,?,?,?,?,?,?)}");
			 int idente =-1;
		// cargar parametros al SP
			sp.registerOutParameter(1,java.sql.Types.INTEGER);
		//idente = sp.getInt(1);
		sp.setString(2, nombre);
		sp.setString(3, apellido);
		sp.setString(4, tipoDoc);
		sp.setString(5, doc);
		sp.setString(6, tel);
		sp.setString(7, mail);
		sp.setInt(8, dom );
		// ejecutar el SP
		sp.execute();
		// confirmar si se ejecuto sin errores
		idente = sp.getInt(1);  
		DBConnection.getPoolConnection().realeaseConnection(con);
		return idente;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR ALTA CLIENTE " + e.getMessage());
		}
		return -1;
	}

	public void update(Cliente c) {
		
		Connection con = DBConnection.getPoolConnection().getConnection();
		
		PreparedStatement s;
		try
		{
			s = con.prepareStatement("UPDATE TNG24V1.dbo.CT_CLIENTE" 
					+ " set telefono =?,"
					+ " mail =?," 
					+ " iddomicilio =?,"  
					+ " estado =? "
					+ "where idcliente =?");

			s.setString(1, c.getTelefono());
			s.setString(2, c.getMail());
			s.setInt(3, c.getDomicilio().getIdDomicilio());
			s.setString(4, "M");
			s.setInt(5, c.getIdEnte());			
			s.execute();
		
			
		
			
			s = con.prepareStatement("UPDATE TNG24V1.dbo.TG_ENTE" 
					+ " set NOMBRE =?,"
					+ " APELLIDO =?," 
					+ " CODTIPODOCUMENTO =?,"  
					+ " NRODOCUMENTO =? ,"
					+ "ESTADO =? "
					+ "where idente =?");

			s.setString(1, c.getNombre());
			s.setString(2, c.getApellido());
			s.setString(3, c.getTipoDoc().getCodTipoDoc());
			s.setString(4, c.getNroDoc());
			s.setString(5, "M");
			s.setInt(6, c.getIdEnte());			
			s.execute();
			DBConnection.getPoolConnection().realeaseConnection(con);
			
		} catch (Exception e)
		{
			System.out.println("ERROR UPDATE CLIENTE" + e.getMessage());
		}
		
	}
	
	
public void updateEnte(Cliente c) {
		
		Connection con = DBConnection.getPoolConnection().getConnection();
		
		PreparedStatement s;
		try
		{
			
		
			
			s = con.prepareStatement("UPDATE TNG24V1.dbo.TG_ENTE" 
					+ " set NOMBRE =?,"
					+ " APELLIDO =?," 
					+ " CODTIPODOCUMENTO =?,"  
					+ " NRODOCUMENTO =? ,"
					+ "ESTADO =? "
					+ "where idente =?");

			s.setString(1, c.getNombre());
			s.setString(2, c.getApellido());
			s.setString(3, c.getTipoDoc().getCodTipoDoc());
			s.setString(4, c.getNroDoc());
			s.setString(5, "M");
			s.setInt(6, c.getIdEnte());			
			s.execute();
			DBConnection.getPoolConnection().realeaseConnection(con);
		
		} catch (Exception e)
		{
			System.out.println("ERROR UPDATE ENTE" + e.getMessage());
		}
		
	}

	public void baja(Cliente c) {
		
		
		
Connection con = DBConnection.getPoolConnection().getConnection();
		
		PreparedStatement s;
		try
		{
			
		
			
			s = con.prepareStatement("UPDATE TNG24V1.dbo.TG_ENTE " 
					+ "set ESTADO = 'B'"
					+ "where idente =?");
			
			
		
		
			s.setInt(1, c.getIdEnte());			
			s.execute();
			DBConnection.getPoolConnection().realeaseConnection(con);
		
		} catch (Exception e)
		{
			System.out.println("ERROR BAJA ENTE" + e.getMessage());
		}
		
	}
	
	public void rehabilitar(Cliente c) {
		
		
		
		Connection con = DBConnection.getPoolConnection().getConnection();
				
				PreparedStatement s;
				try
				{
					
				
					
					s = con.prepareStatement("UPDATE TNG24V1.dbo.TG_ENTE " 
							+ "set ESTADO = 'M'"
							+ "where idente =?");
					
					
				
				
					s.setInt(1, c.getIdEnte());			
					s.execute();
					DBConnection.getPoolConnection().realeaseConnection(con);
				
				} catch (Exception e)
				{
					System.out.println("ERROR REHABILITAR ENTE" + e.getMessage());
				}
				
			}
	

	public ArrayList<Cliente> select() {
		ArrayList<Cliente> list = new ArrayList<Cliente>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT en.IDENTE,en.NOMBRE,en.APELLIDO,en.CODTIPODOCUMENTO,en.NRODOCUMENTO,en.ESTADO,cl.TELEFONO,cl.MAIL,cl.IDDOMICILIO,cl.ESTADO FROM TNG24V1.dbo.CT_CLIENTE cl join TNG24V1.dbo.TG_ENTE en on en.IDENTE = cl.IDCLIENTE");
						

			ResultSet rs = s.executeQuery();
			 Map<String, TipoDocumento> tipodocumento = DAOTipoDocumento.getInstancia().selectAllWithTipoDocumento();
			 Map<Integer,Domicilio> domicilios = DAODomicilio.getInstancia().selectAllWithDomicilio();
			
			DBConnection.getPoolConnection().realeaseConnection(con);

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
	
			
	public Map<Integer,Cliente> selectWhithCliente() {
		Map<Integer,Cliente> map = new HashMap<Integer,Cliente>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT en.IDENTE,en.NOMBRE,en.APELLIDO,en.CODTIPODOCUMENTO,en.NRODOCUMENTO,en.ESTADO,cl.TELEFONO,cl.MAIL,cl.IDDOMICILIO,cl.ESTADO FROM TNG24V1.dbo.CT_CLIENTE cl join TNG24V1.dbo.TG_ENTE en on en.IDENTE = cl.IDCLIENTE");
						

			ResultSet rs = s.executeQuery();
			 Map<String, TipoDocumento> tipodocumento = DAOTipoDocumento.getInstancia().selectAllWithTipoDocumento();
			 Map<Integer,Domicilio> domicilios = DAODomicilio.getInstancia().selectAllWithDomicilio();
			
			DBConnection.getPoolConnection().realeaseConnection(con);

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
				
				Cliente nc =new Cliente(id, nombre,apellido, td,nroDoc, e,telefono, mail,dom);
				map.put(id, nc);
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL CLIENTE" + e.getMessage());
		}
		return map;
	}
	
}
