package excepciones;

public class CodigoNegativoException extends Exception{
	
	@Override
	public String toString() {
		String res = "";
		res = "El código no puede ser negativo.";
		return res;
	}
	
	@Override
	public String getMessage() {
		String res = "";
		res = "El código no puede ser negativo.";
		return res;
	}

}
