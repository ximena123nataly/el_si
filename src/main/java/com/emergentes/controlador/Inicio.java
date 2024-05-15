package com.emergentes.controlador;

import com.emergentes.dao.EstuDAO;
import com.emergentes.dao.EstuDAOimpl;
import com.emergentes.modelo.estu;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name="Inicio", urlPatterns=("/inicio"))
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            EstuDAO dao = new EstuDAOimpl();
            int id;
            estu est = new estu();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    est = dao.getById(id);
                    System.out.println(est);
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/inicio");
                    break;
                case "view":
                    List<estu> lista = dao.getAll();
                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        int sseminarios = Integer.parseInt(request.getParameter("sseminarios"));
        boolean confirmado = Boolean.parseBoolean(request.getParameter("confirmado"));
        String fechaInscripcion = request.getParameter("fecha_inscripcion");

        estu est = new estu();
        est.setId(id);
        est.setNombre(nombre);
        est.setApellidos(apellidos);
        est.setSseminarios(sseminarios);
        est.setConfirmado(confirmado);
        est.setFechaInscripcion(fechaInscripcion);

        try {
            EstuDAO dao = new EstuDAOimpl();
            if (id == 0) {
                dao.insert(est);
            } else {
                dao.update(est);
            }
            response.sendRedirect(request.getContextPath() + "/inicio");
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }
}
