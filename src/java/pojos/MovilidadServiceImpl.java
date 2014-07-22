/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("movilidadService")
@Transactional
public class MovilidadServiceImpl implements MovilidadService{
    
    
    @Autowired
    private MovilidadDao movilidadDao;

    public MovilidadDao getMovilidadDao() {
        return movilidadDao;
    }

    public void setMovilidadDao(MovilidadDao movilidadDao) {
        this.movilidadDao = movilidadDao;
    }
    
    @Override
    public List<Movilidad> listarTodasMovilidades(){
        
        return movilidadDao.listarMovilidad();
        
    }
    @Override
    public List<Movilidad> listarMovilidadesPendientes(){
        
        String estado="pendiente";
        return movilidadDao.listarPorEstado(estado);
        
        
    }
    
    
}
