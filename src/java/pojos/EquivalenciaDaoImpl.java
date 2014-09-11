

package pojos;


import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("equivalenciaDao")
public class EquivalenciaDaoImpl implements EquivalenciaDao,Serializable {
    
@Autowired    
private SessionFactory sessionFactory;    

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Override
    public void insertarEquivalencia(Equivalencia e){
        
        sessionFactory.getCurrentSession().save(e);
     
    }
    @Override
    public void actualizarEquivalencia(Equivalencia e){
        
        sessionFactory.getCurrentSession().saveOrUpdate(e);
    }
    
    @Override
    public void eliminarEquivalencia(Equivalencia e){
        
        sessionFactory.getCurrentSession().delete(e);
        
    }
    
    @Override
    public List<Equivalencia> listarEquivalencias(){
        
        
        return sessionFactory.getCurrentSession().createQuery("select e from Equivalencia e").list();
    }
    @Override
    public void insertarGrupoAsignaturas(GrupoAsignatura grupo){
        
        
        sessionFactory.getCurrentSession().saveOrUpdate(grupo);
    }
    @Override
    public void insertarMiembroGrupoAsignatura(MiembroGrupoAsignatura m){
        
        sessionFactory.getCurrentSession().saveOrUpdate(m);
        
    }
    
    
}
