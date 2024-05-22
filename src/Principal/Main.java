package Principal;

import java.util.Scanner;

import excepciones.CodigoNegativoException;
import medicamento.GestionMedicamentos;
import medicamento.Medicamento;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opc = 0;
		int codigo = 0;
		String nombre = "";
		String descripcion = "";
		double precio = 0;
		String posologia = "";
		char seguir;
		do {
			menu();
			System.out.println("Seleccione una opción");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1 -> {
				GestionMedicamentos.listar();
			}
			case 2 -> {
				System.out.println("Introduzca el código, el nombre, la descripcion, el precio y la posologia");
				codigo = sc.nextInt();
				sc.nextLine();
				nombre = sc.nextLine();
				descripcion = sc.nextLine();
				precio = sc.nextDouble();
				sc.nextLine();
				posologia = sc.nextLine();
				Medicamento m;
				try {
					m = new Medicamento(codigo, nombre, descripcion, precio, posologia);
					if (GestionMedicamentos.addMedicamento(m)) {
						System.out.println("Añadido correctamente");
					}
				} catch (CodigoNegativoException e) {
					e.printStackTrace();
				}
			}
			case 3 -> {
				System.out.println("Introduzca el código del medicamento");
				codigo = sc.nextInt();
				sc.nextLine();
				try {
					Medicamento m = new Medicamento(codigo);
					if (GestionMedicamentos.borrarMedicamento(m)) {
						System.out.println("Borrado correctamente");
					}
				} catch (CodigoNegativoException e) {
					e.printStackTrace();
				}
			}
			case 4 -> {

				try {
					System.out.println("Introduzca el código del medicamento");
					codigo = sc.nextInt();
					sc.nextLine();
					precio = sc.nextDouble();
					sc.nextLine();
					if (GestionMedicamentos.modificarPrecio(codigo, precio)) {
						System.out.println("Se ha modificado el precio");
					}
				} catch (CodigoNegativoException e) {
					e.printStackTrace();
				}
			}
			case 5 -> {

				try {
					System.out.println("Introduzca el código del medicamento");
					codigo = sc.nextInt();
					sc.nextLine();
					posologia = sc.nextLine();
					if (GestionMedicamentos.modificarPosologia(codigo, posologia)) {
						System.out.println("Se ha modificado la posologia");
					}
				} catch (CodigoNegativoException e) {
					e.printStackTrace();
				}
			}
			case 6 ->{
				if(GestionMedicamentos.guardar()) {
					System.out.println("Guardado correctamente");
				}
			}
			case 0 ->{
			System.out.println("Saliendo...");	
			}
			}
		} while (opc != 0);
	}

	private static void menu() {
		System.out.println("╔════════════════════════════════════════════════════════╗");
		System.out.println("🛬              🌎 Menú de Medicamentos 🌎               🛬");
		System.out.println("╟────────────────────────────────────────────────────────╢");
		System.out.println("🛬 1. Mostrar listado📋                                  🛬");
		System.out.println("║  2. Insertar🆕                                         ║");
		System.out.println("🛬 3. Eliminar ❎                                        🛬");
		System.out.println("║  4. Modificar Precio🛠️                                 ║");
		System.out.println("║  5. Modificar Posologia🛠️                              ║");
		System.out.println("🛬 6. Guardar cambios💾                                  🛬");
		System.out.println("║  0. Salir                                              ║");
		System.out.println("╚════════════════════════════════════════════════════════╝");
	}

}
