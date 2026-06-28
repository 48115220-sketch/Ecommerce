package com.sample.core.controller.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.service.UsuarioService;
import com.sample.core.service.UsuarioServiceImpl;

@WebServlet("/EditarUsuario")
public class EditarUsuarioController extends HttpServlet {

    private UsuarioService usuarioService = new UsuarioServiceImpl();

    // Carga el formulario con los datos del usuario
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("usuario", usuarioService.consultarUsuario(id));
            req.getRequestDispatcher("/usuario/EditarUsuarioForm.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Guarda los cambios
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            String email = req.getParameter("email");
            String telefono = req.getParameter("telefono");
            usuarioService.actualizarUsuario(id, nombre, apellido, email, telefono);
            resp.sendRedirect(req.getContextPath() + "/LeerDatosUsuario");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}