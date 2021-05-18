package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import mysql.jdbc.JDBCTelefonoDAO;

/**
 * Servlet implementation class RegresarControler
 */
@WebServlet("/RegresarControler")
public class RegresarControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private TelefonoDAO telefonoDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegresarControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Usuario usuario =(Usuario)request.getSession().getAttribute("usuario");
		telefonoDAO = new JDBCTelefonoDAO();
		
		List<Telefono> telns = new ArrayList<Telefono>();
		for (Telefono telefono : telefonoDAO.find()) {
			if (telefono.getUsuario().getCedula().equals(usuario.getCedula())) {
				telns.add(telefono);
			}
		}
		request.setAttribute("telefonos", telns);
		request.getRequestDispatcher("/inicio_usuario.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
