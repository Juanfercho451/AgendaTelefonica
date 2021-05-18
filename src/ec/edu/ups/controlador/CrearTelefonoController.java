package ec.edu.ups.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class CrearTelefonoController
 */
@WebServlet("/CrearTelefonoController")
public class CrearTelefonoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TelefonoDAO telefonoDAO;
	private Telefono telefono;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearTelefonoController() {
		super();
		// TODO Auto-generated constructor stub
		telefonoDAO = DAOFactory.getFactory().getTelefono();
		telefono = new Telefono();
		usuarioDAO = DAOFactory.getFactory().getUsuario();
		usuario = new Usuario();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		try {
			System.out.println("Guardando...");
			String ced = request.getParameter("usuario");
			System.out.println("Cedula: "+ced);
			usuario = usuarioDAO.read(ced);
			System.out.println("Usuario: "+usuario.toString());
			if (usuario!=null) {
				String numero = request.getParameter("numero");
				String tipo = request.getParameter("tipo");
				String operadora = request.getParameter("operadora");
				telefono.setCodigo(0);
				telefono.setNumero(numero);
				telefono.setTipo(tipo);
				telefono.setOperadora(operadora);
				telefono.setUsuario(usuario);
				telefonoDAO.create(telefono);
				response.sendRedirect("/AgendaTelefonica/crearTelefono.jsp");
				
			}else {
				System.out.println("Usuario no encontrado.");
				url = "/error.jsp";
			}
		} catch (Exception e) {
			System.out.println("Error crear telefono=> "+e.getMessage());
			url = "/error.jsp";
		}
		getServletContext().getRequestDispatcher(url);
	}

}
