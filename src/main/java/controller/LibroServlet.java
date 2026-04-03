package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.LibroDAO;
import model.Libro;

public class LibroServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LibroDAO dao = new LibroDAO();

        List<Libro> lista = dao.listar();

        request.setAttribute("libros", lista);

        RequestDispatcher rd = request.getRequestDispatcher("views/libros.jsp");

        rd.forward(request, response);
    }
}