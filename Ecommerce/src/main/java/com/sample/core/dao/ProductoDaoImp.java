package com.sample.core.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Producto;
import com.sample.core.exceptions.ErrorException;

public class ProductoDaoImp implements ProductoDao {

    private static final String QUERY_LISTAR =
            "SELECT Id_producto, Url_imagen, Titulo, Fecha_public, Stock, Descripcion, Caracteristicas, Precio FROM Productos";

    private static final String QUERY_BUSCAR =
            "SELECT Id_producto, Url_imagen, Titulo, Fecha_public, Stock, Descripcion, Caracteristicas, Precio "
            + "FROM Productos WHERE Titulo LIKE ?";

    private static final String QUERY_FILTRAR_PRECIO =
            "SELECT Id_producto, Url_imagen, Titulo, Fecha_public, Stock, Descripcion, Caracteristicas, Precio "
            + "FROM Productos WHERE Precio BETWEEN ? AND ?";

    private static final String QUERY_FILTRAR_FECHA =
            "SELECT Id_producto, Url_imagen, Titulo, Fecha_public, Stock, Descripcion, Caracteristicas, Precio "
            + "FROM Productos WHERE Fecha_public BETWEEN ? AND ?";

    private static final String QUERY_OBTENER =
            "SELECT Id_producto, Url_imagen, Titulo, Fecha_public, Stock, Descripcion, Caracteristicas, Precio "
            + "FROM Productos WHERE Id_producto=?";

    private static final String QUERY_ACTUALIZAR_STOCK =
            "UPDATE Productos SET Stock=? WHERE Id_producto=?";

    private static final String QUERY_INSERTAR =
            "INSERT INTO Productos (Url_imagen, Titulo, Fecha_public, Stock, Descripcion, Caracteristicas, Precio) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String QUERY_ACTUALIZAR =
            "UPDATE Productos SET Url_imagen=?, Titulo=?, Fecha_public=?, Stock=?, Descripcion=?, Caracteristicas=?, Precio=? WHERE Id_producto=?";

    private static final String QUERY_ELIMINAR =
            "DELETE FROM Productos WHERE Id_producto=?";

    private final Conexion conexion = Conexion.getInstance();

    @Override
    public List<Producto> obtenerTodos() throws Exception {

        PreparedStatement st = null;
        ResultSet rs = null;

        List<Producto> productos = new ArrayList<>();

        try {

            st = conexion.dameConnection().prepareStatement(QUERY_LISTAR);

            rs = st.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto(
                        rs.getInt("Id_producto"),
                        rs.getString("Url_imagen"),
                        rs.getString("Titulo"),
                        rs.getDate("Fecha_public"),
                        rs.getInt("Stock"),
                        rs.getString("Descripcion"),
                        rs.getString("Caracteristicas"),
                        rs.getDouble("Precio"));

                productos.add(producto);

            }

        } catch (Exception e) {

            throw new ErrorException("Error al listar productos en la base de datos.", e);

        } finally {

            if (rs != null)
                rs.close();

            if (st != null)
                st.close();

        }

        return productos;
    }

    @Override
    public List<Producto> buscar(String criterio) throws Exception {

        PreparedStatement st = null;
        ResultSet rs = null;

        List<Producto> productos = new ArrayList<>();

        try {

            st = conexion.dameConnection().prepareStatement(QUERY_BUSCAR);

            st.setString(1, "%" + criterio + "%");

            rs = st.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto(
                        rs.getInt("Id_producto"),
                        rs.getString("Url_imagen"),
                        rs.getString("Titulo"),
                        rs.getDate("Fecha_public"),
                        rs.getInt("Stock"),
                        rs.getString("Descripcion"),
                        rs.getString("Caracteristicas"),
                        rs.getDouble("Precio"));

                productos.add(producto);

            }

        } catch (Exception e) {

            throw new ErrorException("Error al buscar productos por criterio.", e);

        } finally {

            if (rs != null)
                rs.close();

            if (st != null)
                st.close();

        }

        return productos;
    }

    @Override
    public List<Producto> filtrarPrecio(double min, double max) throws Exception {

        PreparedStatement st = null;
        ResultSet rs = null;

        List<Producto> productos = new ArrayList<>();

        try {

            st = conexion.dameConnection().prepareStatement(QUERY_FILTRAR_PRECIO);

            st.setDouble(1, min);
            st.setDouble(2, max);

            rs = st.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto(
                        rs.getInt("Id_producto"),
                        rs.getString("Url_imagen"),
                        rs.getString("Titulo"),
                        rs.getDate("Fecha_public"),
                        rs.getInt("Stock"),
                        rs.getString("Descripcion"),
                        rs.getString("Caracteristicas"),
                        rs.getDouble("Precio"));

                productos.add(producto);

            }

        } catch (Exception e) {

            throw new ErrorException("Error al filtrar productos por precio.", e);

        } finally {

            if (rs != null)
                rs.close();

            if (st != null)
                st.close();

        }

        return productos;
    }

    @Override
    public List<Producto> filtrarFecha(java.util.Date desde, java.util.Date hasta) throws Exception {

        PreparedStatement st = null;
        ResultSet rs = null;

        List<Producto> productos = new ArrayList<>();

        try {

            st = conexion.dameConnection().prepareStatement(QUERY_FILTRAR_FECHA);

            st.setDate(1, new Date(desde.getTime()));
            st.setDate(2, new Date(hasta.getTime()));

            rs = st.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto(
                        rs.getInt("Id_producto"),
                        rs.getString("Url_imagen"),
                        rs.getString("Titulo"),
                        rs.getDate("Fecha_public"),
                        rs.getInt("Stock"),
                        rs.getString("Descripcion"),
                        rs.getString("Caracteristicas"),
                        rs.getDouble("Precio"));

                productos.add(producto);

            }

        } catch (Exception e) {

            throw new ErrorException("Error al filtrar productos por fecha.", e);

        } finally {

            if (rs != null)
                rs.close();

            if (st != null)
                st.close();

        }

        return productos;
    }

    @Override
    public Producto obtenerPorId(int idProducto) throws Exception {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conexion.dameConnection().prepareStatement(QUERY_OBTENER);

            st.setInt(1, idProducto);

            rs = st.executeQuery();

            if (rs.next()) {

                return new Producto(
                        rs.getInt("Id_producto"),
                        rs.getString("Url_imagen"),
                        rs.getString("Titulo"),
                        rs.getDate("Fecha_public"),
                        rs.getInt("Stock"),
                        rs.getString("Descripcion"),
                        rs.getString("Caracteristicas"),
                        rs.getDouble("Precio"));

            }

        } catch (Exception e) {

            throw new ErrorException("Error al obtener el producto.", e);

        } finally {

            if (rs != null)
                rs.close();

            if (st != null)
                st.close();

        }

        return null;
    }
    @Override
    public void insertar(Producto producto) throws Exception {

    PreparedStatement st = null;

    try {

        st = conexion.dameConnection().prepareStatement(QUERY_INSERTAR);

        st.setString(1, producto.getUrlImagen());
        st.setString(2, producto.getTitulo());
        st.setDate(3, new java.sql.Date(producto.getFechaPublic().getTime()));
        st.setInt(4, producto.getStock());
        st.setString(5, producto.getDescripcion());
        st.setString(6, producto.getCaracteristicas());
        st.setDouble(7, producto.getPrecio());

        st.executeUpdate();

    } catch (Exception e) {

        throw new ErrorException("Error al registrar el producto.", e);

    } finally {

        if (st != null)
            st.close();

    }

}
    @Override
    public void actualizar(Producto producto) throws Exception {

    PreparedStatement st = null;

    try {

        st = conexion.dameConnection().prepareStatement(QUERY_ACTUALIZAR);

        st.setString(1, producto.getUrlImagen());
        st.setString(2, producto.getTitulo());
        st.setDate(3, new java.sql.Date(producto.getFechaPublic().getTime()));
        st.setInt(4, producto.getStock());
        st.setString(5, producto.getDescripcion());
        st.setString(6, producto.getCaracteristicas());
        st.setDouble(7, producto.getPrecio());
        st.setInt(8, producto.getIdProducto());

        st.executeUpdate();

    } catch (Exception e) {

        throw new ErrorException("Error al modificar el producto.", e);

    } finally {

        if (st != null)
            st.close();

    }

}

    @Override
    public void eliminar(int idProducto) throws Exception {

    PreparedStatement st = null;

    try {

        st = conexion.dameConnection().prepareStatement(QUERY_ELIMINAR);

        st.setInt(1, idProducto);

        st.executeUpdate();

    } catch (Exception e) {

        throw new ErrorException("Error al eliminar el producto.", e);

    } finally {

        if (st != null)
            st.close();

    }

}

    @Override
    public void actualizarStock(int idProducto, int nuevaCantidad) throws Exception {

        PreparedStatement st = null;

        try {

            st = conexion.dameConnection().prepareStatement(QUERY_ACTUALIZAR_STOCK);

            st.setInt(1, nuevaCantidad);
            st.setInt(2, idProducto);

            st.executeUpdate();

        } catch (Exception e) {

            throw new ErrorException("Error al actualizar el stock del producto.", e);

        } finally {

            if (st != null)
                st.close();

        }

    }

}