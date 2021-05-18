package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import mysql.jdbc.JDBCTelefonoDAO;

/**
 * Servlet implementation class EliminarTelefonoController
 */
@WebServlet("/EliminarTelefonoController")
public class EliminarTelefonoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Telefono telefono;
       private TelefonoDAO telefonoDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarTelefonoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String url = "";
	        
	        telefono = new Telefono();
	        telefonoDAO = new JDBCTelefonoDAO();
	        try {
	            telefono.setCodigo(Integer.valueOf(request.getParameter("codigo")));
	        
	            telefonoDAO.delete(telefono);
	            url = "/LoginUsuarioController";
	        } catch (Exception e) {
	            url = "/error.jsp";
	        }
	        getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
