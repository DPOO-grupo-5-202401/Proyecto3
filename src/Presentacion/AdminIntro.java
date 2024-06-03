package Presentacion;

import javax.swing.*;

import Logica.Administrador;

import java.awt.*;

public class AdminIntro extends BaseFrame {



    public AdminIntro(Administrador administrador) {
		super(administrador);
	}

	@Override
    protected void configureInfoPanel() {
        // Configuración específica del infoPanel para AdminIntro
        JLabel welcomeLabel = new JLabel("Bienvenido a Colmena");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 48));  // Asegúrate de que la fuente es reconocida
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(Box.createVerticalStrut(50));  // Espaciador vertical
        infoPanel.add(welcomeLabel);

        JLabel secondLabel = new JLabel("Panel de Administración");
        secondLabel.setFont(new Font("Serif", Font.PLAIN, 24));  // Asegúrate de que la fuente es reconocida
        secondLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(secondLabel);
    }
}
