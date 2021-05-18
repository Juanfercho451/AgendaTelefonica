package ec.edu.ups.test;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;

public class TestTelefono {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefono();
		telefonoDAO.createTable();
	}

}
