package protoAgustin;


/** Proyecto: Juego de la vida.
 *  Prototipo1.0.ajp
 *  Implementa el concepto de SesionUsuario según el modelo1
 *  @since: Prototipo1.0
 *  @source: Usuario.java 
 *  @version: 1.0 - 11/12/2014 
 *  @author: agu
 */

public class Usuario {
	public String nif;
	public String nombre;
	public String apellidos;
	public String domicilio;
	public String correoE;
	public String fechaNacimiento;
	public String fechaAlta;
	public String claveAcceso;
	public String rol;
	
	@Override
	public String toString() {
		return "nif: \t\t" + nif + "\nnombre: \t" + nombre + "\napellidos: \t"
				+ apellidos + "\ndomicilio: \t" + domicilio + "\ncorreoE: \t"
				+ correoE + "\nfechaNacimiento:" + fechaNacimiento
				+ "\nfechaAlta: \t" + fechaAlta + "\nclaveAcceso: \t" + claveAcceso
				+ "\nrol: \t\t" + rol ;
	}
}

