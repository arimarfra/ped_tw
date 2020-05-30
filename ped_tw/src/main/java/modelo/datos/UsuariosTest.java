package modelo.datos;

import java.util.List;

public class UsuariosTest {


	public static void main(String[] args) {

		GestorUsuarios gu = new GestorUsuarios();

		//Imprimir la lista de usuarios por defecto
		List<Usuario> usuarios = gu.getListaUsuarios();
		for(Usuario u:usuarios) {
			System.out.println(u);
		}

		//Crear un usuario
		Usuario usu1 = new Usuario("juandigomez", "mahou", "juan diego", "gomez", "juandiego@mail.com", "666777888", RolUsuario.ADMIN);	
		gu.crearUsuario(usu1);

		//Buscar un usuario por id
		Usuario usu2=gu.getUsuario("jaraquin");
		System.out.println("Recuperado de la BBDD el usuario: " + usu2);

		//Imprimir la lista de usuarios por actualizada
		usuarios = gu.getListaUsuarios();
		for(Usuario u:usuarios) {
			System.out.println(u);
		}


		//Validar usuarios
		boolean[] validaciones = {gu.validarUsuario("arimarfra", "guiness"), gu.validarUsuario("arimarfra", "wrong"), gu.validarUsuario("mimimi", "mimimi")};
		int i=1;
		for(boolean val: validaciones) {
			if(val) {
				System.out.println(i + ". Validado");
			} else {
				System.out.println(i + ". No validado");
			}
			i++;
		}

	}
}
