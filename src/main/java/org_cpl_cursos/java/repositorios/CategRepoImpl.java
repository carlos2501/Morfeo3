package org_cpl_cursos.java.repositorios;

import org_cpl_cursos.java.modelos.Categoria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategRepoImpl implements Repositorio<Categoria> {
    private final Connection conn;

    public CategRepoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();

        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categorias c ;")) {
            while (rs.next()) {
                Categoria c = cargaCategoria(rs);
                categorias.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categorias;
    }

    @Override
    public Categoria porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Categoria categoria) {

    }

    @Override
    public void borrar(Long id) {

    }

    private Categoria cargaCategoria(ResultSet rs) throws SQLException {
        // creamos una variable local del tipo que hay que devoolver
        Categoria c = new Categoria();

        // del Resulset -rs- obtenemos los valores de cada campo y los asiganamos a cada propiedad del objeto
        c.setId(rs.getLong("id"));
        c.setCategoria(rs.getString("nombre"));

        // devolvemos el objeto local con todas las propiedades asignadas con los valores de los campos
        return c;
    }
}
