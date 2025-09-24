package com.sistemgym.dao;

import com.sistemgym.model.Usuario;
import com.sistemgym.util.DBConnection;

import java.sql.*;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Usuario validarLogin(String username, String password) {
        Usuario usuario = null;
        String sql = "SELECT * FROM login WHERE usuario = ? AND contrasena = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            System.out.println("Consultando usuario: " + username + " con clave: " + password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsername(rs.getString("usuario"));
                usuario.setPassword(rs.getString("contrasena"));
                usuario.setNivel(rs.getString("nivel"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
