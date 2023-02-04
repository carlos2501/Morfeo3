package org_cpl_cursos.java.repositorios;

import org_cpl_cursos.java.modelos.Usuario;

import java.sql.SQLException;

public interface UsuarioRepo extends Repositorio<Usuario>{
     Usuario porNombreUsuario(String nombre) throws SQLException;
}

