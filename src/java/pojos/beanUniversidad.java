

package pojos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;
//import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
//import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;


@ManagedBean
@RequestScoped
public class beanUniversidad implements Serializable{
    
    @ManagedProperty(value="#{universidadService}")
    private UniversidadService universidadService;
    
    
    private String cursoAcademico;
    private ArrayList<Cursoacademico> listaCursoAcademico;
    
    private String paisStr;
    private Pais pais;
    
    
    
    
    private String codUniversidad;
    private String nombre;
    private String universidadStr;
    private String info;
    private String web;
   
    
    private ArrayList<Universidad> listaUniversidades;
    private ArrayList<Pais> listaPaises;
    
    
    private boolean checkPaisStr;
  
    
    private Pais selectedPais;
    private Universidad selectedUniversidad;
    
    
    
    
    @PostConstruct
    public void init(){
        //setListaUniversidades((ArrayList<Universidad>)universidadService.listar());
        setListaPaises((ArrayList<Pais>)universidadService.listaPaises());
        setListaUniversidades((ArrayList<Universidad>)universidadService.listaUniversidades());
        HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (request.getRequestURI().equals("/pfc/admin/crearCursoAcademico.xhtml")==true){
            
            setListaCursoAcademico((ArrayList < Cursoacademico >)universidadService.listaCursosAcademicos());
        }
        
    }
    
    
    public beanUniversidad() {
        
        
    }

    public UniversidadService getUniversidadService() {
        return universidadService;
    }

    public void setUniversidadService(UniversidadService universidadService) {
        this.universidadService = universidadService;
    }

    public String getCursoAcademico() {
        return cursoAcademico;
    }

    public void setCursoAcademico(String cursoAcademico) {
        this.cursoAcademico = cursoAcademico;
    }

    public ArrayList<Cursoacademico> getListaCursoAcademico() {
        return listaCursoAcademico;
    }

    public void setListaCursoAcademico(ArrayList<Cursoacademico> listaCursoAcademico) {
        this.listaCursoAcademico = listaCursoAcademico;
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

    public String getUniversidadStr() {
        return universidadStr;
    }

    public void setUniversidadStr(String universidadStr) {
        this.universidadStr = universidadStr;
    }

    public String getCodUniversidad() {
        return codUniversidad;
    }

    public void setCodUniversidad(String codUniversidad) {
        this.codUniversidad = codUniversidad;
    }
    
    
    

    public Pais getSelectedPais() {
        return selectedPais;
    }

    public void setSelectedPais(Pais selectedPais) {
        this.selectedPais = selectedPais;
    }

   
    
   
   
    public ArrayList<Pais> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(ArrayList<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }
   
 public ArrayList<Universidad> getListaUniversidades() {
       
        return listaUniversidades;
    }

    public void setListaUniversidades(ArrayList<Universidad> listaUniversidades) {
        this.listaUniversidades = listaUniversidades;
    }
   
    
    
    
    

   
 
 
   

    
    
    
   
    
    
    
    
    
    public Universidad getSelectedUniversidad() {
        return selectedUniversidad;
    }

    public void setSelectedUniversidad(Universidad selectedUniversidad) {
        this.selectedUniversidad = selectedUniversidad;
    }

   

    public boolean isCheckPaisStr() {
        return checkPaisStr;
    }

    public void setCheckPais(boolean checkPaisStr) {
        this.checkPaisStr = checkPaisStr;
    }

  
  
  
 
  
  
  public String creaUniversidad(){
        Pais p=universidadService.findPais(paisStr);
        Universidad u=new Universidad();
        u.setInfo(info);
        u.setNombre(nombre);
        u.setPais(p);
        u.setWeb(web);
        u.setCodUniversidad(codUniversidad);
        try{
            
            universidadService.insertarUniversidad(u);
            
        }catch(org.springframework.dao.DataIntegrityViolationException ex){
            creaMensaje("ya existe esa universidad", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        
        creaMensaje("universidad creada", FacesMessage.SEVERITY_INFO);
        nombre="";
        web="";
        info="";
        paisStr="";
        codUniversidad="";
        actualizarUniversidad();
        return "";
        
    }
    
  
  
    
 
  public String eliminaUniversidadLista(){
      
      
      
      
      try{
          
          universidadService.delete(selectedUniversidad);
          
      }catch(Exception ex){
          
          creaMensaje("error al eliminar", FacesMessage.SEVERITY_ERROR);
          return "";
      }
      
      
      creaMensaje("universidad eliminada correctamente "+selectedUniversidad.getNombre(), FacesMessage.SEVERITY_INFO);
      actualizarUniversidad();
      selectedUniversidad=null;
  return "";
  
  
}
  
  
  public String creaPais(){
      
      
      try{
      universidadService.insertarPais(paisStr);
      }catch(DataAccessException ex){
          
          creaMensaje("se ha producido un error creando el país", FacesMessage.SEVERITY_ERROR);
          return null;
      }
          
          creaMensaje("se ha creado el país correctamente", FacesMessage.SEVERITY_INFO);
          paisStr="";
          actualizarPais();
      return null;
      
      
  }
  
  public String eliminaPais(){
      
      try{
          
          universidadService.deletePais(pais);
          
          
      }catch(DataAccessException ex){
          
          creaMensaje("se ha producido un error eliminando el país", FacesMessage.SEVERITY_ERROR);
          return null;
      }
      
      creaMensaje("se ha eliminado correctamente el pais", FacesMessage.SEVERITY_INFO);
      actualizarPais();
      return null;
  }
  
  
  public String creaCursoAcademico(){
      
      if(cursoAcademico.substring(0, 2).compareTo(cursoAcademico.substring(3, 5))!=-1){
          
          creaMensaje("el curso académico no puede empezar más tarde de lo que acaba",FacesMessage.SEVERITY_ERROR);
          return "";
      }
      
      try{
          
          universidadService.crearCursoAcademico(cursoAcademico);
          
      }catch(RuntimeException ex){
          
          creaMensaje("El año "+cursoAcademico+" ya existe", FacesMessage.SEVERITY_ERROR);
          return "";
      }
      
      creaMensaje("curso académico creado correctamente", FacesMessage.SEVERITY_INFO);
      actualizarCursoAcademico();
      cursoAcademico="";
      return "";
      
  }
  
  public String eliminarCursoAcademico(){
      
      try{
          
          universidadService.eliminarCursoAcademico(cursoAcademico);
          
      }catch(Exception ex){
          
          creaMensaje("error al eliminar curso académico", FacesMessage.SEVERITY_ERROR);
          return "";
      }
      creaMensaje("curso académico eliminado correctamente", FacesMessage.SEVERITY_INFO);
      cursoAcademico="";
      actualizarCursoAcademico();
      return "";
  }
  
   
   
   public void actualizarPais(){
       
       setListaPaises((ArrayList<Pais>)universidadService.listaPaises());
   }
   
   public void actualizarUniversidad(){
       
       setListaUniversidades( (ArrayList<Universidad>)universidadService.listar() );
   }
   
  public void actualizarCursoAcademico(){
       
       setListaCursoAcademico((ArrayList<Cursoacademico>)universidadService.listaCursosAcademicos());
   }

  public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
 
 
  public void salir(){
           
      HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
      
      creaMensaje(request.getRequestURI(), FacesMessage.SEVERITY_INFO);
      
            if (request.getRequestURI().equals("/pfc/admin/crearCursoAcademico.xhtml")==true){
                
                creaMensaje("si",FacesMessage.SEVERITY_INFO);
                
            }
            
            //HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            //session.invalidate();
            //return("/principal.xhtml?faces-redirect=true");
            
        }
  
}
