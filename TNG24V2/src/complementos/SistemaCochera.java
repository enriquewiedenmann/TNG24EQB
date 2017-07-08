package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import modelo.Abono;
import modelo.CBU;
import modelo.Cheque;
import modelo.Cliente;
import modelo.Cochera;
import modelo.Contrato;
import modelo.ContratoCBU;
import modelo.ContratoCheque;
import modelo.ContratoEfectivo;
import modelo.ContratoTarjeta;
import modelo.Doble;
import modelo.Efectivo;
import modelo.EntidadBancaria;
import modelo.EntidadEmisoraTarjeta;
import modelo.LimitePorHora;
import modelo.MedioPago;
import modelo.Ocupacion;
import modelo.TarjetaCredito;
import modelo.Vehiculo;
import persistencia.DAOAbono;
import persistencia.DAOCBU;
import persistencia.DAOCochera;
import persistencia.DAOContrato;
import persistencia.DAOEntidadBancaria;
import persistencia.DAOEntidadEmisoraTarjeta;
import persistencia.DAOLimitePorHora;
import persistencia.DAOVehiculo;

public class SistemaCochera
{
	private int							cocheraPosible;
	private int							valorHora	= 8;
	private static int					Plazas;
	private static SistemaCochera		instancia;
	private Ocupacion					ocupacion;
	private Cliente						clienteActual;
	private Contrato					contratoActual;
	private LimitePorHora				limiteActual;
	private List<Abono>					abonos;
	private List<Cliente>				clientes;
	private List<Cochera>				cocheras;
	private List<Contrato>				contratos;
	private List<EntidadBancaria>		bancos;
	private List<EntidadEmisoraTarjeta>	tarjeteros;
	private List<LimitePorHora>			limites;

	public static SistemaCochera getInstance()
	{
		if (instancia == null)
			instancia = new SistemaCochera();
		return instancia;
	}

	private SistemaCochera()
	{
		// CARGAR TODOS LOS OBJETOS DESDE LA BASE DE DATOS
		// CUANDO SE INICIALIZA LA INSTANCIA
		clienteActual = null;
		contratoActual = null;
		limiteActual = null;
		clientes = this.cargarClientes();
		abonos = this.cargarAbonos();
		cocheras = this.cargarCocheras();
		bancos = this.cargarBancos();
		tarjeteros = this.cargarTarjeteros();
		contratos = this.cargarContratos();
		limites = this.cargarLimites();
		ocupacion = new Ocupacion();
		Plazas = 100;
	}

	// CARGA DATOS

	private List<Cliente> cargarClientes()
	{
		List<Cliente> clientes = DAOCliente.getInstancia().selectAll();
		Map<Integer, List<Vehiculo>> vehiculos = DAOVehiculo.getInstancia().selectAll();
		List<Cliente> lc = new ArrayList<Cliente>();

		if (clientes != null)
		{
			for (Cliente c : clientes)
			{
				lc.add(c);
				if (vehiculos != null)
				{
					if (vehiculos.containsKey(c.getDni()))
						c.setVehiculos(vehiculos.get(c.getDni()));
				}
			}
		}
		return lc;
	}

	private List<Abono> cargarAbonos()
	{
		List<Abono> abonos = DAOAbono.getInstancia().selectAll();
		return abonos != null ? abonos : null;
	}

	private List<Cochera> cargarCocheras()
	{
		List<Cochera> cocheras = DAOCochera.getInstancia().selectAll();
		return cocheras != null ? cocheras : null;
	}

	private List<EntidadBancaria> cargarBancos()
	{
		List<EntidadBancaria> bancos = DAOEntidadBancaria.getInstancia().selectAll();
		return bancos != null ? bancos : null;
	}

	private List<EntidadEmisoraTarjeta> cargarTarjeteros()
	{
		List<EntidadEmisoraTarjeta> tarjeteros = DAOEntidadEmisoraTarjeta.getInstancia()
				.selectAll();
		return tarjeteros != null ? tarjeteros : null;
	}

	private List<LimitePorHora> cargarLimites()
	{
		List<LimitePorHora> limites = DAOLimitePorHora.getInstancia().selectAll();
		return limites != null ? limites : null;
	}

	private List<Contrato> cargarContratos()
	{
		List<Contrato> contratos = DAOContrato.getInstancia().selectAll();
		return contratos != null ? contratos : null;
	}

	// FIN CARGA DATOS

	public boolean crearCliente(int dni, String nombre, String domicilio, String Telefono,
			String mail)
	{
		if (this.buscarCliente(dni) == null)
		{
			Cliente cl = new Cliente(dni, nombre, domicilio, Telefono, mail, true, true);
			this.clientes.add(cl);
			this.setClienteActual(cl);
			return true;
		}
		return false;
	}

	public ViewCliente mostrarCliente(int dni)
	{
		Cliente clienteBusqueda = this.buscarCliente(dni);
		ViewCliente vistaCliente = null;

		if (clienteBusqueda != null)
		{
			vistaCliente = clienteBusqueda.verCliente();

		}
		return vistaCliente;
	}

	public void abrirEdicionCliente(int dni)
	{
		Cliente cl = null;
		if (clienteActual == null)
		{
			cl = this.buscarCliente(dni);
			if (cl != null)
			{
				this.setClienteActual(cl);
			}
		}
	}

	public List<ViewCliente> listarClientes(String clave)
	{
		return this.buscarClienteComo(clave);
	}

	public void editarCliente(String nombre, String domicilio, String Telefono, String mail)
	{
		if (clienteActual != null)
		{
			clienteActual.editarme(nombre, domicilio, Telefono, mail);
			this.setClienteActual(null);
		}
	}

	public void eliminarCliente(int dni)
	{
		Cliente cl = null;
		cl = this.buscarCliente(dni);
		if (cl != null)
		{
			cl.bajarme();
			clientes.remove(cl);
		}
	}

	public Cliente buscarCliente(int dni)
	{
		for (Cliente cb : this.clientes)
		{
			if (cb.sosCliente(dni))
				return cb;
		}
		return null;
	}

	public List<ViewCliente> buscarClienteComo(String clave)
	{
		List<ViewCliente> clientesEncontrados = new ArrayList<ViewCliente>();

		for (Cliente c : clientes)
		{
			if (c.tePareces(clave))
			{
				clientesEncontrados.add(c.verCliente());
			}
		}
		return clientesEncontrados;
	}

	public ViewVehiculo altaVehiculoContrato(String patente)
	{
		ViewVehiculo vv = null;
		if (contratoActual != null)
		{
			vv = contratoActual.altaVehiculo(patente);
		}
		return vv;
	}

	public void bajaVehiculoContrato(String patente)
	{
		if (contratoActual != null)
		{
			contratoActual.bajaVehiculo(patente);
		}
	}

	public ViewVehiculo altaVehiculoCliente(String patente, String marca, String modelo,
			Date fechaEntrada)
	{
		ViewVehiculo vv = null;
		if (clienteActual != null)
		{
			vv = clienteActual.asociarAuto(patente, modelo, marca, fechaEntrada);
		}
		return vv;
	}

	public void bajaVehiculoCliente(String patente)
	{
		clienteActual.desasociarAuto(patente);
	}

	public ViewCochera asignarCocheraSimple()
	{
		ViewCochera vc = null;
		boolean superpuesta = false;
		if (contratoActual != null)
		{
			for (Cochera c : cocheras)
			{
				int codigo = c.getNumero();
				codigo = codigo > 100 ? codigo - 100 : codigo; // POR SI ES UNA
																// DOBLE

				if (contratos.size() > 0)
				{
					for (Contrato cont : contratos)
					{
						if (cont.meSuperpongo(contratoActual.getFechaIngreso(),
								contratoActual.getFechaSalida()))
						{
							if (!cont.esMiCochera(codigo))
							{
								setCocheraPosible(codigo);
							} else
							{
								superpuesta = true;
								break;
							}
						}
					}
					if (!superpuesta)
					{
						setCocheraPosible(codigo);
						break;
					}
				} else
				{
					setCocheraPosible(codigo);
					break;
				}
			}

			if (getCocheraPosible() > 0)
			{
				Cochera c = buscarCochera(getCocheraPosible());
				vc = contratoActual.asignarmeCochera(c);
			}

		}
		return vc;
	}

	public ViewCochera asignarCocheraDoble()
	{
		ViewCochera vc = null;
		boolean superpuesta = false;
		if (contratoActual != null)
		{
			for (Cochera c : cocheras)
			{
				int codigo = c.getNumero();
				codigo = codigo > 100 ? codigo - 100 : codigo; // POR SI ES UNA
																// DOBLE
				int codigoVecina = c.getCodigoVecina();
				if (contratos.size() > 0)
				{
					for (Contrato cont : contratos)
					{
						if (cont.meSuperpongo(contratoActual.getFechaIngreso(),
								contratoActual.getFechaSalida()))
						{
							if (!(cont.esMiCochera(codigo)) && !(cont.esMiCochera(codigoVecina)))
							{
								setCocheraPosible(codigo);
								break;
							} else
							{
								superpuesta = true;
								break;
							}
						}
					}
					if (!superpuesta)
					{
						setCocheraPosible(codigo);
						break;
					}
				} else
				{
					setCocheraPosible(codigo);
				}
			}

			if (getCocheraPosible() > 0)
			{
				Cochera c1 = buscarCochera(getCocheraPosible());
				Cochera c2 = buscarCochera(c1.getCodigoVecina());
				vc = contratoActual.asignarmeCocheraDoble(c1, c2);
			}
		}
		return vc;
	}

	public Cochera buscarCochera(int codigo)
	{
		Cochera resp = null;
		for (Cochera c : cocheras)
		{
			if (c.soyCochera(codigo))
			{
				resp = c;
			}
		}
		return resp;
	}

	public Vector<ViewBanco> listarBancos()
	{

		Vector<ViewBanco> vb = new Vector<ViewBanco>();
		for (EntidadBancaria b : bancos)
		{
			vb.add(b.mostrate());
		}
		return vb;
	}

	public Vector<ViewTarjetero> listarTarjeteros()
	{
		Vector<ViewTarjetero> vt = new Vector<ViewTarjetero>();
		for (EntidadEmisoraTarjeta t : tarjeteros)
		{
			vt.add(t.mostrate());
		}
		return vt;
	}

	public ViewMedioPago altaMedioPagoTarjeta(int nroEntidadEmisoraTarjeta, int nroTarjeta,
			Date fechaVencimiento)
	{
		ViewMedioPago cargado = null;

		if (contratoActual != null)
		{
			EntidadEmisoraTarjeta e = this.buscarTarjetero(nroEntidadEmisoraTarjeta);
			if (e != null)
			{
				MedioPago mpTarjeta = new TarjetaCredito(e, nroTarjeta, fechaVencimiento);
				contratoActual.setMedioPago(mpTarjeta);
				cargado = contratoActual.mostraMedioPago();
			}
		}
		return cargado;
	}

	public ViewMedioPago altaMedioPagoCBU(int nroEntidad, int nroCbu)
	{
		ViewMedioPago cargado = null;

		if (contratoActual != null)
		{
			EntidadBancaria b = this.buscarBanco(nroEntidad);
			if (b != null)
			{
				MedioPago mpCbu = new CBU(b, nroCbu);
				contratoActual.asignarMedioPago(mpCbu);
				cargado = contratoActual.mostraMedioPago();
			}
		}
		return cargado;
	}

	public EntidadEmisoraTarjeta buscarTarjetero(int nroEntidad)
	{
		for (EntidadEmisoraTarjeta eet : this.tarjeteros)
		{
			if (eet.sosTarjetero(nroEntidad))
				return eet;
		}
		return null;
	}

	public EntidadBancaria buscarBanco(int nroEntidad)
	{
		for (EntidadBancaria eb : this.bancos)
		{
			if (eb.sosBanco(nroEntidad))
				return eb;
		}
		return null;
	}

	public Vector<ViewAbono> listarAbonos()
	{
		Vector<ViewAbono> va = new Vector<ViewAbono>();
		for (Abono a : abonos)
		{
			va.add(a.mostrate());
		}
		return va;
	}

	public boolean nuevoContratoEfectivo(int dni, Date ingreso, Date egreso)
	{
		Cliente ca;
		ca = this.buscarCliente(dni);
		if (ca != null)
		{
			Contrato nc = new ContratoEfectivo(ca, ingreso, egreso);
			nc.asignarMedioPago(new Efectivo());
			setContratoActual(nc);
			return true;
		} else
			return false;
	}

	public boolean nuevoContratoCheque(int dni, Date ingreso, Date egreso)
	{
		Cliente ca;
		ca = this.buscarCliente(dni);
		if (ca != null)
		{
			Contrato nc = new ContratoCheque(ca, ingreso, egreso);
			nc.asignarMedioPago(new Cheque());
			setContratoActual(nc);
			return true;
		} else
		{
			return false;
		}
	}

	public boolean nuevoContratoCBU(int dni, Date ingreso, Date egreso)
	{
		Cliente ca;
		ca = this.buscarCliente(dni);
		if (ca != null)
		{
			Contrato nc = new ContratoCBU(ca, ingreso, egreso);
			setContratoActual(nc);
			return true;
		} else
			return false;

	}

	public boolean nuevoContratoTarjeta(int dni, Date ingreso, Date egreso)
	{
		Cliente ca;
		ca = this.buscarCliente(dni);
		if (ca != null)
		{
			Contrato nc = new ContratoTarjeta(ca, ingreso, egreso);
			setContratoActual(nc);
			return true;
		} else
			return false;

	}

	public void editarContrato(int nroContrato)
	{
		Contrato ec;
		ec = this.buscarContrato(nroContrato);
		if (ec != null)
			this.setContratoActual(ec);

	}

	public Contrato buscarContrato(int nroContrato)
	{
		for (Contrato cb : contratos)
		{
			if (cb.sosContrato(nroContrato))
				return cb;
		}
		return null;
	}

	public Vector<ViewContrato> listarContratos(String Clave)
	{
		Vector<ViewContrato> vistaContratos = new Vector<ViewContrato>();
		ArrayList<Cliente> posibles = new ArrayList<Cliente>();

		for (Cliente cl : clientes)
		{
			if (cl.tePareces(Clave))
			{
				posibles.add(cl);
			}
		}

		for (Cliente clc : posibles)
		{
			for (Contrato cb : contratos)
			{
				if (cb.esTuCliente(clc))
				{
					vistaContratos.add(cb.mostrate());
				}
			}
		}
		return vistaContratos;
	}

	public ViewContrato verContrato(int nroContrato)
	{
		Contrato vc = this.buscarContrato(nroContrato);
		if (vc != null)
			return vc.mostrate();

		return null;
	}

	public int cerrarContrato()
	{
		float importe = 0;

		if (this.contratoActual != null)
		{
			if (contratoActual.tenesCliente())
			{
				if (contratoActual.tenesMedioPago())
				{
					if (contratoActual.autosYCocherasiguales())
					{
						// CALCULO DE ABONOS
						int horasTotales = contratoActual.calcularHoras();

						Abono abCalcular = null;
						for (Abono ab : abonos)
						{
							if (abCalcular == null)
							{
								abCalcular = ab;
							}
							if (ab.aplicas(horasTotales))
							{
								importe = ab.calcularImporte(valorHora, horasTotales);
							} else
							{
								int horas = ab.getHoras();
								if (horas < horasTotales && horas > abCalcular.getHoras())
								{
									abCalcular = ab;
								}
							}
						}

						if (importe == 0)
						{
							importe = abCalcular.calcularImporte(valorHora, horasTotales);
						}
						// FIN ABONOS
						contratoActual.crearCuentaCorriente(importe);
						DAOContrato.getInstancia().insert(contratoActual);

						// PERSISTIR VEHICULO
						if (contratoActual.getCochera().getNumero() > 100)
						{
							// CODIGO > 100 ES COCHERA DOBLE
							Doble c = (Doble) contratoActual.getCochera();
							for (Cochera o : c.getCochera())
							{
								DAOCochera.getInstancia().asignaContrato(o,
										contratoActual.getNroContrato());
							}
						} else
						{
							DAOCochera.getInstancia().asignaContrato(contratoActual.getCochera(),
									contratoActual.getNroContrato());
						}

						contratoActual.getMedioPago()
								.setIdContrato(contratoActual.getNroContrato());

						// PERSISTIR MEDIO DE PAGO
						contratoActual.getMedioPago().persistite();

						contratos.add(contratoActual);
						return contratoActual.getNroContrato();
					}
				}
			}
		}
		return -1;
	}

	public void bajaContrato(int nroContrato)
	{
		Contrato bc;
		bc = this.buscarContrato(nroContrato);
		if (bc != null)
			bc.bajarme();
	}

	public Vector<ViewCuentaCorriente> mostrarCuentaCorriente()
	{
		Vector<ViewCuentaCorriente> vcc = null;

		if (contratoActual != null)
		{

			vcc = contratoActual.mostrarCuentaCorriente();

		}
		return vcc;
	}

	public ViewMedioPago mostrarMedioPagoContrato()
	{
		ViewMedioPago vmp = null;

		if (contratoActual != null)
		{
			contratoActual.mostraMedioPago();
		}
		return vmp;
	}

	public ViewCochera mostrarCocheraContrato()
	{
		ViewCochera vc = null;
		if (contratoActual != null)
		{
			vc = contratoActual.mostraCochera();
		}
		return vc;
	}

	public ViewVehiculo mostrarVehiculoContrato()
	{
		return contratoActual != null ? contratoActual.mostraVehiculo() : null;
	}

	public List<ViewVehiculo> mostrarVehiculoCliente(int dni)
	{
		if (clienteActual != null)
		{
			return clienteActual.mostrarVehiculos();
		} else
		{
			Cliente cliente = this.buscarCliente(dni);

			if (cliente != null)
				return cliente.mostrarVehiculos();
		}
		return null;
	}

	public void cerrarCliente()
	{
		if (clienteActual != null)
		{
			setClienteActual(null);
		}
	}

	public Vector<ViewLimitePorHora> ListarLimites()
	{
		Vector<ViewLimitePorHora> lista = new Vector<ViewLimitePorHora>();
		for (LimitePorHora l : limites)
		{
			lista.add(l.mostrate());
		}
		return lista;
	}

	public int actualizarLimite(int hora)
	{
		LimitePorHora lb = null;
		lb = this.buscarLimite(hora);
		if (lb != null)
		{
			return lb.limiteActual(SistemaCochera.getPlazas());
		}
		return 0;
	}

	public LimitePorHora buscarLimite(int hora)
	{
		for (LimitePorHora l : limites)
		{
			if (l.sosActual(hora))
			{
				return l;
			}
		}
		return null;
	}

	public ViewLimitePorHora VerLimite(int hora)
	{
		ViewLimitePorHora uno = null;
		LimitePorHora lb = null;
		lb = this.buscarLimite(hora);
		if (lb != null)
		{
			uno = lb.mostrate();
		}
		return uno;
	}

	public void AbrirEdicionLimitePorHora(int hora)
	{
		LimitePorHora lb = null;
		lb = this.buscarLimite(hora);
		if (lb != null)
		{
			this.setLimiteActual(lb);
		}
		return;
	}

	public void CerrarEdicionLimitePorHora(int limite)
	{
		if (this.getLimiteActual() != null)
		{
			this.getLimiteActual().setLimite(limite);
			this.setLimiteActual(null);
		}
		return;
	}

	public LimitePorHora getLimiteActual()
	{
		return limiteActual;
	}

	public void setLimiteActual(LimitePorHora limiteActual)
	{
		this.limiteActual = limiteActual;
	}

	public int OcupacionActual()
	{
		return ocupacion.getAutosAdentro();
	}

	public void ingresaVehiculo(int tamanio)
	{
		ocupacion.ingresaAuto(tamanio);
	}

	public void egresaVehiculo(int tamanio)
	{
		ocupacion.egresaAuto(tamanio);
	}

	// ABONOS INICIO
	public Vector<ViewAbono> listarAbonos(String codigo)
	{
		Vector<ViewAbono> va = new Vector<ViewAbono>();
		for (Abono a : abonos)
		{
			va.add(a.mostrate());
		}
		return va;
	}

	public boolean altaAbono(String codigo, String nombre, int horas, float descuento)
	{
		if (this.buscarAbono(codigo) == null)
		{

			for (Abono abHoras : this.abonos)
			{
				if (abHoras.aplicas(horas))
					return false;
			}

			Abono a = new Abono(codigo, nombre, horas, descuento);
			abonos.add(a);
			return true;
		}
		return false;
	}

	public ViewAbono mostrarAbono(String codigo)
	{
		Abono abonoBusqueda = this.buscarAbono(codigo);
		ViewAbono vistaAbono = null;

		if (abonoBusqueda != null)
		{
			vistaAbono = abonoBusqueda.mostrate();
		}
		return vistaAbono;
	}

	public boolean editarAbono(String codigo, String nombre, int horas, float descuento)
	{
		Abono abModif = this.buscarAbono(codigo);

		if (abModif != null)
		{
			for (Abono abHoras : this.abonos)
			{
				if (abHoras.aplicas(horas))
					return false;
			}

			abModif.editarme(nombre, horas, descuento);
			return true;
		} else
		{
			return false;
		}
	}

	public boolean bajaAbono(String codigo)
	{
		Abono ab = this.buscarAbono(codigo);
		if (ab != null)
		{
			abonos.remove(ab);
			return true;
		}
		return false;
	}

	public Abono buscarAbono(String codigo)
	{
		if (this.abonos != null)
		{
			for (Abono ab : this.abonos)
			{
				if (ab.sosAbono(codigo))
					return ab;
			}
		}
		return null;
	}

	// ABONOS FIN

	// GETTERS AND SETTERS INICIO
	public List<Cliente> getClientes()
	{
		return clientes;
	}

	public void setClientes(List<Cliente> clientes)
	{
		this.clientes = clientes;
	}

	public List<Abono> getAbonos()
	{
		return abonos;
	}

	public void setAbonos(List<Abono> abonos)
	{
		this.abonos = abonos;
	}

	public List<Cochera> getCocheras()
	{
		return cocheras;
	}

	public void setCocheras(List<Cochera> cocheras)
	{
		this.cocheras = cocheras;
	}

	public Cliente getClienteActual()
	{
		return clienteActual;
	}

	public void setClienteActual(Cliente clienteActual)
	{
		this.clienteActual = clienteActual;
	}

	public Contrato getContratoActual()
	{
		return contratoActual;
	}

	public void setContratoActual(Contrato contratoActual)
	{
		this.contratoActual = contratoActual;
	}

	public int getCocheraPosible()
	{

		return cocheraPosible;
	}

	public void setCocheraPosible(int cocheraPosible)
	{
		this.cocheraPosible = cocheraPosible;
	}

	public List<EntidadBancaria> getBancos()
	{
		return bancos;
	}

	public void setBancos(List<EntidadBancaria> bancos)
	{
		this.bancos = bancos;
	}

	public List<EntidadEmisoraTarjeta> getTarjeteros()
	{
		return tarjeteros;
	}

	public void setTarjeteros(List<EntidadEmisoraTarjeta> tarjeteros)
	{
		this.tarjeteros = tarjeteros;
	}

	public static int getPlazas()
	{
		return Plazas;
	}

	// GETTERS AND SETTERS FIN

	public ViewCochera mostrarCocheraContrato(int Contrato)
	{

		Contrato c = null;
		c = this.buscarContrato(Contrato);
		if (c != null)
		{
			return c.mostraCochera();
		}
		return null;
	}

	public ViewVehiculo mostrarVehiculoContrato(int Contrato)
	{

		Contrato c = null;
		c = this.buscarContrato(Contrato);
		if (c != null)
		{
			return c.mostraVehiculo();
		}
		return null;
	}

	public ViewMedioPago mostrarMedioPagoContrato(int Contrato)
	{
		Contrato c = null;
		c = this.buscarContrato(Contrato);
		if (c != null)
		{
			return c.mostraMedioPago();
		}
		return null;

	}

	public Vector<ViewCuentaCorriente> mostrarCuentaCorriente(int Contrato)
	{
		Vector<ViewCuentaCorriente> vcc = null;
		Contrato c = null;
		c = this.buscarContrato(Contrato);
		if (c != null)
		{
			vcc = c.mostrarCuentaCorriente();
		}
		return vcc;
	}

}
