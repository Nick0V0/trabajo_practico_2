package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
    JUJUY(1000000, 53212),
    SALTA(1500000, 155488),
    TUCUMAN(1800000, 22524),
    CATAMARCA(400000, 102602),
    LA_RIOJA(300000, 89680),
    SANTIAGO_DEL_ESTERO(2500000, 136351);


    private double CantidadPoblacion;
    private double Superficie;
    

    
    private Provincia(double cantidadPoblacion, double superficie) {
        CantidadPoblacion = cantidadPoblacion;
        Superficie = superficie;
    }

    
    
	public double getCantidadPoblacion() {
		return CantidadPoblacion;
	}

	
	
	public void setCantidadPoblacion(double cantidadPoblacion) {
		CantidadPoblacion = cantidadPoblacion;
	}
	
	

	public double getSuperficie() {
		return Superficie;
	}
	
	

	public void setSuperficie(double superficie) {
		Superficie = superficie;
	}
	
	

    public double calcularDensidadPoblacional() {
        return CantidadPoblacion / Superficie;
    }
    
    

}
