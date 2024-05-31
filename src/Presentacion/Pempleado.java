package Presentacion;

import Logica.Empleado;
import Logica.Escultura;
import Logica.Fotografia;
import Logica.Pieza;
import Logica.Pintura;
import Logica.Video;
import Logica.Administrador;
import Logica.Autor;
import Logica.Comprador;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pempleado {

    private static Administrador administrador; // Administrador para manejar la carga de datos

    public static void main(String[] args) {
        administrador = new Administrador("Juan", "A1", "A1");
        cargarDatos(); 

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido Empleado");
        
        Empleado empleado = new Empleado("Luis","12345678","E1","E1","p2");

        menuEmpleado(empleado, scanner);
        

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


    // Menú
    private static void menuEmpleado(Empleado empleado, Scanner scanner) {
    	int opcion;
    	do {
            System.out.println("1. Ver historia de una pieza");
            System.out.println("2. Ver historia de un artista");
            System.out.println("3. Salir");
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
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            } 
    	}while (opcion != 3);
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
    
}