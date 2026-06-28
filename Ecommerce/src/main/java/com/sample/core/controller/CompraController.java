package com.sample.core.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.core.domain.Carrito;
import com.sample.core.domain.Compra;
import com.sample.core.service.CompraService;
import com.sample.core.service.CompraServiceImp;
import com.google.gson.Gson;

@WebServlet("/compra")
public class CompraController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CompraService compraService = new CompraServiceImp();

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

        HttpSession session = req.getSession(true);

        try {

            if ("registrar".equals(accion)) {

                int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));

                Carrito carrito = (Carrito) session.getAttribute("carrito");

                if (carrito == null || carrito.estaVacio()) {
                    throw new Exception("El carrito está vacío.");
                }

                Compra compra = compraService.realizarCompra(carrito, idUsuario);

                carrito.vaciar();

                resp.getWriter().print(gson.toJson(compra));

            } else if ("listar".equals(accion)) {

                int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));

                List<Compra> compras = compraService.obtenerMisCompras(idUsuario);

                resp.getWriter().print(gson.toJson(compras));

            } else if ("listarTodo".equals(accion)) {

                List<Compra> compras = compraService.obtenerCompras();

                resp.getWriter().print(gson.toJson(compras));

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
