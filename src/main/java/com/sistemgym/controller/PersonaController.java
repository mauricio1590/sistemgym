package com.sistemgym.controller;

import com.sistemgym.dao.PersonaDAO;
import com.sistemgym.model.Persona;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaController {
    private PersonaDAO dao;

    public PersonaController(Connection con) {
        this.dao = new PersonaDAO(con);
    }

    public void registrar(Persona persona) {
        try {
            boolean exito = dao.registrarPersona(persona);
            if (exito) {
                System.out.println("Persona registrada correctamente.");
            } else {
                System.out.println("Error al registrar persona.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Persona> listar() {
        try {
            return dao.listarPersonas();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Puedes agregar actualizar, buscarPorId, eliminar, etc.
}
