package com.sistemgym.dao;

import com.sistemgym.model.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
        private final Connection con;

        public PersonaDAO(Connection con) {
                this.con = con;
        }

        // Registrar nueva persona
        public boolean registrarPersona(Persona persona) throws SQLException {
                String sql = "INSERT INTO cliente (tipodocumento, cedula, nombre, apellido, telefono, direccion, correo, ruta, nacimiento, eps, contacto, telefono2, rh, huella, modificado) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                        setParametros(stmt, persona);
                        return stmt.executeUpdate() > 0;
                }
        }

        // Actualizar persona existente
        public boolean actualizarPersona(Persona persona) throws SQLException {
                String sql = "UPDATE cliente SET tipodocumento = ?, cedula = ?, nombre = ?, apellido = ?, telefono = ?, direccion = ?, correo = ?, ruta = ?, nacimiento = ?, eps = ?, contacto = ?, telefono2 = ?, rh = ?, huella = ?, modificado = ? WHERE id = ?";

                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                        setParametros(stmt, persona);
                        stmt.setInt(16, persona.getId());
                        return stmt.executeUpdate() > 0;
                }
        }

        // Obtener persona por ID
        public Persona obtenerPersonaPorId(int id) throws SQLException {
                String sql = "SELECT * FROM cliente WHERE id = ?";

                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                        stmt.setInt(1, id);
                        try (ResultSet rs = stmt.executeQuery()) {
                                if (rs.next()) {
                                        return mapearPersona(rs);
                                }
                        }
                }
                return null;
        }

        // Listar todas las personas
        public List<Persona> listarPersonas() throws SQLException {
                List<Persona> lista = new ArrayList<>();
                String sql = "SELECT * FROM cliente";

                try (PreparedStatement stmt = con.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery()) {

                        while (rs.next()) {
                                lista.add(mapearPersona(rs));
                        }
                }
                return lista;
        }

        // Eliminar persona por ID
        public boolean eliminarPersona(int id) throws SQLException {
                String sql = "DELETE FROM cliente WHERE id = ?";

                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                        stmt.setInt(1, id);
                        return stmt.executeUpdate() > 0;
                }
        }

        // Utilidad para mapear ResultSet a Persona
        private Persona mapearPersona(ResultSet rs) throws SQLException {
                Persona persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setTipodocumento(rs.getInt("tipodocumento"));
                persona.setDocumento(rs.getString("cedula"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setCorreo(rs.getString("correo"));
                persona.setRuta(rs.getString("ruta"));
                persona.setNacimiento(rs.getDate("nacimiento"));
                persona.setEps(rs.getString("eps"));
                persona.setContacto(rs.getString("contacto"));
                persona.setTelefono2(rs.getString("telefono2"));
                persona.setRh(rs.getString("rh"));
                persona.setHuella(rs.getLong("huella"));
                persona.setModificado(rs.getTimestamp("modificado"));
                return persona;
        }

        // Utilidad para setear parámetros en PreparedStatement
        private void setParametros(PreparedStatement stmt, Persona persona) throws SQLException {
                stmt.setInt(1, persona.getTipodocumento());
                stmt.setString(2, persona.getDocumento());
                stmt.setString(3, persona.getNombre());
                stmt.setString(4, persona.getApellido());
                stmt.setString(5, persona.getTelefono());
                stmt.setString(6, persona.getDireccion());
                stmt.setString(7, persona.getCorreo());
                stmt.setString(8, persona.getRuta());
                stmt.setDate(9, persona.getNacimiento());
                stmt.setString(10, persona.getEps());
                stmt.setString(11, persona.getContacto());
                stmt.setString(12, persona.getTelefono2());
                stmt.setString(13, persona.getRh());
                stmt.setLong(14, persona.getHuella());
                stmt.setTimestamp(15, persona.getModificado());
        }
}
