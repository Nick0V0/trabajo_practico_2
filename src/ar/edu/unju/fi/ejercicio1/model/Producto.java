package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
	private String cod;
	private String des;
	private Double prec;
	private Origen orig;
	private Categoria cat;
	

public enum Origen{
	ARGENTINA, CHINA, BRASIL, URUGUAY ;
}



public enum Categoria{
	TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS ;
}


public Producto() {
	// TODO Auto-generated constructor stub
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



@Override
public String toString() {
	return "Producto [Codigo=" + cod + ", Descripcion=" + des + ", Precio Unitario=" + prec + ", Origen Fabricacion=" + orig + ", categoria=" + cat + "]";
}


}
