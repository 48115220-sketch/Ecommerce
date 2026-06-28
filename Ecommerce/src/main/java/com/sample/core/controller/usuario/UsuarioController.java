package com.sample.core.controller.usuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.service.UsuarioService;
import com.sample.core.service.UsuarioServiceImpl;

@WebServlet( urlPatterns =  "/crearUsuario")
public class UsuarioController extends HttpServlet{

		

		UsuarioService usuarioService = new UsuarioServiceImpl();
		
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String nombre = req.getParameter("nombre");
			String apellido = req.getParameter("apellido");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String telefono = req.getParameter("telefono");
			
		try {
			usuarioService.crearUsuario(nombre, apellido, email, password, telefono);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/LeerDatosUsuario");
	        dispatcher.forward(req, resp);
	        
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
		
		
	}

