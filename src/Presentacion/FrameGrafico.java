package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import Logica.Administrador;
import Logica.Compra;

public class FrameGrafico extends BaseFrame {

    private HashMap<String, Integer> fechasConCompras; // HashMap para almacenar las fechas con el número de compras

    public FrameGrafico(Administrador administrador) {
        super(administrador);
        setTitle("Visualización de Fechas de Compras");
        fechasConCompras = new HashMap<>();
    }

    @Override
    protected void configureInfoPanel() {
        // Configuración inicial del panel de información
        JLabel titleLabel = new JLabel("Fechas de Compras Realizadas");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(titleLabel);

        // Etiqueta de convención de colores
        JLabel colorConventionLabel = new JLabel("<html><ul>" +
            "<li><font color='red'>1 compra</font></li>" +
            "<li><font color='blue'>2 compras</font></li>" +
            "<li><font color='green'>3 o más compras</font></li>" +
            "</ul></html>");
        colorConventionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        infoPanel.add(colorConventionLabel);

        // Área de texto y panel de gráfico
        JTextArea fechasArea = new JTextArea(10, 30);
        fechasArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fechasArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Fechas"));
        infoPanel.add(scrollPane);

        JButton cargarFechasButton = new JButton("Cargar Fechas");
        cargarFechasButton.addActionListener(e -> mostrarFechas(fechasArea));
        infoPanel.add(cargarFechasButton);

        // Panel para visualizar el gráfico de días del año
        JPanel calendarPanel = new CalendarPanel();
        calendarPanel.setPreferredSize(new Dimension(400, 400));
        infoPanel.add(calendarPanel);
    }

    private void mostrarFechas(JTextArea fechasArea) {
        HashMap<String, Compra> map = administrador.getCompras();
        fechasArea.setText(""); // Limpiar el área de texto antes de añadir nuevas fechas
        fechasConCompras.clear();
        SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy"); // Formato en el que se guardan las fechas
        SimpleDateFormat sdfOutput = new SimpleDateFormat("DDD"); // Formato día del año

        for (Entry<String, Compra> entry : map.entrySet()) {
            String fecha = entry.getValue().getFecha();
            try {
                Date date = sdfInput.parse(fecha); // Convertir la fecha de String a Date
                String dayOfYear = sdfOutput.format(date); // Convertir la fecha a formato día del año
                fechasArea.append(fecha + "\n");
                fechasConCompras.put(dayOfYear, fechasConCompras.getOrDefault(dayOfYear, 0) + 1);
            } catch (ParseException e) {
                e.printStackTrace(); 
            }
        }
        infoPanel.repaint();
    }

    class CalendarPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int totalDias = 365; // Asumiendo un año no bisiesto
            int columnas = 52;
            int filas = (int) Math.ceil(totalDias / (double) columnas);
            int cuadroSize = Math.min(getWidth() / columnas, getHeight() / filas);

            for (int i = 0; i < totalDias; i++) {
                String dayKey = String.format("%03d", i+1);
                int x = (i % columnas) * cuadroSize;
                int y = (i / columnas) * cuadroSize;
                int count = fechasConCompras.getOrDefault(dayKey, 0);
                if (count > 2) {
                    g.setColor(Color.GREEN); // 3 o más compras
                } else if (count > 1) {
                    g.setColor(Color.BLUE); // 2 compras
                } else if (count > 0) {
                    g.setColor(Color.RED); // 1 compra
                } else {
                    g.setColor(Color.GRAY); // Sin compras
                }
                g.fillRect(x, y, cuadroSize, cuadroSize);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cuadroSize, cuadroSize);
            }
        }
    }
}
