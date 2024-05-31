package Logica;

import java.util.HashMap;
import java.util.Random;

public class Autor extends Usuario {

    private HashMap<String, Pieza> piezasQueHaHecho;
    
    public Autor(String nombre) {
		super(nombre);
		this.piezasQueHaHecho = new HashMap<String,Pieza>();
		
	}


	public HashMap<String, Pieza> getPiezasQueHaHecho() {
		return piezasQueHaHecho;
	}

	public void setPiezasQueHaHecho(HashMap<String, Pieza> piezasQueHaHecho) {
		this.piezasQueHaHecho = piezasQueHaHecho;
	}


}
