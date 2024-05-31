package Presentacion;

import java.util.Scanner;

import Logica.Administrador;
import Logica.Comprador;
import Logica.Empleado;

public class Principal {
	private Comprador comprador;
	private Administrador administrador;
	private Empleado empleado;

	public Principal() {
		menu();
	}
	
	private void menu() {
        Scanner sc = new Scanner(System.in);
        String username;
        String password;

        String compradorUsername = "C1";
        String compradorPassword = "C1";
        String adminUsername = "A1";
        String adminPassword = "A1";
        String empleadoUsername = "E1";
        String empleadoPassword = "E1";

        do {
            System.out.println("*** Bienvenido a la Galeria - Casa de Subastas ***");

            System.out.println("\r\n"
                    + " ██████   █████  ██      ███████ ██████  ██  █████  \r\n"
                    + "██       ██   ██ ██      ██      ██   ██ ██ ██   ██ \r\n"
                    + "██   ███ ███████ ██      █████   ██████  ██ ███████ \r\n"
                    + "██    ██ ██   ██ ██      ██      ██   ██ ██ ██   ██ \r\n"
                    + " ██████  ██   ██ ███████ ███████ ██   ██ ██ ██   ██ \r\n"
                    + "                                                    \r\n"
                    + "");

            System.out.print("Usuario: ");
            username = sc.nextLine();
            System.out.print("Contraseña: ");
            password = sc.nextLine();

            if (username.equals(compradorUsername) && password.equals(compradorPassword)) {
                Pcomprador.main(new String[0]);
                break;
            } else if (username.equals(adminUsername) && password.equals(adminPassword)) {
                Padministrador.main(new String[0]);
                break;
            } else if (username.equals(empleadoUsername) && password.equals(empleadoPassword)) {
                Pempleado.main(new String[0]);
                break;
            } else {
                System.out.println("Credenciales incorrectas. Inténtalo de nuevo.");
            }
        } while (true);

        sc.close();
    }
	
	public static void main(String[] args) {
		new Principal();
	}
}
