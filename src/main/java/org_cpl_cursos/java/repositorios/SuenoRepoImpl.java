package org_cpl_cursos.java.repositorios;

import org_cpl_cursos.java.modelos.Sueno;
import org_cpl_cursos.java.modelos.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SuenoRepoImpl implements SuenoRepo{
    private final Connection conn;

    public SuenoRepoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Sueno> listar() {
        return null;
    }

    @Override
    public Sueno porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Sueno sueno) {
        String qry;  // contiene la sentencia SQL a ejecutar
        boolean id = porId(sueno.getId()) != null;

        if(id) {
            qry ="UPDATE suenos SET idCategoria=?, descripcion=?, titulo=?, fecha=?, idPropietaio=? WHERE id = ?";
        } else {
            qry ="INSERT usuarios VALUES(?,?,?,?,?,?)";
        }

        try(PreparedStatement stmt = conn.prepareStatement(qry)){
            if(id) {
                stmt.setLong(1, sueno.getIdCategoria());
                stmt.setString(2, sueno.getDescripcion());
                stmt.setString(3, sueno.getTitulo());
                stmt.setDate(4, Date.valueOf(sueno.getFecha()));
                stmt.setLong(5, sueno.getIdPropietario());
                stmt.setLong(5, sueno.getId());
            } else {
                stmt.setLong(1, sueno.getId());
                stmt.setLong(1, sueno.getIdCategoria());
                stmt.setString(2, sueno.getDescripcion());
                stmt.setString(3, sueno.getTitulo());
                stmt.setDate(4, Date.valueOf(sueno.getFecha()));
                stmt.setLong(5, sueno.getIdPropietario());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(Long id) {

    }

    public List<Sueno> porCategoria(Long idCat) {
        List<Sueno> suenos = new ArrayList<>();

        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM suenos u WHERE idCategoria = ? ;")) {
            stmt.setLong(1, idCat);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Sueno s = cargaSueno(rs);
                suenos.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return suenos;
    }

    public List<Sueno> porSonador(Long idProp){
        List<Sueno> suenos = new ArrayList<>();

        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM suenos u WHERE idPropietario = ? ;")) {
            stmt.setLong(1, idProp);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Sueno s = cargaSueno(rs);
                suenos.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return suenos;
    }


    private Sueno cargaSueno(ResultSet rs) throws SQLException {
        Sueno s = new Sueno();

        s.setId(rs.getLong("id"));
        s.setIdCategoria(rs.getLong("idCategoria"));
        s.setDescripcion(rs.getString("descripcion"));
        s.setTitulo(rs.getString("titulo"));
        s.setFecha(rs.getDate("fecha").toLocalDate());
        s.setIdPropietario(rs.getLong("idPropietario"));

        return s;
    }
}
