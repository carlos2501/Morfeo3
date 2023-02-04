package org_cpl_cursos.java.servicios;

public class ServicioJdbcException extends RuntimeException {
    public ServicioJdbcException(String message) {
        super(message);
    }

    public ServicioJdbcException(String message, Throwable cause) {
        super(message, cause);
    }
}
