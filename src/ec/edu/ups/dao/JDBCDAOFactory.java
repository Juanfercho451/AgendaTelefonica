package ec.edu.ups.dao;

import mysql.jdbc.JDBCTelefonoDAO;
import mysql.jdbc.JDBCUsuarioDAO;

public class JDBCDAOFactory extends DAOFactory{

	@Override
	public void createTable() {
		this.getUsuario().createTable();
	}

	@Override
	public UsuarioDAO getUsuario() {
		// TODO Auto-generated method stub
		return new JDBCUsuarioDAO();
	}

	@Override
	public TelefonoDAO getTelefono() {
		// TODO Auto-generated method stub
		return new JDBCTelefonoDAO();
	}
}
