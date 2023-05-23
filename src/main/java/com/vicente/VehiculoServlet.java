/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vicente;

import com.vicente.dao.VehiculoDAO;
import com.vicente.dao.VehiculoDAOImpl;
import com.vicente.model.Vehiculo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/VehiculoServlet")
public class VehiculoServlet extends HttpServlet {

    private VehiculoDAO vehiculoDao;

    public VehiculoServlet() {
        super();
        vehiculoDao = new VehiculoDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.procesarSolicitud(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.procesarSolicitud(req, resp);
    }

    protected void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("action")) {
            case "list":
                // this.list(request, response);
                break;
            case "create":
                this.create(request, response);
                break;
            case "read":
                // this.read(request, response);
                break;
            case "update":
                //this.update(request, response);
                break;
            case "delete":
                // this.delete(request, response);
                break;
            case "showRegister":
                this.showRegister(request, response);
                break;
            case "index":
                this.index(request, response);
                break;
            default:
                this.index(request, response);
                break;
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/create.jsp");
        dispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String marca = request.getParameter("marca");
        String color = request.getParameter("color");
        String modelo = request.getParameter("modelo");
        String tipo = request.getParameter("tipo");

        // Crear el objeto que se envía al BD
        Vehiculo objVehiculo = new Vehiculo();
        objVehiculo.setMarca(marca);
        objVehiculo.setColor(color);
        objVehiculo.setModelo(modelo);
        objVehiculo.setTipo(tipo);

        vehiculoDao.insert(objVehiculo);

        // Redireccionar al "index"
        this.index(request, response);
    }
}


