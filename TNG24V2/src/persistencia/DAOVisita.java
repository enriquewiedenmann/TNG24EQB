package persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import core.Cliente;
import core.Domicilio;
import core.Empleado;
import core.Factura;
import core.Presupuesto;
import core.Visita;

public class DAOVisita {

	
	private static DAOVisita	instancia;

	private DAOVisita()
	{

	}

	public static DAOVisita getInstancia()
	{
		if (instancia == null)
			instancia = new DAOVisita();
		return instancia;
	}
	
	
	
public int insert(int agenda,Visita v) {
		
		Connection con = DBConnection.getPoolConnection().getConnection();
		CallableStatement sp;
		try {
			sp = con.prepareCall("{CALL TNG24V1.dbo.SP_ALTA_VISITA(?,?,?,?,?,?,?,?,?,?,?)}");
			 int idente =-1;
		// cargar parametros al SP
			sp.registerOutParameter(1,java.sql.Types.INTEGER);
		//idente = sp.getInt(1);
			sp.setInt(2, agenda);
			sp.setInt(3, v.getFactura().getId() );
			sp.setInt(4, v.getPresupuesto().getId() );
			sp.setInt(5, v.getCliente().getIdEnte() );
			sp.setInt(6, v.getDomicilio().getIdDomicilio() );
			
			sp.setDate(7, (Date) v.getInicioProgramado());
			sp.setDate(8, (Date) v.getFinProgramado());
			sp.setDate(9, (Date) v.getInicioReal());
			sp.setDate(10, (Date) v.getFinReal());
			
			sp.setString(11, v.getMotivo());
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

	public void update( Visita v)
		{
			try
			{
			
				Connection con = DBConnection.getPoolConnection().getConnection();
				PreparedStatement s = con.prepareStatement
				("Update CT_VISITA"
						+ "IDFACTURA,"
						+ "IDPRESUPPUESTO,"
						+ "IDCLIENTE,"
						+ "IDDOMICILIO,"
						+ "INICIOPROGRAMADO,"
						+ "FINPROGRAMADO,"
						+ "INICIOREAL,"
						+ "ESTADO where IDVISITA=?);");

				
				s.setInt(1, v.getFactura().getId());
				s.setInt(2, v.getPresupuesto().getId());
				s.setInt(3, v.getCliente().getIdEnte());
				s.setInt(4, v.getDomicilio().getIdDomicilio());
				
				s.setLong(5, v.getInicioProgramado().getTime());
				s.setLong(6, v.getFinProgramado().getTime());
				s.setLong(7, v.getInicioReal().getTime());
				s.setLong(8, v.getFinReal().getTime());
				s.setString(9, "M");
				s.setInt(10, v.getId());
				s.execute();
				DBConnection.getPoolConnection().realeaseConnection(con);

			} catch (Exception e)
			{
				System.out.println("ERROR update VISITA" + e.getMessage());
			}

		}
	
	
	
	public ArrayList<Visita> selectVisita(int idAgendaS)
	{
		ArrayList<Visita> list= new ArrayList<Visita>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT *FROM TNG24V1.dbo.V_VISITA where IDAGENDA=? and ESTADO<>'B'");
			s.setInt(1,idAgendaS );
			ResultSet rs = s.executeQuery();
			Map<Integer,Presupuesto> pre=DAOPresupuesto.getInstancia().selectAllWhithPresupuesto();
			Map<Integer,Empleado> emp=DAOEmpleado.getInstancia().selectwhithEmpleado();
			Map<Integer,Cliente> cli=DAOCliente.getInstancia().selectWhithCliente();
			Map<Integer,Domicilio> dom=DAODomicilio.getInstancia().selectAllWithDomicilio();
			DBConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				
				int id = rs.getInt("IDVISITA");
				int idAgenda=rs.getInt("IDAGENDA");
				int idFactura = rs.getInt("IDFACTURA");
				int idEmpleado=rs.getInt("IDTECNICO");
				int idPresupuesto = rs.getInt("IDPRESUPPUESTO");
				int idCliente = rs.getInt("IDCLIENTE");
				int idDomicilio = rs.getInt("IDDOMICILIO");
				Timestamp inicioProgramado = rs.getTimestamp("INICIOPROGRAMADO");
				
				Timestamp finProgramado =rs.getTimestamp("FINPROGRAMADO");
				Timestamp inicioReal =rs.getTimestamp("INICIOREAL");
				Timestamp finReal =rs.getTimestamp("FINREAL");
				String motivo =rs.getString("MOTIVO");
				String estado =  rs.getString("ESTADO");
				char e = estado.charAt(0);
		
				Presupuesto prei=pre.get(idPresupuesto);
				Cliente clii=cli.get(idCliente);
				Domicilio domi=dom.get(idDomicilio);
				Empleado empS=emp.get(idEmpleado);
			Visita vi = new Visita(id,null,prei,clii,domi,inicioProgramado,finProgramado,inicioReal,finReal,e,motivo,null);
			
			
			
			
			
			
			list.add(vi);
			}

		} catch (Exception e)
		{
			System.out.println("ERROR SELECT VISITAS" + e.getMessage());
		}
		return list;
	}	
	
	
public void rehabilitar (Visita v) {
		
		
		
		Connection con = DBConnection.getPoolConnection().getConnection();
				
				PreparedStatement s;
				try
				{
					
				
					
					s = con.prepareStatement("UPDATE TNG24V1.dbo.CT_VISITA " 
							+ "set ESTADO = 'M'"
							+ "where idente =?");
					
					
				
				
					s.setInt(1, v.getId());			
					s.execute();
					DBConnection.getPoolConnection().realeaseConnection(con);
				
				} catch (Exception e)
				{
					System.out.println("ERROR REHABILITAR visita" + e.getMessage());
				}
				
			}
	
public void baja(Visita v) {
	
	
	
	Connection con = DBConnection.getPoolConnection().getConnection();
			
			PreparedStatement s;
			try
			{
				
			
				
				s = con.prepareStatement("UPDATE TNG24V1.dbo.CT_VISITA " 
						+ "set ESTADO = 'B'"
						+ "where idente =?");
				
				
			
			
				s.setInt(1, v.getId());			
				s.execute();
				DBConnection.getPoolConnection().realeaseConnection(con);
			
			} catch (Exception e)
			{
				System.out.println("ERROR BAJA VISITA" + e.getMessage());
			}
			
		}

	
	
}
