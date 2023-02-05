package org_cpl_cursos.java.repositorios;

import org_cpl_cursos.java.modelos.Sueno;

import java.util.List;

public interface SuenoRepo extends Repositorio<Sueno>{
    List<Sueno> porCategoria(Long idCat);
    List<Sueno> porSonador(Long idProp);
}
