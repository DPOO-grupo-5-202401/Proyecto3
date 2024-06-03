package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import Logica.Administrador;
import Logica.Autor;

public class FramePiezas extends BaseFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JComboBox<String> tipoPiezaCombo;

    public FramePiezas(Administrador administrador) {
        super(administrador);
        setTitle("Creación de Piezas de Arte");
    }

    @Override
    protected void configureInfoPanel() {
        JLabel titleLabel = new JLabel("Creación de Pieza");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(titleLabel, BorderLayout.NORTH);

        tipoPiezaCombo = new JComboBox<>(new String[]{"Escoger tipo...", "Escultura", "Pintura", "Video", "Fotografía"});
        tipoPiezaCombo.addActionListener(this::onTipoPiezaChanged);
        infoPanel.add(tipoPiezaCombo, BorderLayout.NORTH);

        setupCardPanel();
        infoPanel.add(cardPanel, BorderLayout.CENTER);

        JButton createButton = new JButton("Crear");
        createButton.addActionListener(this::createPieza);
        infoPanel.add(createButton, BorderLayout.SOUTH);
    }

    private void setupCardPanel() {
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        cardPanel.add(new JPanel(), "Escoger tipo...");  // Default empty panel
        cardPanel.add(createEsculturaPanel(), "Escultura");
        cardPanel.add(createPinturaPanel(), "Pintura");
        cardPanel.add(createVideoPanel(), "Video");
        cardPanel.add(createFotografiaPanel(), "Fotografía");

        cardLayout.show(cardPanel, "Escoger tipo...");  // Show default panel initially
    }

    private void createPieza(ActionEvent e) {
        String selectedType = (String) tipoPiezaCombo.getSelectedItem();
        switch (selectedType) {
            case "Escultura":
                handleCreateEscultura();
                break;
            case "Pintura":
                handleCreatePintura();
                break;
            case "Video":
                handleCreateVideo();
                break;
            case "Fotografía":
                handleCreateFotografia();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Seleccione un tipo de pieza válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleCreateEscultura() {
        try {
            JPanel panel = (JPanel) cardPanel.getComponent(1);
            String titulo = ((JTextField) ((JPanel) panel.getComponent(1)).getComponent(1)).getText();
            int anio = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(3)).getComponent(1)).getText());
            String lugar = ((JTextField) ((JPanel) panel.getComponent(5)).getComponent(1)).getText();
            boolean enExhibicion = Boolean.parseBoolean(((JTextField) ((JPanel) panel.getComponent(7)).getComponent(1)).getText());
            String fechaSalida = ((JTextField) ((JPanel) panel.getComponent(9)).getComponent(1)).getText();
            int valor = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(11)).getComponent(1)).getText());
            int peso = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(13)).getComponent(1)).getText());
            String autor = ((JTextField) ((JPanel) panel.getComponent(15)).getComponent(1)).getText();
            Autor nuevoAutor = administrador.autores.containsKey(autor) ? administrador.autores.get(autor) : administrador.crearRetornarAutor(autor);
            int alto = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(17)).getComponent(1)).getText());
            int ancho = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(19)).getComponent(1)).getText());
            int largo = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(21)).getComponent(1)).getText());
            String material = ((JTextField) ((JPanel) panel.getComponent(23)).getComponent(1)).getText();

            administrador.crearEscultura(titulo, anio, lugar, enExhibicion, fechaSalida, "ParaVenta", true, valor, 0, 0, administrador.compradores.get("Galeria"), peso, "Sin Observacion", nuevoAutor, alto, ancho, largo, false, material);
            JOptionPane.showMessageDialog(this, "Escultura creada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en el formato de los números ingresados.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Escultura creada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void handleCreatePintura() {
        try {
            JPanel panel = (JPanel) cardPanel.getComponent(2);
            String titulo = ((JTextField) ((JPanel) panel.getComponent(1)).getComponent(1)).getText();
            int anio = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(3)).getComponent(1)).getText());
            String lugar = ((JTextField) ((JPanel) panel.getComponent(5)).getComponent(1)).getText();
            boolean enExhibicion = Boolean.parseBoolean(((JTextField) ((JPanel) panel.getComponent(7)).getComponent(1)).getText());
            String fechaSalida = ((JTextField) ((JPanel) panel.getComponent(9)).getComponent(1)).getText();
            int valor = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(11)).getComponent(1)).getText());
            int peso = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(13)).getComponent(1)).getText());
            String autor = ((JTextField) ((JPanel) panel.getComponent(15)).getComponent(1)).getText();
            Autor nuevoAutor = administrador.autores.containsKey(autor) ? administrador.autores.get(autor) : administrador.crearRetornarAutor(autor);
            String tecnica = ((JTextField) ((JPanel) panel.getComponent(17)).getComponent(1)).getText();
            String estilo = ((JTextField) ((JPanel) panel.getComponent(19)).getComponent(1)).getText();
            int altura = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(21)).getComponent(1)).getText());
            int ancho = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(23)).getComponent(1)).getText());

            administrador.crearPintura(titulo, anio, lugar, enExhibicion, fechaSalida, "ParaVenta", true, valor, 0, 0, administrador.compradores.get("Galeria"), peso, "Sin Observacion", nuevoAutor, tecnica, estilo, altura, ancho);
            JOptionPane.showMessageDialog(this, "Pintura creada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en el formato de los números ingresados.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Pintura creada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void handleCreateVideo() {
        try {
            JPanel panel = (JPanel) cardPanel.getComponent(3);
            String titulo = ((JTextField) ((JPanel) panel.getComponent(1)).getComponent(1)).getText();
            int anio = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(3)).getComponent(1)).getText());
            String lugar = ((JTextField) ((JPanel) panel.getComponent(5)).getComponent(1)).getText();
            boolean enExhibicion = Boolean.parseBoolean(((JTextField) ((JPanel) panel.getComponent(7)).getComponent(1)).getText());
            String fechaSalida = ((JTextField) ((JPanel) panel.getComponent(9)).getComponent(1)).getText();
            int valor = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(11)).getComponent(1)).getText());
            int peso = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(13)).getComponent(1)).getText());
            String autor = ((JTextField) ((JPanel) panel.getComponent(15)).getComponent(1)).getText();
            Autor nuevoAutor = administrador.autores.containsKey(autor) ? administrador.autores.get(autor) : administrador.crearRetornarAutor(autor);
            int resolucion = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(17)).getComponent(1)).getText());
            int duracion = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(19)).getComponent(1)).getText());

            administrador.crearVideo(titulo, anio, lugar, enExhibicion, fechaSalida, "EnVenta", true, valor, 0, 0, administrador.compradores.get("Galeria"), peso, "Sin Observacion", nuevoAutor, resolucion, duracion);
            JOptionPane.showMessageDialog(this, "Video creado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en el formato de los números ingresados.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Video creado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void handleCreateFotografia() {
        try {
            JPanel panel = (JPanel) cardPanel.getComponent(4);
            String titulo = ((JTextField) ((JPanel) panel.getComponent(1)).getComponent(1)).getText();
            int anio = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(3)).getComponent(1)).getText());
            String lugar = ((JTextField) ((JPanel) panel.getComponent(5)).getComponent(1)).getText();
            boolean enExhibicion = Boolean.parseBoolean(((JTextField) ((JPanel) panel.getComponent(7)).getComponent(1)).getText());
            String fechaSalida = ((JTextField) ((JPanel) panel.getComponent(9)).getComponent(1)).getText();
            int valor = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(11)).getComponent(1)).getText());
            int peso = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(13)).getComponent(1)).getText());
            String autor = ((JTextField) ((JPanel) panel.getComponent(15)).getComponent(1)).getText();
            Autor nuevoAutor = administrador.autores.containsKey(autor) ? administrador.autores.get(autor) : administrador.crearRetornarAutor(autor);
            int resolucion = Integer.parseInt(((JTextField) ((JPanel) panel.getComponent(17)).getComponent(1)).getText());
            String tipo = ((JTextField) ((JPanel) panel.getComponent(19)).getComponent(1)).getText();

            administrador.crearFotografia(titulo, anio, lugar, enExhibicion, fechaSalida, "EnVenta", true, valor, 0, 0, administrador.compradores.get("Galeria"), peso, "Sin Observacion", nuevoAutor, resolucion, tipo);
            JOptionPane.showMessageDialog(this, "Fotografía creada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en el formato de los números ingresados.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fotografía creada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private JPanel createEsculturaPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        addField(panel, "Nombre:", new JTextField(10));
        addField(panel, "Año de creación:", new JTextField(10));
        addField(panel, "Lugar de creación:", new JTextField(10));
        addField(panel, "En exhibición (true/false):", new JTextField(10));
        addField(panel, "Fecha de salida (YYYY-MM-DD):", new JTextField(10));
        addField(panel, "Valor:", new JTextField(10));
        addField(panel, "Peso (kg):", new JTextField(10));
        addField(panel, "Autor:", new JTextField(10));
        addField(panel, "Alto (cm):", new JTextField(10));
        addField(panel, "Ancho (cm):", new JTextField(10));
        addField(panel, "Largo (cm):", new JTextField(10));
        addField(panel, "Material:", new JTextField(10));
        return panel;
    }

    private JPanel createPinturaPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        addField(panel, "Nombre:", new JTextField(10));
        addField(panel, "Año de creación:", new JTextField(10));
        addField(panel, "Lugar de creación:", new JTextField(10));
        addField(panel, "En exhibición (true/false):", new JTextField(10));
        addField(panel, "Fecha de salida (YYYY-MM-DD):", new JTextField(10));
        addField(panel, "Valor:", new JTextField(10));
        addField(panel, "Peso (kg):", new JTextField(10));
        addField(panel, "Autor:", new JTextField(10));
        addField(panel, "Técnica:", new JTextField(10));
        addField(panel, "Estilo:", new JTextField(10));
        addField(panel, "Altura (cm):", new JTextField(10));
        addField(panel, "Ancho (cm):", new JTextField(10));
        return panel;
    }

    private JPanel createVideoPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        addField(panel, "Nombre:", new JTextField(10));
        addField(panel, "Año de creación:", new JTextField(10));
        addField(panel, "Lugar de creación:", new JTextField(10));
        addField(panel, "En exhibición (true/false):", new JTextField(10));
        addField(panel, "Fecha de salida (YYYY-MM-DD):", new JTextField(10));
        addField(panel, "Valor:", new JTextField(10));
        addField(panel, "Peso (kg):", new JTextField(10));
        addField(panel, "Autor:", new JTextField(10));
        addField(panel, "Resolución (dpi):", new JTextField(10));
        addField(panel, "Duración (min):", new JTextField(10));
        return panel;
    }

    private JPanel createFotografiaPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        addField(panel, "Nombre:", new JTextField(10));
        addField(panel, "Año de creación:", new JTextField(10));
        addField(panel, "Lugar de creación:", new JTextField(10));
        addField(panel, "En exhibición (true/false):", new JTextField(10));
        addField(panel, "Fecha de salida (YYYY-MM-DD):", new JTextField(10));
        addField(panel, "Valor:", new JTextField(10));
        addField(panel, "Peso (kg):", new JTextField(10));
        addField(panel, "Autor:", new JTextField(10));
        addField(panel, "Resolución (dpi):", new JTextField(10));
        addField(panel, "Tipo (Analógica/Digital):", new JTextField(10));
        return panel;
    }

    private void addField(JPanel panel, String labelText, JTextField textField) {
        panel.add(new JLabel(labelText));
        panel.add(textField);
    }

    private void onTipoPiezaChanged(ActionEvent e) {
        JComboBox<String> cb = (JComboBox<String>) e.getSource();
        String piezaType = cb.getSelectedItem().toString();
        cardLayout.show(cardPanel, piezaType);
    }
}
