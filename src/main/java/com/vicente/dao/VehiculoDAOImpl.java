/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vicente.dao;

import com.vicente.config.Conexion;
import com.vicente.model.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;


public class VehiculoDAOImpl implements VehiculoDAO {

    private Conexion objConexion;
    private Connection objConnection;

    public VehiculoDAOImpl() {
        objConexion = new Conexion();
    }

    @Override
    public List<Vehiculo> findAll() {
        String consulta = "SELECT * FROM vehiculos";
        List<Vehiculo> listado = new LinkedList<>();

        try {
            this.objConexion.conectar();
            this.objConnection = this.objConexion.getJdbcConnection();

            PreparedStatement prest = this.objConnection.prepareStatement(consulta);
            ResultSet rs = prest.executeQuery();

            Vehiculo objVehiculo;

            while (rs.next()) {
                objVehiculo = new Vehiculo();
                objVehiculo.setId(rs.getInt("id"));
                objVehiculo.setMarca(rs.getString("marca"));
                objVehiculo.setColor(rs.getString("color"));
                objVehiculo.setModelo(rs.getString("modelo"));
                objVehiculo.setTipo(rs.getString("tipo"));

                listado.add(objVehiculo);
            }

        } catch (Exception e) {
            System.out.println("Error en la consulta");
        }
        return listado;
    }

    @Override
    public Vehiculo insert(Vehiculo objVehiculo) {
        String consulta = "INSERT INTO vehiculos (marca, color, modelo, tipo) VALUES (?,?,?,?)";
        try {
            this.objConexion.conectar();
            this.objConnection = this.objConexion.getJdbcConnection();

            PreparedStatement prest = this.objConnection.prepareStatement(consulta);
            prest.setString(1, objVehiculo.getMarca());
            prest.setString(2, objVehiculo.getColor());
            prest.setString(3, objVehiculo.getModelo());
            prest.setString(4, objVehiculo.getTipo());

            int count = prest.executeUpdate();

            ResultSet rs = null;
            rs = prest.executeQuery("SELECT LAST_INSERT_ID()");

            int autoKey = -1;
            if (rs.next()) {
                autoKey = rs.getInt(1);
                objVehiculo.setId(autoKey);
                System.out.println("Último ID introducido: " + autoKey);
            } else {
                System.out.println("No existe dato de ID");
            }
        } catch (Exception e) {
            System.out.println("Error al insertar");
        }
        return objVehiculo;
    }

    @Override
    public Vehiculo findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vehiculo updateById(Integer id, Vehiculo objVehiculo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
