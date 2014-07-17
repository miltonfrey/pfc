package pojos;

import java.io.Serializable;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("carreraDao")
public class CarreraDaoImpl implements CarreraDao,Serializable{
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    
    @Override
    public Carrera find(String name){
        
        Session session=sessionFactory.getCurrentSession();
        Query q=session.createQuery("select c from Carrera c where c.id.nombre=:name");
        q.setParameter("name", name);
        return (Carrera)q.uniqueResult();
        
        
    }
    @Override
    public void delete(Carrera c){
        
        sessionFactory.getCurrentSession().delete(c);
    }
    @Override
    public List<Carrera> listarCarreras(){
        
        return(sessionFactory.getCurrentSession().createQuery("select c from Carrera c").list());
        
    }
    
    @Override
    public void insertarCarrera(Carrera c){
        
        sessionFactory.getCurrentSession().save(c);
        
    }
    
    @Override
    public void actualizar(Carrera c){
        
        sessionFactory.getCurrentSession().saveOrUpdate(c);
    }
    
}

