package com.sample.core.dao;
import java.util.List;

import com.sample.core.model.Usuario;
public interface UsuarioDAO {
    public Usuario findById(int id) throws Exception;
    public List<Usuario> list() throws Exception;
    public void save(String nombre, String apellido, String email, String password, String telefono) throws Exception;
    public void delete(int id) throws Exception;
    public void update(int id, String nombre, String apellido, String email, String telefono) throws Exception;
}