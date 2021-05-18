package ec.edu.ups.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;


@WebFilter({"/editarUsuario.jsp" , "/crearTelefono.jsp", "/inicio_usuario.jsp","/EditarUsuarioController"})
//@WebFilter({"/inicio_usuario.jsp","/crearTelefono.jsp","/login.jsp","/register.jsp" ,"/editarUsuario.jsp","/editarTelefono.jsp",
//"/LoginUsuarioController","/EditarUsuarioController","/EditarTelefonoController","/BuscarUsuarioContactoController",
//"/BuscarUsuarioContactoController1", "/CrearTelefonoController", "/CrearUsuarioController"})
public class Fitro implements Filter{
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;
	
	public Fitro() {
		// TODO Auto-generated constructor stub
		super();
        usuarioDAO = DAOFactory.getFactory().getUsuario();
		usuario = new Usuario();
	}
	
	public void destroy(){
		System.out.println("Destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long inicio = System.currentTimeMillis();
		System.out.println("INFO: Tiempo de proceso ("+(System.currentTimeMillis() - inicio)+"ms");
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		if (session.getAttribute("usuario") != null) {
			
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse)response).sendRedirect("/AgendaTelefonica/login.jsp");
		}
		
		/*HttpSession session = ((HttpServletRequest)request).getSession();
		System.out.println("Session: "+session.getAttribute("usuario"));
		if (session.getAttribute("usuario")!=null) {
			try {
				Usuario utemp = new Usuario();
				utemp = (Usuario)session.getAttribute("usuario");
				usuario = usuarioDAO.read(utemp.getCedula());
				chain.doFilter(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Erro en filtro validando login: "+e.getMessage());
				session.invalidate();
				((HttpServletResponse)response).sendRedirect("/AgendaTelefonica/login.jsp");
			}		
		}else {
			((HttpServletResponse)response).sendRedirect("/AgendaTelefonica/principal.jsp");
			session.invalidate();
			System.out.println("Debe iniciar secion para ingresar a cualquier pagina");
		}*/
	}	
}
