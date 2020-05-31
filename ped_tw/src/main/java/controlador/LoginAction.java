package controlador;

import com.opensymphony.xwork2.ActionSupport;

import modelo.datos.GestorUsuarios;

/**
 * Clase que procesa la petición de login generada desde la vista login.jsp.
 * Comprueba que el usuario y contraseña introducidos son correctos. Si lo 
 * son, redirige a la vista de usuario logado. Si no lo son, muestra un
 * error en la pantalla de login
 * 
 * @author Ariana Martínez
 *
 */
public class LoginAction extends ActionSupport {
	
	/**
	 * Constructor sin parámetros.
	 */
	public LoginAction() {
		
	}
	
	
	/**
	 * Método que comprueba si el usuario y contraseña introducidos
	 * son correctos y redirige a la vista correspondiente.
	 * 
	 * El workflow interceptor llamará a este método una vez se haya
	 * ejecutado validate() con éxito.
	 * 
	 * @return	String con el resultado, que está mapeado con la 
	 * ruta de la vista que le corresponde en struts.xml
	 */
	public String execute() {
		GestorUsuarios gu = new GestorUsuarios();
		String resultado="";
		if(gu.validarUsuario(idUsuario, password)) {
			resultado="success";
		} else {
			resultado="input";
		}
		return resultado;
	}
	
	
	/**
	 * Método que valida los datos introducidos en el formulario
	 * antes de llamar a execute. Si se detecta algún dato erróneo
	 * se registra un mensaje de error, que el workflow interceptor
	 * se encargará de mostrar en la vista automáticamente.
	 */
	public void validate() {
		//Comprobamos que el campo usuario no está vacío
		if(getIdUsuario().length()==0) {
			addFieldError("idUsuario", getText("usuario.vacio"));
		}
		//Comprobamos que la contraseña no esté vacía
		if(getPassword().length()==0) {
			addFieldError("password", getText("password.vacia"));
		}
	}
	
	// Java Bean Properties. El interceptor params los popula con 
	// los datos introducidos en el formulario automáticamente.
	
	private String idUsuario;
	private String password;
	
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
	
}
