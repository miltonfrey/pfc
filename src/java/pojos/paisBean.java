package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.springframework.dao.DataAccessException;

//import javax.faces.bean.SessionScoped;
//import javax.faces.component.UIComponent;
import pojos.utillidades.beanUtilidades;


@ManagedBean
@ViewScoped
public class paisBean implements Serializable{
    
    @ManagedProperty(value="#{universidadService}")
    private UniversidadService universidadService;

     
   @ManagedProperty(value="#{beanUtilidades}")
    private beanUtilidades beanUtilidades;
    
    public UniversidadService getUniversidadService() {
        return universidadService;
    }

    public void setUniversidadService(UniversidadService universidadService) {
        this.universidadService = universidadService;
    }

    public beanUtilidades getBeanUtilidades() {
        return beanUtilidades;
    }

    public void setBeanUtilidades(beanUtilidades beanUtilidades) {
        this.beanUtilidades = beanUtilidades;
    }
     
    private String paisStr;
    private Pais pais;
    private ArrayList<Pais> listaPaises;
    
     @PostConstruct
    public void init(){
        
        setListaPaises((ArrayList<Pais>)universidadService.listaPaises());
        
    }

    public String getPaisStr() {
        return paisStr;
    }

    public void setPaisStr(String paisStr) {
        this.paisStr = paisStr;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public ArrayList<Pais> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(ArrayList<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }
   
    
    
    
    
    
    public String creaPais(){
      
      
      try{
      universidadService.insertarPais(paisStr);
      }catch(DataAccessException ex){
          
          beanUtilidades.creaMensaje("se ha producido un error creando el país", FacesMessage.SEVERITY_ERROR);
          return null;
      }
          
          beanUtilidades.creaMensaje("se ha creado el país correctamente", FacesMessage.SEVERITY_INFO);
          paisStr="";
          listaPaises=(ArrayList<Pais>)universidadService.listaPaises();
      return null;
      
      
  }
  
  public String eliminaPais(){
      
      try{
          
          universidadService.deletePais(pais);
          
          
      }catch(DataAccessException ex){
          
          beanUtilidades.creaMensaje("se ha producido un error eliminando el país", FacesMessage.SEVERITY_ERROR);
          return null;
      }
      
      beanUtilidades.creaMensaje("se ha eliminado correctamente el pais", FacesMessage.SEVERITY_INFO);
      listaPaises=(ArrayList<Pais>)universidadService.listaPaises();
      return null;
  }
  
    
    
    
    
    
    
    
}  