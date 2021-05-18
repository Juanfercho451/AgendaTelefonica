package mysql.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDAO {

	@Override
	public void createTable() {
		conexionDos.update("DROP TABLE IF EXISTS TELEFONO");
		conexionDos.update("CREATE TABLE TELEFONO ("
				+ "TEL_CODIGO INT NOT NULL AUTO_INCREMENT,"
				+ "TEL_NUMERO VARCHAR(20),"
				+ "TEL_TIPO VARCHAR(50),"
				+ "TEL_OPERADORA VARCHAR(250),"
				+ "USU_CEDULA VARCHAR(20),"
				+ "PRIMARY KEY(TEL_CODIGO),"
				+ "FOREIGN KEY(USU_CEDULA) REFERENCES USUARIO(USU_CEDULA)"
				+ ") ENGINE=InnoDB AUTO_INCREMENT=1");
	}

	@Override
	public void create(Telefono telefono) {
		// TODO Auto-generated method stub
		conexionDos.update("INSERT INTO TELEFONO VALUES("
		+telefono.getCodigo()+",'"
		+telefono.getNumero()+"','"
		+telefono.getTipo()+"','"
		+telefono.getOperadora()+"','"
		+telefono.getUsuario().getCedula()
		+"');");
	}

	@Override
	public Telefono read(Integer id) {
		// TODO Auto-generated method stub
		JDBCUsuarioDAO jdbcusu = new JDBCUsuarioDAO();
		
		Telefono telefono = null;
		ResultSet rs = conexionDos.query("SELECT * FROM TELEFONO WHERE TEL_CODIGO="+id);
		try {
			if (rs!=null && rs.next()) {
				Usuario usuario = new Usuario();
				
				String numero = rs.getString("TEL_NUMERO");
				String tipo = rs.getString("TEL_TIPO");
				String operadora = rs.getString("TEL_OPERADORA");
				String cedula = rs.getString("USU_CEDULA");
				
				usuario = jdbcusu.read(cedula);
				
				telefono = new Telefono(id,numero, tipo, operadora, usuario);
			}
		} catch (Exception e) {
			System.out.println("Error red telefono: "+e.getMessage());
			return null;
		}
		return telefono;
	}

	@Override
	public void update(Telefono telefono) {
		conexionDos.update("UPDATE TELEFONO SET TEL_NUMERO='"+telefono.getNumero()+"',"
				+"TEL_TIPO='"+telefono.getTipo()+"',"
				+ "TEL_OPERADORA='"+telefono.getOperadora()+"' "
				+ "WHERE TEL_CODIGO="+telefono.getCodigo());
		
	}

	@Override
	public void delete(Telefono telefono) {
		conexionDos.update("DELETE FROM TELEFONO WHERE TEL_CODIGO = "+telefono.getCodigo());
	}

	@Override
	public List<Telefono> find() {
		JDBCUsuarioDAO udao = new JDBCUsuarioDAO();
		
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = conexionDos.query("SELECT * FROM TELEFONO");
		try {
			while (rs.next()) {
				
				Usuario usuario = new Usuario();
				
				int codigo = rs.getInt("TEL_CODIGO");
				String numero = rs.getString("TEL_NUMERO");
				String tipo = rs.getString("TEL_TIPO");
				String operadora = rs.getString("TEL_OPERADORA");
				String cedula = rs.getString("USU_CEDULA");
				
				usuario = udao.read(cedula);
				Telefono telefono = new Telefono(codigo,numero,tipo,operadora,usuario);
				list.add(telefono);
			}
		} catch (Exception e) {
			System.out.println("Error list telefono: "+e.getMessage());
			return null;
		}
		return list;
	}

}
