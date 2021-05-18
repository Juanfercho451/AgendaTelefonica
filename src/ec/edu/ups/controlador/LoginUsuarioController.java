package ec.edu.ups.controlador;

import java.io.IOException;
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
 * Servlet implementation class LoginUsuarioController
 */
@WebServlet("/LoginUsuarioController")
public class LoginUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;
	private TelefonoDAO telefonoDAO;
	private Telefono telefono;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUsuarioController() {
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
		HttpSession session = request.getSession(true);
		System.out.println("Conculta. " + request);
		if (request.getParameter("logout") != null) {
			session.invalidate();
			response.sendRedirect("/AgendaTelefonica/principal.jsp");
			System.out.println("secion cerrada con exito");

		} else {

			usuario = (Usuario) session.getAttribute("usuario");
			List<Telefono> telns = new ArrayList<Telefono>();
			for (Telefono telefono : telefonoDAO.find()) {
				if (telefono.getUsuario().getCedula().equals(usuario.getCedula())) {
					telns.add(telefono);
				}
			}
			request.setAttribute("telefonos", telns);

			getServletContext().getRequestDispatcher("/inicio_usuario.jsp").forward(request, response);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;

		int num = 0;
		response.setContentType("text/jsp");

		try {

			String mail = String.valueOf(request.getParameter("mail"));
			String pass = String.valueOf(request.getParameter("pass"));

			System.out.println("Iniciando...");
			HttpSession session = request.getSession(true);
			List<Usuario> list = new ArrayList<Usuario>();
			list = usuarioDAO.find();

			System.out.println("Listado " + list.toString());
			url = "/principal.jsp";
			if (list != null) {
				for (Usuario usuario : list) {
					System.out.println("Usuario allado" + usuario.toString());
					System.out.println("Datos ingresados email: " + mail + " pass: " + pass);
					System.out.println(
							"Datos recuperados email: " + usuario.getCorreo() + " pass: " + usuario.getContrasena());

					if (usuario.getContrasena().equals(pass) && usuario.getCorreo().equals(mail)) {
						System.out.println("Logiado");
						session.setAttribute("usuario", usuario);

						if (session.isNew()) {
							session.setAttribute("accesos", 1);
						} else {
							session.setAttribute("accesos", num + 1);
						}
						System.out.println("Iniciando session");
						request.setAttribute("usuario", usuario);
						List<Telefono> telns = new ArrayList<Telefono>();
						for (Telefono telefono : telefonoDAO.find()) {
							if (telefono.getUsuario().getCedula().equals(usuario.getCedula())) {
								telns.add(telefono);
							}
						}
						request.setAttribute("telefonos", telns);

						url = "/inicio_usuario.jsp";
						System.out.println(url);
						break;
						// response.sendRedirect(url);
					}
				}
			} else {
				session.invalidate();
				System.out.println("Usuario o clave incorrecta.");
				url = "/principal.jsp";
			}

		} catch (Exception e) {
			url = "/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}