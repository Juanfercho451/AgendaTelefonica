package ec.edu.ups.test;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

public class TestUsuario {

	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuario();
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefono();
		
		usuarioDAO.createTable();
		telefonoDAO.createTable();
		
		Usuario u1;
		
		Telefono t1, t2, t3,t4;
		List<Telefono> listel = new ArrayList<Telefono>();
		u1 = new Usuario("0106405948", "Angel", "Jadan", "ajadanc@est.ups.edu.ec", "Angel2002", listel);
		
		t1 = new Telefono(1, "0990527381", "CELULAR", "Claro", u1);
		listel.add(t1);
		t2 = new Telefono(2, "0990515471", "CELULAR", "Movistar", u1);
		listel.add(t2);
		t3 = new Telefono(3, "0990526561", "CELULAR", "CNT", u1);
		listel.add(t3);
		t4 = new Telefono(4, "072328069", "CELULAR", "Etapa", u1);
		listel.add(t4);
		//u1.setTelefonos(listel);
				
		usuarioDAO.create(u1);
		
		System.out.println("--Creación de usuarios \n--"+usuarioDAO.find());
		
	}

}
