package com.sample.core.controller.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.service.UsuarioService;
import com.sample.core.service.UsuarioServiceImpl;

@WebServlet("/LeerDatoUsuario")
public class LeerDatosUsuarioController extends HttpServlet {

    private UsuarioService usuarioService = new UsuarioServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            request.setAttribute("usuarios",
                    usuarioService.listarUsuario());

            request.getRequestDispatcher("/LeerDatosUsuario.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}