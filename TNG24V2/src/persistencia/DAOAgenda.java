package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import core.Agenda;
import core.Empleado;
import core.Usuario;

public class DAOAgenda {
	private static DAOAgenda	instancia;

	private DAOAgenda()
	{

	}

	public static DAOAgenda getInstancia()
	{
		if (instancia == null)
			instancia = new DAOAgenda();
		return instancia;
	}
	
	


	
	
	
	public ArrayList<Agenda> selectAll()
	{
		ArrayList<Agenda> list= new ArrayList<Agenda>();
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from TNG24V1.dbo.CT_AGENDA");

			ResultSet rs = s.executeQuery();
			Map<Integer,Empleado> emp=DAOEmpleado.getInstancia().selectwhithEmpleado();
			PoolConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				
				int id = rs.getInt("IDAGENDA");
				int idEmpleado = rs.getInt("idtecnico");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
			Empleado empS=emp.get(idEmpleado);
			Agenda ag = new Agenda(id,empS,e);
				
			list.add(ag);
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT ALL AGENDAS" + e.getMessage());
		}
		return list;
	}	
}
