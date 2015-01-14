package protoAgustin;


/**  
* Prototipo1.0.ajp
*  Prueba del las clases Usuario y SesionUsuario del modelo1 
*  @source: Principal.java 
*  @version: 1.0 - 11/12/2014 
*  @author: agu
*/

import java.util.Date;
import java.util.Scanner;


/**
* @author admin
* 
*/
public class Principal {

	public static final int MAX_USUARIOS = 10;
	public static final int MAX_SESIONES = 10;
	
	public static Usuario[] datosUsuarios = new Usuario[MAX_USUARIOS];
	public static SesionUsuario[] sesionesUsuario = new SesionUsuario[MAX_SESIONES];
	
	
	public static void main(String[] args) {
		
		//Apartado 4 y 5: Pruebas
		//pruebasPrevias();
		
		//Apartado 6 y 7: 
		cargarDatosPrueba();		
		//mostrarTodosDatosUsuarios();
		
		//Apartado 8:
		iniciarSesion();
	
	 
		
	}

	/**
	 * Simulaciï¿½n de control de acceso de usuario 
	 * y registro de la sesiï¿½n correspondiente. 
	 */
	private static void iniciarSesion() {

		Scanner teclado = new Scanner(System.in);	//Entrada por consola
		boolean noEncuentra = true; 				// Control de usuario no vï¿½lido
		boolean seguir = true;						// Control de fin de la simulaciï¿½n
		int sesionesRegistradas = 0;				// Control de sesiones registradas
		String credencialUsuario = null;			// Auxiliar para entrada por teclado
		String password = null;
		int intentos = 3;							// Contandor de intentos
		do {
			// Pide credencial usuario y contraseï¿½a
			System.out.print("Introduce el nombre: ");
			credencialUsuario = teclado.nextLine();
			System.out.print("Introduce clave acceso: ");
			password = teclado.nextLine();

			// Busca usuario correspondiente a credencial
			for (int i = 0; i < MAX_USUARIOS && datosUsuarios[i] != null; i++) { 					//recorrer vector

				//compara nombre
				if (datosUsuarios[i].nombre.equals(credencialUsuario)) { 		//Si encontrado 
					noEncuentra  = false;

					//comprueba clave
					if (datosUsuarios[i].claveAcceso.equals(password)) {		//Si coincide

						// Registra sesiÃ³n
						sesionesUsuario[sesionesRegistradas] = new SesionUsuario();
						sesionesUsuario[sesionesRegistradas].usr = datosUsuarios[i];
						sesionesUsuario[sesionesRegistradas].fecha = new Date().toString();

						sesionesRegistradas++;									// actualiza contador sesiones

						System.out.println("Sesiï¿½n: " + sesionesRegistradas + '\n' +
								"Iniciada por: " + datosUsuarios[i].nombre + " "
								+ datosUsuarios[i].apellidos);
					}
					else {
						intentos--;
						System.out.println("Contraseï¿½a incorrecta... ");
					}

					break; 				//Termina for de busqueda													// Termina bucle de busqueda
				
				} //if nombre
			
			} //for

			if (noEncuentra) {
				intentos--;
				System.out.println("Usuario no vï¿½lido... ");
			}
			
			// Comprueba si se quiere terminar la simulaciï¿½n 
			System.out.print("teclea T para terminar... ");
			if (teclado.nextLine().toUpperCase().equals("T")) 
				seguir = false; 

			// Continï¿½a la simulaciï¿½n si se quiere seguir y hay sitio para nuevas sesiones	
		} while (seguir && intentos > 0 && sesionesRegistradas < sesionesUsuario.length); 

		System.out.println("Fin de la prueba...");

		teclado.close();
		
	}

	
	/**
	 * Muestra por consola todos los usuarios almacenados.
	 */
	private static void mostrarTodosDatosUsuarios() {
		
		for (Usuario u: datosUsuarios)
			System.out.println("\n" + u);
	
	}

	
	/**
	 * //Apartado 4 y 5: Pruebas
	 */
	private static void pruebasPrevias() {
		Scanner teclado = new Scanner(System.in);
		
		// Prueba de la clase Usuario
		
		Usuario usr1;
		
		
		
		Usuario usr2 = new Usuario();
		Usuario usr3 = new Usuario();

		//usr1 = usr2;
		
		//usr1.nombre = "Luis";
		//null.nombre = "Luis";
		
		
		
		usr2.nif = "23456790K";
		usr2.nombre = "Pepe";
		usr2.apellidos = "Lï¿½pez Pï¿½rez";
		usr2.domicilio = "C/Luna, 27 30132 Murcia";
		usr2.correoE = "pepe@gmail.com";
		usr2.fechaNacimiento = "1990.11.12";
		usr2.fechaAlta = "2014.12.3";
		usr2.claveAcceso = "miau";
		usr2.rol = "usuario normal";
		
		usr3.nif = teclado.nextLine();
		usr3.nombre = teclado.nextLine();
		usr3.apellidos = teclado.nextLine();
		usr3.domicilio = teclado.nextLine();
		usr3.correoE = teclado.nextLine();
		usr3.fechaNacimiento = teclado.nextLine();
		usr3.fechaAlta = teclado.nextLine();
		usr3.claveAcceso = teclado.nextLine();
		usr3.rol = teclado.nextLine();
		
		
		usr1 = usr2;
		
		System.out.println(usr1);
		//System.out.println(usr1.nif);
		//System.out.println(usr1.nombre);

		
		SesionUsuario sesion1 = new SesionUsuario();
	
		sesion1.usr = usr2;
		sesion1.fecha = "2014.12.3";
		
		System.out.println(sesion1);
		
	}

	/**
	 * Genera datos de prueba vï¿½lidos dentro 
	 * de los almacenes de datos.
	 */
	private static void cargarDatosPrueba() {
		datosUsuarios[0] = new Usuario();
		
		datosUsuarios[0].nif = "2344556K";
		datosUsuarios[0].nombre = "pepe"; 
		datosUsuarios[0].apellidos = "Lï¿½pez Pï¿½rez";
		datosUsuarios[0].domicilio = "C/Luna, 27 30132 Murcia";
		datosUsuarios[0].correoE = "pepe@gmail.com";
		datosUsuarios[0].fechaNacimiento = "1990.11.12";
		datosUsuarios[0].fechaAlta = "2014.12.3";
		datosUsuarios[0].claveAcceso = "miau";
		datosUsuarios[0].rol = "usuario normal";
		
		for (int i = 1; i < MAX_USUARIOS; i++) {
			
			datosUsuarios[i] = new Usuario();
			
			datosUsuarios[i].nif = i + "344556K";
			datosUsuarios[i].nombre = "pepe" + i; 
			datosUsuarios[i].apellidos = "Lï¿½pez" + " Pï¿½rez" +i ;
			datosUsuarios[i].domicilio = "C/Luna, 27 30132 Murcia";
			datosUsuarios[i].correoE = "pepe" + i + "@gmail.com";
			datosUsuarios[i].fechaNacimiento = "1990.11.12";
			datosUsuarios[i].fechaAlta = "2014.12.3";
			datosUsuarios[i].claveAcceso = "miau" + i;
			datosUsuarios[i].rol = "usuario normal";
		}
		
	}

}

