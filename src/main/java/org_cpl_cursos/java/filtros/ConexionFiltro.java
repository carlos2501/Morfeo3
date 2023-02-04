package org_cpl_cursos.java.filtros;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org_cpl_cursos.java.servicios.ServicioJdbcException;
import org_cpl_cursos.java.utilidades.ConexionBD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionFiltro implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        try(Connection conn = ConexionBD.abreConexion()) {
            // Aseguramos que ponemos la nueva conexión en modo "transacción"
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try {
                req.setAttribute("conn", conn);  // pasamos la conexión a los siguientes elementos de la cadena mediante la request
                chain.doFilter(req, resp); // se ejecuta el siguiente elemento (filtro o servlet de la cadena)
                conn.commit();  // finalizo la transacción y se graba el resultado en la BBDD.
            } catch (SQLException | ServicioJdbcException e){
                conn.rollback(); // Si hay un error con la transacción, se deshace
                // Como el ServletRequest no tiene acceso al método sendError, encapsulamos la respuesta como HTTPServletRequest, que sí lo tiene
                ((HttpServletResponse)resp).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
