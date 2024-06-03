package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logica.Administrador;

public class FrameDatos extends BaseFrame {
    public FrameDatos(Administrador administrador) {
        super(administrador);
        configureFontAndBackground();
    }

    private void configureFontAndBackground() {
        // Asegúrate de tener la fuente Lato disponible, de lo contrario cambia a una disponible
        Font latoFont = new Font("Lato", Font.PLAIN, 14);
        setBackgroundAndFont(infoPanel, new Color(255, 253, 239), latoFont);
    }

    private void setBackgroundAndFont(Container container, Color bgColor, Font font) {
        container.setBackground(bgColor);
        for (Component comp : container.getComponents()) {
            comp.setBackground(bgColor);
            comp.setFont(font);
            if (comp instanceof Container) {
                setBackgroundAndFont((Container) comp, bgColor, font);
            }
        }
    }

    @Override
    protected void configureInfoPanel() {
        JLabel titleLabel = new JLabel("Gestión de Datos");
        titleLabel.setFont(new Font("Lato", Font.BOLD, 24));  // Aplicar Lato a título también
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(titleLabel);

        addDataManagementButtons();
    }

    private void addDataManagementButtons() {
        JButton cargarButton = new JButton("Cargar Datos");
        cargarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarDatos();
            }
        });
        JButton guardarButton = new JButton("Guardar Datos");
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(cargarButton);
        buttonPanel.add(guardarButton);

        infoPanel.add(buttonPanel);
    }

    private void cargarDatos() {
        // Implementación específica para cargar datos
        JOptionPane.showMessageDialog(this, "Datos cargados correctamente.", "Carga Completa", JOptionPane.INFORMATION_MESSAGE);
    }

    private void guardarDatos() {
        // Implementación específica para guardar datos
        JOptionPane.showMessageDialog(this, "Datos guardados correctamente.", "Guardado Completo", JOptionPane.INFORMATION_MESSAGE);
    }
}
