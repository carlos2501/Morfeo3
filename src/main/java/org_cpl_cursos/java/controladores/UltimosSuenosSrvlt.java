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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/suenos/ultimos")
public class UltimosSuenosSrvlt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SuenoSrvc suenoSrvc = new SuenoSrvcImpl((Connection) req.getAttribute("conn"));
        List<Sueno> ultSuenos = null;
        try {
            ultSuenos = suenoSrvc.ultimosSuenos(20);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("sueños", ultSuenos);
        getServletContext().getRequestDispatcher("/templates/ultimosSuenos.jsp").forward(req, resp);
    }

}
