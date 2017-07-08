package complementos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import persistencia.AdministradorPersistencia;
import persistencia.PoolConnection;
import modelo.Cliente;

public class DAOCliente extends AdministradorPersistencia
{
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

	@Override
	public void insert(Object o)
	{
		try
		{
			Cliente c = (Cliente) o;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("INSERT INTO tpo.user_tpo.CLIENTE "
					+ "(dni,nombre,domicilio,telefono,mail,estado)" + "values (?,?,?,?,?,?)");

			s.setInt(1, c.getDni());
			s.setString(2, c.getNombre());
			s.setString(3, c.getDomicilio());
			s.setString(4, c.getTelefono());
			s.setString(5, c.getMail());
			s.setBoolean(6, c.isEstado());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);

		} catch (Exception e)
		{
			System.out.println("ERROR INSERT CLIENTE" + e.getMessage());
		}

	}

	@Override
	public void update(Object o)
	{
		Cliente c = (Cliente) o;
		Connection con = PoolConnection.getPoolConnection().getConnection();
		PreparedStatement s;
		try
		{
			s = con.prepareStatement("UPDATE tpo.user_tpo.Cliente" 
					+ " set domicilio =?,"
					+ " mail =?," 
					+ " nombre =?," 
					+ " telefono =?," 
					+ " estado =? "
					+ "where dni =?");

			s.setString(1, c.getDomicilio());
			s.setString(2, c.getMail());
			s.setString(3, c.getNombre());
			s.setString(4, c.getTelefono());
			s.setInt(5, c.isEstado()?1:0);
			s.setInt(6, c.getDni());
			
			s.execute();
			
			PoolConnection.getPoolConnection().realeaseConnection(con);
		} catch (Exception e)
		{
			System.out.println("ERROR UPDATE CLIENTE" + e.getMessage());
		}

	}

	@Override
	public void delete(Object d)
	{
		try
		{
			Cliente c = (Cliente) d;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("UPDATE tpo.user_tpo.Cliente set estado = 0 WHERE dni = ?");
			s.setInt(1, c.getDni());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		} catch (Exception e)
		{
			System.out.println("ERROR DELETE CLIENTE" + e.getMessage());
		}
	}

	public List<Cliente> selectAll()
	{
		List<Cliente> list = new ArrayList<Cliente>();
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT * FROM tpo.user_tpo.Cliente WHERE estado = 1");

			ResultSet rs = s.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				int dni = rs.getInt("dni");
				String nombre = rs.getString("nombre");
				String domicilio = rs.getString("domicilio");
				String telefono = rs.getString("telefono");
				String mail = rs.getString("mail");
				boolean estado = rs.getBoolean("estado");
				list.add(new Cliente(dni, nombre, domicilio, telefono, mail, estado,false));
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL CLIENTE" + e.getMessage());
		}
		return list;
	}
	
	public Map<Integer, Cliente> selectAllWithContracts()
	{
		Map<Integer, Cliente> map = new HashMap<Integer,Cliente>();
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT * FROM tpo.user_tpo.Cliente WHERE estado = 1 AND idContrato IS NOT NULL");

			ResultSet rs = s.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			
			while (rs.next())
			{
				int dni = rs.getInt("dni");
				String nombre = rs.getString("nombre");
				String domicilio = rs.getString("domicilio");
				String telefono = rs.getString("telefono");
				String mail = rs.getString("mail");
				boolean estado = rs.getBoolean("estado");
				int idContrato = rs.getInt("idContrato");
				
				Cliente c = new Cliente(dni, nombre, domicilio, telefono, mail, estado, false);
				
				map.put(idContrato,c);
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL CLIENTE" + e.getMessage());
		}
		return map;
	}

	@Override
	public Vector<Object> select(Object o)
	{
		Vector<Object> ret = new Vector<Object>();
		try
		{
			Cliente c = (Cliente) o ;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT * FROM tpo.user_tpo.Cliente WHERE dni = ?");
			s.setInt(1, c.getDni());

			ResultSet rs = s.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			while (rs.next())
			{
				int dni = rs.getInt("dni");
				String nombre = rs.getString("nombre");
				String domicilio = rs.getString("domicilio");
				String telefono = rs.getString("telefono");
				String mail = rs.getString("mail");
				boolean estado = rs.getBoolean("estado");
				ret.add(new Cliente(dni, nombre, domicilio, telefono, mail, estado,false));
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT CLIENTE" + e.getMessage());
		}
		return ret;
	}
}
