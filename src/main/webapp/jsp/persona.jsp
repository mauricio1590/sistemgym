<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sistemgym.model.Persona" %>

<%
    List<Persona> personas = (List<Persona>) session.getAttribute("personas");
%>

<h4>Registro de Persona</h4>
<form action="personas" method="post" class="form-grid">
    <div class="form-group">
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre" required>
    </div>
    <div class="form-group">
        <label for="apellido">Apellido:</label>
        <input type="text" name="apellido" id="apellido" required>
    </div>
    <div class="form-group full-width">
        <button type="submit">Registrar</button>
    </div>
</form>

<h4>Personas registradas</h4>
<%
    if (personas != null && !personas.isEmpty()) {
%>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
            </tr>
        </thead>
        <tbody>
            <% for (Persona p : personas) { %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getNombre() %></td>
                    <td><%= p.getApellido() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
<%
    } else {
%>
    <p>No hay personas registradas.</p>
<%
    }
%>
