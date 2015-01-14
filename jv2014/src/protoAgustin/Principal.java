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

import modelo.SesionUsuario;
import modelo.Usuario;
import accesoDatos.datos;


/**
* @author admin
* 
*/
public class Principal {
	
	public static void main(String[] args) {
		
		datos.cargarDatosUsuario();
		
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
			for (int i = 0; i < datos.MAX_USUARIOS && datos.datosUsuarios[i] != null; i++) { 					//recorrer vector

				//compara nombre
				if (datos.datosUsuarios[i].nombre.equals(credencialUsuario)) { 		//Si encontrado 
					noEncuentra  = false;

					//comprueba clave
					if (datos.datosUsuarios[i].claveAcceso.equals(password)) {		//Si coincide

						// Registra sesiÃ³n
						datos.sesionesUsuario[sesionesRegistradas] = new SesionUsuario();
						datos.sesionesUsuario[sesionesRegistradas].usr = datos.datosUsuarios[i];
						datos.sesionesUsuario[sesionesRegistradas].fecha = new Date().toString();

						sesionesRegistradas++;									// actualiza contador sesiones

						System.out.println("Sesiï¿½n: " + sesionesRegistradas + '\n' +
								"Iniciada por: " + datos.datosUsuarios[i].nombre + " "
								+ datos.datosUsuarios[i].apellidos);
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
		} while (seguir && intentos > 0 && sesionesRegistradas < datos.sesionesUsuario.length); 

		System.out.println("Fin de la prueba...");

		teclado.close();
		
	}

	
	/**
	 * Muestra por consola todos los usuarios almacenados.
	 */
	private static void mostrarTodosDatosUsuarios() {
		
		for (Usuario u: datos.datosUsuarios)
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

}

