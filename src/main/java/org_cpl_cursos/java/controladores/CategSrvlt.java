package org_cpl_cursos.java.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org_cpl_cursos.java.modelos.Categoria;
import org_cpl_cursos.java.modelos.Usuario;
import org_cpl_cursos.java.servicios.CategSrvc;
import org_cpl_cursos.java.servicios.CategSrvcImpl;
import org_cpl_cursos.java.servicios.UsuarioSrvc;
import org_cpl_cursos.java.servicios.UsuarioSrvcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/categorias/lista")
public class CategSrvlt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategSrvc catSrvc = new CategSrvcImpl((Connection) req.getAttribute("conn"));

        List<Categoria> categs =catSrvc.listaCategorias();

        req.setAttribute("categorias", categs);
        getServletContext().getRequestDispatcher("/listaCategorias.jsp").forward(req, resp);
    }
}
