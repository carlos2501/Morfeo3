package org_cpl_cursos.java.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org_cpl_cursos.java.modelos.Sueno;
import org_cpl_cursos.java.servicios.SuenoSrvc;
import org_cpl_cursos.java.servicios.SuenoSrvcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/usuarios/suenos")
public class SuenosUsuSrvlt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SuenoSrvc suenoSrvc = new SuenoSrvcImpl((Connection) req.getAttribute("conn"));
        List<Sueno> suenosUsu = suenoSrvc.porSonador(Long.valueOf(req.getParameter("id")));
        req.setAttribute("sueños", suenosUsu);
        req.setAttribute("soñador", Long.valueOf(req.getParameter("id")));
        getServletContext().getRequestDispatcher("/suenosUsuario.jsp").forward(req, resp);
    }

}
