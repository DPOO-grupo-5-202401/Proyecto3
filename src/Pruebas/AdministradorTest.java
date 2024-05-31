package Pruebas;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import Logica.Administrador;
import Logica.Autor;
import Logica.Comprador;
import junit.framework.TestCase;

public class AdministradorTest extends TestCase {

	private Administrador admin;

	@BeforeEach
	public void setUp() {
		this.admin= new Administrador("Juan", "A1", "A1");
		Comprador nuevoComprador = new Comprador("Logan",123456789,"C10","LOG1"); 
		this.admin.compradores.put(nuevoComprador.getLogin(),nuevoComprador);
	}
	
	@Test
	public void crearCompradorTest() {
		assertTrue(this.admin.compradores.containsKey("LOG1"));
	}
	@Test
	public void registrarEsculturaTest() {
		Autor nuevoAutor = admin.crearRetornarAutor("William");
		this.admin.crearEscultura("hola", 2023, "Colombia", false,"2025-05-05", "ParaVenta", true, 50, 0, 0, admin.compradores.get("Galeria"), 90, "Sin Observacion",admin.autores.get(nuevoAutor.getNombre()) , 5, 10, 10, false, "Piedra");
		assertTrue(this.admin.esculturas.containsKey("hola"));
	}
	@Test
	public void registrarPinturaTest() {
		Autor nuevoAutor = admin.crearRetornarAutor("William");
		this.admin.crearPintura("Hola", 2023, "Colombia", false,"2025-05-05", "ParaVenta", true, 50, 0, 0, admin.compradores.get("Galeria"), 90, "Sin Observacion",admin.autores.get(nuevoAutor.getNombre()) , "Al Oleo", "Vanguardismo", 50,60);
		assertTrue(this.admin.pinturas.containsKey("Hola"));
	}
	@Test
	public void registrarFotoTest() {
		Autor nuevoAutor = admin.crearRetornarAutor("William");
		this.admin.crearVideo("holaVideo", 2023, "Colombia", false,"2025-05-05", "EnVenta", true, 50, 0, 0, admin.compradores.get("Galeria"), 90, "Sin Observacion",admin.autores.get(nuevoAutor.getNombre()) ,1920,60);
		assertTrue(this.admin.fotografias.containsKey("holaVideo"));
	}
	
	


}
