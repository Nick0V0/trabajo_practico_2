package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago{
	
    private String numeroTarjeta;
    private LocalDate fechaPago;
    private double montoPagado;
    
	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		this.montoPagado = monto + monto * 0.15;
	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		System.out.println("");
        System.out.println("Pago con tarjeta:");
        System.out.println("Número de tarjeta: " + numeroTarjeta);
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
	}

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
	}
	
}
