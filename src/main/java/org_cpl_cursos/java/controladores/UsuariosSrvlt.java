package org_cpl_cursos.java.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org_cpl_cursos.java.modelos.Usuario;
import org_cpl_cursos.java.servicios.SuenoSrvc;
import org_cpl_cursos.java.servicios.SuenoSrvcImpl;
import org_cpl_cursos.java.servicios.UsuarioSrvc;
import org_cpl_cursos.java.servicios.UsuarioSrvcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/usuarios/lista")
public class UsuariosSrvlt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Pasamos al service la conexión que recibimos en req (creada por el ConexionFiltro)
        // req.Atribute devuelve una clase Object, por eso hay que envolver el resultado como un objeto de la clase Connection
        UsuarioSrvc usuService = new UsuarioSrvcImpl((Connection) req.getAttribute("conn"));

        List<Usuario> usuarios = usuService.listaUsu();
    /*
        LoginSrvc auth = new LoginSrvcSessionImpl();
        Optional<Usuario> usu = auth.getUsuario(req);
    */
        req.setAttribute("usuarios", usuarios);
        //System.out.println(usuarios);
        //req.setAttribute("usuario", usu.get().getNombre());
        getServletContext().getRequestDispatcher("/listaUsuarios.jsp").forward(req, resp);
    }
}


