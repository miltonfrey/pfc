/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("carreraService")
@Transactional
public class CarreraServiceImpl implements CarreraService,Serializable{
    
    @Autowired
    private CarreraDao carreraDao;

    public CarreraDao getCarreraDao() {
        return carreraDao;
    }

    public void setCarreraDao(CarreraDao carreraDao) {
        this.carreraDao = carreraDao;
    }
    
    @Override
    public List<Carrera> listar(){
        
        return(carreraDao.listarCarreras());
    }
    
    @Override
    public void delete(Carrera c){
        
        carreraDao.delete(c);
        
    }
    
    @Override
    public Carrera find(String name){
        
        return carreraDao.find(name);
        
    }
    @Override
    public void insertarCarrera(Carrera c){
        
        carreraDao.insertarCarrera(c);
        
        
    }
    @Override
    public void actualizar(Carrera c){
        
        carreraDao.actualizar(c);
        
    }
    
    @Override
    public List<Carrera>listarPorUniversidad(String universidad){
        
        return carreraDao.listarPorUniversidad(universidad);
    }
    
    @Override
    public List<Carrera>listarPorPais(String pais){
        
        return carreraDao.listarPorPais(pais);
        
    }
    @Override
    public List<String>listarPorPaisStr(String pais){
        
       
        
        return carreraDao.listarPorPaisStr(pais);
    }
    @Override
    public List<String>listarPorUniversidadStr(String universidad){
        
        return carreraDao.listarPorUniversidadStr(universidad);
        
        
    }
    
    public String prueba(){
        
        return "mierda";
    }
    
    
}
