package medicamento;

import excepciones.CodigoNegativoException;

public class Medicamento implements Comparable<Medicamento>{

	private int codigo = 0;
	
	private String nombre = "";
	
	private String descripcion = "";
	
	private double precio = 0.0;
	
	private String posologia = "";
	
	
	
	public Medicamento(int codigo) throws CodigoNegativoException{
		comprobarCodigo(codigo);
		
	}
	
	public Medicamento(int codigo, String nombre, String descripcion) throws CodigoNegativoException {
		this(codigo);
		if(nombre != null && !nombre.equals("")) {
			this.nombre = nombre;
		}
		if(descripcion != null && !descripcion.equals("")) {
			this.descripcion = descripcion;
		}	}
	
	


	public Medicamento(int codigo, String nombre, String descripcion, double precio, String posologia) throws CodigoNegativoException {
		this(codigo, nombre, descripcion);
		this.precio = precio;
		this.posologia = posologia;
	}

	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getPosologia() {
		return posologia;
	}


	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}


	public int getCodigo() {
		return codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}

	private void comprobarCodigo(int codigo) throws CodigoNegativoException {
		if(codigo > 0) {
			this.codigo = codigo;
		}else {
			throw new CodigoNegativoException();
		}
	}
	
	
	@Override
	public String toString() {
		String res = "";
		res += "Código: " + this.codigo + "\n";
		res += "Nombre: " + this.nombre+ "\n";
		res += "Descripción: " + this.descripcion+ "\n";
		res += "Precio: " + this.precio+ "\n";
		res += "Posologia: " + this.posologia+ "\n";
		return res;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		Medicamento med = (Medicamento) obj;
		if(this.codigo == med.codigo) {
			res = true;
		}
		return res;
	}

	@Override
	public int compareTo(Medicamento o) {
		int res = 0;
		
		res = this.codigo - o.codigo;
		
		return res;
	}

}
