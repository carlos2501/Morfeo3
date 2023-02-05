package org_cpl_cursos.java.utilidades;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBDPool {
    public static Connection abreConexion() throws NamingException, SQLException {
        Context initContext;
        initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource)  envContext.lookup("jdbc/mysqlBD");  // el nombre sale del context.xml
        return ds.getConnection();
    }
}
