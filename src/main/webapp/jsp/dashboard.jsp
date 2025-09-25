<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sistemgym.model.Usuario" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - SistemGym</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/dashboard.css">
</head>
<body>
    <div class="container">
        <!-- Menú lateral -->
        <aside class="sidebar">
            <h2>SistemaGym</h2>
            <ul>
                <li><a href="dashboard.jsp?vista=persona">👤 Persona</a></li>
                <li><a href="dashboard.jsp?vista=clases">📚 Clases</a></li>
                <li><a href="dashboard.jsp?vista=gym">🏋️ Gym</a></li>
                <li><a href="dashboard.jsp?vista=talleres">🛠 Talleres</a></li>
                <li><a href="dashboard.jsp?vista=reportes">📊 Reportes</a></li>
            </ul>
        </aside>

        <!-- Contenido principal -->
        <main class="main">
            <%
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                if (usuario != null) {
                    String nombre = usuario.getUsername();
            %>
                <h3>Bienvenido, <%= nombre %></h3>
                <div class="sub-content">
                    <%
                        String vista = request.getParameter("vista");
                        List<String> vistasPermitidas = Arrays.asList("persona", "clases", "gym", "talleres", "reportes");

                        if (vista != null && vistasPermitidas.contains(vista)) {
                            RequestDispatcher rd = request.getRequestDispatcher("/jsp/" + vista + ".jsp");
                            rd.include(request, response);
                        } else {
                            out.println("<p>Selecciona una opción del menú para comenzar.</p>");
                        }
                    %>
                </div>
            <%
                } else {
                    response.sendRedirect("../login.jsp");
                }
            %>
        </main>
    </div>
</body>
</html>
