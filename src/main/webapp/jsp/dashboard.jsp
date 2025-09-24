<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sistemgym.model.Usuario" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - SistemGym</title>
    <link rel="stylesheet" href="../css/dashboard.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <!-- Sidebar fijo -->
        <div class="sidebar">
            <h2>SistemGym</h2>
            <ul>
                <li><a href="dashboard.jsp?vista=persona">👤 Persona</a></li>
                <li><a href="dashboard.jsp?vista=cliente">🧍 Cliente</a></li>
                <li><a href="dashboard.jsp?vista=pago">💳 Pago</a></li>
                <li><a href="dashboard.jsp?vista=gastos">💸 Gastos</a></li>
                <li><a href="dashboard.jsp?vista=ventas">🛒 Ventas</a></li>
                <li><a href="dashboard.jsp?vista=reportes">📊 Reportes</a></li>
            </ul>
        </div>

        <!-- Contenido principal -->
        <div class="main">
            <%
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                if (usuario != null) {
                    String nombre = usuario.getUsername();
            %>
                <h3>Bienvenido, <%= nombre %></h3>

                <div class="sub-content">
                    <%
                        String vista = request.getParameter("vista");
                        List<String> vistasPermitidas = Arrays.asList("persona", "cliente", "pago", "gastos", "ventas", "reportes");

                        if (vista != null && vistasPermitidas.contains(vista)) {
                            try {
                                out.println("Vista solicitada: " + vista);
                                RequestDispatcher rd = request.getRequestDispatcher("/jsp/" + vista + ".jsp");
                                rd.include(request, response);
                            } catch (Exception e) {
                                out.println("<p>Error al cargar la vista: " + vista + "</p>");
                            }
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
        </div>
    </div>
</body>
</html>
