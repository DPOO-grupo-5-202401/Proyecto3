package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ArchivoTextoPlano {

	public static void almacenar(String archivo, ArrayList<String> textos) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(archivo)));
			for(String texto : textos) {
				bw.write(texto);
			}
			bw.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> cargar(String archivo){
		ArrayList<String> textos = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(archivo)));
			String linea;
			while((linea=br.readLine()) != null) {
				textos.add(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textos;
	}
}