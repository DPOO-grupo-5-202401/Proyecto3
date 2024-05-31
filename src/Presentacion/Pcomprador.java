package Presentacion;

import Logica.Administrador;
import Logica.Compra;
import Logica.Comprador;
import Logica.Oferta;
import Logica.Pieza;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;
import java.util.Map.Entry;

public class Pcomprador {

    private static Administrador administrador; // Administrador para manejar la carga de datos

    public static void main(String[] args) {
        administrador = new Administrador("Juan", "A1", "A1");
        cargarDatos(); 

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido Comprador");
        
        Comprador comprador = new Comprador("Camilo",12345678,"C1","C1");

        menuComprador(comprador, scanner);
        

        guardarDatos(); 
        scanner.close();
    }

    private static void cargarDatos() {
        administrador.cargarCompradores();
        administrador.cargarEsculturas();
        administrador.cargarFotografias();
        administrador.cargarPinturas();
        administrador.cargarVideos();
    }

    private static void guardarDatos() {
        administrador.almacenarCompradores();
        administrador.almacenarEsculturas();
        administrador.almacenarFotografias();
        administrador.almacenarPinturas();
        administrador.almacenarVideos();
    }

    private static void menuComprador(Comprador comprador, Scanner scanner) {
        int opcion;
        do {
            System.out.println("1. Ver historia de una pieza");
            System.out.println("2. Ver historia de un artista");
            System.out.println("3. Realizar Compra");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    verHistoriaPieza(scanner);
                    break;
                case 2:
                    verHistoriaArtista(scanner);
                    break;
                case 3:
                	realizarCompra(comprador, scanner);
                case 4:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 4);
    }

    
    //Historia de una PIEZA	
    private static void verHistoriaPieza(Scanner scanner) {
        System.out.print("Ingrese el título de la pieza: ");
        String tituloPieza = scanner.nextLine().trim().toLowerCase();

        // Buscar piezas por título en el inventario histórico
        boolean found = false;
        for (Pieza pieza : administrador.getInventarioHistorico().values()) {
            if (pieza.getTitulo().toLowerCase().equals(tituloPieza)) {
                displayPiezaDetails(pieza);
                found = true;
                
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró ninguna pieza con el título '" + tituloPieza + "'");
        }
    }

    private static void displayPiezaDetails(Pieza pieza) {
        System.out.println("Mostrando detalles de la pieza encontrada:");
        System.out.println("ID: " + pieza.getId());
        System.out.println("Título: " + pieza.getTitulo());
        System.out.println("Año: " + pieza.getAnio());
        System.out.println("Autor: " + (pieza.getAutor() != null ? pieza.getAutor().getNombre() : "Desconocido"));
        System.out.println("Estado actual: " + pieza.getEstadoActual());
        System.out.println("En exhibición: " + (pieza.getEnExhibicion() ? "Sí" : "No"));

        
        if (pieza.getValorFijo()) {
            System.out.println("Tipo de venta: Precio fijo");
            System.out.println("Precio: " + pieza.getValor());
        } else {
            System.out.println("Tipo de venta: Subasta");
            System.out.println("Valor inicial: " + pieza.getValorInicial());
            System.out.println("Valor mínimo: " + pieza.getValorMinimo());
        }
    }



    //Historia de un ARTISTA
    private static void verHistoriaArtista(Scanner scanner) {
        System.out.print("Ingrese el nombre del artista: ");
        String nombreArtista = scanner.nextLine().trim().toLowerCase();

        
        boolean found = false;
        for (Pieza pieza : administrador.getInventarioHistorico().values()) {
            if (pieza.getAutor() != null && pieza.getAutor().getNombre().toLowerCase().equals(nombreArtista)) {
                if (!found) {
                    System.out.println("Mostrando obras de " + pieza.getAutor().getNombre() + ":");
                    found = true; 
                }
                mostrarDetallesPieza(pieza);
            }
        }

        if (!found) {
            System.out.println("No se encontraron obras del artista '" + nombreArtista + "'.");
        }
    }

    
    private static void mostrarDetallesPieza(Pieza pieza) {
        System.out.println("ID: " + pieza.getId());
        System.out.println("Título: " + pieza.getTitulo());
        System.out.println("Año: " + pieza.getAnio());
        System.out.println("Valor: " + pieza.getValor());
        
    }
    
    //Realizar COMPRA
    private static void realizarCompra(Comprador comprador, Scanner scanner) {
        System.out.print("Ingrese el título de la pieza que desea comprar: ");
        String tituloPieza = scanner.nextLine().trim().toLowerCase();

        ArrayList<Pieza> piezasEncontradas = new ArrayList<>();
        for (Pieza pieza : administrador.getInventarioHistorico().values()) {
            if (pieza.getTitulo().toLowerCase().equals(tituloPieza)) {
                piezasEncontradas.add(pieza);
            }
        }

        if (piezasEncontradas.isEmpty()) {
            System.out.println("No se encontró ninguna pieza con el título '" + tituloPieza + "'.");
            return;
        }

        Pieza piezaSeleccionada = elegirPieza(piezasEncontradas, scanner);
        if (piezaSeleccionada == null) {
            return;  
        }

       
        //if (!piezaSeleccionada.getEstadoActual().equals("ParaVenta")) {
          //  System.out.println("Esta pieza no está disponible para la venta.");
            //return;
        //}

       // if (!piezaSeleccionada.getValorFijo()) {
         //   System.out.println("Esta pieza está destinada a ser vendida en subasta y no puede ser comprada directamente.");
           // return;
        //}

        System.out.println("Detalles de la pieza seleccionada:");
        mostrarDetallesPieza(piezaSeleccionada);

        System.out.print("¿Desea proceder con la compra? (S/N): ");
        String respuesta = scanner.nextLine().trim();
        if (respuesta.equalsIgnoreCase("S")) {
            procesarCompra(piezaSeleccionada, comprador);
        } else {
            System.out.println("Compra cancelada.");
        }
    }
    
    private static void procesarCompra(Pieza pieza, Comprador comprador) {
        
        Oferta ofertaSimulada = new Oferta(administrador.contadorOfertas,comprador, pieza);

        
        Compra nuevaCompra = new Compra(ofertaSimulada);
        
        administrador.getCompras().put(nuevaCompra.getId(), nuevaCompra);
        pieza.setEstadoActual("Vendida");  // Actualizar el estado de la pieza
        pieza.setDueñoActual(comprador);   // Actualizar el dueño de la pieza

        System.out.println("Compra realizada con éxito. ID de la compra: " + nuevaCompra.getId());
        System.out.println("Fecha de la compra: " + nuevaCompra.getFecha());
        System.out.println("Valor de la compra: " + nuevaCompra.getValor());
        System.out.println("Impuestos aplicados: " + nuevaCompra.getImpuestos());
    }



    private static String generarIdCompra() {
    	return UUID.randomUUID().toString();
	}

	private static Pieza elegirPieza(ArrayList<Pieza> piezas, Scanner scanner) {
        if (piezas.size() == 1) {
            return piezas.get(0);
        }

        System.out.println("Se encontraron múltiples piezas con ese título. Por favor seleccione una:");
        int index = 1;
        for (Pieza pieza : piezas) {
            System.out.println(index++ + ". " + pieza.getTitulo() + " - ID: " + pieza.getId() + " - Estado: " + pieza.getEstadoActual());
        }
        System.out.print("Ingrese el número de la pieza que desea comprar o 0 para cancelar: ");
        int eleccion = scanner.nextInt();
        scanner.nextLine();  

        if (eleccion > 0 && eleccion <= piezas.size()) {
            return piezas.get(eleccion - 1);
        }
        System.out.println("Selección inválida o cancelada.");
        return null;
    }
    
}