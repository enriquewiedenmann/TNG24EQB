package complementos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistencia.DAOVehiculo;
import controlador.ViewCliente;
import controlador.ViewVehiculo;

public class Cliente
{
	private int				dni;
	private String			nombre;
	private String			domicilio;
	private String			telefono;
	private String			mail;
	private boolean			estado;
	private List<Vehiculo>	vehiculos;

	public Cliente(int dni, String nombre, String domicilio, String telefono, String mail,
			boolean estado, boolean persistir)
	{
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.estado = estado;
		this.vehiculos = new ArrayList<Vehiculo>();

		if (persistir)
			DAOCliente.getInstancia().insert(this);
	}

	public void bajarme()
	{
		this.estado = false;
		DAOCliente.getInstancia().delete(this);
	}

	public void editarme(String nombre, String domicilio, String telefono, String mail)
	{
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		DAOCliente.getInstancia().update(this);
	}

	public ViewVehiculo asociarAuto(String patente, String modelo, String marca, Date fechaEntrada)
	{
		ViewVehiculo res = null;
		Vehiculo aux = null;
		if (vehiculos != null)
		{
			for (Vehiculo v : vehiculos)
			{
				if (v.sosVehiculo(patente))
				{
					aux = v;
				}
			}
			if (aux == null)
			{ 
				Vehiculo nv = new Vehiculo(patente, marca, modelo);
				vehiculos.add(nv);
				DAOVehiculo.getInstancia().asociarVehiculoCliente(nv, this.getDni());
				res = nv.verVehiculo();
			}
		}
		return res;
	}

	public void desasociarAuto(String patente)
	{
		if (vehiculos != null && !vehiculos.isEmpty())
		{
			Vehiculo vehiculoABorrar = null;
			for (Vehiculo v : vehiculos)
			{
				if (v.sosVehiculo(patente))
				{
					vehiculoABorrar = v;
				}
			}
			
			if(vehiculoABorrar != null)
			{
				vehiculos.remove(vehiculoABorrar);
				vehiculoABorrar.bajate();
			}
		}

	}

	public List<ViewVehiculo> mostrarVehiculos()
	{
		List<ViewVehiculo> vv = new ArrayList<ViewVehiculo>();
		if (vehiculos != null)
		{
			for (Vehiculo v : vehiculos)
			{
				vv.add(v.verVehiculo());
			}
		}
		return vv;
	}

	public boolean sosCliente(int dni)
	{
		return this.getDni() == dni ? true : false;
	}

	public ViewCliente verCliente()
	{
		return new ViewCliente(this.getDni(), this.getNombre(), this.getDomicilio(),
				this.getTelefono(), this.getMail());
	}

	public boolean tePareces(String clave)
	{
		return nombre.toUpperCase().contains(clave.toUpperCase()) ? true : false;
	}

	public boolean esMiVehiculo(String patente)
	{
		boolean res = false;

		if (vehiculos != null)
		{
			for (Vehiculo v : vehiculos)
			{
				if (v.getPatente().equals(patente))
				{
					res = true;
					break;
				}
			}
		}
		return res;

	}

	public ViewVehiculo mostrarVehiculo(String patente)
	{
		ViewVehiculo vv = null;
		if (vehiculos != null)
		{
			for (Vehiculo v : vehiculos)
			{
				if (v.getPatente().equalsIgnoreCase(patente))
				{
					vv = v.verVehiculo();
					break;
				}
			}
		}

		return vv;
	}
	
	public Vehiculo buscarVehiculo(String patente)
	{
		Vehiculo vr = null ;
		if(this.vehiculos != null)
		{
			for(Vehiculo c :this.vehiculos)
			{
				if(c.getPatente().toUpperCase().equals(patente.toUpperCase()))
				{
					vr = c;
					break;
				}
			}
		}
		return vr;
	}
	public int getDni()
	{
		return dni;
	}

	public void setDni(int dni)
	{
		this.dni = dni;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getDomicilio()
	{
		return domicilio;
	}

	public void setDomicilio(String domicilio)
	{
		this.domicilio = domicilio;
	}

	public String getTelefono()
	{
		return telefono;
	}

	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	public String getMail()
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	public boolean isEstado()
	{
		return estado;
	}

	public void setEstado(boolean estado)
	{
		this.estado = estado;
	}

	public List<Vehiculo> getVehiculos()
	{
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos)
	{
		this.vehiculos = vehiculos;
	}
}
