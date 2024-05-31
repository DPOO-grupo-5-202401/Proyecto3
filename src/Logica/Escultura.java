package Logica;

import java.util.HashMap;

public class Escultura extends Pieza {
	private int largo;
	private int ancho;
	private int alto;
	private Boolean electricidad;
	private String material;
	
	public Escultura(String titulo,int año,String lugarDeCreacion,boolean enExhibicion, String FechaSalidaGaleria,
    		String EstadoActual,
    		boolean ValorFijo,int ValorInicial,int ValorMinimo,int Valor,
    		Comprador DueñoActual, int peso,String observacion,Autor autor,int Alto,
    		int Ancho, int Largo, boolean Electricidad, String Material) {
		
		super(titulo, año, lugarDeCreacion, enExhibicion , EstadoActual, ValorFijo,
				ValorInicial, ValorMinimo, Valor, DueñoActual, peso, observacion, autor,FechaSalidaGaleria);
		
    	this.id = "ESCULTURA";
		this.alto = Alto;
		this.ancho = Ancho;
		this.largo = Largo;
		this.material = Material;
		this.electricidad = Electricidad;

		
	}




	//Getters
	public int getLargo() {
		return largo;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public Boolean getElectricidad() {
		return electricidad;
	}
	
	
	public String getMaterial() {
		return material;
	}
	
	//Setters
	public void setLargo(int largo) {
		this.largo=largo;
	}
	
	public void setAncho(int ancho) {
		this.ancho=ancho;
	}
	
	public void setAlto(int alto) {
		this.alto=alto;
	}
	
	
	public void setElectricidad(boolean electricidad) {
		this.electricidad=electricidad;
	}
	
	
	public void setMaterial(String material) {
		this.material=material;
	}

	public void setElectricidad(Boolean electricidad) {
		this.electricidad = electricidad;
	}
	

		
	}
	

