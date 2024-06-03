package Presentacion;

import javax.swing.*;

import Logica.Administrador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class BaseFrame extends JFrame {
    protected JPanel buttonPanel;
    protected JPanel infoPanel;
    protected Administrador administrador;  // Asumiendo que existe una clase Administrador

    public BaseFrame(Administrador administrador) {
        this.administrador = administrador;
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeComponents();
        setVisible(true);
    }

    private void initializeComponents() {
        // Panel Principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(255, 253, 239));

        // Panel para los botones de la izquierda
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(new Color(203, 187, 145));

        // Agregar botones
        String[] buttonLabels = {"Datos", "Piezas", "Ofertas", "Compras", "Compradores", "Historias", "Subastas"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Lato", Font.BOLD, 12));
            button.setBackground(new Color(203, 187, 145));
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(this::onButtonPressed);
            buttonPanel.add(button);
            buttonPanel.add(Box.createVerticalStrut(10));
        }

        // Panel de información de la derecha
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(255, 253, 239));

        configureInfoPanel();

        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(infoPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    protected abstract void configureInfoPanel();

    protected void onButtonPressed(ActionEvent e) {
        String command = ((JButton)e.getSource()).getText();
        switch(command) {
            case "Datos" -> transitionTo(new FrameDatos(administrador));
            case "Piezas" -> transitionTo(new FramePiezas(administrador));
            case "Compradores" -> transitionTo(new FrameCompradores(administrador));
            
            
            
            default -> System.out.println("No se reconoce el tipo de frame: " + command);
        }
    }

    private void transitionTo(BaseFrame frame) {
        frame.setVisible(true);
        this.dispose();
    }
}
