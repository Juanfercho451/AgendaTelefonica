package ec.edu.ups.test;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;

public class TestCreateTables {

	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuario();
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefono();
		
		usuarioDAO.createTable();
		telefonoDAO.createTable();
		System.out.println("Tablas creadas");
	}

}
