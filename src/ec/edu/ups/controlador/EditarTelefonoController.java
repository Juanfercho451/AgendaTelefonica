package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import mysql.jdbc.JDBCTelefonoDAO;
import mysql.jdbc.JDBCUsuarioDAO;

/**
 * Servlet implementation class EditarTelefonoController
 */
@WebServlet("/EditarTelefonoController")
public class EditarTelefonoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telefonoDAO;
	private Telefono telefono;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarTelefonoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo =Integer.valueOf(request.getParameter("codigo"));
        telefonoDAO = new JDBCTelefonoDAO();
         telefono =telefonoDAO.read(codigo);
       
        request.setAttribute("telefonoM", telefono);
       
        request.getRequestDispatcher("/editarTelefono.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "text";
		telefonoDAO = new JDBCTelefonoDAO();
		telefono = new Telefono();
		try {
			System.out.println("Codigo: " + request.getParameter("codigo"));
			telefono.setCodigo(Integer.parseInt(request.getParameter("codigo")));
			telefono.setNumero(String.valueOf(request.getParameter("numero")));
			telefono.setTipo(String.valueOf(request.getParameter("tipo")));
			telefono.setOperadora(String.valueOf(request.getParameter("operadora")));
			
			telefonoDAO.update(telefono);
			request.setAttribute("telefonoM", telefono);

			url = "/editarTelefono.jsp";
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	}

