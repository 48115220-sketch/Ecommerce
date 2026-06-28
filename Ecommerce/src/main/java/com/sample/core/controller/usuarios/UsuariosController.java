package com.sample.core.controller.usuarios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sample.core.service.UsuarioService;
import com.sample.core.service.UsuarioServiceImpl;

@WebServlet("/usuarios")
public class UsuariosController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private UsuarioService emailService = new UsuarioServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			Gson json = new Gson();
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			out.print(json.toJson(emailService.listarUsuario()));
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
