package org_cpl_cursos.java.servicios;


import org_cpl_cursos.java.modelos.Usuario;
import org_cpl_cursos.java.repositorios.Repositorio;
import org_cpl_cursos.java.repositorios.UsuarioRepo;
import org_cpl_cursos.java.repositorios.UsuarioRepoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsuarioSrvcImpl implements UsuarioSrvc{
    private UsuarioRepo repoUsu;

    public UsuarioSrvcImpl(Connection conn) {
        this.repoUsu = new UsuarioRepoImpl(conn);
    }

    @Override
    public List<Usuario> listaUsu() {
        return repoUsu.listar();
    }

    @Override
    public Optional<Usuario> porId(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Usuario prod) {

    }

    @Override
    public void borrar(Long id) {

    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(repoUsu.porNombreUsuario(username)).filter(u -> u.getClave().equals(password));
        } catch (SQLException e) {
            throw new ServicioJdbcException(e.getMessage(),e.getCause());
        }
    }
}
