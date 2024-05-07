package ar.edu.unju.fi.ejercicio7.main;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio7.main.Producto;
import ar.edu.unju.fi.ejercicio7.main.Producto.Categoria;

public class Main {

	public static void main(String[] args) {

			List<Producto> productos = new ArrayList<Producto>();

			productos.add(new Producto("001", "Teléfono Móvil X1", 499.99, Producto.Origen.ARGENTINA, Producto.Categoria.TELEFONIA, false));
			productos.add(new Producto("002", "Laptop Pro 15", 1299.99, Producto.Origen.CHINA, Producto.Categoria.INFORMATICA, true));
			productos.add(new Producto("003", "Refrigerador Plus", 899.99, Producto.Origen.BRASIL, Producto.Categoria.ELECTROHOGAR, false));
			productos.add(new Producto("004", "Taladro Inalámbrico Z3", 249.99, Producto.Origen.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
			productos.add(new Producto("005", "Smartwatch 2.0", 199.99, Producto.Origen.ARGENTINA, Producto.Categoria.TELEFONIA, true));
			productos.add(new Producto("006", "Tablet Fire 8", 299.99, Producto.Origen.CHINA, Producto.Categoria.INFORMATICA, true));
			productos.add(new Producto("007", "Licuadora PowerMix", 99.99, Producto.Origen.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
			productos.add(new Producto("008", "Set de Herramientas Basic", 149.99, Producto.Origen.URUGUAY, Producto.Categoria.HERRAMIENTAS, false));
			productos.add(new Producto("009", "Cámara de Seguridad HD", 199.99, Producto.Origen.CHINA, Producto.Categoria.INFORMATICA, true));
			productos.add(new Producto("010", "Aspiradora Robot V5", 499.99, Producto.Origen.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
			productos.add(new Producto("011", "Smartphone Ultra 12", 999.99, Producto.Origen.ARGENTINA, Producto.Categoria.TELEFONIA, false));
			productos.add(new Producto("012", "Monitor Gamer Curvo 27'", 399.99, Producto.Origen.CHINA, Producto.Categoria.INFORMATICA, true));
			productos.add(new Producto("013", "Microondas QuickCook", 199.99, Producto.Origen.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
			productos.add(new Producto("014", "Sierra Circular 7\"", 129.99, Producto.Origen.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
			productos.add(new Producto("015", "Auriculares Bluetooth BeatX", 59.99, Producto.Origen.CHINA, Producto.Categoria.TELEFONIA, false));
			
			Scanner scanner = new Scanner(System.in);
	        String opcion;
	        
			do {
				System.out.println("Menú de opciones:");
				System.out.println("1 - Mostrar productos disponibles");
				System.out.println("2 - Mostrar productos faltantes");
				System.out.println("3 - Incrementar precios en un 20%");
				System.out.println("4 - Mostrar productos de Electrohogar disponibles");
				System.out.println("5 - Ordenar productos por precio descendente");
				System.out.println("6 - Mostrar nombres de productos en mayúsculas");
				System.out.println("7 - Salir");
				System.out.print("Ingrese una opción: ");
	            opcion = scanner.nextLine();

				switch (opcion) {
					case "1":
							MostrarDisponible(productos);
						break;
					case "2": 
							System.out.println(MostrarFaltantes(productos)); 
						break;
					case "3":
							Aumentos(productos);
						break;
					case "4":
							System.out.println(ElectrohogarDisponibilidad(productos));
						break;
					case "5":
							System.out.println(MostrarOrdenados(productos));
						break;
					case "6":
							System.out.println(MostrarMayúsculas(productos));
						break;
					case "7":
							System.out.println("Saliendo del programa...");
						break;
					default:
						System.out.println("Opción inválida. Intente nuevamente.");
				}
				} while (!opcion.equals("7"));    
				
				
		}
		
		
		static void MostrarDisponible(List<Producto>productos) {
			System.out.println("--- Productos Disponibles -----");
			Consumer<Producto> Mostrar = (n)-> {if(n.getEstado()) 
				System.out.println("Producto : "+n.getDes()+" :: Precio : "+n.getPrec());
			};
			productos.forEach(Mostrar);
		}
		
		
		static List<Producto> MostrarFaltantes(List<Producto>productos) {	
			System.out.println("--- Productos Faltantes -----");
				Predicate<Producto> condicion = (n)-> !n.getEstado();
				return productos.stream()
					.filter(condicion)
					.collect(Collectors.toList());
		}
		

		static List<Producto> Aumentos(List<Producto>productos) {
			System.out.println("--- Precios Incrementados -----");
			Function<Producto, Producto> nuevo = p -> {
				p.setPrec(p.getPrec()*1.20f);
				return p;
				};
			return productos.stream()
					.map(nuevo)
					.collect(Collectors.toList());
			}
		
		
		static List<Producto> ElectrohogarDisponibilidad(List<Producto>productos) {	
			System.out.println("--- ProductoS Por Categoria -----");
				Predicate<Producto> condicion = (n)-> n.getEstado() && n.getCat().equals(Categoria.ELECTROHOGAR);
				return productos.stream()
					.filter(condicion)
					.collect(Collectors.toList());
		}
		
		
		static List<Producto> MostrarOrdenados(List<Producto>productos) {
			System.out.println("--- Productos Em Orden De Forma Descendiente Por Su Precio -----");
			Comparator<Producto> n = Comparator.comparing(Producto::getPrec).reversed();
			productos.sort(n);
			return productos;
		}
		
		
	    static List<Producto> MostrarMayúsculas(List<Producto> productos) {
	        System.out.println("--- Productos en Mayúsculas -----");
	        Function<Producto, Producto> nuevo = p -> new Producto(p.getCod(), p.getDes().toUpperCase(), p.getPrec(), p.getOrig(), p.getCat(), p.getEstado());
	        return productos.stream()
	                .map(nuevo)
	                .collect(Collectors.toList());
	    }

	
}
