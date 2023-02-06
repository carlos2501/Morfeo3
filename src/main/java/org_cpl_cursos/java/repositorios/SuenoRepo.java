package org_cpl_cursos.java.repositorios;

import org_cpl_cursos.java.modelos.Sueno;

import java.sql.SQLException;
import java.util.List;

public interface SuenoRepo extends Repositorio<Sueno>{
    List<Sueno> porCategoria(Long idCat);
    List<Sueno> porSonador(Long idProp);
    List<Sueno> ultimosSuenos(int cantidad) throws SQLException;
}
