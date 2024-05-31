package Logica;

import java.util.HashMap;

public class Subasta {
    private String fecha;
    private Integer pujaActual;
    private Comprador compradorFinal;
    private Administrador administrador;
    private Pieza pieza;
    private HashMap<String,Comprador> compradoresValidados;
    private HashMap<String,Movimiento> movimientos;
    private Boolean finalizada;
    
	public Subasta(String fecha, Administrador administrador, Pieza pieza,
			HashMap<String, Comprador> compradoresValidados) {
		super();
		this.fecha = fecha;
		this.pujaActual = 0;
		this.compradorFinal = new Comprador("No Registra",000000000,"AA","AA");
		this.administrador = administrador;
		this.pieza = pieza;
		this.compradoresValidados = compradoresValidados;
		this.movimientos = new HashMap<String, Movimiento>();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getPujaActual() {
		return pujaActual;
	}

	public void setPujaActual(Integer pujaActual) {
		this.pujaActual = pujaActual;
	}

	public Comprador getCompradorFinal() {
		return compradorFinal;
	}

	public void setCompradorFinal(Comprador compradorFinal) {
		this.compradorFinal = compradorFinal;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public HashMap<String, Comprador> getCompradoresValidados() {
		return compradoresValidados;
	}

	public void setCompradoresValidados(HashMap<String, Comprador> compradoresValidados) {
		this.compradoresValidados = compradoresValidados;
	}

	public HashMap<String, Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(HashMap<String, Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Boolean getFinalizada() {
		return finalizada;
	}

	public void setFinalizada(Boolean finalizada) {
		this.finalizada = finalizada;
	}
	
	
    
    
    

}
