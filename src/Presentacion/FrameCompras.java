package Presentacion;

import javax.swing.*;
import java.awt.*;

public class FrameCompras extends BaseFrame {
    public FrameCompras() {
        super("Datos - Administración de Colmena");
    }

    @Override
    protected void configureInfoPanel() {
        // Aquí personalizas el infoPanel específico para "Datos"
        JLabel titleLabel = new JLabel("Gestión de Datos");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(titleLabel);

        // Puedes añadir más componentes al infoPanel según los requerimientos específicos de esta sección
        JLabel infoLabel = new JLabel("Aquí se pueden modificar y visualizar los datos relevantes.");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(infoLabel);
    }
}
