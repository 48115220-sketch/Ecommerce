package com.sample.core.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sample.core.domain.Producto;
import com.sample.core.service.ProductoService;
import com.sample.core.service.ProductoServiceImp;

@WebServlet("/producto")
public class ProductoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductoService productoService = new ProductoServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();

        String accion = req.getParameter("accion");

        try {

            List<Producto> productos = null;

            if ("listar".equals(accion)) {

                productos = productoService.obtenerProductos();
                resp.getWriter().print(gson.toJson(productos));

            } else if ("buscar".equals(accion)) {

                String criterio = req.getParameter("criterio");

                productos = productoService.buscarProductos(criterio);
                resp.getWriter().print(gson.toJson(productos));

            } else if ("precio".equals(accion)) {

                double minimo = Double.parseDouble(req.getParameter("minimo"));
                double maximo = Double.parseDouble(req.getParameter("maximo"));

                productos = productoService.filtrarPrecio(minimo, maximo);
                resp.getWriter().print(gson.toJson(productos));

            } else if ("fecha".equals(accion)) {

                Date desde = Date.valueOf(req.getParameter("desde"));
                Date hasta = Date.valueOf(req.getParameter("hasta"));

                productos = productoService.filtrarFecha(desde, hasta);
                resp.getWriter().print(gson.toJson(productos));

            } else if ("obtener".equals(accion)) {

                int idProducto = Integer.parseInt(req.getParameter("idProducto"));

                Producto producto = productoService.obtenerProducto(idProducto);

                resp.getWriter().print(gson.toJson(producto));

            } else if ("insertar".equals(accion)) {

                Producto producto = new Producto();

                producto.setUrlImagen(req.getParameter("urlImagen"));
                producto.setTitulo(req.getParameter("titulo"));
                producto.setFechaPublic(Date.valueOf(req.getParameter("fechaPublic")));
                producto.setStock(Integer.parseInt(req.getParameter("stock")));
                producto.setDescripcion(req.getParameter("descripcion"));
                producto.setCaracteristicas(req.getParameter("caracteristicas"));
                producto.setPrecio(Double.parseDouble(req.getParameter("precio")));

                productoService.registrarProducto(producto);

                resp.getWriter().print(gson.toJson("Producto registrado correctamente"));

            } else if ("actualizar".equals(accion)) {

                Producto producto = new Producto();

                producto.setIdProducto(Integer.parseInt(req.getParameter("idProducto")));
                producto.setUrlImagen(req.getParameter("urlImagen"));
                producto.setTitulo(req.getParameter("titulo"));
                producto.setFechaPublic(Date.valueOf(req.getParameter("fechaPublic")));
                producto.setStock(Integer.parseInt(req.getParameter("stock")));
                producto.setDescripcion(req.getParameter("descripcion"));
                producto.setCaracteristicas(req.getParameter("caracteristicas"));
                producto.setPrecio(Double.parseDouble(req.getParameter("precio")));

                productoService.modificarProducto(producto);

                resp.getWriter().print(gson.toJson("Producto actualizado correctamente"));

            } else if ("eliminar".equals(accion)) {

                int idProducto = Integer.parseInt(req.getParameter("idProducto"));

                productoService.eliminarProducto(idProducto);
                
                resp.getWriter().print(gson.toJson("Producto eliminado correctamente"));

            } else {

                throw new Exception("Acción no válida.");

            }

        } catch (Exception e) {

            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().print(gson.toJson(e.getMessage()));
            e.printStackTrace();

        }

    }

}