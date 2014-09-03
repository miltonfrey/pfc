

package pojos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
//import javax.faces.bean.SessionScoped;
//import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

//import javax.faces.event.ActionEvent;

import org.springframework.dao.DataAccessException;


@ManagedBean
@ViewScoped
public class beanUniversidad implements Serializable{
    
    @ManagedProperty(value="#{universidadService}")
    private UniversidadService universidadService;
    
    @ManagedProperty (value="#{asignaturaService}")
    private AsignaturaService asignaturaService;
    
    
    
    private String cursoAcademico;
    private ArrayList<Cursoacademico> listaCursoAcademico;
    
    private String paisStr;
    private Pais pais;
    
   
    
    //universidad
    private String codUniversidad;
    private String nombre;
    private String universidadStr;
    private String info;
    private String web;
   
    
    //asignatura
    
    private Integer codAsignatura;
    private String nombreAsignatura;
    private Integer creditosAsignatura;
    private String periodoAsignatura;
    private String infoAsignatura;
    private String webAsignatura;
    private String facultadAsignatura;
    private String titulacionAsignatura;
    
    
    private ArrayList<Pais> listaPaises;
    private ArrayList<Universidad> listaUniversidades;
    private ArrayList<Asignatura> listaAsignaturas;
    
    private boolean checkPaisStr;
    private boolean checkUniversidadStr;
    private boolean checkDetalles;
    private boolean checkTabla;
    
    private Pais selectedPais;
    private Universidad selectedUniversidad;
    private ArrayList<Asignatura> selectedAsignaturas;
    private Asignatura SelectedAsignatura;
    private ArrayList<Asignatura>filteredAsignaturas;
    
    
    public UniversidadService getUniversidadService() {
        return universidadService;
    }

    public void setUniversidadService(UniversidadService universidadService) {
        this.universidadService = universidadService;
    }

    public AsignaturaService getAsignaturaService() {
        return asignaturaService;
    }

    public void setAsignaturaService(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }
    
    
    
    
    
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

    public ArrayList<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }
   
    
    
    
    
     public Universidad getSelectedUniversidad() {
        return selectedUniversidad;
    }

    public void setSelectedUniversidad(Universidad selectedUniversidad) {
        this.selectedUniversidad = selectedUniversidad;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    public Integer getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Integer codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Integer getCreditosAsignatura() {
        return creditosAsignatura;
    }

    public void setCreditosAsignatura(Integer creditosAsignatura) {
        this.creditosAsignatura = creditosAsignatura;
    }

    public String getPeriodoAsignatura() {
        return periodoAsignatura;
    }

    public void setPeriodoAsignatura(String periodoAsignatura) {
        this.periodoAsignatura = periodoAsignatura;
    }

    public String getInfoAsignatura() {
        return infoAsignatura;
    }

    public void setInfoAsignatura(String infoAsignatura) {
        this.infoAsignatura = infoAsignatura;
    }

    public String getWebAsignatura() {
        return webAsignatura;
    }

    public void setWebAsignatura(String webAsignatura) {
        this.webAsignatura = webAsignatura;
    }

    public String getFacultadAsignatura() {
        return facultadAsignatura;
    }

    public void setFacultadAsignatura(String facultadAsignatura) {
        this.facultadAsignatura = facultadAsignatura;
    }

    public String getTitulacionAsignatura() {
        return titulacionAsignatura;
    }

    public void setTitulacionAsignatura(String titulacionAsignatura) {
        this.titulacionAsignatura = titulacionAsignatura;
    }

    public ArrayList<Asignatura> getSelectedAsignaturas() {
        return selectedAsignaturas;
    }

    public void setSelectedAsignaturas(ArrayList<Asignatura> selectedAsignaturas) {
        this.selectedAsignaturas = selectedAsignaturas;
    }

    public Asignatura getSelectedAsignatura() {
        return SelectedAsignatura;
    }

    public void setSelectedAsignatura(Asignatura SelectedAsignatura) {
        this.SelectedAsignatura = SelectedAsignatura;
    }

    public ArrayList<Asignatura> getFilteredAsignaturas() {
        return filteredAsignaturas;
    }

    public void setFilteredAsignaturas(ArrayList<Asignatura> filteredAsignaturas) {
        this.filteredAsignaturas = filteredAsignaturas;
    }
    
    
    
    
    
   
   public void onChangePais(){
       
       
       checkPaisStr=true;
       listaUniversidades=(ArrayList < Universidad >)universidadService.listarPorPais(paisStr);
       universidadStr="";
       checkDetalles=false;
       checkUniversidadStr=false;
       checkTabla=false;
       
       
   }

    public void onChangeUniversidad(){
        
        checkUniversidadStr=true;
        checkTabla=true;
        listaAsignaturas=(ArrayList<Asignatura>)asignaturaService.listarAsignaturasPorUniversidad(universidadStr);
       checkDetalles=false;
       
        
    }
    
    public String creaAsignatura(){
        
       
        Universidad uni=universidadService.findUniversidad(universidadStr);
         AsignaturaId id=new AsignaturaId(codAsignatura,universidadStr);
        
        
        
       
        Asignatura a=new Asignatura(id,uni, nombreAsignatura, creditosAsignatura.shortValue(),periodoAsignatura,infoAsignatura,webAsignatura,facultadAsignatura,titulacionAsignatura,null);
        
        try{
            
            asignaturaService.crearAsignatura(a);
        }catch(Exception ex){
            
            creaMensaje("se ha producido un error creando la asignatura, el código ya existe", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        
        creaMensaje("asignatura creada correctamente", FacesMessage.SEVERITY_INFO);
        nombreAsignatura="";
        codAsignatura=null;
        creditosAsignatura=null;
        periodoAsignatura="";
        titulacionAsignatura="";
        facultadAsignatura="";
        infoAsignatura="";
        webAsignatura="";
        listaAsignaturas=(ArrayList<Asignatura>)asignaturaService.listarAsignaturasPorUniversidad(universidadStr);
        //filteredAsignaturas=null;
        return "";
    }
    
    public void verDetalles(){
        
        webAsignatura=SelectedAsignatura.getWebAsignatura();
        infoAsignatura=SelectedAsignatura.getInfoAsigantura();
        facultadAsignatura=SelectedAsignatura.getFacultad();
        titulacionAsignatura=SelectedAsignatura.getTitulacion();
        checkDetalles=true;
        //checkUniversidadStr=false;
        
    }
    
   
    public void editar(){
        
        try{
            
            asignaturaService.actualizarAsignatura(SelectedAsignatura);
            checkDetalles=false;
            
        }catch(Exception ex){
            
            creaMensaje("error al editar la asignatura", FacesMessage.SEVERITY_INFO);
        }
        
        
        listaAsignaturas=(ArrayList < Asignatura >)asignaturaService.listarAsignaturasPorUniversidad(universidadStr);
        
        
    }
    
    
    public void cerrar(){
        
        checkDetalles=false;
        webAsignatura="";
        infoAsignatura="";
        facultadAsignatura="";
        titulacionAsignatura="";
    }
    
    
    public String eliminaAsignaturasLista(){
        
        if(selectedAsignaturas.isEmpty()==false){
        for (Asignatura a:selectedAsignaturas){
            
            try{
                
                asignaturaService.eliminaAsignatura(a);
                
                
            }catch(Exception ex){
                
                creaMensaje("se ha producido un error eliminando asignatura", FacesMessage.SEVERITY_ERROR);
                return null;
            }
            
            
        }
        
        creaMensaje("se han eliminado correctamente las asignaturas",FacesMessage.SEVERITY_INFO);
        listaAsignaturas=(ArrayList < Asignatura >)asignaturaService.listarAsignaturasPorUniversidad(universidadStr);
        //checkUniversidadStr=false;
        checkDetalles=false;
        return "";
    }
        
        return "";
    }
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
   

   

    public boolean isCheckPaisStr() {
        return checkPaisStr;
    }

    public void setCheckPais(boolean checkPaisStr) {
        this.checkPaisStr = checkPaisStr;
    }

    public boolean isCheckUniversidadStr() {
        return checkUniversidadStr;
    }

    public void setCheckUniversidadStr(boolean checkUniversidadStr) {
        this.checkUniversidadStr = checkUniversidadStr;
    }

    public boolean isCheckDetalles() {
        return checkDetalles;
    }

    public void setCheckDetalles(boolean checkDetalles) {
        this.checkDetalles = checkDetalles;
    }

    public boolean isCheckTabla() {
        return checkTabla;
    }

    public void setCheckTabla(boolean checkTabla) {
        this.checkTabla = checkTabla;
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
          Cursoacademico c=new Cursoacademico(cursoAcademico);
          universidadService.crearCursoAcademico(c);
          
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
      
           // if (request.getRequestURI().equals("/pfc/admin/crearCursoAcademico.xhtml")==true){
                
            //    creaMensaje("si",FacesMessage.SEVERITY_INFO);
                
           // }
            
            //HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            //session.invalidate();
            //return("/principal.xhtml?faces-redirect=true");
            
        }
  
}
