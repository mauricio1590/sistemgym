<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sistemgym.model.Persona" %>

<h4>Registro de Persona</h4>
<form action="PersonaServlet" method="post">
    <div>
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre" required>
    </div>
    <div>
        <label for="apellido">Apellido:</label>
        <input type="text" name="apellido" id="apellido" required>
    </div>
    <div>
        <label for="documento">Documento:</label>
        <input type="text" name="documento" id="documento" required>
    </div>
    <div>
        <label for="edad">Edad:</label>
        <input type="number" name="edad" id="edad">
    </div>
    <button type="submit">Registrar</button>
</form>

<h4>Personas registradas</h4>
<%
    List<Persona> personas = (List<Persona>) request.getAttribute("personas");
    if (personas != null && !personas.isEmpty()) {
%>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Documento</th>
                <th>Edad</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Persona p : personas) {
            %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getNombre() %></td>
                    <td><%= p.getApellido() %></td>
                    <td><%= p.getDocumento() %></td>
                    <td><%= p.getEdad() %></td>
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
