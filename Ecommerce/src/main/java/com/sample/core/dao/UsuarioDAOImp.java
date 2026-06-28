package com.sample.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.exceptions.ErrorException;
import com.sample.core.model.Usuario;

public class UsuarioDAOImp implements UsuarioDAO {

    private static final String queryConsultarUsuario
            = "SELECT Id_usuario, Nombre_user, Apellido_user, Email, Contrasena, Telefono, Rol FROM Usuarios WHERE Id_usuario=?";

    private static final String queryAddUsuario
            = "INSERT INTO Usuarios (Nombre_user, Apellido_user, Email, Contrasena, Telefono) VALUES (?,?,?,?,?)";

    private static final String queryDeleteUsuario
            = "DELETE FROM Usuarios WHERE Id_usuario=?";

    private static final String queryList
            = "SELECT Id_usuario, Nombre_user, Apellido_user, Email, Contrasena, Telefono, Rol FROM Usuarios";

    private static final String queryUpdateUsuario
            = "UPDATE Usuarios SET Nombre_user=?, Apellido_user=?, Email=?, Telefono=? WHERE Id_usuario=?";
    private Conexion conexion = Conexion.getInstance();

    public Usuario findById(int id) throws Exception {
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            st = conexion.dameConnection().prepareStatement(queryConsultarUsuario);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
            }
        } catch (Exception e) {
            throw new ErrorException("Hubo un error al realizar la consulta", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
            
                }} catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (st != null) {
                    st.close();
            
                }} catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Usuario> list() throws Exception {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection conn = conexion.dameConnection();
            st = conn.prepareStatement(queryList);
            rs = st.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }
            return usuarios;
        } catch (Exception e) {
            throw new ErrorException("Error al listar usuarios", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
            
                }} catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (st != null) {
                    st.close();
            
                }} catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(int id, String nombre, String apellido, String email, String telefono) throws Exception {
        PreparedStatement st = null;
        try {
            st = conexion.dameConnection().prepareStatement(queryUpdateUsuario);
            st.setString(1, nombre);
            st.setString(2, apellido);
            st.setString(3, email);
            st.setString(4, telefono);
            st.setInt(5, id);
            st.executeUpdate();
            conexion.dameConnection().commit();
            System.out.println("Usuario actualizado correctamente.");
        } catch (Exception e) {
            throw new ErrorException("Error al actualizar el usuario", e);
        } finally {
            try {
                if (st != null) {
                    st.close();
            
                }} catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id) throws Exception {
        PreparedStatement st = null;
        try {
            st = conexion.dameConnection().prepareStatement(queryDeleteUsuario);
            st.setInt(1, id);
            int filas = st.executeUpdate(); // ✅ corregido
            if (filas == 0) {
                throw new ErrorException("No se encontró el registro", null);
            }
        } catch (ErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new ErrorException("Hubo un error al eliminar el usuario", e);
        } finally {
            try {
                if (st != null) {
                    st.close();
            
                }} catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(String nombre, String apellido, String email,
            String password, String telefono) throws ErrorException {
        PreparedStatement st = null;
        try {
            st = conexion.dameConnection().prepareStatement(queryAddUsuario);
            st.setString(1, nombre);
            st.setString(2, apellido);
            st.setString(3, email);
            st.setString(4, password);
            st.setString(5, telefono);
            System.out.println("Guardando: " + nombre + " " + apellido + " " + email);
            st.executeUpdate();
            conexion.dameConnection().commit();
            System.out.println("Commit realizado correctamente.");
        } catch (Exception e) {
            throw new ErrorException("Hubo un error al guardar el usuario", e);
        } finally {
            try {
                if (st != null) {
                    st.close();
            
                }} catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
