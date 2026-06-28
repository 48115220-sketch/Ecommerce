package com.sample.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Compra;
import com.sample.core.domain.DetalleCompra;
import com.sample.core.domain.Producto;
import com.sample.core.exceptions.ErrorException;

public class DetalleCompraDaoImp implements DetalleCompraDao {

    private static final String SQL_INSERT =
            "INSERT INTO Detalle_compras (Id_compra, Id_producto, Cantidad, Precio_unitario) VALUES (?, ?, ?, ?)";

    private static final String SQL_POR_COMPRA =
            "SELECT dc.Id_detalle, dc.Id_compra, dc.Id_producto, dc.Cantidad, dc.Precio_unitario, "
            + "p.Titulo, p.Url_imagen "
            + "FROM Detalle_compras dc "
            + "JOIN Productos p ON dc.Id_producto = p.Id_producto "
            + "WHERE dc.Id_compra = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM Detalle_compras WHERE Id_detalle = ?";

    private Conexion conexion = Conexion.getInstance();

    @Override
    public void insertar(DetalleCompra detalle) throws Exception {

        PreparedStatement st = null;

        try {

            st = conexion.dameConnection().prepareStatement(SQL_INSERT);

            st.setInt(1, detalle.getCompra().getIdCompra());
            st.setInt(2, detalle.getProducto().getIdProducto());
            st.setInt(3, detalle.getCantidad());
            st.setDouble(4, detalle.getPrecioUnitario());

            st.executeUpdate();

        } catch (Exception e) {

            throw new ErrorException("Error al registrar el detalle de la compra.", e);

        } finally {

            if (st != null) {
                st.close();
            }

        }

    }

    @Override
    public List<DetalleCompra> obtenerPorCompra(int idCompra) throws ErrorException {

        List<DetalleCompra> lista = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conexion.dameConnection().prepareStatement(SQL_POR_COMPRA);
            st.setInt(1, idCompra);

            rs = st.executeQuery();

            while (rs.next()) {

                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("Id_compra"));

                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("Id_producto"));
                producto.setTitulo(rs.getString("Titulo"));
                producto.setUrlImagen(rs.getString("Url_imagen"));

                DetalleCompra detalle = new DetalleCompra(
                        rs.getInt("Id_detalle"),
                        compra,
                        producto,
                        rs.getInt("Cantidad"),
                        rs.getDouble("Precio_unitario"));

                lista.add(detalle);
            }

        } catch (Exception e) {

            throw new ErrorException("Error al recuperar los detalles de la compra.", e);

        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return lista;
    }

    @Override
    public void eliminarPorDetalle(int idDetalle) throws Exception {

        PreparedStatement st = null;

        try {

            st = conexion.dameConnection().prepareStatement(SQL_ELIMINAR);

            st.setInt(1, idDetalle);

            st.executeUpdate();

        } catch (Exception e) {

            throw new ErrorException("Error al eliminar el detalle de la compra.", e);

        } finally {

            if (st != null) {
                st.close();
            }

        }

    }

}