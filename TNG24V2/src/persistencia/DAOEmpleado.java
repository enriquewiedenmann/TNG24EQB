package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import core.Cliente;
import core.Domicilio;
import core.Empleado;
import core.RollEmpleado;
import core.TipoDocumento;
import core.Usuario;

public class DAOEmpleado {

	private static DAOEmpleado	instancia;

	private DAOEmpleado()
	{
		
	}

	public static DAOEmpleado getInstancia()
	{
		if (instancia == null)
			instancia = new DAOEmpleado();
		return instancia;
	}
	
	
	public ArrayList<Empleado> select() {
		ArrayList<Empleado> list = new ArrayList<Empleado>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT en.IDENTE,en.NOMBRE,en.APELLIDO,en.CODTIPODOCUMENTO,en.NRODOCUMENTO,en.ESTADO,cl.TELEFONO,cl.MAIL,cl.ESTADO, cl.CODROLLEMPPLEADO FROM TNG24V1.dbo.CT_EMPLEADO cl join TNG24V1.dbo.TG_ENTE en on en.IDENTE = cl.idempleado");
						

			ResultSet rs = s.executeQuery();
			 Map<String, TipoDocumento> tipodocumento = DAOTipoDocumento.getInstancia().selectAllWithTipoDocumento();
			Map<String,RollEmpleado> rollEmpleado = DAORollEmpleado.getInstancia().selectAllWithRoll();
			Map<Integer,Usuario> user=DAOUsuarios.getInstancia().selectAllWithUsuario();
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
				String rolE = rs.getString("CODROLLEMPPLEADO");
				char e = estado.charAt(0);
				
				
				RollEmpleado re = rollEmpleado.get(rolE);
				TipoDocumento td = tipodocumento.get(tipoDoc);
				Usuario us = user.get(id);
				
				list.add(new Empleado(id, nombre, apellido,td, nroDoc, e, us, telefono, mail, re));
				
				
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL EMPLEADO" + e.getMessage());
		}
		return list;
			
	}
	
	public  Map<Integer,Empleado> selectwhithEmpleado() {
		Map<Integer,Empleado>  map = new HashMap<Integer,Empleado>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT en.IDENTE,en.NOMBRE,en.APELLIDO,en.CODTIPODOCUMENTO,en.NRODOCUMENTO,en.ESTADO,cl.TELEFONO,cl.MAIL,cl.ESTADO, cl.CODROLLEMPPLEADO FROM TNG24V1.dbo.CT_EMPLEADO cl join TNG24V1.dbo.TG_ENTE en on en.IDENTE = cl.idempleado");
						

			ResultSet rs = s.executeQuery();
			 Map<String, TipoDocumento> tipodocumento = DAOTipoDocumento.getInstancia().selectAllWithTipoDocumento();
			Map<String,RollEmpleado> rollEmpleado = DAORollEmpleado.getInstancia().selectAllWithRoll();
			Map<Integer,Usuario> user=DAOUsuarios.getInstancia().selectAllWithUsuario();
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
				String rolE = rs.getString("CODROLLEMPPLEADO");
				char e = estado.charAt(0);
				
				
				RollEmpleado re = rollEmpleado.get(rolE);
				TipoDocumento td = tipodocumento.get(tipoDoc);
				Usuario us = user.get(id);
				
				Empleado ne =new Empleado(id, nombre, apellido,td, nroDoc, e, us, telefono, mail, re);
				
				map.put(id, ne);
				
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL EMPLEADO" + e.getMessage());
		}
		return map;
	}
}
