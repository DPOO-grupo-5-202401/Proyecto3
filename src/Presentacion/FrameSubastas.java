package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import Logica.Administrador;

public class FrameSubastas extends BaseFrame {
    
    private JTextField idField;
    private JTextField compradorField;
    private JTextArea resultArea;
    private int pujaActual;

    public FrameSubastas(Administrador administrador) {
        super(administrador);
        setTitle("Simulación de Subastas");
        pujaActual = 1000; // Puja inicial
    }

    @Override
    protected void configureInfoPanel() {
        // Panel para ingresar el ID de la subasta
        JPanel idPanel = new JPanel();
        idPanel.add(new JLabel("Ingrese ID de la subasta a iniciar:"));
        idField = new JTextField(15);
        idPanel.add(idField);

        // Botón para iniciar la subasta
        JButton iniciarButton = new JButton("Iniciar Subasta");
        iniciarButton.addActionListener(this::iniciarSubasta);
        idPanel.add(iniciarButton);

        // Área de texto para mostrar resultados
        resultArea = new JTextArea(15, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Panel para ingresar datos del comprador y realizar pujas
        JPanel pujaPanel = new JPanel();
        pujaPanel.add(new JLabel("Ingrese el Login del comprador que desee aumentar la puja (+500):"));
        compradorField = new JTextField(15);
        pujaPanel.add(compradorField);

        // Botón para aumentar la puja
        JButton pujarButton = new JButton("Aumentar Puja");
        pujarButton.addActionListener(this::aumentarPuja);
        pujaPanel.add(pujarButton);

        // Botón para finalizar la subasta
        JButton finalizarButton = new JButton("Finalizar Subasta");
        finalizarButton.addActionListener(this::finalizarSubasta);
        pujaPanel.add(finalizarButton);

        // Añadiendo componentes al infoPanel
        infoPanel.add(idPanel);
        infoPanel.add(pujaPanel);
        infoPanel.add(scrollPane);
    }

    private void iniciarSubasta(ActionEvent e) {
        String idSubasta = idField.getText();
        if (idSubasta.isEmpty()) {
            resultArea.setText("Por favor, ingrese un ID de subasta válido.\n");
        } else {
            resultArea.setText("Subasta iniciada con ID: " + idSubasta + "\n");
            resultArea.append("La puja actual es " + pujaActual + "\n");
        }
    }

    private void aumentarPuja(ActionEvent e) {
        String comprador = compradorField.getText();
        if (comprador.isEmpty()) {
            resultArea.append("Por favor, ingrese el login del comprador.\n");
        } else {
            pujaActual += 500;
            resultArea.append("El comprador " + comprador + " ha aumentado la puja a " + pujaActual + "\n");
        }
    }

    private void finalizarSubasta(ActionEvent e) {
        int response = JOptionPane.showConfirmDialog(this, "Este comprador comprará la obra (s/n)?", "Confirmar Compra", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            resultArea.append("Subasta terminada con éxito!\n");
        } else {
            resultArea.append("Subasta no finalizada. Continúe pujando.\n");
        }
    }
}
