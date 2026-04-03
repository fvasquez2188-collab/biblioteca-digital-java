package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response
            ) throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = dao.login(usuario, password);

        if(user != null){

            HttpSession session = request.getSession();
            session.setAttribute("usuario", user);

            response.sendRedirect("libros");

        } else {

            response.sendRedirect("index.jsp");

        }

    }
}