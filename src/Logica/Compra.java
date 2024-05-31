package Logica;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Compra {
	public static int contadorCompras = 0;
    private String id;
    private String fecha;
    private int valor;
    private double impuestos;
    private Oferta ofertaValidada;
    
	public Compra(Oferta ofertaValidada) {
		String numero = String.format("%03d", contadorCompras);
		this.id = numero;
		contadorCompras++;
		
    	Date currentDate = new Date();
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	String dateString = formatter.format(currentDate);
    	
    	this.fecha = dateString;
    	
		this.valor = ofertaValidada.getPieza().getValor();
		this.impuestos = (valor * 0.19);
		
		this.ofertaValidada = ofertaValidada;
		
	}
	
	public Compra(String id, Oferta ofertaValidada,String fecha) {
		this.id = id;
	
    	
    	this.fecha = fecha;
    	
		this.valor = ofertaValidada.getPieza().getValor();
		this.impuestos = (valor * 0.19);
		
		this.ofertaValidada = ofertaValidada;
		
	}
	
	public String getId() {
		return id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Oferta getOfertaValidada() {
		return ofertaValidada;
	}
	public void setOfertaValidada(Oferta ofertaValidada) {
		this.ofertaValidada = ofertaValidada;
	}

	public int getValor() {
		return valor;
	}

	public double getImpuestos() {
		return impuestos;
	}


}
