<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - SistemGym</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css?v=2">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
    <div class="login-container">
        <h2><i class="fas fa-dumbbell"></i> SistemGym</h2>
        <form action="login" method="post">
            <label for="usuario">Usuario</label>
            <input type="text" name="username" id="usuario" placeholder="Ingresa tu usuario" required>

            <label for="clave">Contraseña</label>
            <input type="password" name="password" id="clave" placeholder="Ingresa tu contraseña" required>

            <button type="submit">Ingresar</button>

            <%
                String error = request.getParameter("error");
                if ("1".equals(error)) {
            %>
                <p class="error">Usuario o contraseña incorrectos.</p>
            <%
                }
            %>
        </form>
    </div>3
    <script>
        const hour = new Date().getHours();
        const body = document.body;

        if (hour >= 6 && hour < 18) {
            body.classList.add('day-mode');
        } else {
            body.classList.add('night-mode');
        }
    </script>

</body>
</html>

