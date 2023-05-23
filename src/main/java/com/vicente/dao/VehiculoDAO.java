/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vicente.dao;

import com.vicente.model.Vehiculo;
import java.util.List;


public interface VehiculoDAO {
    // Método que devuelve el listado de objetos
    public List<Vehiculo> findAll();
    // Método que inserta un objeto en la BBDD
    public Vehiculo insert(Vehiculo objVehiculo);
    // Método que devuelve un objeto en base a su ID
    public Vehiculo findById(Integer id);
    // Método que modifica un objeto en la BBDD en base a su ID
    public Vehiculo updateById(Integer id, Vehiculo objVehiculo);
    // Método que elimina un objeto en la BBDD en base a su ID
    public Boolean deleteById(Integer id);
}
