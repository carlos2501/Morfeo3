package org_cpl_cursos.java.servicios;

import org_cpl_cursos.java.modelos.Sueno;
import org_cpl_cursos.java.repositorios.SuenoRepo;
import org_cpl_cursos.java.repositorios.SuenoRepoImpl;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class SuenoSrvcImpl implements SuenoSrvc{
    private final SuenoRepo repoSueno;

    public SuenoSrvcImpl(Connection conn) {
        this.repoSueno = new SuenoRepoImpl(conn);
    }

    @Override
    public List<Sueno> listaSueno() {
        return repoSueno.listar();
    }

    @Override
    public Optional<Sueno> porId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Sueno> porCategoria(Long idCat) {
        return repoSueno.porCategoria(idCat);
    }

    @Override
    public List<Sueno> porSonador(Long idProp) {
        return repoSueno.porSonador(idProp);
    }

    @Override
    public void guardar(Sueno s) {

    }

    @Override
    public void borrar(Long id) {

    }
}
