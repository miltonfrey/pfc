/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.RowEditEvent;


@ManagedBean
@RequestScoped
public class beanCarrera implements Serializable{
    
    @ManagedProperty(value="#{carreraService}")
    private CarreraService carreraService;
    
    private String pais;
    private String nombre;
    private String universidad;
    private String info;
    private String web;
    private Carrera selectedCarrera;
    
    private ArrayList<Carrera> listaCarreras;
    private ArrayList<String> paises;
    
    @PostConstruct
    public void init(){
        setListaCarreras((ArrayList<Carrera>)carreraService.listar());
        ArrayList<String>aux=new ArrayList<String>();
        aux.add("Alemania");
        aux.add("Francia");
        aux.add("Italia");
        aux.add("Suecia");
        setPaises(aux);
        
    }
    
    
    public beanCarrera() {
        
        
    }

    public CarreraService getCarreraService() {
        return carreraService;
    }

    public void setCarreraService(CarreraService carreraService) {
        this.carreraService = carreraService;
    }
    
    

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    
    

    public ArrayList<Carrera> getListaCarreras() {
        setListaCarreras(listaCarreras);
        return listaCarreras;
    }

    public void setListaCarreras(ArrayList<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    public ArrayList<String> getPaises() {
        return paises;
    }

    public void setPaises(ArrayList<String> paises) {
        this.paises = paises;
    }
    
    public String creaCarrera(){
        
        Carrera c=new Carrera();
        CarreraId id=new CarreraId(nombre,universidad);
        c.setId(id);
        c.setInfo(info);
        c.setPais(pais);
        c.setWeb(web);
        
        try{
            
            carreraService.insertarCarrera(c);
            
        }catch(org.springframework.dao.DataIntegrityViolationException ex){
            creaMensaje("ya existe esa carrera en esa universidad", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        
        creaMensaje("carrera creada", FacesMessage.SEVERITY_INFO);
        setNombre("");
        setUniversidad("");
        setPais("");
        actualizar();
        return "";
        
    }
    
    
    public void actualizar(){
        
        setListaCarreras((ArrayList<Carrera>)carreraService.listar());
    }

    public Carrera getSelectedCarrera() {
        return selectedCarrera;
    }

    public void setSelectedCarrera(Carrera selectedCarrera) {
        this.selectedCarrera = selectedCarrera;
    }
    
    
    
    
    
    
    
    
    
    
    
    
 public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
 
 
  public String salir(){
            
            
            
            HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.invalidate();
            return("/principal.xhtml?faces-redirect=true");
            
        }
  
  public List<String> completa(String text){
      
      
      ArrayList<String> lista=paises;
      return lista;
      
  }
  
  
  public String onRowEdit(RowEditEvent event){
      
      
      
      Carrera c=(Carrera)event.getObject();
      Carrera d=selectedCarrera;
      try{
          
          carreraService.actualizar(c);
          
      }catch(Exception ex){
          
          creaMensaje("se ha producido un error al actualizar "+ selectedCarrera.getId().getNombre(), FacesMessage.SEVERITY_ERROR);
          return "";
      }
      
      creaMensaje("carrera actualiza", FacesMessage.SEVERITY_INFO);
      return "";
  }
  
  
  
  public void onRowCancel(RowEditEvent event){
      
      creaMensaje("edicion cancelada", FacesMessage.SEVERITY_INFO);
      
  }
    
 
  public String eliminaCarreraLista(){
      
      try{
          
          carreraService.delete(selectedCarrera);
          
      }catch(Exception ex){
          
          creaMensaje("error al eliminar", FacesMessage.SEVERITY_ERROR);
          return "";
      }
      
      
      creaMensaje("carrera eliminada correctamente", FacesMessage.SEVERITY_INFO);
      actualizar();
      selectedCarrera=null;
  return "";
  
  
}
}
