package fichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import excepciones.CodigoNegativoException;
import medicamento.Medicamento;

public class Fichero {

	private static BufferedReader br = null;
	private static BufferedWriter bw = null;
	private static String archivo = "src/archivo/medicamentos.txt";

	
	public static TreeSet<Medicamento> leer(){
		TreeSet<Medicamento> lista = new TreeSet<>();
		try {
			String linea = "";
			String[] valores;
			Medicamento m = null;
			br = new BufferedReader(new FileReader(archivo));
			while((linea = br.readLine())!=null) {
				valores = linea.split(";");
				m = new Medicamento(Integer.parseInt(valores[0]), valores[1], valores[2], Double.parseDouble(valores[3]), valores[4]);
				
				lista.add(m);
				//br.readLine(); No poner si se inicializa en el bucle
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (CodigoNegativoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public static void escribir (TreeSet<Medicamento> lista) {
		try {
			bw = new BufferedWriter(new FileWriter(archivo));
			for(Medicamento med : lista) {
			bw.write(med.getCodigo() + ";" + med.getNombre() + ";" 
			+ med.getDescripcion() + ";" + med.getPrecio() + ";" + med.getPosologia());
			bw.newLine();
		}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
