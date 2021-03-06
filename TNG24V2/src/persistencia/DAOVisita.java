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
import java.util.Calendar;
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
	
	java.sql.Timestamp f1 = new Timestamp(v.getInicioProgramado().getTime());
	java.sql.Timestamp f2 = new Timestamp(v.getFinProgramado().getTime());
	
		Connection con = DBConnection.getPoolConnection().getConnection();
		CallableStatement sp;
		try {
			sp = con.prepareCall("{CALL TNG24V1.dbo.SP_ALTA_VISITA(?,?,?,?,?,?,?,?,?,?,?)}");
			 int idente =-1;
		// cargar parametros al SP
			sp.registerOutParameter(1,java.sql.Types.INTEGER);
		//idente = sp.getInt(1);
			sp.setInt(2, agenda);
			if(v.getFactura()!=null){
				sp.setInt(3, v.getFactura().getId() );	
			}else{
				
				sp.setNull(3, 1);
			}
			if(v.getPresupuesto()!=null){
			sp.setInt(4, v.getPresupuesto().getId() );
			}else{
				sp.setNull(4, 1);	
			}
			sp.setInt(5, v.getCliente().getIdEnte() );
			sp.setInt(6, v.getDomicilio().getIdDomicilio() );
			
			sp.setTimestamp(7,  f1);
			sp.setTimestamp(8, f2);
			if(v.getInicioReal()!=null){
			sp.setDate(9, (Date) v.getInicioReal());
			}else{
				sp.setNull(9, 1);			}
			if(v.getFinReal()!=null){
			sp.setDate(10, (Date) v.getFinReal());
			}else{
				sp.setNull(10, 1);
			}
			if(v.getMotivo()!=null){
			sp.setString(11, v.getMotivo());
			}else{
				sp.setNull(11, 1);	
			}
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
				java.sql.Timestamp f1 = new Timestamp(v.getInicioProgramado().getTime());
				java.sql.Timestamp f2 = new Timestamp(v.getFinProgramado().getTime());
				Connection con = DBConnection.getPoolConnection().getConnection();
				CallableStatement sp;
				sp = con.prepareCall("{CALL TNG24V1.dbo.SP_UPDATE_VISITA(?,?,?,?,?,?,?,?,?,?)}");
						
				if(v.getFactura()!=null){
				sp.setInt(2, v.getFactura().getId());
				}else{
					sp.setNull(2, 1);
				}
				if(v.getPresupuesto()!=null){
				sp.setInt(3, v.getPresupuesto().getId());
				}else{
				sp.setNull(3, 1);
				}
				if(v.getCliente()!=null){
				sp.setInt(4, v.getCliente().getIdEnte());
				}else{
					sp.setNull(4, 1);
				}
				if(v.getDomicilio()!=null){
				sp.setInt(5, v.getDomicilio().getIdDomicilio());
				}else{
					sp.setNull(5, 1);
				}
				if(v.getInicioProgramado()!=null){
				sp.setTimestamp(6, f1);
				}else{
					sp.setNull(6, 1);
				}
				if(v.getFinProgramado()!=null){
				sp.setTimestamp(7, f2);
				}else{
					sp.setNull(7, 1);
				}
				if(v.getInicioReal()!=null){
				sp.setLong(8, v.getInicioReal().getTime());
				}else{
					sp.setNull(8, 1);
				}
				if(v.getFinReal()!=null){
				sp.setLong(9, v.getFinReal().getTime());
				}else{
					sp.setNull(9, 1);
				}
				if(v.getMotivo()!=null){
					sp.setString(10, v.getMotivo());
					}else{
						sp.setNull(10, 1);
					}
				
				
				
				sp.setInt(1, v.getId());
				
				sp.execute();
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
						+ "where IDVISITA =?");
				
				
			
			
				s.setInt(1, v.getId());			
				s.execute();
				DBConnection.getPoolConnection().realeaseConnection(con);
			
			} catch (Exception e)
			{
				System.out.println("ERROR BAJA VISITA" + e.getMessage());
			}
			
		}

	
	
}
