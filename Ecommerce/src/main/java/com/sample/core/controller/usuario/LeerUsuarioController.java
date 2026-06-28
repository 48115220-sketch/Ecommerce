package com.sample.core.controller.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.service.UsuarioService;
import com.sample.core.service.UsuarioServiceImpl;

@WebServlet("/LeerDatosUsuario")
public class LeerUsuarioController extends HttpServlet {

    private UsuarioService usuarioService = new UsuarioServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            try {
                req.setAttribute("usuarios", usuarioService.listarUsuario());
            } catch (Exception e) {
                System.out.println("Aviso: No se pudieron listar usuarios de la BD: " + e.getMessage());
            }

            req.getRequestDispatcher("/usuario/VerUsuarios.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error crítico en el controlador: " + e.getMessage());
        }
    }
}