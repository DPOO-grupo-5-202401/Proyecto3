package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    private JTextField userField;
    private JPasswordField passwordField;

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
        subtitleLabel.setFont(new Font("Javanese Text", Font.PLAIN, 24));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(subtitleLabel);

        // Espaciador
        panel.add(Box.createVerticalStrut(20));

        // Etiqueta para usuario
        JLabel userLabel = new JLabel("Usuario");
        userLabel.setFont(new Font("Lato", Font.PLAIN,12));
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(userLabel);

        // Campo de usuario
        userField = new JTextField("Admin1",20);
        userField.setForeground(Color.GRAY); // Color del texto predeterminado
        userField.setMaximumSize(userField.getPreferredSize());
        userField.setAlignmentX(Component.CENTER_ALIGNMENT);
        userField.setBackground(new Color(255, 253, 239));  // Color de fondo #FFFDEF
        panel.add(userField);

        // Espaciador
        panel.add(Box.createVerticalStrut(10));

        // Etiqueta para contraseña
        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setFont(new Font("Lato", Font.PLAIN,12));
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(passwordLabel);

        // Campo de contraseña
        passwordField = new JPasswordField("Admin1",20);
        passwordField.setForeground(Color.GRAY); // Color del texto predeterminado
        passwordField.setMaximumSize(passwordField.getPreferredSize());
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setBackground(new Color(255, 253, 239));  // Color de fondo #FFFDEF
        panel.add(passwordField);
        
        // Espaciador
        panel.add(Box.createVerticalStrut(10));

        // Botón de ingresar
        JButton loginButton = new JButton("Ingresar");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setFont(new Font("Lato", Font.BOLD,12));
        loginButton.setBackground(new Color(188, 187, 174)); // Color #BCBBAE
        loginButton.addActionListener(this);
        panel.add(loginButton);

        // Añadir el panel al frame
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("Admin1") && password.equals("Admin1")) {
        	new MainControllerAdmin();  
        	this.dispose();
        } else if (username.equals("Empleado1") && password.equals("Empleado1")) {
        	new MainControllerAdmin();  
        	this.dispose();
        } else if (username.equals("Comprador1") && password.equals("Comprador1")) {
        	new MainControllerAdmin();  
        	this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(LoginFrame.this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame());
    }
}
