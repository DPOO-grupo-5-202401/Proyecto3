package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map.Entry;

import Logica.Administrador;
import Logica.Comprador;

public class FrameCompradores extends BaseFrame {

    public FrameCompradores(Administrador administrador) {
        super(administrador);
        setTitle("Creación y Vista de Compradores");
    }

    @Override
    protected void configureInfoPanel() {
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        // Título del panel
        JLabel titleLabel = new JLabel("Creación y Vista de Compradores");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(titleLabel);

        // Sección para crear nuevos compradores
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Crear Nuevo Comprador"));

        JTextField nombreField = new JTextField(10);
        JTextField contactoField = new JTextField(10);
        JTextField loginField = new JTextField(10);
        JPasswordField contrasenaField = new JPasswordField(10);
        JButton crearButton = new JButton("Crear Comprador");

        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nombreField);
        formPanel.add(new JLabel("Número de contacto:"));
        formPanel.add(contactoField);
        formPanel.add(new JLabel("Login:"));
        formPanel.add(loginField);
        formPanel.add(new JLabel("Contraseña:"));
        formPanel.add(contrasenaField);
        formPanel.add(crearButton);

        infoPanel.add(formPanel);

        crearButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            try {
                int contacto = Integer.parseInt(contactoField.getText());
                String login = loginField.getText();
                String contrasena = new String(contrasenaField.getPassword());
                administrador.crearComprador(nombre, contacto, contrasena, login);
                JOptionPane.showMessageDialog(this, "Comprador " + login + " creado con éxito", "Comprador Creado", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, introduzca un número de contacto válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Sección para mostrar la lista de compradores
        JTextArea listaCompradores = new JTextArea(10, 30);
        listaCompradores.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listaCompradores);
        JButton mostrarButton = new JButton("Mostrar Compradores");
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Compradores"));

        infoPanel.add(scrollPane);
        infoPanel.add(mostrarButton);

        mostrarButton.addActionListener(e -> {
            HashMap<String, Comprador> map = administrador.getCompradores();
            listaCompradores.setText(""); // Limpiar el área de texto antes de añadir nuevos datos
            for (Entry<String, Comprador> entry : map.entrySet()) {
                listaCompradores.append(entry.getKey() + " : " + entry.getValue().getNombre() + "\n");
            }
        });
    }
}
