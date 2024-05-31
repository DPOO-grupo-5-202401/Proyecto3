package Presentacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import Logica.Administrador;
import Logica.Autor;
import Logica.Compra;
import Logica.Comprador;
import Logica.Oferta;
import Logica.Pieza;


public class Padministrador {
	private Administrador administrador;


	public Padministrador() {
		this.administrador = new Administrador("Juan", "A1", "A1");
		administrador.cargarCompradores();
		administrador.cargarVideos();
		administrador.cargarEsculturas();
		administrador.cargarPinturas();
		administrador.cargarFotografias();
		administrador.cargarOfertas();
		administrador.cargarCompras();
		menu();
	}

	private void menu() {
			int op = 0;
			Scanner sc = new Scanner(System.in);
			do {
				
				
				System.out.println("\n");
		        System.out.println("*****Bienvenido Administrador*****");
				System.out.println("\n");
				System.out.println("Digite una opcion");
				System.out.println("0. Salir");
				System.out.println("1. Registrar Nuevo Comprador");
				System.out.println("2. Consultar Compradores");
				System.out.println("3. Registrar Nueva Pieza");
				System.out.println("4. Consultar Piezas");
				System.out.println("5. Cargar Datos");
				System.out.println("6. Guardar Datos");
				System.out.println("7. Crear Oferta");
				System.out.println("8. Consultar Ofertas");
				System.out.println("9. Confirmar Venta Obra");
				System.out.println("10. Consultar Ventas");
				System.out.println("11.Consultar Historia Pieza");
				System.out.println("12.Consultar Historia Artista");
				System.out.println("13.Consultar Historia Comprador");
				System.out.println("14. Verificar Comprador para Subasta");
				System.out.println("15. Iniciar Subasta");
				op = sc.nextInt();
				try {
					if(op == 1) {
						System.out.println("Digite nombre");
						String nombre = sc.next();
						
						System.out.println("Digite numero de contacto");
						int contacto = sc.nextInt();
						
						System.out.println("Digite login");
						String login = sc.next();
						
						System.out.println("Digite contraseña");
						String contrasena = sc.next();
						
						administrador.crearComprador(nombre, contacto, contrasena, login);
						System.out.println("Comprador " + login + " creado con exito");
						
					}else if(op == 2) {
						
						HashMap<String, Comprador> map = administrador.getCompradores();
						
				        for (Entry<String, Comprador> entry : map.entrySet()) {
				            System.out.println(entry.getKey() + " : " + entry.getValue().getNombre());
				        }
				        
					}else if(op == 3) {
						int intpieza = 0;
						do {
							System.out.println("Que tipo de Pieza desea registrar");
							System.out.println("1. Escultura");
							System.out.println("2. Pintura");
							System.out.println("3. Video");
							System.out.println("4. Fotografia");
							System.out.println("5. Regresar al Menu Principal");
							intpieza = sc.nextInt();
							
							if (intpieza == 1) {
								
								System.out.println("Digite el nombre de la pieza");
								String titulo = sc.next();
								
								System.out.println("Digite año de creacion de la pieza");
								int anio = sc.nextInt();
								
								System.out.println("Digite lugar de creacion de la pieza");
								String lugar = sc.next();
								
								System.out.println("¿La pieza se va a exhibicion? (true/false)");
								boolean enExhibicion = Boolean.parseBoolean(sc.next().trim().toLowerCase());
								
								System.out.println("Digite hasta cuando estara la pieza en la galeria (YYYY-MM-DD)");
								String fechaSalida = sc.next();
								
								System.out.println("Digite el valor de la pieza");
								int valor = sc.nextInt();
								
								System.out.println("Digite el peso de la pieza");
								int peso = sc.nextInt();
								
								System.out.println("Digite el autor de la pieza");
								String autor = sc.next();
								Autor nuevoAutor = null;
								if (administrador.autores.containsKey(autor)) {
									nuevoAutor = administrador.autores.get(autor);
								}else {
									nuevoAutor = administrador.crearRetornarAutor(autor);
								}
								
								System.out.println("Digite el alto de la pieza");
								int alto = sc.nextInt();
								
								System.out.println("Digite el ancho de la pieza");
								int ancho = sc.nextInt();
							
								System.out.println("Digite el largo de la pieza");
								int largo = sc.nextInt();
								
								System.out.println("Digite el material de la pieza");
								String material = sc.next();
								
								
								administrador.crearEscultura(titulo, anio, lugar, enExhibicion,fechaSalida, "ParaVenta", true, valor, 0, 0, administrador.compradores.get("Galeria"),peso, "Sin Observacion",administrador.autores.get(nuevoAutor.getNombre()) , alto,ancho,largo, false,material);
								System.out.println("Escultura Creada!");
								break;
							}

							
							else if (intpieza == 2) {
								System.out.println("Digite el nombre de la pieza");
								String titulo = sc.next();
								
								System.out.println("Digite año de creacion de la pieza");
								int anio = sc.nextInt();
								
								System.out.println("Digite lugar de creacion de la pieza");
								String lugar = sc.next();
								
								System.out.println("¿La pieza se va a exhibicion? (true/false)");
								boolean enExhibicion = Boolean.parseBoolean(sc.next().trim().toLowerCase());
								
								System.out.println("Digite hasta cuando estara la pieza en la galeria (YYYY-MM-DD)");
								String fechaSalida = sc.next();
								
								System.out.println("Digite el valor de la pieza");
								int valor = sc.nextInt();
								
								System.out.println("Digite el peso de la pieza");
								int peso = sc.nextInt();
								
								System.out.println("Digite el autor de la pieza");
								String autor = sc.next();
								Autor nuevoAutor = null;
								if (administrador.autores.containsKey(autor)) {
									nuevoAutor = administrador.autores.get(autor);
								}else {
									nuevoAutor = administrador.crearRetornarAutor(autor);
								}
								
								System.out.println("Digite la tecnica de la pieza");
								String tecnica = sc.next();
								
								System.out.println("Digite el estilo de la pieza");
								String estilo = sc.next();
								
								System.out.println("Digite la altura de la pieza");
								int altura = sc.nextInt();
								
								System.out.println("Digite ancho de la pieza");
								int ancho = sc.nextInt();
								
								
								administrador.crearPintura(titulo, anio,lugar, enExhibicion,fechaSalida, "ParaVenta", true, valor, 0, 0, administrador.compradores.get("Galeria"), peso, "Sin Observacion",administrador.autores.get(nuevoAutor.getNombre()) , tecnica, estilo, altura,ancho);
								System.out.println("Pintura Creada!");

								break;
								
							}
							
							else if (intpieza == 3) {
								System.out.println("Digite el nombre de la pieza");
								String titulo = sc.next();
								
								System.out.println("Digite año de creacion de la pieza");
								int anio = sc.nextInt();
								
								System.out.println("Digite lugar de creacion de la pieza");
								String lugar = sc.next();
								
								System.out.println("¿La pieza se va a exhibicion? (true/false)");
								boolean enExhibicion = Boolean.parseBoolean(sc.next().trim().toLowerCase());
								
								System.out.println("Digite hasta cuando estara la pieza en la galeria (YYYY-MM-DD)");
								String fechaSalida = sc.next();
								
								System.out.println("Digite el valor de la pieza");
								int valor = sc.nextInt();
								
								System.out.println("Digite el peso de la pieza");
								int peso = sc.nextInt();
								
								System.out.println("Digite el autor de la pieza");
								String autor = sc.next();
								Autor nuevoAutor = null;
								if (administrador.autores.containsKey(autor)) {
									nuevoAutor = administrador.autores.get(autor);
								}else {
									nuevoAutor = administrador.crearRetornarAutor(autor);
								}
								
								
								System.out.println("Digite la altura de la pieza");
								int resolucion = sc.nextInt();
								
								System.out.println("Digite la duracion del video");
								int duracion = sc.nextInt();
								
								administrador.crearVideo(titulo, anio, lugar,enExhibicion,fechaSalida, "EnVenta", true, valor, 0, 0, administrador.compradores.get("Galeria"), peso, "Sin Observacion",administrador.autores.get(nuevoAutor.getNombre()) ,resolucion,duracion);
								System.out.println("Video Creado!");
								break;
								
							}
							
							else if (intpieza == 4) {
								
								System.out.println("Digite el nombre de la pieza");
								String titulo = sc.next();
								
								System.out.println("Digite año de creacion de la pieza");
								int anio = sc.nextInt();
								
								System.out.println("Digite lugar de creacion de la pieza");
								String lugar = sc.next();
								
								System.out.println("¿La pieza se va a exhibicion? (true/false)");
								boolean enExhibicion = Boolean.parseBoolean(sc.next().trim().toLowerCase());
								
								System.out.println("Digite hasta cuando estara la pieza en la galeria (YYYY-MM-DD)");
								String fechaSalida = sc.next();
								
								System.out.println("Digite el valor de la pieza");
								int valor = sc.nextInt();
								
								System.out.println("Digite el peso de la pieza");
								int peso = sc.nextInt();
								
								System.out.println("Digite el autor de la pieza");
								String autor = sc.next();
								Autor nuevoAutor = null;
								if (administrador.autores.containsKey(autor)) {
									nuevoAutor = administrador.autores.get(autor);
								}else {
									nuevoAutor = administrador.crearRetornarAutor(autor);
								}
								
								
								System.out.println("Digite la altura de la pieza");
								int resolucion = sc.nextInt();
								
								System.out.println("Digite el tipo de foto (Analoga o Digital)");
								String tipo = sc.next();
								
								administrador.crearFotografia(titulo, anio, lugar, enExhibicion,fechaSalida, "EnVenta", true, valor, 0, 0, administrador.compradores.get("Galeria"), peso, "Sin Observacion",administrador.autores.get(nuevoAutor.getNombre()) , resolucion,tipo);
								System.out.println("Pieza Creada!");
								break;
								
								
							}
							
							else if (intpieza == 5) {	
								break;
							}
							
							
							
						}while(intpieza != 0);
						
	
					}else if(op == 4) {
						
						HashMap<String, Pieza> map = administrador.getInventarioHistorico();
						
				        for (Entry<String, Pieza> entry : map.entrySet()) {
				            System.out.println(entry.getValue().getId() + ":" + entry.getKey() + " por " + entry.getValue().getAutor().getNombre() + ". ESTADO: " + entry.getValue().getEstadoActual());
				        }
	
					}else if(op == 5) {
						administrador.cargarCompradores();
						administrador.cargarVideos();
						administrador.cargarEsculturas();
						administrador.cargarPinturas();
						administrador.cargarFotografias();
									
	
					}else if(op == 6) {
						
						administrador.almacenarCompradores();
						administrador.almacenarVideos();
						administrador.almacenarEsculturas();
						administrador.almacenarPinturas();
						administrador.almacenarFotografias();
						
					}else if(op == 7) {
						System.out.println("Digite el Login del comprador que hace la oferta");
						String login = sc.next();
						
						System.out.println("Digite el nombre de la pieza a realizar una oferta");
						String piezaNombre = sc.next();
						
						
						
						
						Oferta nuevaOferta = administrador.crearRetornarOferta(administrador.compradores.get(login), administrador.inventarioHistorico.get(piezaNombre));
						if (nuevaOferta == null) {
							System.out.println("La oferta no pudo ser creada, verifica si la pieza si esta disponible para compra");
						}else {
							System.out.println("La oferta ha sido creada exitosamente, adquiriras la pieza cuando un administrador verifique tu compra");
						}
						
					}else if(op == 8) {
						HashMap<String, Oferta> map = administrador.getOfertas();
						
				        for (Entry<String, Oferta> entry : map.entrySet()) {
				            System.out.println(entry.getKey() + ": " + entry.getValue().getPieza().getTitulo() + ". Comprada Por: " + entry.getValue().getComprador().getNombre() + " - " + entry.getValue().isValidada());
				        }
						
					}else if(op == 9) {
						
						System.out.println("Digite el ID de la oferta a validar");
						String ID = sc.next();
						
						Compra nuevaCompra = administrador.crearRetornarCompra(administrador.ofertas.get(ID));
						
						
						
					}else if(op == 10) {
						HashMap<String, Compra> map = administrador.getCompras();
						
				        for (Entry<String, Compra> entry : map.entrySet()) {
				            System.out.println(entry.getValue().getId() + ": " + entry.getValue().getOfertaValidada().getPieza().getTitulo() + ". Comprada Por: " + entry.getValue().getOfertaValidada().getComprador().getNombre());
				        }
				        
				        
					}else if(op == 11) {
						System.out.println("Digite el nombre de la pieza a consultar su historia");
						String piezaNombre = sc.next();
						
				        List<Compra> lista = administrador.getInventarioHistorico().get(piezaNombre).getHistoriaPieza();
				        for (int i = 0; i < lista.size(); i++) {
				            System.out.println(lista.get(i).getId() + ": " + lista.get(i).getOfertaValidada().getPieza().getTitulo() + ". Comprada Por: " + lista.get(i).getOfertaValidada().getComprador().getNombre());
				        }
					}else if(op == 12) {
				
						
						Scanner scanner = new Scanner(System.in);
						System.out.println("Nombre del artista a Consultar");
						String artista = scanner.nextLine();
						
						HashMap<String, Pieza> map = administrador.autores.get(artista).getPiezasQueHaHecho();
				        for (Entry<String, Pieza> entry : map.entrySet()) {
				            System.out.println(entry.getValue().getTitulo() + ". Año: " +entry.getValue().getAnio() + ". Fecha de Compra: " + entry.getValue().getHistoriaPieza().get(0).getFecha() + ". Valor Compra: " + entry.getValue().getHistoriaPieza().get(0).getValor());
				        }
					}else if(op == 13) {
				
						
						Scanner scanner = new Scanner(System.in);
						System.out.println("Login del Comprador a consultar");
						String comprador = scanner.nextLine();
						
						HashMap<String, Pieza> map = administrador.compradores.get(comprador).getPiezasqueHaTenido();
				        for (Entry<String, Pieza> entry : map.entrySet()) {
				            System.out.println(entry.getValue().getTitulo() + ". Año: " +entry.getValue().getAnio() + ". Fecha de Compra: " + entry.getValue().getHistoriaPieza().get(0).getFecha() + ". Valor Compra: " + entry.getValue().getHistoriaPieza().get(0).getValor());
				        }
					}else if(op == 14) {
				
						
						Scanner scanner = new Scanner(System.in);
						System.out.println("Nombre del Comprador a Verificar");
						String comprador = scanner.nextLine();
						
						System.out.println("ID de la Subasta");
						String ID = scanner.nextLine();
						
						administrador.VerificarComprador(ID,comprador);
						
						System.out.println("Comprador Verificado con Exito!");							
						

					}else if(op == 15) {
				
						
						Scanner scanner = new Scanner(System.in);
						System.out.println("Ingrese ID de la subasta a iniciar");
						String ID = scanner.nextLine();
						
						
						System.out.println("La puja actual es 1000");
						System.out.println("Ingrese el Login del comprador que desee aumentar la puja (+500)");
						String puja = scanner.nextLine();
						
						System.out.println("Este comprador comprara la obra (s/n)");
						String decision = scanner.nextLine();
						
						
						System.out.println("Subasta terminada con Exito!");							
						

					}
					
					
					
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} 
				
			}while(op != 0);
			sc.close();
		}
	
	
	
	
	
		public static void main(String[] args) {
			new Padministrador();
		}
}




