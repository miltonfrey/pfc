package pojos;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("universidadService")
@Transactional
public class UniversidadServiceImpl implements UniversidadService,Serializable{
    
    @Autowired
    private UniversidadDao universidadDao;

    public UniversidadDao getCarreraDao() {
        return universidadDao;
    }

    public void setCarreraDao(UniversidadDao carreraDao) {
        this.universidadDao = carreraDao;
    }
    
    @Override
    public List<Pais> listaPaises(){
        
        return universidadDao.listaPaises();
    }
    
    @Override
    public List<Universidad> listaUniversidades(){
        
        return universidadDao.listaUniversidades();
    }
    
    @Override
    public Pais findPais(String pais){
        
        return universidadDao.findPais(pais);
    }
    
    
    @Override
    public void insertarPais(String pais){
        
        
        Pais p=new Pais(pais);
        universidadDao.insertarPais(p);        
            
        
    }
    @Override
    public void deletePais(Pais p){
        
        universidadDao.deletePais(p);
    }
    
    
    
    @Override
    public List<Universidad> listar(){
        
        return(universidadDao.listarUniversidades());
    }
    
    @Override
    public void delete(Universidad u){
        
        universidadDao.delete(u);
        
    }
    
    
        
    
    @Override
    public void insertarUniversidad(Universidad u){
        
     universidadDao.insertarCarrera(u);
        
        
    }
    @Override
    public void actualizar(Universidad u){
        
        universidadDao.actualizar(u);
        
    }
    
    @Override
    public List<Universidad>listarPorUniversidad(String universidad){
        
        return universidadDao.listarPorUniversidad(universidad);
    }
    
    @Override
    public List<Universidad>listarPorPais(String pais){
        
        return universidadDao.listarPorPais(pais);
        
    }
    @Override
    public List<String>listarPorPaisStr(String pais){
        
       
        
        return universidadDao.listarPorPaisStr(pais);
    }
    @Override
    public List<String>listarPorUniversidadStr(String universidad){
        
        return universidadDao.listarPorUniversidadStr(universidad);
        
        
    }
    @Override
   public void crearCursoAcademico(String cursoAcademico){
       
       Cursoacademico c=new Cursoacademico(cursoAcademico);
       universidadDao.crearCursoAcademico(c);
       
   }
   @Override
   public void eliminarCursoAcademico(String cursoAcademico){
       
       
           
           
       
       
       
       
       Cursoacademico c=new Cursoacademico(cursoAcademico);
       universidadDao.eliminarCursoAcademico(c);
       
       
   }
    
   @Override
   public List<Cursoacademico> listaCursosAcademicos(){
       
       return universidadDao.listaCursosAcademicos();
   }
   
   
   @Override
   public Universidad findUniversidad(String universidad){
       
       return universidadDao.findUniversidad(universidad);
   }
    
}

