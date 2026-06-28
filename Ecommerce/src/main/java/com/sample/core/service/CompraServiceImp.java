package com.sample.core.service;

import java.util.Date;
import java.util.List;

import com.sample.core.dao.CompraDao;
import com.sample.core.dao.CompraDaoImp;
import com.sample.core.dao.DetalleCompraDao;
import com.sample.core.dao.DetalleCompraDaoImp;
import com.sample.core.dao.ProductoDao;
import com.sample.core.dao.ProductoDaoImp;
import com.sample.core.domain.Carrito;
import com.sample.core.domain.Compra;
import com.sample.core.domain.DetalleCompra;
import com.sample.core.domain.Producto;
import com.sample.core.enums.EstadoCompra;

public class CompraServiceImp implements CompraService {

    private CompraDao compraDao = new CompraDaoImp();
    private DetalleCompraDao detalleDao = new DetalleCompraDaoImp();
    private ProductoDao productoDao = new ProductoDaoImp();

    @Override
    public Compra realizarCompra(Carrito carrito, int idUsuario) throws Exception {

        Compra compra = new Compra();

        compra.setIdUsuario(idUsuario);
        compra.setFechaCompra(new Date());
        compra.setEstado(EstadoCompra.PENDIENTE);

        int idCompra = compraDao.insertarCompra(compra);

        compra.setIdCompra(idCompra);

        for (DetalleCompra detalle : carrito.getDetalles()) {

            Producto productoBD
                    = productoDao.obtenerPorId(
                            detalle.getProducto().getIdProducto());

            if (productoBD == null) {
                throw new Exception("Producto inexistente.");
            }

            if (productoBD.getStock() < detalle.getCantidad()) {
                throw new Exception(
                        "No hay stock suficiente para "
                        + productoBD.getTitulo());
            }

            detalle.setCompra(compra);
            detalle.setProducto(productoBD);

            detalleDao.insertar(detalle);

            int nuevoStock
                    = productoBD.getStock() - detalle.getCantidad();

            productoDao.actualizarStock(
                    productoBD.getIdProducto(),
                    nuevoStock);
        }

        return compra;
    }

    @Override
    public List<Compra> obtenerMisCompras(int idUsuario) throws Exception {

        return compraDao.obtenerPorUsuario(idUsuario);

    }

    @Override
    public List<Compra> obtenerCompras() throws Exception {

        return compraDao.listarCompras();

    }

}
