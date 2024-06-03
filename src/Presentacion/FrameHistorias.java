package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import Logica.Administrador;
import Logica.Compra;
import Logica.Pieza;

public class FrameHistorias extends BaseFrame {

    private JTextField inputField;
    private JTextArea resultArea;

    public FrameHistorias(Administrador administrador) {
        super(administrador);
        setTitle("Historias de Piezas y Artistas");
    }

    @Override
    protected void configureInfoPanel() {
        // Configuración de panel para entradas
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(20);
        inputPanel.add(new JLabel("Ingrese el dato requerido:"));
        inputPanel.add(inputField);
        
        // Configuración de botones para diferentes consultas
        JPanel buttonPanel = new JPanel();
        JButton piezaButton = new JButton("Consultar Historia de Pieza");
        piezaButton.addActionListener(this::consultarHistoriaPieza);
        JButton artistaButton = new JButton("Consultar Obras de Artista");
        artistaButton.addActionListener(this::consultarObrasArtista);
        JButton compradorButton = new JButton("Consultar Compras de Comprador");
        compradorButton.addActionListener(this::consultarComprasComprador);
        
        buttonPanel.add(piezaButton);
        buttonPanel.add(artistaButton);
        buttonPanel.add(compradorButton);
        
        // Área de texto para resultados
        resultArea = new JTextArea(15, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        
        // Añadiendo componentes al infoPanel
        infoPanel.add(inputPanel);
        infoPanel.add(buttonPanel);
        infoPanel.add(scrollPane);
    }

    private void consultarHistoriaPieza(ActionEvent e) {
        String piezaNombre = inputField.getText();
        if (!piezaNombre.isEmpty() && administrador.getInventarioHistorico().containsKey(piezaNombre)) {
            List<Compra> lista = administrador.getInventarioHistorico().get(piezaNombre).getHistoriaPieza();
            resultArea.setText("");
            for (Compra compra : lista) {
                resultArea.append(compra.getId() + ": " + compra.getOfertaValidada().getPieza().getTitulo() +
                                  ". Comprada Por: " + compra.getOfertaValidada().getComprador().getNombre() + "\n");
            }
        } else {
            resultArea.setText("Pieza no encontrada.");
        }
    }

    private void consultarObrasArtista(ActionEvent e) {
        String artista = inputField.getText();
        if (!artista.isEmpty() && administrador.autores.containsKey(artista)) {
            HashMap<String, Pieza> map = administrador.autores.get(artista).getPiezasQueHaHecho();
            resultArea.setText("");
            for (Entry<String, Pieza> entry : map.entrySet()) {
                Pieza pieza = entry.getValue();
                resultArea.append(pieza.getTitulo() + ". Año: " + pieza.getAnio() + ". Fecha de Compra: " +
                                  pieza.getHistoriaPieza().get(0).getFecha() + ". Valor Compra: " + pieza.getHistoriaPieza().get(0).getValor() + "\n");
            }
        } else {
            resultArea.setText("Artista no encontrado.");
        }
    }

    private void consultarComprasComprador(ActionEvent e) {
        String comprador = inputField.getText();
        if (!comprador.isEmpty() && administrador.compradores.containsKey(comprador)) {
            HashMap<String, Pieza> map = administrador.compradores.get(comprador).getPiezasqueHaTenido();
            resultArea.setText("");
            for (Entry<String, Pieza> entry : map.entrySet()) {
                Pieza pieza = entry.getValue();
                resultArea.append(pieza.getTitulo() + ". Año: " + pieza.getAnio() + ". Fecha de Compra: " +
                                  pieza.getHistoriaPieza().get(0).getFecha() + ". Valor Compra: " + pieza.getHistoriaPieza().get(0).getValor() + "\n");
            }
        } else {
            resultArea.setText("Comprador no encontrado.");
        }
    }
}
