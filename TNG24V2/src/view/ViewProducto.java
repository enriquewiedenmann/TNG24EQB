package view;

public class ViewProducto {

	private int id;
	private String codProducto;
	private String desc;
	private int stock;
	private int ptoPedido;
	private int precio;
	private char estado;
	public ViewProducto(int id, String codProducto, String desc, int stock,
			int ptoPedido, int precio, char estado) {
		super();
		this.id = id;
		this.codProducto = codProducto;
		this.desc = desc;
		this.stock = stock;
		this.ptoPedido = ptoPedido;
		this.precio = precio;
		this.estado = estado;
	}
	
	
	public String vistaTabla(){
		return  "<tr class=\"bodyTableProd\" ><th id=\"id\" >"+this.getCodProducto()+"</th><th>"+
        this.getDesc()+"</th><th>"+
        this.getPrecio()+"</th></tr>";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPtoPedido() {
		return ptoPedido;
	}
	public void setPtoPedido(int ptoPedido) {
		this.ptoPedido = ptoPedido;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "ViewProducto [id=" + id + ", codProducto=" + codProducto
				+ ", desc=" + desc + ", stock=" + stock + ", ptoPedido="
				+ ptoPedido + ", precio=" + precio + ", estado=" + estado + "]";
	}
	
	
	
	
	
}
