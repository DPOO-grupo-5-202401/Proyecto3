package Logica;

import java.util.HashMap;

public class Comprador extends Usuario {
	private String contrasena;
	private String login;
    private int numeroDeContacto;
    private int valorMaximoCompras;
    private boolean esPropietario;
    private HashMap<String, Pieza> piezasCompradas;
    private HashMap<String, Oferta> ofertas;
    private HashMap<String, Compra> compras;
    private HashMap<String, Pieza> piezasqueHaTenido;

    // Constructor
    public Comprador(String nombre, int numeroDeContacto, String contrasena,String login) {
    	
		super(nombre);
		this.numeroDeContacto = numeroDeContacto;
		this.valorMaximoCompras = 0;
		this.esPropietario = false;
		this.piezasCompradas = new HashMap<String,Pieza>();
		this.ofertas = new HashMap<String,Oferta>();
		this.compras = new HashMap<String, Compra>();
		this.piezasqueHaTenido = new HashMap<String, Pieza>();
		this.setContrasena(contrasena);
		this.setLogin(login);
	}
    
    
    // Getters y setters
    public int getNumeroDeContacto() {
        return numeroDeContacto;
    }



	public void setNumeroDeContacto(int numeroDeContacto) {
        this.numeroDeContacto = numeroDeContacto;
    }

    public int getValorMaximoCompras() {
        return valorMaximoCompras;
    }

    public void setValorMaximoCompras(int valorMaximoCompras) {
        this.valorMaximoCompras = valorMaximoCompras;
    }

    public boolean isEsPropietario() {
        return esPropietario;
    }

    public void setEsPropietario(boolean esPropietario) {
        this.esPropietario = esPropietario;
    }

    public HashMap<String, Pieza> getPiezasCompradas() {
        return piezasCompradas;
    }

    public void setPiezasCompradas(HashMap<String, Pieza> piezasCompradas) {
        this.piezasCompradas = piezasCompradas;
    }

    public HashMap<String, Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(HashMap<String, Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public HashMap<String, Compra> getCompras() {
        return compras;
    }

    public void setCompras(HashMap<String, Compra> compras) {
        this.compras = compras;
    }

    public HashMap<String, Pieza> getPiezasqueHaTenido() {
        return piezasqueHaTenido;
    }

    public void setPiezasqueHaTenido(HashMap<String, Pieza> piezasqueHaTenido) {
        this.piezasqueHaTenido = piezasqueHaTenido;
    }

    public void agregarPiezaComprada(Pieza pieza) {
        this.piezasCompradas.put(pieza.getId(), pieza);
    }

    public void realizarOferta(Oferta oferta) {
        this.ofertas.put(oferta.getId(), oferta);
    }

    public void registrarCompra(Compra compra) {
        this.compras.put(compra.getId(), compra);
    }

    public void registrarPiezaqueHaTenido(Pieza pieza) {
        this.piezasqueHaTenido.put(pieza.getId(), pieza);
    }


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}
}