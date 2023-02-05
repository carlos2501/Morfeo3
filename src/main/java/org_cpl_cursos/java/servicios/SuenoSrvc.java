package org_cpl_cursos.java.servicios;

import org_cpl_cursos.java.modelos.Sueno;
import org_cpl_cursos.java.modelos.Usuario;

import java.util.List;
import java.util.Optional;

public interface SuenoSrvc {
    List<Sueno> listaSueno();
    Optional<Sueno> porId(Long id);
    List<Sueno> porCategoria(Long idcat);
    List<Sueno> porSonador(Long idProp);
    void guardar(Sueno s);
    void borrar(Long id);
}
