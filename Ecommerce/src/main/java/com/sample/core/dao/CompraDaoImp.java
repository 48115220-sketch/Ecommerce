package com.sample.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Compra;
import com.sample.core.enums.EstadoCompra;
import com.sample.core.exceptions.ErrorException;

public class CompraDaoImp implements CompraDao {

    private static final String QUERY_INSERTAR
            = "INSERT INTO Compras (Id_usuario, Fecha_compra, Estado) VALUES (?, ?, ?)";

    private static final String QUERY_OBTENER
            = "SELECT Id_compra, Id_usuario, Fecha_compra, Estado FROM Compras WHERE Id_compra=?";

    private static final String QUERY_USUARIO
            = "SELECT Id_compra, Id_usuario, Fecha_compra, Estado "
            + "FROM Compras WHERE Id_usuario=? ORDER BY Fecha_compra DESC";

    private static final String QUERY_ESTADO
            = "UPDATE Compras SET Estado=? WHERE Id_compra=?";

    private Conexion conexion = Conexion.getInstance();

    @Override
    public int insertarCompra(Compra compra) throws Exception {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conexion.dameConnection().prepareStatement(
                    QUERY_INSERTAR,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setInt(1, compra.getIdUsuario());
            st.setTimestamp(2, new java.sql.Timestamp(compra.getFechaCompra().getTime()));
            st.setString(3, compra.getEstado().name());

            st.executeUpdate();

            rs = st.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

            throw new Exception("No se pudo obtener el ID de la compra.");

        } catch (Exception e) {

            throw new ErrorException("Error al registrar la compra.", e);

        } finally {

            if (rs != null) {
                rs.close();
            }

            if (st != null) {
                st.close();
            }

        }
    }

    @Override
    public Compra obtenerPorId(int idCompra) throws Exception {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conexion.dameConnection().prepareStatement(QUERY_OBTENER);

            st.setInt(1, idCompra);

            rs = st.executeQuery();

            if (rs.next()) {

                return new Compra(
                        rs.getInt("Id_compra"),
                        rs.getInt("Id_usuario"),
                        rs.getTimestamp("Fecha_compra"),
                        EstadoCompra.valueOf(rs.getString("Estado")));

            }

            return null;

        } catch (Exception e) {

            throw new ErrorException("Error al obtener la compra.", e);

        } finally {

            if (rs != null) {
                rs.close();
            }

            if (st != null) {
                st.close();
            }

        }

    }

    @Override
    public List<Compra> obtenerPorUsuario(int idUsuario) throws Exception {

        PreparedStatement st = null;
        ResultSet rs = null;

        List<Compra> compras = new ArrayList<>();

        try {

            st = conexion.dameConnection().prepareStatement(QUERY_USUARIO);

            st.setInt(1, idUsuario);

            rs = st.executeQuery();

            while (rs.next()) {

                Compra compra = new Compra(
                        rs.getInt("Id_compra"),
                        rs.getInt("Id_usuario"),
                        rs.getTimestamp("Fecha_compra"),
                        EstadoCompra.valueOf(rs.getString("Estado")));

                compras.add(compra);

            }

            return compras;

        } catch (Exception e) {

            throw new ErrorException("Error al listar compras del usuario.", e);

        } finally {

            if (rs != null) {
                rs.close();
            }

            if (st != null) {
                st.close();
            }

        }

    }

    @Override
    public List<Compra> listarCompras() throws Exception {

        PreparedStatement st = null;
        ResultSet rs = null;

        List<Compra> compras = new ArrayList<>();

        try {

            st = conexion.dameConnection().prepareStatement(
                    "SELECT Id_compra, Id_usuario, Fecha_compra, Estado "
                    + "FROM Compras ORDER BY Fecha_compra DESC");

            rs = st.executeQuery();

            while (rs.next()) {

                Compra compra = new Compra(
                        rs.getInt("Id_compra"),
                        rs.getInt("Id_usuario"),
                        rs.getTimestamp("Fecha_compra"),
                        EstadoCompra.valueOf(rs.getString("Estado")));

                compras.add(compra);

            }

            return compras;

        } catch (Exception e) {

            throw new ErrorException("Error al listar compras.", e);

        } finally {

            if (rs != null) {
                rs.close();
            }

            if (st != null) {
                st.close();
            }

        }

    }

    @Override
    public void actualizarEstado(int idCompra, EstadoCompra estado) throws Exception {

        PreparedStatement st = null;

        try {

            st = conexion.dameConnection().prepareStatement(QUERY_ESTADO);

            st.setString(1, estado.name());
            st.setInt(2, idCompra);

            st.executeUpdate();

        } catch (Exception e) {

            throw new ErrorException("Error al actualizar el estado de la compra.", e);

        } finally {

            if (st != null) {
                st.close();
            }

        }

    }

}
