package org_cpl_cursos.java.servicios;


import org_cpl_cursos.java.modelos.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioSrvc {
    List<Usuario> listaUsu();
    Optional<Usuario> porId(Long id);
    void guardar(Usuario prod);
    void borrar(Long id);
    Optional<Usuario> login(String username, String password);
}
