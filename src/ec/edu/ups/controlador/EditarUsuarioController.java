package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import mysql.jdbc.JDBCTelefonoDAO;
import mysql.jdbc.JDBCUsuarioDAO;

/**
 * Servlet implementation class EditarTelefonoController
 */
@WebServlet("/EditarUsuarioController")
public class EditarUsuarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarUsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cedula =request.getParameter("codigo");
        usuarioDAO = new JDBCUsuarioDAO();
        usuario =usuarioDAO.read(cedula);
       
        request.setAttribute("usuario", usuario);
       
        request.getRequestDispatcher("/editarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "text";
		usuarioDAO = new JDBCUsuarioDAO();
		usuario = new Usuario();
		try {
			System.out.println("Nombre: " + request.getParameter("nombre"));
			usuario.setCedula(String.valueOf(request.getParameter("cedula")));
			usuario.setNombre(String.valueOf(request.getParameter("nombre")));
			usuario.setApellido(String.valueOf(request.getParameter("apellido")));
			usuario.setCorreo(String.valueOf(request.getParameter("correo")));
			usuario.setContrasena(String.valueOf(request.getParameter("contrasena")));
			usuario.setTelefonos(null);
			usuarioDAO.update(usuario);

			url = "/editarUsuario.jsp";
		} catch (Exception e) {
			//url = "/error.jsp";
			e.printStackTrace();
		
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}
