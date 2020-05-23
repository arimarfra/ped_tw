package modelo.datos;

import java.util.List;

import org.hibernate.Session;

/**
 * Clase que gestiona los usuarios de la aplicación.
 * Interactúa con la base de datos HSQLDB para crear,
 * leer, modificar o eliminar usuarios.
 * 
 * @author ariana martinez
 */
public class GestorUsuarios {


	public GestorUsuarios() {

	}

	/**
	 * Método para crear un usuario. Guarda el nuevo usuario
	 * en la base de datos.
	 * 
	 * @param idUsuario
	 * @param password
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param telefono
	 * @param rol
	 */
	public void crearUsuario(String idUsuario, String password, String nombre, String apellidos, String email, String telefono,
			RolUsuario rol) {

		Usuario usuario=new Usuario(idUsuario, password, nombre, apellidos, email, telefono, rol);
		
		crearUsuario(usuario);
		
	}
	
	public void crearUsuario(Usuario usuario) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método para recuperar un usuario de la base de datos
	 * 
	 * @param idUsuario		El id de usuario
	 * @return el usuario recuperado
	 */
	public Usuario getUsuario(String idUsuario) {
		Usuario usuario = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			usuario=session.get(Usuario.class, idUsuario);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return usuario;
	}
	
	/**
	 * Método que devuelve la lista de todos los usuarios
	 * de la base de datos
	 */
	public List<Usuario> getListaUsuarios(){
		List<Usuario> usuarios=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			usuarios = session.createQuery("from Usuario").getResultList();
			return usuarios;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return usuarios;
		
	}
	
	/**
	 * Método para validar un usuario. Recibe el id y la contraseña, y devuelve
	 * un booleano si los datos son correctos
	 * 
	 * @param idUsuario     El id del usuario
	 * @param password      La contraseña del usuario
	 * @return	true si el usuario y contraseña son válidos
	 */
	public boolean validarUsuario(String idUsuario, String password) {
		boolean validado=false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Usuario usuario = session.get(Usuario.class, idUsuario);
			if(usuario!=null) {
				validado=usuario.getPassword().equals(password);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return validado;
	}
}
