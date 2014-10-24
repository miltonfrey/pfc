

package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("equivalenciaService")
public class EquivalenciaServiceImpl implements EquivalenciaService,Serializable{
 
    
    @Autowired
    private EquivalenciaDao equivalenciaDao;
    
   

    public EquivalenciaDao getEquivalenciaDao() {
        return equivalenciaDao;
    }

    public void setEquivalenciaDao(EquivalenciaDao equivalenciaDao) {
        this.equivalenciaDao = equivalenciaDao;
    }

    @Override
    public void crearEquivalencia(Equivalencia e){
        
        equivalenciaDao.insertarEquivalencia(e);
    }
    
    @Override
    public void eliminarEquivalencia(Equivalencia e){
        
        equivalenciaDao.eliminarEquivalencia(e);
        
    }
    @Override
    public void actualizarEquivalencia(Equivalencia e){
        
        equivalenciaDao.actualizarEquivalencia(e);
        
    }
    
    @Override
    public List<Equivalencia> listarEquivalencias(){
        
        return equivalenciaDao.listarEquivalencias();
    }
    
    @Override
    public void crearGrupoAsignaturasA(GrupoAsignaturaA grupo){
        
        equivalenciaDao.insertarGrupoAsignaturasA(grupo);
    }
    
    @Override
    public void crearGrupoAsignaturasB(GrupoAsignaturaB grupo){
        
        equivalenciaDao.insertarGrupoAsignaturasB(grupo);
    }
    
    
   /* @Override
    public void crearMiembroGrupoAsignatura(MiembroGrupoAsignatura m){
        
        equivalenciaDao.insertarMiembroGrupoAsignatura(m);
        
    }*/
    
    @Override
    public void creaContrato(Contrato c){
        equivalenciaDao.creaContrato(c);
        
    }
    
    @Override
    public void modificaContrato(Contrato c){
        equivalenciaDao.modificaContrato(c);
    }
    @Override
    public List<Contrato> listaContratos(Movilidad m){
        return equivalenciaDao.listaContratos(m);
    }
    @Override
    public void eliminaContrato(Contrato c){
        
        
        equivalenciaDao.eliminaContrato(c);
       
    }
    @Override
    public List<Equivalencia> listarEquivalenciasPorContrato(Integer id){
        List<Equivalencia> listaEquivalenciasPorcontrato=equivalenciaDao.listarEquivalenciasPorContrato(id);
        
        for(Equivalencia e:listaEquivalenciasPorcontrato){ 
            
        Hibernate.initialize(e.getGrupoAsignaturaB().getMiembroGrupoAsignaturaBs());
        Iterator i=e.getGrupoAsignaturaB().getMiembroGrupoAsignaturaBs().iterator();
        while(i.hasNext()){
            MiembroGrupoAsignaturaB m=(MiembroGrupoAsignaturaB)i.next();
            Hibernate.initialize(m.getAsignatura());
        }
        Hibernate.initialize(e.getGrupoAsignaturaA().getMiembroGrupoAsignaturaAs());
        Iterator j=e.getGrupoAsignaturaA().getMiembroGrupoAsignaturaAs().iterator();
        while(j.hasNext()){
            MiembroGrupoAsignaturaA m=(MiembroGrupoAsignaturaA)j.next();
            Hibernate.initialize(m.getAsignatura());
        }
        
        
        
        
        }
        return listaEquivalenciasPorcontrato;
        
    }
    
    @Override
    public Contrato findContrato(Integer id){
        
        Contrato c=equivalenciaDao.findContrato(id);
        Hibernate.initialize(c.getEquivalencias());
        for(Equivalencia e:c.getEquivalencias()){ 
            
        Hibernate.initialize(e.getGrupoAsignaturaB().getMiembroGrupoAsignaturaBs());
        Iterator i=e.getGrupoAsignaturaB().getMiembroGrupoAsignaturaBs().iterator();
        while(i.hasNext()){
            MiembroGrupoAsignaturaB m=(MiembroGrupoAsignaturaB)i.next();
            Hibernate.initialize(m.getAsignatura());
        }
        Hibernate.initialize(e.getGrupoAsignaturaA().getMiembroGrupoAsignaturaAs());
        Iterator j=e.getGrupoAsignaturaA().getMiembroGrupoAsignaturaAs().iterator();
        while(j.hasNext()){
            MiembroGrupoAsignaturaA m=(MiembroGrupoAsignaturaA)j.next();
            Hibernate.initialize(m.getAsignatura());
            
        }
        
        
        
        
    }
           return c; 
}       
  
      @Override      
    public List<Equivalencia> equivalenciasPublicas(String Universidad){
        
        ArrayList<Equivalencia> listaEquivalencias=(ArrayList < Equivalencia >)equivalenciaDao.equivalenciasPublicas(Universidad);
        Iterator i;
        for(Equivalencia e:listaEquivalencias){
            Hibernate.initialize(e.getGrupoAsignaturaA().getMiembroGrupoAsignaturaAs());
            i=e.getGrupoAsignaturaA().getMiembroGrupoAsignaturaAs().iterator();
            while(i.hasNext()){
                MiembroGrupoAsignaturaA m=(MiembroGrupoAsignaturaA)i.next();
                Hibernate.initialize(m.getAsignatura());
            }
            
             Hibernate.initialize(e.getGrupoAsignaturaB().getMiembroGrupoAsignaturaBs());
            i=e.getGrupoAsignaturaB().getMiembroGrupoAsignaturaBs().iterator();
            while(i.hasNext()){
                MiembroGrupoAsignaturaB m=(MiembroGrupoAsignaturaB)i.next();
                Hibernate.initialize(m.getAsignatura());
            }
        }
        return listaEquivalencias;
    }
    
    public List<Object[]> listaObject(){
        
        return equivalenciaDao.listaObject();
    }
    
    
}         
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
          
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
