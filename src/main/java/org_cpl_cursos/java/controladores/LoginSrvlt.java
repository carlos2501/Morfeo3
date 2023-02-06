package org_cpl_cursos.java.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org_cpl_cursos.java.modelos.Usuario;
import org_cpl_cursos.java.servicios.UsuarioSrvc;
import org_cpl_cursos.java.servicios.UsuarioSrvcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/acceder")
public class LoginSrvlt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Leemos si existe usuario en la sesión
        //LoginSrvc autoriz = new LoginSrvcImpl();
        //Optional<String> usu = autoriz.leerUsuario(req);
        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("usuario");
        String password = req.getParameter("clave");

        UsuarioSrvc service = new UsuarioSrvcImpl((Connection) req.getAttribute("conn"));
        Optional<Usuario> usuario = service.login(username, password);
        if (usuario.isPresent()) {
            HttpSession session = req.getSession();
            /*
                ¡ATENCIÓN! Lo siguiente es inseguro. La clave está en los datos del usuario.
                O bien se pone solo el nombre, o bien se usa un DTO en la opción de login para no guardar la clave.
                La siguiente línea se deja como está solamente a efectos ilustrativos.
             */
            //session.setAttribute("usuario", usuario);
            session.setAttribute("nombreusuario", usuario.get().getNombre());
            session.setAttribute("idusuario", usuario.get().getId());

            resp.sendRedirect(req.getContextPath() + "/index.html");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
        }
    }
}
