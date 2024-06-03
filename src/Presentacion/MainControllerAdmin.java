package Presentacion;

import javax.swing.*;

import Logica.Administrador;

public class MainControllerAdmin {
    private Administrador administrador;

    public MainControllerAdmin() {
        administrador = new Administrador("Juan", "A1", "A1");
        cargarDatos();
        mostrarAdminIntro();
    }

    private void cargarDatos() {
        administrador.cargarCompradores();
        administrador.cargarVideos();
        administrador.cargarEsculturas();
        administrador.cargarPinturas();
        administrador.cargarFotografias();
        administrador.cargarOfertas();
        administrador.cargarCompras();
    }

    private void mostrarAdminIntro() {
        SwingUtilities.invokeLater(() -> {
            AdminIntro adminIntro = new AdminIntro(administrador);
            adminIntro.setVisible(true);
        });
    }
}
