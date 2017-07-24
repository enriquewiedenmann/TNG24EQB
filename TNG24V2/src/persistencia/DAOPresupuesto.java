package persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import core.Cliente;
import core.Empleado;
import core.ItemDocumento;
import core.Presupuesto;
import core.Producto;
import core.Provincia;

public class DAOPresupuesto {

	private static DAOPresupuesto	instancia;

	private DAOPresupuesto()
	{

	}

	public static DAOPresupuesto getInstancia()
	{
		if (instancia == null)
			instancia = new DAOPresupuesto();
		return instancia;
	}
	
	
	
	public ArrayList<Presupuesto> selectAllPresupuesto()
	{
		ArrayList<Presupuesto> lista = new ArrayList<Presupuesto>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT *FROM TNG24V1.dbo.CT_PRESUPUESTO");

			ResultSet rs = s.executeQuery();
			 Map<Integer, Cliente> cliente = DAOCliente.getInstancia().selectWhithCliente();
			 Map<Integer, Empleado> empleado = DAOEmpleado.getInstancia().selectwhithEmpleado();
			
			DBConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				
				             
				
			
			
				int id = rs.getInt("IDPRESUPUESTO");
				Date fec= rs.getDate("FECHAEMISIONPRESUPUESTO");
				int idCliente = rs.getInt("IDCLIENTE");
				String motivo = rs.getString("MOTIVO");
				int idTecnico= rs.getInt("IDTECNICO");				
				int tiempoManoObra=rs.getInt("TIEMPOMANOOBRA");
				int montoManoObra = rs.getInt("MONTOMANOOBRA");
				Cliente cli = cliente.get(idCliente);
				Empleado emp= empleado.get(idTecnico);
			
				Presupuesto p= new Presupuesto(id,fec,cli,motivo,tiempoManoObra,montoManoObra,this.selectAllItemPresupuesto(id),emp);
				lista.add(p);
				
			}

		} catch (Exception e)
		{
			System.out.println("ERROR EN SELECT PRESUPUESTO" + e.getMessage());
		}
		return lista;
	}	


	public  Map<Integer, Presupuesto> selectAllWhithPresupuesto()
	{
		 Map<Integer, Presupuesto> map = new  HashMap<Integer, Presupuesto>();
		try
		{Connection con = DBConnection.getPoolConnection().getConnection();
		PreparedStatement s = con
				.prepareStatement("SELECT *FROM TNG24V1.dbo.CT_PRESUPUESTO");

		ResultSet rs = s.executeQuery();
		 Map<Integer, Cliente> cliente = DAOCliente.getInstancia().selectWhithCliente();
		 Map<Integer, Empleado> empleado = DAOEmpleado.getInstancia().selectwhithEmpleado();
		
		DBConnection.getPoolConnection().realeaseConnection(con);

		while (rs.next())
		{
			
			             
			
		
		
			int id = rs.getInt("IDPRESUPUESTO");
			Date fec= rs.getDate("FECHAEMISIONPRESUPUESTO");
			int idCliente = rs.getInt("IDCLIENTE");
			String motivo = rs.getString("MOTIVO");
			int idTecnico= rs.getInt("IDTECNICO");
			int tiempoManoObra=rs.getInt("TIEMPOMANOOBRA");
			int montoManoObra = rs.getInt("MONTOMANOOBRA");
			Cliente cli = cliente.get(idCliente);
			Empleado emp= empleado.get(idTecnico);
		
			Presupuesto p= new Presupuesto(id,fec,cli,motivo,tiempoManoObra,montoManoObra,this.selectAllItemPresupuesto(id),emp);
				map.put(id,p);
				
			}

		} catch (Exception e)
		{
			System.out.println("ERROR EN SELECT PRESUPUESTO" + e.getMessage());
		}
		return map;
	
	}	
	
	
	
	
	public int insertPresupuesto(Presupuesto p){
		java.util.Date utilStartDate = p.getFechaEmision();
		java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
		
		Connection con = DBConnection.getPoolConnection().getConnection();
		CallableStatement sp;
		try {
			sp = con.prepareCall("{CALL TNG24V1.dbo.SP_ALTA_PRESUPEUSTO(?,?,?,?,?,?,?)}");
			 int idpresupuesto =-1;
			
			sp.registerOutParameter(1,java.sql.Types.INTEGER);
			sp.setDate(2, sqlStartDate);
			sp.setInt(3, p.getCliente().getEstado() );
			sp.setInt(4,p.getTecnico().getIdEnte());
			sp.setInt(5, p.getTiempoManoObra());
			sp.setInt(6, p.getMontoManoObra() );
			sp.setString(7, p.getMotivo() );
		
		// ejecutar el SP
		sp.execute();
		// confirmar si se ejecuto sin errores
		idpresupuesto = sp.getInt(1);  
		DBConnection.getPoolConnection().realeaseConnection(con);
		for(ItemDocumento it:p.getItems()){
			this.insertItemPresupuesto(idpresupuesto,it);
		}
		
		return idpresupuesto;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR ALTA PRESUPUESTO " + e.getMessage());
		}
		
		
		
		
		return -1;
	}
	
	
	
	
	
	
	
	//------------------------------------ITEMS----------------------------------------------
	
	
	public ArrayList<ItemDocumento> selectAllItemPresupuesto(int idpresupuesto)
	{
		ArrayList<ItemDocumento> lista = new ArrayList<ItemDocumento>();
		try
		{
			Connection con = DBConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("SELECT *FROM TNG24V1.dbo.CT_ITEMPRESUPUESTO where idpresupuesto=?");
			s.setInt(1, idpresupuesto);
			Map<String,Producto> prod = DAOProducto.getInstancia().selectAllWhithProduto();
			ResultSet rs = s.executeQuery();
			Map<String,Producto> MP = DAOProducto.getInstancia().selectAllWhithProduto();
			DBConnection.getPoolConnection().realeaseConnection(con);

			while (rs.next())
			{
				
				             
				
				int id = rs.getInt("IDITEMPRESUPUESTO"); 
				String codProd=rs.getString("CODPRODUCTO");
				int cantProd= rs.getInt("CANTPRODUTO");
				int montoProd = rs.getInt("MONTOITEM");
				int nroItem= rs.getInt("NROITEM");
				Producto p= MP.get(codProd);
				
				ItemDocumento itemDoc= new ItemDocumento(nroItem,p,cantProd,montoProd);
				lista.add(itemDoc);
				
			}

		} catch (Exception e)
		{
			System.out.println("ERROR EN SELECT ITEMPRESUPUESTO" + e.getMessage());
		}
		return lista;
	}	


	public  Map<Integer, ItemDocumento> selectAllWhithItemDocumento()
	{
		 Map<Integer, ItemDocumento> map = new  HashMap<Integer, ItemDocumento>();
		 try
			{
				Connection con = DBConnection.getPoolConnection().getConnection();
				PreparedStatement s = con
						.prepareStatement("SELECT *FROM TNG24V1.dbo.CT_ITEMPRESUPUESTO");
				Map<String,Producto> prod = DAOProducto.getInstancia().selectAllWhithProduto();
				ResultSet rs = s.executeQuery();
				Map<String,Producto> MP = DAOProducto.getInstancia().selectAllWhithProduto();
				DBConnection.getPoolConnection().realeaseConnection(con);

				while (rs.next())
				{
					
					             
					
					int id = rs.getInt("IDITEMPRESUPUESTO"); 
					int idPresupuesto = rs.getInt("IDPRESUPUESTO");
					String codProd=rs.getString("CODPRODUCTO");
					int cantProd= rs.getInt("CANTPRODUTO");
					int montoProd = rs.getInt("MONTOITEM");
					int nroItem= rs.getInt("NROITEM");
					Producto p= MP.get(codProd);
					
					ItemDocumento itemDoc= new ItemDocumento(nroItem,p,cantProd,montoProd);
					map.put(idPresupuesto, itemDoc);
					
				}

			} catch (Exception e)
			{
				System.out.println("ERROR EN SELECT ITEMPRESUPUESTO" + e.getMessage());
			}
		return map;
	
	}	
	
	
	private int insertItemPresupuesto(int presupuesto,ItemDocumento item){
		
	
		
		
		Connection con = DBConnection.getPoolConnection().getConnection();
		CallableStatement sp;
		try {
			sp = con.prepareCall("{CALL TNG24V1.dbo.SP_ALTA_ITEMPRESUPUESTO(?,?,?,?,?,?)}");
			 int idItempresupuesto =-1;
	
			sp.registerOutParameter(1,java.sql.Types.INTEGER);
			sp.setInt(2,presupuesto);
			sp.setString(3,item.getProducto().getCodProducto());
			sp.setInt(4,item.getCantProd());
			sp.setInt(5, item.getMontoItem());
			sp.setInt(6, item.getNroItem());
			
		
		// ejecutar el SP
		sp.execute();
		// confirmar si se ejecuto sin errores
		idItempresupuesto = sp.getInt(1);  
		DBConnection.getPoolConnection().realeaseConnection(con);
		return idItempresupuesto;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR ALTA ITEMPRESUPUESTO " + e.getMessage());
		}
		
		
		
		
		return -1;
	}
	
	
	
}
