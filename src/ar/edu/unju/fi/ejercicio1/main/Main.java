package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.Origen;

public class Main {

	public static void main(String[] args) {
		
		List<Producto> producto = new ArrayList<Producto>();
		Scanner scanner = new Scanner(System.in);
		String opcion;
		
		do {
            System.out.println("------------------------");
            System.out.println("1. Crear Producto ");
            System.out.println("2. Mostrar productos  ");
            System.out.println("3. Modificar producto (sólo puede modificar: descripción, precio unitario, origen fabricación o categoría). ");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            
            opcion = scanner.nextLine();
            
            	switch (opcion) {
                    case "1":
                    	CrearProducto(scanner,producto);
                        break;
                    case "2":
                    	if (producto.isEmpty()) {
                    	    System.out.println("La lista de producto está vacía.");
                    	} else {
                    		MostrarProducto(producto);
                    	}
                        break;
                    case "3":
                    	if (producto.isEmpty()) {
                    		System.out.println("La lista de producto está vacía.");
                    	} else {
                    		ModificarProducto(scanner,producto);
                    	}
                        break;
                    case "4":
                    	System.out.println("Saliendo del menú...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
        } while (!opcion.equals("4"));

	}
	
	
	static void CrearProducto(Scanner scanner,List<Producto> producto) {
		Producto produc = new Producto();
		try {
			System.out.println("---- Ingrese dato para: ------ ");
			System.out.println("Código:");
			produc.setCod(scanner.nextLine());
			System.out.println("Descripción:");
			produc.setDes(scanner.nextLine());
			System.out.println("Precio unitario:");
			produc.setPrec(scanner.nextDouble());
			scanner.nextLine();
	        System.out.println("---- Origen de fabricación ------ ");
	        OpcionesOrigen(scanner, produc);
	        System.out.println("------ Categoría ------  ");
	        OpcionesCategoria(scanner, produc);
	        producto.add(produc);
		} catch (java.util.InputMismatchException e) {
			System.out.println("Error al cargar datos del producto. Motivo: " + e.getMessage());
		}
	}
	
	
	static void OpcionesOrigen(Scanner scanner,Producto producto){
        System.out.println("	1 - Argentina  ");
        System.out.println("	2 - China  ");
        System.out.println("	3 - Brasil ");
        System.out.println("	4 – Uruguay");
        System.out.print("Ingrese una opción: ");  
        boolean verificacion = true;
		do {            
			 String opcion = scanner.nextLine();   
            	switch (opcion) {
                    case "1":
                    	producto.setOrig(Origen.ARGENTINA);
                    	verificacion = false;
                        break;
                    case "2":
                    	producto.setOrig(Origen.CHINA);
                    	verificacion = false;
                        break;
                    case "3":
                    	producto.setOrig(Origen.BRASIL);
                    	verificacion = false;
                        break;
                    case "4":
                    	producto.setOrig(Origen.URUGUAY);
                    	verificacion = false;
                    	break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
        } while (verificacion);
        
	}
	
	
	static void OpcionesCategoria(Scanner scanner,Producto producto){
        System.out.println("	1 – Telefonía   ");
        System.out.println("	2 – Informática  ");
        System.out.println("	3 – Electro hogar ");
        System.out.println("	4 – Herramientas");
        System.out.print("Ingrese una opción: ");
        boolean verificacion = true;
		do {     
			 String opcion = scanner.nextLine();
            	switch (opcion) {
                    case "1":
                    	producto.setCat(Categoria.TELEFONIA);
                    	verificacion = false;
                        break;
                    case "2":
                    	producto.setCat(Categoria.INFORMATICA);
                    	verificacion = false;
                        break;
                    case "3":
                    	producto.setCat(Categoria.ELECTROHOGAR);
                    	verificacion = false;
                        break;
                    case "4":
                    	producto.setCat(Categoria.HERRAMIENTAS);
                    	verificacion = false;
                    	break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
        } while (verificacion);
        
	}

	
	static void MostrarProducto(List<Producto>producto){
        for (Producto productos : producto) {
            System.out.println(productos);
        }
	}
	
	
	static void ModificarProducto(Scanner scanner,List<Producto>producto) {
        System.out.println("Ingrese el código del producto a modificar:");
        String codigo = scanner.nextLine();
	    Producto productoEncontrado = null;
	    for (Producto productos : producto) {
	        if (productos.getCod().equals(codigo)) {
	            productoEncontrado = productos;
	            break;
	        }
	    }
	    if(productoEncontrado != null) {
	        System.out.println("---- Modificar producto " + productoEncontrado.getCod() + " ------    ");
	        System.out.println("	1 – Descripción  ");
	        System.out.println("	2 – Precio unitario  ");
	        System.out.println("	3 – Origen fabricación ");
	        System.out.println("	4 – Categoría");
	        System.out.print("Ingrese una opción: ");
	        boolean verificacion = true;
			do {            
				String opcion = scanner.nextLine();
	            	switch (opcion) {
	                    case "1":
	                    	System.out.println("Igrese nueva descripcion: ");
	                    	productoEncontrado.setDes(scanner.nextLine());
	                    	verificacion = false;
	                        break;
	                    case "2":
	                    	productoEncontrado.setPrec(scanner.nextDouble());
	                    	scanner.nextLine();
	                    	verificacion = false;
	                        break;
	                    case "3":
	                        System.out.println("---- Origen de fabricación ------ ");
	                        OpcionesOrigen(scanner, productoEncontrado);
	                    	verificacion = false;
	                        break;
	                    case "4":
	                        System.out.println("------ Categoría ------  ");
	                        OpcionesCategoria(scanner, productoEncontrado);
	                    	verificacion = false;
	                    	break;
	                    default:
	                        System.out.println("Opción no válida. Intente nuevamente.");
	                }
	        } while (verificacion);
	    }
	    else {
	    	System.out.println("Producto no encontrado");
	    }

	    
	}


}

	
