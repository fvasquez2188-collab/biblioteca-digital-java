package controller;

import dao.PrestamoDAO;
import model.Prestamo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet("/PrestamoServlet")
public class PrestamoServlet extends HttpServlet {

    PrestamoDAO dao = new PrestamoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion.equals("listar")) {
            request.setAttribute("lista", dao.listar());
            request.getRequestDispatcher("prestamo.jsp").forward(request, response);
        }

        if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            response.sendRedirect("PrestamoServlet?accion=listar");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            int idLibro = Integer.parseInt(request.getParameter("idLibro"));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            java.util.Date fechaPrestamo = sdf.parse(request.getParameter("fechaPrestamo"));
            java.util.Date fechaDevolucion = sdf.parse(request.getParameter("fechaDevolucion"));

            Prestamo p = new Prestamo(idUsuario, idLibro, fechaPrestamo, fechaDevolucion);

            dao.registrar(p);

            response.sendRedirect("PrestamoServlet?accion=listar");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}