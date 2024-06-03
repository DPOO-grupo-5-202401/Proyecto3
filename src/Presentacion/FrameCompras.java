package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Logica.Administrador;
import Logica.DetallesPago;
import Logica.PasarelaDePago;
import Logica.PayPal;
import Logica.PayU;
import Logica.Sire;

public class FrameCompras extends BaseFrame {

    private JTextField userField;
    private JTextField piezaField;
    private JTextField numeroTarjetaField;
    private JTextField fechaExpiracionField;
    private JTextField cvvField;
    private JTextField montoField;
    private JComboBox<String> pasarelaComboBox;

    public FrameCompras(Administrador administrador) {
        super(administrador);
        setTitle("Formulario de Compras");
    }

    @Override
    protected void configureInfoPanel() {
        // Panel para el formulario de compras
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10));

        formPanel.add(new JLabel("Login del Usuario:"));
        userField = new JTextField();
        formPanel.add(userField);

        formPanel.add(new JLabel("Nombre de la Pieza:"));
        piezaField = new JTextField();
        formPanel.add(piezaField);

        formPanel.add(new JLabel("Número de Tarjeta:"));
        numeroTarjetaField = new JTextField();
        formPanel.add(numeroTarjetaField);

        formPanel.add(new JLabel("Fecha de Expiración:"));
        fechaExpiracionField = new JTextField();
        formPanel.add(fechaExpiracionField);

        formPanel.add(new JLabel("CVV:"));
        cvvField = new JTextField();
        formPanel.add(cvvField);

        formPanel.add(new JLabel("Monto:"));
        montoField = new JTextField();
        formPanel.add(montoField);

        formPanel.add(new JLabel("Pasarela de Pago:"));
        pasarelaComboBox = new JComboBox<>(new String[]{"PayPal", "PayU", "Sire"});
        formPanel.add(pasarelaComboBox);

        JButton submitButton = new JButton("Realizar Compra");
        submitButton.addActionListener(this::realizarCompra);
        formPanel.add(submitButton);

        infoPanel.add(formPanel);
    }

    private void realizarCompra(ActionEvent e) {
        String login = userField.getText();
        String nombrePieza = piezaField.getText();
        String numeroTarjeta = numeroTarjetaField.getText();
        String fechaExpiracion = fechaExpiracionField.getText();
        String cvv = cvvField.getText();
        int monto = Integer.parseInt(montoField.getText());
        String pasarelaSeleccionada = (String) pasarelaComboBox.getSelectedItem();

        DetallesPago detallesPago = new DetallesPago(numeroTarjeta, fechaExpiracion, cvv, monto);
        PasarelaDePago pasarela = obtenerPasarela(pasarelaSeleccionada);
               
        
        if (pasarela != null) {
            pasarela.procesarPago(detallesPago);
            JOptionPane.showMessageDialog(this, "Compra realizada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error al procesar el pago.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private PasarelaDePago obtenerPasarela(String nombre) {
        switch (nombre) {
            case "PayPal":
                return new PayPal();
                
            case "PayU":
                return new PayU();
            case "Sire":
                return new Sire();
            default:
                return null;
        }
    }
}
