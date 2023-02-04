package org_cpl_cursos.java.repositorios;

import org_cpl_cursos.java.modelos.Usuario;
import org_cpl_cursos.java.utilidades.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepoImpl implements Repositorio <Usuario>{
    private Connection conn;

    public UsuarioRepoImpl(Connection conexion) {
        this.conn = conexion;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();

        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios u ;")) {
            while (rs.next()) {
                Usuario u = getUsuario(rs);
                usuarios.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;

    }

    @Override
    public Usuario porId(Long id) {
        //  Creo una variable local que contendrá lños datos del usaurio a devolver -por eso es de la clase Usuario-
        //  se incializa a null para que tenga un valor incial.
        Usuario usu = null;

        //  Como vamos a conectarnos a la BBDD y es necesario asegurarnos de que, una vez utilizada, la conexión se cierra,
        //  usamos un try con recurosos y ponemos como recurso (entre paréntesis) la conexión, a la que le añadimos la
        //  sentencia a ejecutar con un parámetro: el id que hay que localizar
        try(PreparedStatement stmt = conn.
                prepareStatement("SELECT * FROM usuarios WHERE id = ?")) {

            // Asignamos el valor del parámetro con lo que ha llegado en la llamada
            stmt.setLong(1, id);

            // Se ejecuta la consulta
            ResultSet rs = stmt.executeQuery();

            // Si hay algún registro (debería haber como mucho uno ya que el id es PK y no se puede repetir), es el usuario
            // buscado...
            if (rs.next())  {
                // ... entonces leemos sus datos desde el rs y los asignamos al objeto usu que hemos creado al principio
                usu = cargaUsuario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usu;
    }

    @Override
    public void guardar(Usuario usu) {
        String qry;  // contiene la sentencia SQL a ejecutar

        /* Usamos esto para ahorrarnos una llamada al método porId()
        Esta es la versión larga ....
        Boolean id = false;
        if(porId(usu.getId()) != null) {
            id = true;
        };
        ...Esta es la versión corta (operador ternario)
         */
        Boolean id = porId(usu.getId()) != null ? true : false;

        /* Compruebo si el usuario pasado como argumento de la llamada existe */
        if(id) {
            // indica que elusuario pasado EXISTE y por lo tanto hay que modificarlo
            qry ="UPDATE Usuarios SET usuario=?, clave=?, nombre=?, apellidos=?, emilio=?, tlf=?,nacimiento=?, avatar=? WHERE id = ?";
        } else {
            // indica que el usuario NO EXISTE (y, porlo tanto hay que añadirlo
            qry ="INSERT usuarios VALUES(?,?,?,?,?,?,?,?,?)";
        }
        //  Como vamos a conectarnos a la BBDD y es necesario asegurarnos de que, una vez utilizada, la conexión se cierra,
        //  usamos un try con recurosos y ponemos como recurso (entre paréntesis) la conexión, a la que le añadimos la
        //  sentencia a ejecutar con los parámetros necesarios
        try(PreparedStatement stmt = conn.prepareStatement(qry)){
            if(id) {
                stmt.setString(1, usu.getUsuario());
                stmt.setString(2, usu.getClave());
                stmt.setString(3, usu.getNombre());
                stmt.setString(4, usu.getApellidos());
                stmt.setString(5, usu.getEmilio());
                stmt.setString(6, usu.getTlf());
                stmt.setDate(7, (Date) usu.getNacimiento());
                stmt.setString(8, usu.getAvatar());
                stmt.setLong(9, usu.getId());
            } else {
                stmt.setLong(1, usu.getId());
                stmt.setString(2, usu.getUsuario());
                stmt.setString(3, usu.getClave());
                stmt.setString(4, usu.getNombre());
                stmt.setString(5, usu.getApellidos());
                stmt.setString(6, usu.getEmilio());
                stmt.setString(7, usu.getTlf());
                stmt.setDate(8,(Date) usu.getNacimiento());
                stmt.setString(9, usu.getAvatar());

            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(Long id) {

    }

    private Usuario cargaUsuario(ResultSet rs) throws SQLException {
        // creamos una variable local del tipo que hay que devoolver
        Usuario u = new Usuario();

        // del Resulset -rs- obtenemso los valores de cada campo y los asiganamos a cada propiedad del objeto
        u.setUsuario(rs.getString("usuario"));
        u.setClave(rs.getString("clave"));
        u.setNombre(rs.getString("nombre"));
        u.setApellidos(rs.getString("apellidos"));
        u.setEmilio(rs.getString("emilio"));
        u.setTlf(rs.getString("tlf"));
        u.setNacimiento(rs.getDate("nacimiento"));
        u.setAvatar(rs.getString("avatar"));

        // devolvemos el objeto local con todas las propiedades asignadas con los valores de los campos
        return u;
    }
    private static Usuario getUsuario(ResultSet rs) throws SQLException {
        Usuario p = new Usuario();

        p.setId(rs.getLong("id"));
        p.setUsuario(rs.getString("usuario"));
        p.setClave(rs.getString("clave"));
        p.setNombre(rs.getString("nombre"));
        p.setApellidos(rs.getString("apellidos"));
        p.setEmilio(rs.getString("emilio"));
        p.setTlf(rs.getString("tlf"));
        p.setNacimiento(rs.getDate("nacimiento"));
        p.setTlf(rs.getString("avatar"));
        return p;
    }
}
