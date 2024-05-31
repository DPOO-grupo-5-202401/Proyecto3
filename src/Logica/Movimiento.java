package Logica;

import java.time.LocalTime;

public class Movimiento {
    private String id;
    private String hora;
    private int valor;
    private String tipoMovimiento;
    private Comprador comprador;
    
    
	public Movimiento(String id, String horaActual, int valor, String tipoMovimiento, Comprador comprador) {
		this.id = id;
		this.hora = horaActual;
		this.valor = valor;
		this.tipoMovimiento = tipoMovimiento;
		this.comprador = comprador;
	}
	
	
    
    
}
