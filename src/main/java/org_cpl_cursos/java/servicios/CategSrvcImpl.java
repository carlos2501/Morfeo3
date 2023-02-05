package org_cpl_cursos.java.servicios;

import org_cpl_cursos.java.modelos.Categoria;
import org_cpl_cursos.java.repositorios.CategRepo;
import org_cpl_cursos.java.repositorios.CategRepoImpl;
import org_cpl_cursos.java.repositorios.Repositorio;
import org_cpl_cursos.java.repositorios.SuenoRepo;

import java.sql.Connection;
import java.util.List;

public class CategSrvcImpl implements CategSrvc{
    private final Repositorio<Categoria> repoCateg;

    public CategSrvcImpl(Connection conn) {
        this.repoCateg = new CategRepoImpl(conn);
    }

    @Override
    public List<Categoria> listaCategorias() {
        return this.repoCateg.listar();
    }

    @Override
    public void guardar(Categoria s) {

    }

    @Override
    public void borrar(Long id) {

    }
}
