package com.sistemgym.controller;

import com.sistemgym.dao.UsuarioDAO;
import com.sistemgym.dao.UsuarioDAOImpl;
import com.sistemgym.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");


        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Usuario usuario = usuarioDAO.validarLogin(username, password);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("jsp/dashboard.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");;
        }
    }
}
