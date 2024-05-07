package ar.edu.unju.fi.ejercicio7.main;


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




public String getCod() {
	return cod;
}




public void setCod(String cod) {
	this.cod = cod;
}




public String getDes() {
	return des;
}




public void setDes(String des) {
	this.des = des;
}




public double getPrec() {
	return prec;
}




public void setPrec(double d) {
	this.prec = d;
}




public Origen getOrig() {
	return orig;
}




public void setOrig(Origen orig) {
	this.orig = orig;
}




public Categoria getCat() {
	return cat;
}




public void setCat(Categoria cat) {
	this.cat = cat;
}




public Producto(String cod, String des, Double prec, Origen orig, Categoria cat, boolean estado) {
	super();
	this.cod = cod;
	this.des = des;
	this.prec = prec;
	this.orig = orig;
	this.cat = cat;
	this.estado = estado;
}




@Override
public String toString() {
	return "Producto [Codigo=" + cod + ", Descripcion=" + des + ", Precio Unitario=" + prec + ", Origen Fabricacion=" + orig + ", categoria=" + cat + "]";
}


}
