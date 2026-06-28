package com.sample.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.core.domain.Carrito;
import com.sample.core.domain.DetalleCompra;
import com.sample.core.domain.Producto;
import com.google.gson.Gson;

@WebServlet("/carrito")
public class CarritoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

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

        HttpSession session = req.getSession(true);

        Carrito carrito = (Carrito) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }

        String accion = req.getParameter("accion");

        try {

            if ("listar".equals(accion)) {

                resp.getWriter().print(gson.toJson(carrito));

            } else if ("agregar".equals(accion)) {

                int idProducto = Integer.parseInt(req.getParameter("idProducto"));
                int cantidad = Integer.parseInt(req.getParameter("cantidad"));
                double precio = Double.parseDouble(req.getParameter("precio"));

                String titulo = req.getParameter("titulo");
                String urlImagen = req.getParameter("urlImagen");

                Producto producto = new Producto();

                producto.setIdProducto(idProducto);
                producto.setTitulo(titulo);
                producto.setUrlImagen(urlImagen);
                producto.setPrecio(precio);

                DetalleCompra detalle = new DetalleCompra();

                detalle.setProducto(producto);
                detalle.setCantidad(cantidad);
                detalle.setPrecioUnitario(precio);

                carrito.agregarProducto(detalle);

                resp.getWriter().print(gson.toJson(carrito));

            } else if ("eliminar".equals(accion)) {

                int indice = Integer.parseInt(req.getParameter("indice"));

                carrito.eliminarProducto(indice);

                resp.getWriter().print(gson.toJson(carrito));

            } else if ("vaciar".equals(accion)) {

                carrito.vaciar();

                resp.getWriter().print(gson.toJson(carrito));

            } else {

                throw new Exception("Acción inválida.");

            }

        } catch (Exception e) {

            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().print(gson.toJson(e.getMessage()));
            e.printStackTrace();

        }

    }

}