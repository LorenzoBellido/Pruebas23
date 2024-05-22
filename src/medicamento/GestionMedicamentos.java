package medicamento;

import java.util.TreeSet;

import excepciones.CodigoNegativoException;
import fichero.Fichero;

public class GestionMedicamentos {

	public static TreeSet<Medicamento> listaMedicamento = Fichero.leer();

	public static boolean addMedicamento(Medicamento m) {
		boolean add = false;
		if(!listaMedicamento.contains(m)) {
			listaMedicamento.add(m);
			add = true;
		}

		return add;
	}

	public static boolean borrarMedicamento(Medicamento m) {
		boolean borrado = false;
		if (listaMedicamento.contains(m)) {
			listaMedicamento.remove(m);
			borrado = true;
		}
		return borrado;
	}

	public static void listar() {
		for (Medicamento m : listaMedicamento) {
			System.out.println(m);
			System.out.println("----------------------");
		}
	}

	public static boolean modificarPrecio(int codigo, double precio) throws CodigoNegativoException {
		boolean modificado = false;
		Medicamento m = new Medicamento(codigo);
		for (Medicamento med : listaMedicamento) {
			if (med.equals(m)) {
				med.setPrecio(precio);
				modificado = true;
			}
		}

		return modificado;
	}

	public static boolean modificarPosologia(int codigo, String posologia) throws CodigoNegativoException {
		boolean modificado = false;
		Medicamento m = new Medicamento(codigo);

		for (Medicamento med : listaMedicamento) {
			if (med.equals(m)) {
				med.setPosologia(posologia);
				modificado = true;
			}
		}
		return modificado;
	}
	public static boolean guardar() {
		
		Fichero.escribir(listaMedicamento);
		
		return true;
	}
}
