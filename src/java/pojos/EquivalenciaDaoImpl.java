

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
        
        sessionFactory.getCurrentSession().update(e);
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
    public void insertarGrupoAsignaturasA(GrupoAsignaturaA grupo){
        
        
        sessionFactory.getCurrentSession().saveOrUpdate(grupo);
    }
     @Override
    public void insertarGrupoAsignaturasB(GrupoAsignaturaB grupo){
        
        
        sessionFactory.getCurrentSession().saveOrUpdate(grupo);
    }
   /* @Override
    public void insertarMiembroGrupoAsignatura(MiembroGrupoAsignaturaA m){
        
        sessionFactory.getCurrentSession().saveOrUpdate(m);
        
    }*/
    @Override
    public void creaContrato(Contrato c){
        
        sessionFactory.getCurrentSession().save(c);
    }
    @Override
    
    public void modificaContrato(Contrato c){
        
        sessionFactory.getCurrentSession().saveOrUpdate(c);
      
    }
    @Override
    public List<Contrato> listaContratos(Movilidad m){
        
        return sessionFactory.getCurrentSession().createQuery("select c from Contrato c where c.movilidad=:movilidad").setParameter("movilidad", m).list();
                
    }
    @Override
    public void eliminaContrato(Contrato c){
        
        sessionFactory.getCurrentSession().delete(c);
    }
    @Override
    public List<Equivalencia> listarEquivalenciasPorContrato(Integer id){
        
        return sessionFactory.getCurrentSession().createQuery("select e from Equivalencia e where e.contratos.idContrato").setParameter("id", id).list();
    }
    @Override
    public Contrato findContrato(Integer id){
        
       // return (Contrato)sessionFactory.getCurrentSession().createQuery("select c from Contrato c where c.idContrato=:contrato").setParameter("contrato", id).uniqueResult();
        return (Contrato)sessionFactory.getCurrentSession().get(Contrato.class, id);
    }
  
    @Override
   public List<Equivalencia> equivalenciasPublicas(String universidad){
       
       
       
       return sessionFactory.getCurrentSession().createQuery("select e from Equivalencia e where e.visible='si' and idequivalencia in(select  g.idequivalencia from GrupoAsignaturaB g where g.idequivalencia in" +
               "(select m.grupoAsignaturaB.idequivalencia from MiembroGrupoAsignaturaB m where m.asignatura.id.nombreUniversidad=:universidad))").setParameter("universidad", universidad).list();
   }
   
   @Override
   public List<Object[]> listaObject(){ 
       
       String query="select * from equivalencia";
       return sessionFactory.getCurrentSession().createSQLQuery(query).list();
   }
    
   
   
    
}
