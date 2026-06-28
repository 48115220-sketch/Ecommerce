package com.sample.core.service;

import java.util.List;

import com.sample.core.dao.UsuarioDAO;
import com.sample.core.dao.UsuarioDAOImp;
import com.sample.core.model.Usuario;
import com.sample.core.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDAO usuarioDAO = new UsuarioDAOImp();

    @Override
    public List<Usuario> listarUsuario() throws Exception {
        return usuarioDAO.list();
    }

    @Override
    public Usuario consultarUsuario(int id) throws Exception {
        return usuarioDAO.findById(id);
    }

    @Override
    public void crearUsuario(String nombre, String apellido, String email,
            String password, String telefono) throws Exception {
        usuarioDAO.save(nombre, apellido, email, password, telefono);
    }


	@Override
	public void actualizarUsuario(int id, String nombre, String apellido, String email, String telefono) throws Exception {
	    usuarioDAO.update(id, nombre, apellido, email, telefono);
	}

	@Override
	public void eliminarUsuario(int id) throws Exception {
	    usuarioDAO.delete(id);
	}

}