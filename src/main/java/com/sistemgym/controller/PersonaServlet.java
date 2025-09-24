package com.sistemgym.controller;

import com.sistemgym.dao.PersonaDAO;
import com.sistemgym.model.Persona;
import com.sistemgym.util.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {
    private PersonaDAO dao;

    @Override
    public void init() throws ServletException {
        try {
            Connection con = DBConnection.getConnection();
            dao = new PersonaDAO(con);
        } catch (SQLException e) {
            throw new ServletException("Error al conectar con la base de datos", e);
        }
    }

    // Listar, buscar y eliminar personas
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        try {
            if ("buscar".equals(accion)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Persona persona = dao.obtenerPersonaPorId(id);
                request.setAttribute("persona", persona);
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/formularioPersona.jsp");
                rd.forward(request, response);

            } else if ("eliminar".equals(accion)) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.eliminarPersona(id);
                List<Persona> personas = dao.listarPersonas();
                request.setAttribute("personas", personas);
                RequestDispatcher rd = request.getRequestDispatcher("jsp/dashboard.jsp?vista=persona");
                rd.forward(request, response);

            } else { // listar
                List<Persona> personas = dao.listarPersonas();
                request.setAttribute("personas", personas);
                RequestDispatcher rd = request.getRequestDispatcher("jsp/dashboard.jsp?vista=persona");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("jsp/dashboard.jsp?vista=persona&error=1");
        }
    }

    // Registrar o actualizar persona
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Persona persona = new Persona();
            persona.setTipodocumento(Integer.parseInt(request.getParameter("tipodocumento")));
            persona.setDocumento(request.getParameter("cedula"));
            persona.setNombre(request.getParameter("nombre"));
            persona.setApellido(request.getParameter("apellido"));
            persona.setTelefono(request.getParameter("telefono"));
            persona.setDireccion(request.getParameter("direccion"));
            persona.setCorreo(request.getParameter("correo"));
            persona.setRuta(request.getParameter("ruta"));
            persona.setNacimiento(java.sql.Date.valueOf(request.getParameter("nacimiento")));
            persona.setEps(request.getParameter("eps"));
            persona.setContacto(request.getParameter("contacto"));
            persona.setTelefono2(request.getParameter("telefono2"));
            persona.setRh(request.getParameter("rh"));
            persona.setHuella(Long.parseLong(request.getParameter("huella")));
            persona.setModificado(new java.sql.Timestamp(System.currentTimeMillis()));

            String idParam = request.getParameter("id");
            boolean exito;

            if (idParam != null && !idParam.isEmpty()) {
                persona.setId(Integer.parseInt(idParam));
                exito = dao.actualizarPersona(persona);
            } else {
                exito = dao.registrarPersona(persona);
            }

            if (exito) {
                List<Persona> personas = dao.listarPersonas();
                request.setAttribute("personas", personas);
                RequestDispatcher rd = request.getRequestDispatcher("jsp/dashboard.jsp?vista=persona");
                rd.forward(request, response);
            } else {
                request.setAttribute("error", "No se pudo guardar la persona.");
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/formularioPersona.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("jsp/dashboard.jsp?vista=persona&error=2");
        }
    }
}
