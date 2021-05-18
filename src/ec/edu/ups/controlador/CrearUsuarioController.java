package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class CrearUsuarioController
 */
@WebServlet("/CrearUsuarioController")
public class CrearUsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearUsuarioController() {
		super();
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			System.out.println("Nombre: " + request.getParameter("nombre"));

			if (verificarCedula(String.valueOf(request.getParameter("cedula"))) == true) {
				System.out.println("Nombre: " + request.getParameter("cedula"));
				usuario.setCedula(String.valueOf(request.getParameter("cedula")));
				usuario.setNombre(String.valueOf(request.getParameter("nombre")));
				usuario.setApellido(String.valueOf(request.getParameter("apellido")));
				usuario.setCorreo(String.valueOf(request.getParameter("email")));
				usuario.setContrasena(String.valueOf(request.getParameter("pass")));
				usuario.setTelefonos(null);
				usuarioDAO.create(usuario);
				url = "/principal.jsp";

			} else {
				System.out.println("CEDULA INCORRECTA");
				url = "/errorCedula.jsp";
			}

		} catch (

		Exception e) {
			url = "/error.jsp";
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	public boolean verificarCedula(String cedula) {
		int total = 0;
		int tamanoLongitudCedula = 10;
		int[] coeficientes = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
		int numeroProviancias = 24;
		int tercerdigito = 6;
		if (cedula.matches("[0-9]*") && cedula.length() == tamanoLongitudCedula) {
			int provincia = Integer.parseInt(cedula.charAt(0) + "" + cedula.charAt(1));
			int digitoTres = Integer.parseInt(cedula.charAt(2) + "");
			if ((provincia > 0 && provincia <= numeroProviancias) && digitoTres < tercerdigito) {
				int digitoVerificadorRecibido = Integer.parseInt(cedula.charAt(9) + "");
				for (int i = 0; i < coeficientes.length; i++) {
					int valor = Integer.parseInt(coeficientes[i] + "") * Integer.parseInt(cedula.charAt(i) + "");
					total = valor >= 10 ? total + (valor - 9) : total + valor;
				}
				int digitoVerificadorObtenido = total >= 10 ? (total % 10) != 0 ? 10 - (total % 10) : (total % 10)
						: total;
				if (digitoVerificadorObtenido == digitoVerificadorRecibido) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public static boolean ValidarMail(String email) {

		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);
		return mather.find();
	}

}