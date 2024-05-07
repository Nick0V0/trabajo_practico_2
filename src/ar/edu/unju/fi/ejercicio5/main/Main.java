package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio5.interfaces.*;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

public class Main {

	public static void main(String[] args) {
		List<Producto> productos = new ArrayList<Producto>();
		List<Producto> ProductoDisponible = new ArrayList<Producto>();

		productos.add(new Producto("001", "Teléfono Móvil X1", 499.99, Producto.Origen.ARGENTINA, Producto.Categoria.TELEFONIA, false));
		productos.add(new Producto("002", "Laptop Pro 15", 1299.99, Producto.Origen.CHINA, Producto.Categoria.INFORMATICA, true));
		productos.add(new Producto("003", "Refrigerador Plus", 899.99, Producto.Origen.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
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

		filtrar(productos, ProductoDisponible);
		
		Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println();
            System.out.println("Menú de opciones:");
            System.out.println("1 - Mostrar productos");
            System.out.println("2 - Realizar compra");
            System.out.println("3 - Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextLine();
            System.out.println();
            switch (opcion) {
                case "1":
                    MostrarProductos(ProductoDisponible);

                    break;
                case "2":
                	RealizarCompra(scanner, ProductoDisponible);
                    break;
                case "3":
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (!opcion.equals("3"));
	}
	
private static void filtrar(List<Producto>productos,List<Producto>ProductosDisponibles) {
	for(Producto producto:productos) {
		if(producto.getEstado()) {
			ProductosDisponibles.add(producto);
		}
	}
}


private static void MostrarProductos(List<Producto>productos) {
	System.out.println("Productos disponibles");
	for(Producto producto:productos) {
			System.out.println("Código: " + producto.getCod());
	        System.out.println("Descripción: " + producto.getDes());
	        System.out.printf("Precio: $%.2f\n", producto.getPrec());
	        System.out.println("Origen: " + producto.getOrig());
	        System.out.println("Categoría: " + producto.getCat());
	        System.out.println();
	}
}


private static void  RealizarCompra (Scanner scanner,List<Producto> productos) {
	List<Producto> CarritoDeCompras = new ArrayList<Producto>();
    double monto = 0;
	String opcion;
	do {
		System.out.println();
	    System.out.println("  Monto total:" + monto );
	    System.out.println("  1 - Agregar un producto");
	    System.out.println("  2 - Pago efectivo(10% de descuento)");
	    System.out.println("  3 - Pago con tarjeta(15% de recarga)");
	    System.out.println("  4 - Cancelar");
	    System.out.print("  Ingrese una opción: ");
	    opcion = scanner.nextLine();
    
	    switch (opcion) {
		    case "1":
		    	System.out.print("  Ingrese el codigo del producto: ");
		    	Producto producto=BuscarProducto(productos,scanner.nextLine());
		    	if(producto!=null) {
		    		monto += producto.getPrec();
		    		System.out.println("  Producto agregado al carrito. Total hasta ahora: $" + monto);
		    	}
		    	else {
		    		System.out.println("  No existe el producto.");	
		    	}
		        break;
		    case "2":
		    	PagoE(monto);
		    	CarritoDeCompras.clear();
		    	monto = 0;
		        break;
		    case "3":
		    	PagoT(scanner,monto);
		    	CarritoDeCompras.clear();
		    	monto = 0;
		        break;
		    case "4":
		        System.out.println("  Compra cancelada");
		        break;
		    default:
		        System.out.println("  Opción inválida. Intente nuevamente.");
	    	} 
	    
	}while (!opcion.equals("4"));
}


private static Producto BuscarProducto(List<Producto>producto, String codigo) {
    for (Producto productos : producto) {
        if (productos.getCod().equals(codigo)) {
            return productos;
        }
    }
	return null;
}


private static void PagoT(Scanner scanner , Double monto) {
	System.out.print("  Escriba el número de su tarjeta:");
	PagoTarjeta pago = new PagoTarjeta(scanner.nextLine(),LocalDate.now());
	pago.realizarPago(monto);
	pago.imprimirRecibo();
}


private static void PagoE(Double monto) {
	PagoEfectivo pago = new PagoEfectivo(LocalDate.now());
	pago.realizarPago(monto);
	pago.imprimirRecibo();
 }
}

