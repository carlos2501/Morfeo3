package org_cpl_cursos.java.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String url = "jdbc:mysql://localhost:3306/morfeo";
    private static final String user = "root";
    private static final String clave = "carlospdl%";
    private static Connection conn;

    public static Connection abreConexion() throws SQLException {
        if(conn == null) {
            conn = DriverManager.getConnection(url, user, clave);
            System.out.println("Conexión con BBDD");
        }
        return conn;
    }
}