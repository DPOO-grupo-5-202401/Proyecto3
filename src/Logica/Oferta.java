package Logica;

import java.util.Random;



public class Oferta {
    private int valorOferta;
    private boolean validada;
    private Comprador comprador;
    private Pieza Pieza;
    private String id;
    
	public Oferta(int contadorOfertas,Comprador comprador, Pieza pieza) {
		//Random random = new Random();
        //int numeroAleatorio = random.nextInt(1000);
		String numero =String.format("%03d", contadorOfertas+1);
		this.id = numero;
		
		this.valorOferta = pieza.getValor();
		this.validada = false;
		this.comprador = comprador;
		this.Pieza = pieza;
		
	
	}
	
	public Oferta(String id,Comprador comprador, Pieza pieza, boolean validada) {
		
		this.id = id;
		this.valorOferta = pieza.getValor();
		this.validada = validada;
		this.comprador = comprador;
		this.Pieza = pieza;
		
	
	}

	public int getValorOferta() {
		return valorOferta;
	}

	public void setValorOferta(int valorOferta) {
		this.valorOferta = valorOferta;
	}

	public boolean isValidada() {
		return validada;
	}

	public void setValidada(boolean validada) {
		this.validada = validada;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public Pieza getPieza() {
		return Pieza;
	}

	public void setPieza(Pieza pieza) {
		Pieza = pieza;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
