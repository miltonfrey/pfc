

package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public List<Contrato> listaContratos(Movilidad m){
        return equivalenciaDao.listaContratos(m);
    }
    @Override
    public void eliminaContrato(Contrato c){
        
        
        equivalenciaDao.eliminaContrato(c);
       
    }
    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
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
      @Transactional(readOnly = true)
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
    
    
    @Override
    public int[] totalCreditos(ArrayList<Equivalencia> lista){
        
         int a=0;
         int b=0;
         
        for(Equivalencia e:lista){
            Iterator i=e.getGrupoAsignaturaA().getMiembroGrupoAsignaturaAs().iterator();
            while(i.hasNext()){
                MiembroGrupoAsignaturaA mA=(MiembroGrupoAsignaturaA)i.next();
                a=a+mA.getAsignatura().getCreditos();
            }
        }
        
        for(Equivalencia e:lista){
            Iterator i=e.getGrupoAsignaturaB().getMiembroGrupoAsignaturaBs().iterator();
            while(i.hasNext()){
                MiembroGrupoAsignaturaB mB=(MiembroGrupoAsignaturaB)i.next();
                b=b+mB.getAsignatura().getCreditos();
            }
        }
        
        return new int[]{a,b};
    }
    
    @Override
    public void confirmarContrato(ArrayList<Equivalencia> listaAuxEquivalencias,Contrato c){
        
        for(Equivalencia e:listaAuxEquivalencias){
          
            c.getEquivalencias().add(e);
            //e.getContratos().add(c); //No hace falta
            
            crearEquivalencia(e);
            crearGrupoAsignaturasA(e.getGrupoAsignaturaA());
            crearGrupoAsignaturasB(e.getGrupoAsignaturaB());
          
        }
        
        creaContrato(c);
        
    }
    
    @Override
    public void editarContrato(ArrayList<Equivalencia> listaAuxEquivalencias,Contrato c){
        
        ArrayList<Equivalencia> listaCopia=new ArrayList<Equivalencia>();
               
        
        for(Equivalencia e:c.getEquivalencias()){
            
            if(listaAuxEquivalencias.contains(e)==false){
              
                   listaCopia.add(e);
          
        }
        }
        
        for(Equivalencia e:listaCopia){
           
            c.getEquivalencias().remove(e);
            //e.getContratos().remove(c);
            
            //equivalenciaService.actualizarEquivalencia(e);
            modificaContrato(c);
            eliminarEquivalencia(e);
        
        }
        
        
        for(Equivalencia e:listaAuxEquivalencias){
            
         if(c.getEquivalencias().contains(e)==false){   
           
            //e.getContratos().add(c);
            c.getEquivalencias().add(e);
            crearEquivalencia(e);
            crearGrupoAsignaturasA(e.getGrupoAsignaturaA());
            crearGrupoAsignaturasB(e.getGrupoAsignaturaB());
         
        }
       
    }
       
            c.setEstado("pendiente");
            c.setFecha(Calendar.getInstance().getTime());
            modificaContrato(c);
        
    }
    
    
 
    @Override
     public void crearContratoDesdeAceptado(ArrayList<Equivalencia>listaAuxEquivalencias,Contrato c,Contrato cNuevo){
       
        
        
        for(Equivalencia e:listaAuxEquivalencias){
            
         if(c.getEquivalencias().contains(e)==true){   
            
            cNuevo.getEquivalencias().add(e);
            
         
           
        }else{
             
            crearEquivalencia(e);
            crearGrupoAsignaturasA(e.getGrupoAsignaturaA());
            crearGrupoAsignaturasB(e.getGrupoAsignaturaB());
             cNuevo.getEquivalencias().add(e);
         }
       
    }
        
        creaContrato(cNuevo);
        
    }
    
    
}         
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
          
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
