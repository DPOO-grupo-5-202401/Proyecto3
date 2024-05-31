package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import Persistencia.ArchivoTextoPlano;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Map.Entry;


public class Administrador extends Usuario {
	
	//Atributos
	private String contrasena;
	private String login;
    private HashMap<String, Comprador> compradoresVerificados;
	public HashMap<String, Pieza> inventarioHistorico;
	public HashMap<String, Video> videos;
	public HashMap<String, Escultura> esculturas;
	public HashMap<String, Pintura> pinturas;
	public HashMap<String, Fotografia> fotografias;
	public HashMap<String, Comprador> compradores;
	public HashMap<String, Autor> autores;
	public HashMap<String, Oferta> ofertas;
	public HashMap<String, Compra> compras;
	public static int contadorOfertas;
	public static int contadorCompras;
	
	
    // Constructor
    public Administrador(String nombre, String contrasena, String login) {
        super(nombre);
        this.contrasena = contrasena;
        this.login = login;
        this.compradoresVerificados = new HashMap<>();
        this.compradores = new HashMap<>();
        this.inventarioHistorico = new HashMap<>();
        this.autores = new HashMap<>();
        this.videos = new HashMap<>();
        this.esculturas = new HashMap<>();
        this.fotografias = new HashMap<>();
        this.pinturas = new HashMap<>();
        this.ofertas = new HashMap<>();
        this.compras = new HashMap<>();
        
        }


	//Metodos
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public HashMap<String, Comprador> getCompradoresVerificados() {
		return compradoresVerificados;
	}

	public void setCompradoresVerificados(HashMap<String, Comprador> compradoresVerificados) {
		this.compradoresVerificados = compradoresVerificados;
	}

	public HashMap<String, Pieza> getInventarioHistorico() {
		return inventarioHistorico;
	}

	public void setInventarioHistorico(HashMap<String, Pieza> inventarioHistorico) {
		this.inventarioHistorico = inventarioHistorico;
	}

	public HashMap<String, Comprador> getCompradores() {
		return compradores;
	}

	public void setCompradores(HashMap<String, Comprador> compradores) {
		this.compradores = compradores;
	}
	
	public HashMap<String, Autor> getAutores() {
		return autores;
	}

	public void setAutores(HashMap<String, Autor> autores) {
		this.autores = autores;
	}



    
	


    // Verificar un comprador
   // public void verificarComprador(Comprador comprador) {
     //   compradoresVerificados.put(comprador.getNombre(), comprador);
    //}
    
    //Crear Comprador
	public void crearComprador(String nombre, int numeroDeContacto, String contrasena, String login) {
		Comprador nuevoComprador = new Comprador(nombre,numeroDeContacto,contrasena,login); 
		this.compradores.put(nuevoComprador.getLogin(),nuevoComprador);
	}
	
	
    //Crear Autor
	public void crearAutor(String nombre) {
		Autor nuevoAutor = new Autor(nombre); 
		this.autores.put(nuevoAutor.getNombre(),nuevoAutor);
	}
	
	public void crearOfertaTP(String id,Comprador comprador, Pieza pieza, boolean validada) {
		Oferta nuevaOferta = new Oferta(id,comprador,pieza,validada); 
		this.ofertas.put(nuevaOferta.getId(),nuevaOferta);
	}
	
	public void crearCompraTP(String id,Oferta ofertaValidada,String fecha) {
		Compra nuevaCompra = new Compra(id,ofertaValidada,fecha); 
		this.compras.put(nuevaCompra.getId(),nuevaCompra);
		Comprador nuevoDueño = nuevaCompra.getOfertaValidada().getComprador();
    	nuevaCompra.getOfertaValidada().getPieza().getHistoriaPieza().add(nuevaCompra);
    	nuevaCompra.getOfertaValidada().getPieza().setEstadoActual("FueraDeGaleria");
    	Pieza pieza = nuevaCompra.getOfertaValidada().getPieza();
    	nuevoDueño.getPiezasqueHaTenido().put(pieza.getTitulo(), pieza);
    	
	}
	
	
	
	public Autor crearRetornarAutor(String nombre) {
		Autor nuevoAutor = new Autor(nombre); 
		this.autores.put(nuevoAutor.getNombre(),nuevoAutor);
		return nuevoAutor;
	}
	
	// Crear Video
	public void crearVideo(String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor, int resolucion, int duracion) {
		
		Video nuevoVideo = new Video(titulo,año,lugarDeCreacion,enExhibicion,FechaSalidaGaleria,EstadoActual,ValorFijo,
				ValorInicial,ValorMinimo,Valor,DueñoActual,peso,observacion,autor,resolucion,duracion);
		this.inventarioHistorico.put(nuevoVideo.getTitulo(),nuevoVideo);
		this.videos.put(nuevoVideo.getTitulo(),nuevoVideo);
		autor.getPiezasQueHaHecho().put(nuevoVideo.getTitulo(), nuevoVideo);
	}
	
	
	//Crear Pintura
	public void crearPintura(String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor, String tecnica, String estilo, int altura, int ancho) {
		
		Pintura nuevaPintura = new Pintura(titulo,año,lugarDeCreacion,enExhibicion,
				FechaSalidaGaleria,EstadoActual,ValorFijo,
				ValorInicial, ValorMinimo,Valor,DueñoActual,peso, observacion,
				autor, tecnica,estilo,altura,ancho);
		
		this.inventarioHistorico.put(nuevaPintura.getTitulo(),nuevaPintura);
		this.pinturas.put(nuevaPintura.getTitulo(),nuevaPintura);
		autor.getPiezasQueHaHecho().put(nuevaPintura.getTitulo(), nuevaPintura);
	}
	
	//Crear Escultura
	public void crearEscultura(String titulo,int año,String lugarDeCreacion,boolean enExhibicion, 
    		String EstadoActual,String fechaSalidaGaleria,
    		boolean ValorFijo,int ValorInicial,int ValorMinimo,int Valor,
    		Comprador DueñoActual, int peso,String observacion,Autor autor,  int alto,
    		int ancho, int largo, boolean electricidad, String material) {
		
		Escultura nuevaEscultura = new Escultura(titulo,año,lugarDeCreacion,enExhibicion, 
	    		EstadoActual,fechaSalidaGaleria,
	    		ValorFijo,ValorInicial,ValorMinimo,Valor,
	    		DueñoActual,peso,observacion,autor,alto,
	    		ancho, largo, electricidad, material);
		
		this.inventarioHistorico.put(nuevaEscultura.getTitulo(),nuevaEscultura);
		this.esculturas.put(nuevaEscultura.getTitulo(),nuevaEscultura);
		autor.getPiezasQueHaHecho().put(nuevaEscultura.getTitulo(), nuevaEscultura);
	}
	
	
	//Crear Fotografia
	public void crearFotografia(String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor, int resolucion, String tipo) {
		
		Fotografia nuevaFotografia = new Fotografia(titulo, año, lugarDeCreacion, enExhibicion,
				FechaSalidaGaleria, EstadoActual, ValorFijo,
				ValorInicial, ValorMinimo, Valor, DueñoActual,peso,observacion,
				autor, resolucion,tipo);
		this.inventarioHistorico.put(nuevaFotografia.getTitulo(),nuevaFotografia);
		this.fotografias.put(nuevaFotografia.getTitulo(),nuevaFotografia);
		autor.getPiezasQueHaHecho().put(nuevaFotografia.getTitulo(), nuevaFotografia);
	}
	
	
	//Persistencia - Cargar Texto Plano
	public void cargarCompradores() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("compradores.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			this.crearComprador(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3]);
		}
	}
	
	
	public void cargarVideos() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("videos.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			Autor nuevoAutor = this.crearRetornarAutor(datos[13]);
			
			this.crearVideo(datos[0], Integer.parseInt(datos[1]), datos[2], Boolean.parseBoolean(datos[3]),
					datos[4], datos[5], Boolean.parseBoolean(datos[6]),
					Integer.parseInt(datos[7]), Integer.parseInt(datos[8]), Integer.parseInt(datos[9]), this.compradores.get(datos[10]), Integer.parseInt(datos[11]), datos[12],
					this.autores.get(nuevoAutor.getNombre()), Integer.parseInt(datos[14]), Integer.parseInt(datos[15]));
		}
	}
	
	public void cargarEsculturas() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("esculturas.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			Autor nuevoAutor = null;
			if (this.autores.containsKey(datos[13])) {
				nuevoAutor = this.autores.get(datos[13]);
			}else {
				nuevoAutor = this.crearRetornarAutor(datos[13]);
			}
			
			
			this.crearEscultura(datos[0],Integer.parseInt(datos[1]),datos[2],Boolean.parseBoolean(datos[3]), 
		    		datos[4],datos[5],
		    		Boolean.parseBoolean(datos[6]),Integer.parseInt(datos[7]), Integer.parseInt(datos[8]), Integer.parseInt(datos[9]),
		    		this.compradores.get(datos[10]), Integer.parseInt(datos[11]) , datos[12],this.autores.get(nuevoAutor.getNombre()),  Integer.parseInt(datos[14]), Integer.parseInt(datos[15]),
		    		Integer.parseInt(datos[16]), Boolean.parseBoolean(datos[17]), datos[18]);
		}
	}



	public void cargarPinturas() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("pinturas.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			Autor nuevoAutor = null;
			if (this.autores.containsKey(datos[13])) {
				nuevoAutor = this.autores.get(datos[13]);
			}else {
				nuevoAutor = this.crearRetornarAutor(datos[13]);
			}
			
			this.crearPintura(datos[0],Integer.parseInt(datos[1]),datos[2],Boolean.parseBoolean(datos[3]), 
		    		datos[4],datos[5],
		    		Boolean.parseBoolean(datos[6]),Integer.parseInt(datos[7]), Integer.parseInt(datos[8]), Integer.parseInt(datos[9]),
		    		this.compradores.get(datos[10]), Integer.parseInt(datos[11]) , datos[12],this.autores.get(nuevoAutor.getNombre()), datos[14],datos[15],
		    		Integer.parseInt(datos[16]), Integer.parseInt(datos[17]));
		}
	}
	

	public void cargarFotografias() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("fotografias.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			Autor nuevoAutor = null;
			if (this.autores.containsKey(datos[13])) {
				nuevoAutor = this.autores.get(datos[13]);
			}else {
				nuevoAutor = this.crearRetornarAutor(datos[13]);
			}
			
			this.crearFotografia(datos[0],Integer.parseInt(datos[1]),datos[2],Boolean.parseBoolean(datos[3]), 
		    		datos[4],datos[5],
		    		Boolean.parseBoolean(datos[6]),Integer.parseInt(datos[7]), Integer.parseInt(datos[8]), Integer.parseInt(datos[9]),
		    		this.compradores.get(datos[10]), Integer.parseInt(datos[11]) , datos[12],this.autores.get(nuevoAutor.getNombre()),
		    		Integer.parseInt(datos[14]), datos[15]);
		}
	}
	
	public void cargarOfertas() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("ofertas.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			

			String cleanString = datos[0].replace("\uFEFF", "");
			contadorOfertas = Integer.parseInt(cleanString);
		
			Comprador comprador = this.compradores.get(datos[1]);
			Pieza pieza = this.inventarioHistorico.get(datos[2]);
			
			this.crearOfertaTP(cleanString,comprador,pieza,Boolean.parseBoolean(datos[3]));
		}
	}
	
	public void cargarCompras() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("compras.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			

			String cleanString = datos[0].replace("\uFEFF", "");

			String cleanString2 = datos[1].replace("\uFEFF", "");
			contadorCompras = Integer.parseInt(cleanString);
		
			Oferta oferta = this.ofertas.get(cleanString2);
			
			this.crearCompraTP(cleanString,oferta,datos[2]);
		}
	}
	
	//Persistencia - Almacenar en Texto Plano
	
	//Almacenar Compradores
	public void almacenarCompradores() {
		ArrayList<String> textos = new ArrayList<String>();		
        for (Entry<String, Comprador> entry : compradores.entrySet()) {
        	textos.add(entry.getValue().getNombre() + ";" + entry.getValue().getNumeroDeContacto() + ";" + entry.getValue().getContrasena() + ";" + entry.getKey() + "\n");
        }
		ArchivoTextoPlano.almacenar("compradores.csv", textos);
	}
	
	
	//Almacenar Video
	public void almacenarVideos() {
		ArrayList<String> textos = new ArrayList<String>();		
        for (Entry<String, Video> entry : videos.entrySet()) {
				System.out.println(entry.getValue().getTitulo());
				
        		textos.add(entry.getValue().getTitulo() + ";" +
        	            entry.getValue().getAnio() + ";" +
        	            entry.getValue().getLugarDeCreacion() + ";" +
        	            entry.getValue().getEnExhibicion() + ";" +
        	            entry.getValue().getFechaSalidaGaleria() + ";" +
        	            entry.getValue().getEstadoActual() + ";" +
        	            entry.getValue().getValorFijo() + ";" +
        	            entry.getValue().getValorInicial() + ";" +
        	            entry.getValue().getValorMinimo() + ";" +
        	            entry.getValue().getValor() + ";" +
        	            entry.getValue().getDueñoActual().getNombre() + ";" +
        	            entry.getValue().getPeso() + ";" +
        	            entry.getValue().getObservacion() + ";" +
        	            entry.getValue().getAutor().getNombre() + ";" +
        	            entry.getValue().getResolucion() + ";" +
        	            entry.getValue().getDuracion() + "\n");
        }
		ArchivoTextoPlano.almacenar("videos.csv", textos);
	}
	
	public void almacenarPinturas() {
	    ArrayList<String> textos = new ArrayList<String>();		
	    for (Entry<String, Pintura> entry : pinturas.entrySet()) {		
	        textos.add(entry.getValue().getTitulo() + ";" +
	                   entry.getValue().getAnio() + ";" +
	                   entry.getValue().getLugarDeCreacion() + ";" +
	                   entry.getValue().getEnExhibicion() + ";" +
	                   entry.getValue().getFechaSalidaGaleria() + ";" +
	                   entry.getValue().getEstadoActual() + ";" +
	                   entry.getValue().getValorFijo() + ";" +
	                   entry.getValue().getValorInicial() + ";" +
	                   entry.getValue().getValorMinimo() + ";" +
	                   entry.getValue().getValor() + ";" +
	                   entry.getValue().getDueñoActual().getNombre() + ";" +
	                   entry.getValue().getPeso() + ";" +
	                   entry.getValue().getObservacion() + ";" +
	                   entry.getValue().getAutor().getNombre() + ";" +
	                   entry.getValue().getTecnica() + ";" +
	                   entry.getValue().getEstilo() + ";" +
	                   entry.getValue().getAltura() + ";" +
	                   entry.getValue().getAncho() + "\n");
	    }
	    ArchivoTextoPlano.almacenar("pinturas.csv", textos);
	}
	
	public void almacenarEsculturas() {
	    ArrayList<String> textos = new ArrayList<String>();		
	    for (Entry<String, Escultura> entry : esculturas.entrySet()) {		
	        textos.add(entry.getValue().getTitulo() + ";" +
	                   entry.getValue().getAnio() + ";" +
	                   entry.getValue().getLugarDeCreacion() + ";" +
	                   entry.getValue().getEnExhibicion() + ";" +
	                   entry.getValue().getEstadoActual() + ";" +
	                   entry.getValue().getFechaSalidaGaleria() + ";" +
	                   entry.getValue().getValorFijo() + ";" +
	                   entry.getValue().getValorInicial() + ";" +
	                   entry.getValue().getValorMinimo() + ";" +
	                   entry.getValue().getValor() + ";" +
	                   entry.getValue().getDueñoActual().getNombre() + ";" +
	                   entry.getValue().getPeso() + ";" +
	                   entry.getValue().getObservacion() + ";" +
	                   entry.getValue().getAutor().getNombre() + ";" +
	                   entry.getValue().getAlto() + ";" +
	                   entry.getValue().getAncho() + ";" +
	                   entry.getValue().getLargo() + ";" +
	                   entry.getValue().getElectricidad() + ";" +
	                   entry.getValue().getMaterial() + "\n");
	    }
	    ArchivoTextoPlano.almacenar("esculturas.csv", textos);
	}
	
	public void almacenarFotografias() {
	    ArrayList<String> textos = new ArrayList<String>();		
	    for (Entry<String, Fotografia> entry : fotografias.entrySet()) {		
	        textos.add(entry.getValue().getTitulo() + ";" +
	                   entry.getValue().getAnio() + ";" +
	                   entry.getValue().getLugarDeCreacion() + ";" +
	                   entry.getValue().getEnExhibicion() + ";" +
	                   entry.getValue().getEstadoActual() + ";" +
	                   entry.getValue().getFechaSalidaGaleria() + ";" +
	                   entry.getValue().getValorFijo() + ";" +
	                   entry.getValue().getValorInicial() + ";" +
	                   entry.getValue().getValorMinimo() + ";" +
	                   entry.getValue().getValor() + ";" +
	                   entry.getValue().getDueñoActual().getNombre() + ";" +
	                   entry.getValue().getPeso() + ";" +
	                   entry.getValue().getObservacion() + ";" +
	                   entry.getValue().getAutor().getNombre() + ";" +
	                   entry.getValue().getResolucion() + ";" +
	                   entry.getValue().getTipo() + "\n");
	    }
	    ArchivoTextoPlano.almacenar("fotografias.csv", textos);
	}
	
    
    public Oferta crearRetornarOferta(Comprador comprador, Pieza pieza){
        if (pieza.getValorFijo()==false || pieza.getEstadoActual() == "Bloqueada") {
        	return null;
        }
        else {
        	pieza.setEstadoActual("Bloqueada");
        	System.out.println("Pieza Bloqueda");
        	Oferta nuevaOferta = new Oferta(contadorOfertas,comprador,pieza);
        	contadorOfertas=+1;
        	this.ofertas.put(nuevaOferta.getId(),nuevaOferta);
        	return nuevaOferta;
        }
    }

    
    // Devolver una pieza al propietario
    public void devolverPieza(Pieza pieza) {
        
    }
    
    public Compra crearRetornarCompra(Oferta oferta) {
    	Comprador nuevoDueño = oferta.getComprador();
    	oferta.getPieza().setDueñoActual(nuevoDueño);
    	oferta.setValidada(true);
    	Compra nuevaCompra = new Compra(oferta);
    	contadorCompras=+1;
    	this.compras.put(nuevaCompra.getId(),nuevaCompra);
    	nuevaCompra.getOfertaValidada().getPieza().setEstadoActual("FueraDeGaleria");
    	nuevaCompra.getOfertaValidada().getPieza().getHistoriaPieza().add(nuevaCompra);
    	Pieza pieza = nuevaCompra.getOfertaValidada().getPieza();
    	nuevoDueño.getPiezasqueHaTenido().put(pieza.getTitulo(), pieza);
    	
    	return nuevaCompra;
    }
    

    // Iniciar una subasta
	
	public Subasta iniciarSubasta(Administrador administrador, Pieza pieza,
			HashMap<String, Comprador> compradoresValidados) {	
		LocalDate fecha = LocalDate.now();
		String fechaString = fecha.toString();
		Subasta nuevaSubasta = new Subasta(fechaString, administrador, pieza,compradoresValidados);
		
		return nuevaSubasta;
	}
	

	public void nuevoMovimiento(Integer valor, String tipoMovimiento,Comprador comprador) {
		Random random = new Random();
		Integer num = random.nextInt(90) + 10;
		String id = "MOV-" + num.toString();
		LocalTime horaActual = LocalTime.now();
		String hora = horaActual.toString();
		Movimiento nuevoMovimiento = new Movimiento(id,hora,valor,tipoMovimiento,comprador);
	}
	
	public void VerificarComprador(String id,String login) {
		
	}


	public HashMap<String, Video> getVideos() {
		return videos;
	}


	public void setVideos(HashMap<String, Video> videos) {
		this.videos = videos;
	}


	public HashMap<String, Escultura> getEsculturas() {
		return esculturas;
	}


	public void setEsculturas(HashMap<String, Escultura> esculturas) {
		this.esculturas = esculturas;
	}


	public HashMap<String, Pintura> getPinturas() {
		return pinturas;
	}


	public void setPinturas(HashMap<String, Pintura> pinturas) {
		this.pinturas = pinturas;
	}


	public HashMap<String, Fotografia> getFotografias() {
		return fotografias;
	}


	public void setFotografias(HashMap<String, Fotografia> fotografias) {
		this.fotografias = fotografias;
	}


	public HashMap<String, Oferta> getOfertas() {
		return ofertas;
	}


	public void setOfertas(HashMap<String, Oferta> ofertas) {
		this.ofertas = ofertas;
	}


	public HashMap<String, Compra> getCompras() {
		return compras;
	}


	public void setCompras(HashMap<String, Compra> compras) {
		this.compras = compras;
	}
	


}
