package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
			List<Efemeride> efemerides = new ArrayList<Efemeride>();
			Scanner scanner = new Scanner(System.in);
			String opcion;
			
			do {
	            System.out.println("------------------------");
	            System.out.println("1 – Crear efeméride ");
	            System.out.println("2 – Mostrar efemérides  ");
	            System.out.println("3 – Eliminar efeméride");
	            System.out.println("4 – Modificar efeméride ");
	            System.out.println("5 – Salir. ");
	            System.out.print("Ingrese una opción: ");
	            
	            opcion = scanner.nextLine();
	            
	            	switch (opcion) {
	                    case "1":
	                    	CrearEfeméride(scanner,efemerides);
	                        break;
	                    case "2":
	                    	if (efemerides.isEmpty()) {
	                    	    System.out.println("No hay efemérides para mostrar.");
	                    	} else {
	                    		Mostrar(efemerides);
	                    	}
	                        break;
	                    case "3":
	                    	if (efemerides.isEmpty()) {
	                    		System.out.println("No hay efemérides para Eliminar.");
	                    	} else {
	                    		Eliminar(scanner, efemerides);
	                    	}
	                        break;
	                    case "4":
	                    	if (efemerides.isEmpty()) {
	                    		System.out.println("No hay efemérides para Eliminar.");
	                    	} else {
	                    		Modificar(scanner, efemerides);
	                    	}
	                    	break;
	                    case "5":
	                    	System.out.println("Saliendo del menú...");
	                        break;
	                    default:
	                        System.out.println("Opción no válida. Intente nuevamente.");
	                }
	        } while (!opcion.equals("5"));

		}
		
		static void CrearEfeméride(Scanner scanner,List<Efemeride> efemerides) {
			Efemeride EfemeridesnNuevo = new Efemeride();
			try {
				System.out.println("---- Ingrese dato: ------ ");
				System.out.println("Código:");
				EfemeridesnNuevo.setCodigo(scanner.nextLine());
				
				System.out.println("Mes [1-12]:(ej: 3  ---> MARZO.)");
				AgregarMes(scanner,EfemeridesnNuevo);
				
				System.out.println("Dia: ");
				EfemeridesnNuevo.setDia(scanner.nextInt());
				scanner.nextLine();
				
				System.out.println("Detalle :");
				EfemeridesnNuevo.setDetalle(scanner.nextLine());
				
				efemerides.add(EfemeridesnNuevo);

			} catch (java.util.InputMismatchException e) {
				System.out.println("Error al cargar datos del efemérides. Motivo: " + e.getMessage());
			}
		}

		
		static void AgregarMes(Scanner scanner, Efemeride efemeride ) {
			int x;		
			do {
				while(!scanner.hasNextInt()) {
					System.out.println("Eso no es un número. Inténtalo de nuevo.");
					scanner.nextLine();
				}
				x = scanner.nextInt();
				scanner.nextLine();
				if(x>13) {
					System.out.println("Mes fuera de rango");
				}
			}while(x>13);
			efemeride.setMes(Mes.values()[x-1]);
		}

		
		static void Mostrar(List<Efemeride> efemerides) {
	        for (Efemeride efemeride : efemerides) {
	            System.out.println(efemeride);
	        }
			
		}
		
		
		static void Eliminar(Scanner scanner,List<Efemeride> efemerides){
			System.out.print("Ingrese el código de la efeméride a eliminar: ");
			String codigo = scanner.nextLine();
			Efemeride Eliminar = new Efemeride(); 
			Eliminar = Buscar(efemerides, codigo);
			if(Eliminar!=null) {
	            efemerides.remove(Eliminar);
	            System.out.println("Efeméride eliminada con éxito.");
			}
			else {
				 System.out.println("No se encontró una efeméride con ese código.");
			}
				
		}
		
		
		static void Modificar(Scanner scanner,List<Efemeride>efemerides) {
			System.out.print("Ingrese el código del efemerides a modificar: ");
			String codigo = scanner.nextLine();
			Efemeride Modificar = Buscar(efemerides, codigo);
			if(Modificar!=null) {
				try {
					System.out.println("---- Ingrese nuevo dato para: " + Modificar.getDia() + ": ------ ");
					System.out.println("Código:");
					Modificar.setCodigo(scanner.nextLine());
					
					System.out.println("Mes:(ej: 3  ---> MARZO.)");
					AgregarMes(scanner,Modificar);
					
					System.out.println("Dia: ");
					Modificar.setDia(scanner.nextInt());
					scanner.nextLine();
					
					System.out.println("Detalle :");
					Modificar.setDetalle(scanner.nextLine());

				} catch (java.util.InputMismatchException e) {
					System.out.println("Error al cargar datos del efemerides. Motivo: " + e.getMessage());
				}
			}
			else {
				 System.out.println("No se encontró una efeméride con ese código.");
			}
		}
		
		
		static Efemeride Buscar(List<Efemeride>efemerides,String cod) {
			for(Efemeride efemeride: efemerides) {
				if(efemeride.getCodigo().equals(cod)) {
					return efemeride;
					
				}
			}
			return null;
		}


}
