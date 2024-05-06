package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n\t\tMENÚ DE JUGADORES");
            System.out.println("------------------------");
            System.out.println("1. Alta de jugador");
            System.out.println("2. Mostrar todos los jugadores");
            System.out.println("3. Modificar la posición de un jugador");
            System.out.println("4. Eliminar un jugador");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = entrada.nextInt();
                entrada.nextLine();

                switch (opcion) {
                    case 1:
                    	altaJugador(entrada, jugadores);
                        break;
                    case 2:
                    	if (jugadores.isEmpty()) {
                    	    System.out.println("La lista de jugadores está vacía.");
                    	} else {
                    		mostrarDatosJugadores(jugadores);
                    	}
                        break;
                    case 3:
                    	if (jugadores.isEmpty()) {
                    	    System.out.println("La lista de jugadores está vacía.");
                    	} else {
                    		 modificarDatosJugador(entrada,jugadores);
                    	}
                        break;
                    case 4:
                    	if (jugadores.isEmpty()) {
                    	    System.out.println("La lista de jugadores está vacía.");
                    	} else {
                    		eliminarJugador(entrada,jugadores);
                    	}
                        break;
                    case 5:
                        System.out.println("Saliendo del menú...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                entrada.nextLine();
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado. Motivo: " + e.getMessage());
            }
        } while (opcion != 5);

        entrada.close();
	}
	

	
	static void altaJugador(Scanner entrada, List<Jugador> jugadores) {
        String pos;
        Boolean Verificacion=true;
		
        try {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = entrada.nextLine();

            System.out.print("Ingrese el apellido del jugador: ");
            String apellido = entrada.nextLine();

            System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
            LocalDate fechaNacimiento = LocalDate.parse(entrada.nextLine());

            System.out.print("Ingrese la nacionalidad del jugador: ");
            String nacionalidad = entrada.nextLine();

            System.out.print("Ingrese la estatura del jugador (en cm): ");
            double estatura = entrada.nextDouble();
            entrada.nextLine();

            System.out.print("Ingrese el peso del jugador (en kg): ");
            double peso = entrada.nextDouble();
            entrada.nextLine();

            System.out.print("Ingrese la posición del jugador ");
			System.out.println("\n ----- POSICIONES ----");
			System.out.println("1- DELANTERO");
			System.out.println("2- MEDIO");
			System.out.println("3- DEFENSA");
			System.out.println("4- ARQUERO");
            
			do {
				System.out.print("INGRESE OPCION: ");
				pos=entrada.nextLine();
				switch(pos) {
				case "1":
					jugadores.add(new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, Posicion.DELANTERO));
					Verificacion=false;
					break;
				case "2":
					jugadores.add(new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, Posicion.MEDIO));
					Verificacion=false;
					break;
				case "3":
					jugadores.add(new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, Posicion.DEFENSA));
					Verificacion=false;
					break;
				case "4":
					jugadores.add(new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, Posicion.ARQUERO));
					Verificacion=false;
					break;
				default:
					System.out.println("Opción inválida. Intente nuevamente.");
				}
			}while(Verificacion);
         	
            System.out.println("Hay " + jugadores.size()+" Jugador dado de alta correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al dar de alta al jugador. Motivo: " + e.getMessage());
        }
    }

	
	static void mostrarDatosJugadores(List<Jugador> jugadores) {
		for(Jugador jugador:jugadores) {
                System.out.println("\nDatos del jugador:");
                System.out.println("Nombre: " + jugador.getNombre() + " " + jugador.getApellido());
                System.out.println("Fecha de nacimiento: " + jugador.getFechaNac());
                System.out.println("Nacionalidad: " + jugador.getNacionalidad());
                System.out.println("Estatura: " + jugador.getEstatura() + " cm");
                System.out.println("Peso: " + jugador.getPeso() + " kg");
                System.out.println("Posición: " + jugador.getPosicion());
                System.out.println("Edad: " + jugador.calcularEdad() + " años");
		}

    }
 
	
    static Jugador buscarJugador(String nombre, String apellido, List<Jugador> jugadores) {
    	
    	Jugador jugadorEncontrado = new Jugador();
    	jugadorEncontrado = null;
    	try {        	
            for (Jugador jugador : jugadores) {
            	if (jugador.getApellido().equals(apellido) && jugador.getNombre().equals(nombre)) {
            		jugadorEncontrado = jugador;
            	}                
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar jugadores ordenados. Motivo: " + e.getMessage());
        }
        return jugadorEncontrado;
    }

    
    static void modificarDatosJugador(Scanner entrada ,List<Jugador> jugadores) {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = entrada.nextLine();

            System.out.print("Ingrese el apellido del jugador: ");
            String apellido = entrada.nextLine();

            Jugador jugador = buscarJugador(nombre, apellido, jugadores);
            
            String pos;
            Boolean Verificacion=true;
            
            if (jugador != null) {
            	
                System.out.print("Ingrese la posición del jugador ");
				System.out.println("\n ----- POSICIONES ----");
				System.out.println("1- DELANTERO");
				System.out.println("2- MEDIO");
				System.out.println("3- DEFENSA");
				System.out.println("4- ARQUERO");
				
				do {
					System.out.print("INGRESE OPCION: ");
					pos=entrada.nextLine();
					switch(pos) {
					case "1":
						jugador.setPosicion(Posicion.DELANTERO);
						Verificacion=false;
						break;
					case "2":
						jugador.setPosicion(Posicion.MEDIO);
						Verificacion=false;
						break;
					case "3":
						jugador.setPosicion(Posicion.DEFENSA);
						Verificacion=false;
						break;
					case "4":
						jugador.setPosicion(Posicion.ARQUERO);
						Verificacion=false;
						break;
					default:
						System.out.println("Opción inválida. Intente nuevamente.");
					}
				}while(Verificacion);
             	
            } else {
                System.out.println("Jugador no encontrado.");
            }
    	
    	
    }

    
    static void eliminarJugador(Scanner entrada ,List<Jugador> jugadores) {
		try {
	        System.out.print("Ingrese el nombre del jugador: ");
	        String nombre = entrada.nextLine();
	
	        System.out.print("Ingrese el apellido del jugador: ");
	        String apellido = entrada.nextLine();
	        boolean eliminado = false;
	        
			for(int i=0; i< jugadores.size();i++) {
				if(nombre.equals(jugadores.get(i).getNombre()) && apellido.equals(jugadores.get(i).getApellido()) ) {
					eliminado = true;
					jugadores.remove(i);
				}
			}
	        if (eliminado) {
	        	System.out.println("Jugador a sido eliminado con exito.");
	        } else {
	            System.out.println("Jugador no encontrado.");
	        }
	
	    } catch (Exception e) {
	        System.out.println("Error al ingrsar datos del jugador. Motivo: " + e.getMessage());
	    }	
    }
	

}

