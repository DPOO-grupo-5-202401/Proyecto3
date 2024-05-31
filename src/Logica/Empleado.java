package Logica;

import java.util.HashMap;

public class Empleado extends Usuario {
    private String idEmpleado;
    private String login;
    private String contrasena;
    private String puesto;
    private HashMap<String, Pieza> piezasGestionadas;
    private HashMap<String, Compra> comprasGestionadas;

    public Empleado(String nombre, String idEmpleado, String login, String contrasena, String puesto) {
        super(nombre);
        this.idEmpleado = idEmpleado;
        this.login = login;
        this.contrasena = contrasena;
        this.puesto = puesto;
        this.piezasGestionadas = new HashMap<>();
        this.comprasGestionadas = new HashMap<>();
    }

    // Getters y Setters
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public HashMap<String, Pieza> getPiezasGestionadas() {
        return piezasGestionadas;
    }

    public void setPiezasGestionadas(HashMap<String, Pieza> piezasGestionadas) {
        this.piezasGestionadas = piezasGestionadas;
    }

    public HashMap<String, Compra> getComprasGestionadas() {
        return comprasGestionadas;
    }

    public void setComprasGestionadas(HashMap<String, Compra> comprasGestionadas) {
        this.comprasGestionadas = comprasGestionadas;
    }

    public void gestionarPieza(Pieza pieza) {
        this.piezasGestionadas.put(pieza.getId(), pieza);
    }

    public void validarOferta(Oferta oferta) {
        oferta.setValidada(true);
    }

    public void gestionarCompra(Compra compra) {
        this.comprasGestionadas.put(compra.getId(), compra);
    }
}
