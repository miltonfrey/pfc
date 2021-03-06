/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("movilidadService")
@Transactional
public class MovilidadServiceImpl implements MovilidadService,Serializable{
    
    
    @Autowired
    private MovilidadDao movilidadDao;
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");

    public MovilidadDao getMovilidadDao() {
        return movilidadDao;
    }

    public void setMovilidadDao(MovilidadDao movilidadDao) {
        this.movilidadDao = movilidadDao;
    }
    
    @Override
    public List<Movilidad> listarTodasMovilidades(){
        
       List<Movilidad> aux=movilidadDao.listarMovilidad();
        for(Movilidad m:aux){
            Hibernate.initialize(m.getUniversidad());
        }
        return aux;
        
    }
    @Override
    public List<Movilidad> listarMovilidadesPendientes(){
        
        String estado="pendiente";
        return movilidadDao.listarPorEstado(estado);
        
        
    }
    
    @Override
    public Date fechaMin(){
        
        Calendar calendario=Calendar.getInstance();
        Date d=calendario.getTime();
        return d;
    }
    
    @Override
    public Date fechaMax(){
        Calendar calendario=Calendar.getInstance();
        calendario.add(1, 1);// máximo tiempo para empezar la movilidad
        Date d=calendario.getTime();
        return d;
        
    }
    
    @Override
    public void crearMovilidad(Movilidad m){
        
        movilidadDao.crearMovilidad(m);
    }
    
    @Override
    public List<Movilidad> listarMisMovilidades(String user){
        
        List<Movilidad> aux= movilidadDao.listarMisMovilidades(user);
        for(Movilidad m:aux){
            
            
            if(m.getFechaFin().compareTo(new Date())==-1){
                m.setEstado("terminada");
            }
            
            
        }
        return aux;
    }
    @Override
    public List<Movilidad> listarMisMovilidadesPorEstado(String user, String estado){
        return movilidadDao.listarMisMovilidadesPorEstado(user, estado);
    }
    @Override
    public void eliminarMovilidad(Movilidad m){
        
        movilidadDao.eliminarMovilidad(m);
    }
    
    @Override
    public List<Object> doJoin(){
        
        return movilidadDao.doJoin();
        
    }
    
    
    @Override
    public List<Movilidad> listarMovilidadesValidas(String user){
        
        return movilidadDao.listarMovilidadesValidas(user);
        
        
    }
    
    @Override
    public Movilidad findMovilidad(Integer id){
        
        Movilidad m=movilidadDao.findMovilidad(id);
        Hibernate.initialize(m.getUniversidad());
        return m;
    }
    
    
}
