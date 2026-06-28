package com.sample.core.service;
import java.util.List;

import com.sample.core.model.Usuario;
public interface UsuarioService {
    public List<Usuario> listarUsuario() throws Exception;
    public Usuario consultarUsuario(int id) throws Exception;
    public void crearUsuario(String nombre, String apellido, String email, String password, String telefono) throws Exception;
    public void actualizarUsuario(int id, String nombre, String apellido, String email, String telefono) throws Exception; 
    public void eliminarUsuario(int id) throws Exception;}