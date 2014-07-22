/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("movilidadDao") 
public class MovilidadDaoImpl implements MovilidadDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    
    
    
    @Override
    public void crearMovilidad(Movilidad c){
        
        sessionFactory.getCurrentSession().saveOrUpdate(c);
        
        
    }
    @Override
    public List<Movilidad> listarMovilidad(){
        
        return(sessionFactory.getCurrentSession().createQuery("select m from Movilidad m").list());
        
    }
    @Override
    public void cambiarMovilidad(Movilidad m){
        
        sessionFactory.getCurrentSession().saveOrUpdate(m);
        
    }
    
    
    @Override
    public void eliminarMovilidad(Movilidad m){
        
        sessionFactory.getCurrentSession().delete(m);
        
    }
    @Override
    public List<Movilidad> listarPorEstado(String estado){
        
        Query q=sessionFactory.getCurrentSession().createQuery("select m from Movilidad m where m.estado=:estado");
        q.setParameter("estado", estado);
        return(q.list());
    }
    
    
}
