package modelo.datos;

import javax.persistence.*;
/**
 * Clase que representa a un usuario de la aplicación.
 * 
 * @author ariana martinez
 */


@Entity
@Table(name="Usuarios")
public class Usuario {

	@Id
	@Column(name="id_usuario")
	private String idUsuario;
	
	@Column(name="password")
	private String password;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefono")
	private String telefono;
	
	@Enumerated(EnumType.STRING)
	@Column(name="rol")
	private RolUsuario rol;
	
	
	
	public Usuario() {
		
	}
	

	public Usuario(String idUsuario, String password, String nombre, String apellidos, String email, String telefono,
			RolUsuario rol) {
		this.idUsuario = idUsuario;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.rol = rol;
	}

   // Getters y setters
	public String getidUsuario() {
		return idUsuario;
	}

	public void setidUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setRol(RolUsuario rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
}
