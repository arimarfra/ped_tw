package controlador;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.opensymphony.xwork2.ActionSupport;

import modelo.datos.GestorUsuarios;
import modelo.datos.RolUsuario;
import modelo.datos.Usuario;

/**
 * Clase que procesa la petición de creación de un nuevo usuario. 
 * Tras validar los datos y comprobar que el id de usuario no
 * existe, crea un nuevo usuario y devuelve al usuario a la vista
 * de usuario
 * 
 * @author Ariana Martínez
 */

public class CrearUsuarioAction extends ActionSupport {
	
	private GestorUsuarios gestor;
	
	/**
	 * Constructor sin parámetros de la clase
	 * CrearUsuarioAction.
	 */
	public CrearUsuarioAction() {
		this.gestor=new GestorUsuarios();
	}
	
	/**
	 * 
	 */
	public String execute() {
		//RolUsuario rolEnum = identificarRol(rol);
		Usuario usu = new Usuario(idUsuario, password, nombre, apellidos, 
									email, telefono, rol); 
		gestor.crearUsuario(usu);
		Usuario guardado = gestor.getUsuario(idUsuario);
		System.out.println(guardado);
		System.out.println(guardado.getRol());
		return "success";
	}
	
	public void validate() {
		if(!passwordConf.equals(password)) {
			addFieldError("passwordConf",getText("password.distinta"));
		}
		if((!email.contains("@")||(!email.contains(".")))) {
			addFieldError("email", getText("email.invalido"));
		}
		if(gestor.getUsuario(idUsuario)!=null) {
			addFieldError("idUsuario", getText("usuario.existe"));
		}
	}
	
	private String idUsuario;	
	private String password;
	private String passwordConf;
	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;
//	private String rol;
	private RolUsuario rol;
	
	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConf() {
		return password;
	}

	public void setPasswordConf(String password) {
		this.passwordConf = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public RolUsuario getRol() {
		return rol;
	}

//	public void setRol(String rol) {
//		this.rol = rol;
//	}
	
	public void setRol(String rolString) {
		if(rolString.equalsIgnoreCase("admin")){
			rol=RolUsuario.ADMIN;
		} else if (rolString.equalsIgnoreCase("jefe de proyecto")) {
			rol=RolUsuario.JEFE;
		} else {
			rol = RolUsuario.EMPLEADO;
		}
	}

//	private RolUsuario identificarRol(String rolString) {
//		RolUsuario rolEnum = RolUsuario.EMPLEADO;
//		if(rolString.equalsIgnoreCase("admin")){
//			rolEnum=RolUsuario.ADMIN;
//		} else if (rolString.equalsIgnoreCase("jefe de proyecto")) {
//			rolEnum=RolUsuario.JEFE;
//		}
//	}
}
