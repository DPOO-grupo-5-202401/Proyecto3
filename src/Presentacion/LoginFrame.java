package Presentacion;


import javax.swing.*;
import java.awt.*;


public class LoginFrame extends JFrame {
    public LoginFrame() {
        // Configurar el JFrame
        setTitle("Colmena");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar la ventana

        // Panel principal con diseño BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 253, 239));  // Color de fondo #FFFDEF
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(150));

        // Etiqueta de título
        JLabel titleLabel = new JLabel("Colmena");
        titleLabel.setFont(new Font("Javanese Text", Font.BOLD, 80));  
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        
        // Espaciador
        panel.add(Box.createVerticalStrut(-80));

        // Etiqueta de subtítulo
        JLabel subtitleLabel = new JLabel("Galería y Casa de Subastas");
        subtitleLabel.setFont(new Font("Javanese Text",Font.PLAIN, 24));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(subtitleLabel);

        // Espaciador
        panel.add(Box.createVerticalStrut(20));

        // Etiqueta para usuario
        JLabel userLabel = new JLabel("Usuario");
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(userLabel);

        // Campo de usuario
        JTextField userField = new JTextField("Usuario", 20);
        userField.setForeground(Color.GRAY); // Color del texto predeterminado
        userField.setMaximumSize(userField.getPreferredSize());
        userField.setAlignmentX(Component.CENTER_ALIGNMENT);
        userField.setBackground(new Color(255, 253, 239));  // Color de fondo #FFFDEF
        panel.add(userField);

        panel.add(Box.createVerticalStrut(10));

        // Etiqueta para contraseña
        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(passwordLabel);

        // Campo de contraseña
        JPasswordField passwordField = new JPasswordField("Contraseña", 20);
        passwordField.setForeground(Color.GRAY); // Color del texto predeterminado
        passwordField.setMaximumSize(passwordField.getPreferredSize());
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setBackground(new Color(255, 253, 239));  // Color de fondo #FFFDEF
        panel.add(passwordField);
        
        panel.add(Box.createVerticalStrut(10));
        
        
        // Botón de ingresar
        JButton loginButton = new JButton("Ingresar");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setBackground(new Color(188, 187, 174)); // Color #BCBBAE
        panel.add(loginButton);

        // Añadir el panel al frame
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame());
    }
}
