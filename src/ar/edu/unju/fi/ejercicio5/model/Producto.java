package ar.edu.unju.fi.ejercicio5.model;

public class Producto {
	private String cod;
	private String des;
	private Double prec;
	private Origen orig;
	private Categoria cat;
	private boolean estado; // Atributo adicional 
	
public enum Origen{
	ARGENTINA, CHINA, BRASIL, URUGUAY ;
}

public enum Categoria{
	TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS ;
}




public boolean getEstado() {
	return estado;
}


}
