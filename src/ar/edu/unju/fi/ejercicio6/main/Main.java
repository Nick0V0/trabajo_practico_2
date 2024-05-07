package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45,12f); 
		Converter<FelinoDomestico,FelinoSalvaje> converter = x-> new FelinoSalvaje(x.getNombre(),x.getEdad(),x.getPeso());
		FelinoSalvaje felino1 = converter.convert(gato);
		converter.mostrarObjetos(felino1);
		
		FelinoSalvaje tigre= new FelinoSalvaje("Tanner", (byte)20,186f);
		
		if(Converter.isNotNull(tigre)){
			Converter<FelinoSalvaje,FelinoDomestico> converter2 = x-> new FelinoDomestico(x.getNombre(),x.getEdad(),x.getPeso());
			FelinoDomestico felino2 = converter2.convert(tigre);
			converter2.mostrarObjetos(felino2);
		}
		else {
			System.out.println("El objeto a convertir es nulo.");
		}
	}

}