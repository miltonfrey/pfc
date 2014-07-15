/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.List;


public interface CarreraDao {
    public List<Carrera> listarCarreras();
    public void delete(Carrera c);
    public Carrera find(String name);
    public void insertarCarrera(Carrera c);
    public void actualizar(Carrera c);
    
    
    
}

