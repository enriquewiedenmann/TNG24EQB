package persistencia;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

public class PoolConnection
{
	private Vector<Connection>		connections	= new Vector<Connection>();
	protected String				jdbc;
	protected String				servidor;
	protected String				usuario;
	protected String				password;
	protected int					cantCon;
	private static PoolConnection	pool;

	private PoolConnection()
	{
		getConfiguration();
		for (int i = 0; i < cantCon; i++)
			connections.add(connect());
	}

	public static PoolConnection getPoolConnection()
	{
		if (pool == null)
			pool = new PoolConnection();
		return pool;
	}

	private Connection connect()
	{
		try
		{
			// Setear driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbConnectString = jdbc + servidor;
			Connection con = DriverManager.getConnection(dbConnectString, usuario, password);

			return con;
		} catch (SQLException e)
		{
			System.out.println("Mensaje Error: " + e.getMessage());
			System.out.println("Stack Trace: " + e.getStackTrace());
			return null;
		} catch (Exception ex)
		{
			System.out.println("Mensaje Error: " + ex.getMessage());
			System.out.println("Stack Trace: " + ex.getStackTrace());
			return null;
		}
	}

	public void getConfiguration()
	{


		
		try
		{

			// Leo los valores de configuracion
			jdbc = "jdbc:sqlserver://";
			servidor = "127.0.0.1:1433";
			usuario = "sa";
			password = "A#33914084";
			cantCon = 3;
		} catch (Exception e)
		{
			System.out.println("Mensaje Error: " + e.getMessage());
			System.out.println("Stack Trace: " + e.getStackTrace());
		}
	}

	public void closeConnections()
	{
		for (int i = 0; i < connections.size(); i++)
		{
			try
			{
				connections.elementAt(i).close();
			} catch (Exception e)
			{
				System.out.println("Mensaje Error: " + e.getMessage());
				System.out.println("Stack Trace: " + e.getStackTrace());
			}
		}
	}

	public Connection getConnection()
	{
		Connection c = null;
		if (connections.size() > 0)
			c = connections.remove(0);
		else
		{
			c = connect();
			System.out
					.println("Se ha creado una nueva conexion fuera de los parametros de configuracion. cantidad de conexiones: "+connections.size() );
		}
		return c;
	}

	public void realeaseConnection(Connection c)
	{
		connections.add(c);
	}
}
