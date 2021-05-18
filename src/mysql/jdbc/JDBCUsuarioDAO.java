package mysql.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, String> implements UsuarioDAO {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		conexionUno.update("DROP TABLE IF EXISTS Usuario");
		conexionUno.update("CREATE TABLE Usuario (" 
		+ "USU_CEDULA VARCHAR(20) NOT NULL,"
		+ "USU_NOMBRE VARCHAR(255) NOT NULL, "
		+ "USU_APELLIDO VARCHAR(255) NOT NULL,"
		+ "USU_CORREO VARCHAR(255) NOT NULL UNIQUE,"
		+ "USU_CONTRASENA VARCHAR(255) NOT NULL,"
		+ "PRIMARY KEY (USU_CEDULA))");

	}

	@Override
	public void create(Usuario usuario) {
		// TODO Auto-generated method stub
		JDBCTelefonoDAO jdbctel = new JDBCTelefonoDAO();

		conexionUno.update("INSERT INTO USUARIO VALUES('" + usuario.getCedula() + "','" + usuario.getNombre() + "','"
				+ usuario.getApellido() + "','" + usuario.getCorreo() + "','" + usuario.getContrasena() + "');");

		if (usuario.getTelefonos() != null && (usuario.getTelefonos().size())>0) {
			List<Telefono> list = new ArrayList<Telefono>();

			list = usuario.getTelefonos();
			for (Telefono telefono : list) {
				jdbctel.create(telefono);
			}
		}
	}

	@Override
	public Usuario read(String cedula) {
		// TODO Auto-generated method stub
		JDBCTelefonoDAO jdbctel = new JDBCTelefonoDAO();

		Usuario usuario = null;
		ResultSet rs = conexionUno.query("SELECT * FROM USUARIO WHERE USU_CEDULA='" + cedula+"'");
		try {
			if (rs != null && rs.next()) {
				
				String nombre = rs.getString("USU_NOMBRE");
				String apellido = rs.getString("USU_APELLIDO");
				String correo = rs.getString("USU_CORREO");
				String contrasenia = rs.getString("USU_CONTRASENA");
				
				usuario = new Usuario(cedula, nombre, apellido, correo, contrasenia, null);
				
			}
		} catch (Exception e) {
			System.out.println("Error read usuario=>" + e.getMessage());
			return null;
		}
		return usuario;
	}

	@Override
	public void update(Usuario usuario) {
		conexionUno.update("UPDATE USUARIO SET "
	                + "	usu_nombre = '" + usuario.getNombre() + "',"
	                + "	usu_apellido = '" + usuario.getApellido() + "',"
	                + " usu_correo ='" + usuario.getCorreo() +"',"
	                + "	usu_contrasena  = '" + usuario.getContrasena() + "'"
	                + "	WHERE usu_cedula = '" + usuario.getCedula() + "';");
	}
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		conexionUno.update("DELETE FROM USUARIO WHERE USU_CEDULA='" + usuario.getCedula() + "';");
	}

	@Override
	public List<Usuario> find() {
		// TODO Auto-generated method stub
		JDBCTelefonoDAO jdbctel = new JDBCTelefonoDAO();

		List<Usuario> list = new ArrayList<Usuario>();
		ResultSet rs = conexionUno.query("SELECT * FROM USUARIO");
		try {
			while (rs.next()) {
				List<Telefono> listel = new ArrayList<Telefono>();

				String cedula = rs.getString("USU_CEDULA");
				String nombre = rs.getString("USU_NOMBRE");
				String apellido = rs.getString("USU_APELLIDO");
				String correo = rs.getString("USU_CORREO");
				String cont = rs.getString("USU_CONTRASENA");

				Usuario usuario = new Usuario(cedula, nombre, apellido, correo, cont, listel);
				list.add(usuario);
			}
		} catch (Exception e) {
			System.out.println("Error listar usuarios: " + e.getMessage());
		}
		return list;
	}
}
