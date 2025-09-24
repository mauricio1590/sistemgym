package com.sistemgym.dao;

import com.sistemgym.model.Usuario;

public interface UsuarioDAO {

    Usuario validarLogin (String username, String password);
}
