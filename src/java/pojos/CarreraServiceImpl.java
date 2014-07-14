/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("carreraService")
@Transactional
public class CarreraServiceImpl implements CarreraService{
    
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
    
}
