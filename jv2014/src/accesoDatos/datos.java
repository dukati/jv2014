package accesoDatos;

import modelo.SesionUsuario;
import modelo.Usuario;

public class datos {
	
	public static final int MAX_USUARIOS = 10;
	public static final int MAX_SESIONES = 10;
	
	public static Usuario[] datosUsuarios = new Usuario[MAX_USUARIOS];
	public static SesionUsuario[] sesionesUsuario = new SesionUsuario[MAX_SESIONES];

	public static void main(String[] args) {
	
			
			cargarDatosUsuario();	
			
			//mostrar Todos Datos Usuarios
			mostrarDatosUsuarios();
			
			
	
	}
	/**
	 * Genera datos de prueba vï¿½lidos dentro 
	 * de los almacenes de datos.
	 */
	public static void cargarDatosUsuario() {
		
		
		
		
		for (int i = 0; i < MAX_USUARIOS; i++) {
			
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
	
	/**
	 * Muestra por consola todos los usuarios almacenados.
	 */
	public static void mostrarDatosUsuarios() {
		
		for (Usuario u: datos.datosUsuarios)
			System.out.println("\n" + u);
	
	}
	
	
}
