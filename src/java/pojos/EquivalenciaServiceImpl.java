

package pojos;

import java.io.Serializable;
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
    public void crearGrupoAsignaturas(GrupoAsignatura grupo){
        
        equivalenciaDao.insertarGrupoAsignaturas(grupo);
    }
    
    
    @Override
    public void crearMiembroGrupoAsignatura(MiembroGrupoAsignatura m){
        
        equivalenciaDao.insertarMiembroGrupoAsignatura(m);
        
    }
    
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
    public List<Equivalencia> listarEquivalenciasPorContrato(Contrato c){
        List<Equivalencia> listaEquivalenciasPorcontrato=equivalenciaDao.listarEquivalenciasPorContrato(c);
        for(Equivalencia e:listaEquivalenciasPorcontrato){
        
        Hibernate.initialize(e.getGrupoAsignaturaByGrupoAsignaturaB().getMiembroGrupoAsignaturas());
        Iterator i=e.getGrupoAsignaturaByGrupoAsignaturaB().getMiembroGrupoAsignaturas().iterator();
        while(i.hasNext()){
            MiembroGrupoAsignatura m=(MiembroGrupoAsignatura)i.next();
            Hibernate.initialize(m.getAsignatura());
        }
        Hibernate.initialize(e.getGrupoAsignaturaByGrupoAsignaturaA().getMiembroGrupoAsignaturas());
        Iterator j=e.getGrupoAsignaturaByGrupoAsignaturaA().getMiembroGrupoAsignaturas().iterator();
        while(j.hasNext()){
            MiembroGrupoAsignatura m=(MiembroGrupoAsignatura)j.next();
            Hibernate.initialize(m.getAsignatura());
        }
        
        
        }
        return listaEquivalenciasPorcontrato;
    }
            
}       
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
          
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
