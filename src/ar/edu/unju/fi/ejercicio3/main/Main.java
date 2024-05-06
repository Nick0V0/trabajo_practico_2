package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
        Provincia[] provincias = Provincia.values();

        for (Provincia provincia : provincias) {
            double poblacion = provincia.getCantidadPoblacion();
            double superficie = provincia.getSuperficie();
            double densidadPoblacional = provincia.calcularDensidadPoblacional();

            System.out.println("Provincia: " + provincia);
            System.out.println("Población: " + poblacion);
            System.out.println("Superficie: " + superficie);
            System.out.println("Densidad Poblacional: " + densidadPoblacional);
            System.out.println();

        }
	}
}
