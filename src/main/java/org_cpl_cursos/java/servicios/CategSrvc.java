package org_cpl_cursos.java.servicios;

import org_cpl_cursos.java.modelos.Categoria;
import org_cpl_cursos.java.modelos.Sueno;

import java.util.List;
import java.util.Optional;

public interface CategSrvc {
    List<Categoria> listaCategorias();
    void guardar(Categoria s);
    void borrar(Long id);
}
