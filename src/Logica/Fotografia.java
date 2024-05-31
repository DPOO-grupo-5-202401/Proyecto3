package Logica;

public class Fotografia extends Pieza{
	private int resolucion;
	private String tipo;
	
	public int getResolucion() {
    	return resolucion;
    }
	public String getTipo() {
		return tipo;
	}
	
	public void setResolucion(int resolucion) {
    	this.resolucion= resolucion;
    }
	
	public void setTipo(String tipo) {
    	this.tipo= tipo;
    }
	public Fotografia(String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor, int resolucion, String tipo) {
		
		super(titulo, año, lugarDeCreacion, enExhibicion , EstadoActual, ValorFijo,
				ValorInicial, ValorMinimo, Valor, DueñoActual, peso, observacion, autor,FechaSalidaGaleria);
		
    	this.id = "FOTOGRAFIA";
		this.resolucion = resolucion;
		this.tipo = tipo;
	}
	
}
	
	
	

	
	
	
