package ec.edu.ups.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class BuscarUsuarioContactoController
 */
@WebServlet("/BuscarUsuarioContactoController")
public class BuscarUsuarioContactoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;
	private TelefonoDAO telefonoDAO;
	private Telefono telefono;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscarUsuarioContactoController() {
		super();
		usuarioDAO = DAOFactory.getFactory().getUsuario();
		usuario = new Usuario();

		telefonoDAO = DAOFactory.getFactory().getTelefono();
		telefono = new Telefono();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		String identificador = request.getParameter("identificacion");
		String uscedula = request.getParameter("cedula");
		System.out.println("cedula usuario " + uscedula);
		for (Usuario user : usuarioDAO.find()) {
			if (user.getCedula().equals(uscedula)) {
			} else {
				if (user.getCedula().equals(identificador) || user.getCorreo().equals(identificador)) {
					usuario = user;
					List<Telefono> telefonos = new ArrayList<Telefono>();
					for (Telefono telefono : telefonoDAO.find()) {
						if (telefono.getUsuario().getCedula().equals(usuario.getCedula())) {
							telefonos.add(telefono);
						}
					}
					System.out.println("Telefonos: " + telefonos.toString());
					user.setTelefonos(telefonos);
					request.setAttribute("contacto", user);
					System.out.println(user);
					url = "/principal.jsp";
					break;
				}
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}