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
    public Carrera find(String name,String uni);
    public void insertarCarrera(Carrera c);
    public void actualizar(Carrera c);
    public List<Carrera> listarPorUniversidad(String universidad);
    public List<Carrera> listarPorPais(String pais);
   public List<String> listarPorUniversidadStr(String universidad);
   public List<String> listarPorPaisStr(String pais);
    
}

