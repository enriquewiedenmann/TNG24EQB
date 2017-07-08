package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.joda.time.DateTime;
import org.joda.time.Months;

import controlador.ViewCliente;
import controlador.ViewCochera;
import controlador.ViewContrato;
import controlador.ViewCuentaCorriente;
import controlador.ViewMedioPago;
import controlador.ViewVehiculo;

public abstract class Contrato
{
	private int						nroContrato;
	private boolean					estado;
	private String					tipo;
	private Date					fechaSalida;
	private Date					fechaIngreso;
	private Cliente					cliente;
	private MedioPago				medioPago;
	private Vehiculo				vehiculo;
	private Cochera					cochera;
	private List<CuentaCorriente>	cuentaCorriente;
	private List<Cobranza>			cobranza;
	private static int				nroContratoAutogenerado;

	public Contrato(Cliente cliente, Date fechaIngreso, Date fechaSalida, String tipo)
	{
		this.nroContrato = autoNro();
		this.vehiculo = null;
		this.cochera = null;
		this.cuentaCorriente = new ArrayList<CuentaCorriente>();
		this.cobranza = new ArrayList<Cobranza>();
		this.estado = true;
		this.tipo = tipo;

		this.cliente = cliente;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	public boolean hayQueFacturar()
	{
		return false;
	}

	public boolean estasVencido()
	{
		return false;
	}

	private static int autoNro()
	{

		return nroContratoAutogenerado++;
	}

	public ViewVehiculo altaVehiculo(String patente)
	{
		ViewVehiculo vv = null;
		if (this.cliente != null)
		{
			if (this.cliente.getVehiculos() != null)
			{
				if (this.cliente.esMiVehiculo(patente))
				{
					this.vehiculo = this.cliente.buscarVehiculo(patente);
					vv = this.vehiculo.verVehiculo();
				}
			}
		}
		return vv;
	}

	public void bajaVehiculo(String Patente)
	{
		if (vehiculo != null)
		{
			vehiculo.bajate();
			vehiculo = null;
		}
	}

	public ViewCochera asignarmeCochera(Cochera c)
	{
		ViewCochera v = c.verCochera();
		this.setCochera(c);
		return v;
	}

	public ViewCochera mostraCochera()
	{
		return this.cochera != null ? this.cochera.verCochera() : null;
	}

	public boolean esMiCochera(int codigoCochera)
	{
		return this.cochera != null ? this.cochera.soyCochera(codigoCochera) : false;

	}

	public boolean meSuperpongo(Date inicio, Date fin)
	{
		boolean ret = false;

		if (this.getFechaIngreso().before(inicio) && this.getFechaSalida().after(inicio))
		{
			ret = true;
		}
		if (this.getFechaIngreso().before(fin) && this.getFechaSalida().after(fin))
		{
			ret = true;
		}
		if (inicio.equals(this.getFechaIngreso()) || fin.equals(this.getFechaIngreso()))
		{
			ret = true;
		}
		if (inicio.equals(this.getFechaSalida()) || fin.equals(this.getFechaSalida()))
		{
			ret = true;
		}

		return ret;
	}

	public ViewCochera asignarmeCocheraDoble(Cochera c1, Cochera c2)
	{
		Doble d = new Doble(c1, c2);
		ViewCochera v = d.verCochera();
		this.setCochera(d);
		return v;
	}

	public boolean sosContrato(int nroContrato)
	{
		return (this.getNroContrato() == nroContrato);
	}

	public boolean esTuCliente(Cliente c)
	{
		return (this.getCliente() == c);
	}

	public ViewContrato mostrate()
	{
		ViewContrato nv = new ViewContrato(this.getNroContrato(), this.getFechaIngreso(),
				this.getFechaSalida(), this.getEstado());
		ViewCliente vc = this.getCliente().verCliente();
		nv.agregarCliente(vc);
		return nv;

	}

	public boolean tenesCliente()
	{
		return this.cliente != null;
	}

	public boolean tenesMedioPago()
	{
		return this.medioPago != null;
	}

	public boolean autosYCocherasiguales()
	{
		return this.vehiculo != null && this.cochera != null;
	}

	public int contarAutos()
	{
		return -1;
	}

	public void crearCuentaCorriente(float importe)
	{
		int numerocuota = 1;
		int cantcuotas = this.calcularCantCuotas();
		float imp = this.calcularImporteCuota(cantcuotas, importe);
		while (numerocuota <= cantcuotas)
		{
			DateTime di = new DateTime(this.getFechaIngreso());
			di = di.plusDays(10);
			di = di.plusMonths(1 * (numerocuota - 1));
			CuentaCorriente nc = new CuentaCorriente(numerocuota, imp, di.toDate());
			this.cuentaCorriente.add(nc);
			numerocuota++;
		}
	}

	public int calcularCantCuotas()
	{
		DateTime di = new DateTime(this.getFechaIngreso());
		DateTime df = new DateTime(this.getFechaSalida());

		int cantcuota = Months.monthsBetween(di, df).getMonths();

		return cantcuota;

	}

	public float calcularImporteCuota(int cantCuotas, float importe)
	{
		return (importe / cantCuotas);
	}

	public void bajarme()
	{
		this.setEstado(false);

	}

	public Vector<ViewCuentaCorriente> mostrarCuentaCorriente()
	{
		Vector<ViewCuentaCorriente> vcc = new Vector<ViewCuentaCorriente>();

		if (cuentaCorriente != null)
		{
			for (CuentaCorriente c : cuentaCorriente)
			{
				vcc.add(c.mostrate());
			}
		}
		return vcc;
	}

	public abstract ViewMedioPago mostraMedioPago();

	public ViewVehiculo mostraVehiculo()
	{
		return this.vehiculo != null ? this.vehiculo.verVehiculo() : null;
	}

	public int getNroContrato()
	{
		return nroContrato;
	}

	public void setNroContrato(int nroContrato)
	{
		this.nroContrato = nroContrato;
	}

	public Vehiculo getVehiculo()
	{
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo)
	{
		this.vehiculo = vehiculo;
	}

	public Cochera getCochera()
	{
		return cochera;
	}

	public void setCochera(Cochera cochera)
	{
		this.cochera = cochera;
	}

	public List<CuentaCorriente> getCuentaCorriente()
	{
		return cuentaCorriente;
	}

	public void setCuentaCorriente(List<CuentaCorriente> cuentaCorriente)
	{
		this.cuentaCorriente = cuentaCorriente;
	}

	public List<Cobranza> getCobranza()
	{
		return cobranza;
	}

	public void setCobranza(List<Cobranza> cobranza)
	{
		this.cobranza = cobranza;
	}

	public Cliente getCliente()
	{
		return cliente;
	}

	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}

	public Date getFechaIngreso()
	{
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso)
	{
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida()
	{
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida)
	{
		this.fechaSalida = fechaSalida;
	}

	public boolean isEstado()
	{
		return estado;
	}

	public void setEstado(boolean estado)
	{
		this.estado = estado;
	}

	public boolean getEstado()
	{
		return this.estado;
	}

	public int calcularHoras()
	{
		return (int) ((fechaSalida.getTime() - fechaIngreso.getTime()) / (3600 * 1000));
	}

	public MedioPago getMedioPago()
	{
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago)
	{
		this.medioPago = medioPago;
	}

	public abstract void asignarMedioPago(MedioPago medioPago);

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public String getTipo()
	{
		return tipo;
	}
}
