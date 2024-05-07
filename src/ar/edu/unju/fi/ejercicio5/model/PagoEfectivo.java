package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {

    private LocalDate fechaPago;
    private double montoPagado;
    
	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		this.montoPagado = monto - monto * 0.1;
		
	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		System.out.println("");
        System.out.println("Pago en efectivo:");
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
		
	}

	public PagoEfectivo(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	
}
