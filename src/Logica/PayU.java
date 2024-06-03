package Logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PayU implements PasarelaDePago {
    public boolean procesarPago(DetallesPago detalles) {
        
        boolean resultado = true; 

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PayU.log", true))) {
            writer.write("Transacción: " + detalles.toString() + " Resultado: " + resultado);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultado;
    }
}