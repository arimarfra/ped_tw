package modelo.datos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase para gestionar una SessionFactory, utilizada para obtener sesiones
 * en Hibernate.
 * 
 * Nos va a permitir tener una sola instancia de SessionFactory a la que podremos
 * llamar desde distintas clases de la app para crear sesiones cuando necesitemos
 * interactuar con la base de datos.
 * 
 * @author ariana martinez
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;

	//Inicializamos la SessionFactory
	//Este método se llamará la primera vez que la clase sea cargada
	static {
		sessionFactory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		cargarDatosDemo();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
	
	private static void cargarDatosDemo() {
		Usuario u1 = new Usuario("arimarfra", "guiness", "ariana", "martinez", "ari@mail.com", "111222333", RolUsuario.ADMIN);
		Usuario u2 = new Usuario("marloz", "cruzcampo", "maria", "lozano", "maria@mail.com", "222333444", RolUsuario.JEFE);
		Usuario u3 = new Usuario("guiheralf", "aguila", "guillermo", "hernandez", "guille@mail.com", "333444555", RolUsuario.EMPLEADO);
		Usuario u4 = new Usuario("jaraquin", "gazpacho", "jara", "quintana", "jara@mail.com", "444555666", RolUsuario.EMPLEADO);
		
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(u1);
			session.save(u2);
			session.save(u3);
			session.save(u4);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
}
