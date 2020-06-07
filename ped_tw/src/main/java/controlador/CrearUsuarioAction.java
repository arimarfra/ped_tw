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
//		Usuario usu = new Usuario(idUsuario, password, nombre, apellidos, 
//									email, telefono, rol); 
//		gestor.crearUsuario(usu);
		usuario.setRol(rol);
		gestor.crearUsuario(usuario);
		Usuario guardado = gestor.getUsuario(usuario.getIdUsuario());
		System.out.println(guardado);
		System.out.println(guardado.getRol());
		return "success";
	}
	
	public void validate() {
		if(!passwordConf.equals(usuario.getPassword())) {
			addFieldError("passwordConf",getText("password.distinta"));
		}
		if((!usuario.getEmail().contains("@")||(!usuario.getEmail().contains(".")))) {
			addFieldError("usuario.email", getText("email.invalido"));
		}
		if(gestor.getUsuario(usuario.getIdUsuario())!=null) {
			addFieldError("usuario.idUsuario", getText("usuario.existe"));
		}
	}
	
	public String previoInput() {
		return "success";
	}
	
	private Usuario usuario;
	private String rol;
	private String passwordConf;

	public String getPasswordConf() {
		return passwordConf;
	}

	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario=usuario;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol=rol;
	}	
	
}
