<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sistemgym.model.Persona" %>

<%
    out.println("🟧 persona.jsp cargado");

    List<Persona> personas = (List<Persona>) session.getAttribute("personas");

    if (personas == null) {
        out.println("<p>⚠️ Lista de personas no recibida en sesión.</p>");
    } else {
        out.println("<p>✅ Lista recibida con " + personas.size() + " personas.</p>");
    }
%>

<h4>Registro de Persona</h4>
<form action="personas" method="post">
    <div>
        <label for="tipodocumento">Tipo de Documento:</label>
        <select name="tipodocumento" id="tipodocumento" required>
            <option value="1">Cédula</option>
            <option value="2">Pasaporte</option>
            <option value="3">Otro</option>
        </select>
    </div>
    <div>
        <label for="cedula">Número de Documento:</label>
        <input type="text" name="cedula" id="cedula" required>
    </div>
    <div>
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre" required>
    </div>
    <div>
        <label for="apellido">Apellido:</label>
        <input type="text" name="apellido" id="apellido" required>
    </div>
    <div>
        <label for="telefono">Teléfono:</label>
        <input type="text" name="telefono" id="telefono">
    </div>
    <div>
        <label for="direccion">Dirección:</label>
        <input type="text" name="direccion" id="direccion">
    </div>
    <div>
        <label for="correo">Correo:</label>
        <input type="email" name="correo" id="correo">
    </div>
    <div>
        <label for="ruta">Ruta:</label>
        <input type="text" name="ruta" id="ruta">
    </div>
    <div>
        <label for="nacimiento">Fecha de Nacimiento:</label>
        <input type="date" name="nacimiento" id="nacimiento">
    </div>
    <div>
        <label for="eps">EPS:</label>
        <input type="text" name="eps" id="eps">
    </div>
    <div>
        <label for="contacto">Contacto de Emergencia:</label>
        <input type="text" name="contacto" id="contacto">
    </div>
    <div>
        <label for="telefono2">Teléfono de Emergencia:</label>
        <input type="text" name="telefono2" id="telefono2">
    </div>
    <div>
        <label for="rh">Grupo RH:</label>
        <input type="text" name="rh" id="rh">
    </div>
    <div>
        <label for="huella">Código de Huella:</label>
        <input type="number" name="huella" id="huella">
    </div>
    <button type="submit">Registrar</button>
</form>

<h4>Personas registradas</h4>
<%
    if (personas != null && !personas.isEmpty()) {
%>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Documento</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Teléfono</th>
                <th>Correo</th>
                <th>EPS</th>
                <th>RH</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Persona p : personas) {
            %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getDocumento() %></td>
                    <td><%= p.getNombre() %></td>
                    <td><%= p.getApellido() %></td>
                    <td><%= p.getTelefono() %></td>
                    <td><%= p.getCorreo() %></td>
                    <td><%= p.getEps() %></td>
                    <td><%= p.getRh() %></td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
<%
    } else {
%>
    <p>No hay personas registradas.</p>
<%
    }
%>
