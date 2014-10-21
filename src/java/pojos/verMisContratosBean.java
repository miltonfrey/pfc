

package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import pojos.utillidades.beanUtilidades;


@ManagedBean
@ViewScoped
public class verMisContratosBean implements Serializable{

    @ManagedProperty(value="#{beanUtilidades}")
    private beanUtilidades beanUtilidades;
    
    @ManagedProperty(value="#{movilidadService}")
    private MovilidadService movilidadService;
    
    @ManagedProperty(value="#{equivalenciaService}")
    private EquivalenciaService equivalenciaService;

    
    
   private Usuario user;
    
    private HttpSession session;
    
    
    private boolean nuevo;
    private boolean visibleContratos;
    private boolean verAceptado;
    
    
    
    private ArrayList<Contrato> listaContratos;
    private ArrayList<Contrato> filteredContratos;
    private Contrato selectedContrato;
    
    private Movilidad selectedMovilidad;
  
    
    public verMisContratosBean() {
    }
    
    @PostConstruct
    public void init(){
        
       
       session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        user=(Usuario)session.getAttribute("user");
         
        }

    public beanUtilidades getBeanUtilidades() {
        return beanUtilidades;
    }

    public void setBeanUtilidades(beanUtilidades beanUtilidades) {
        this.beanUtilidades = beanUtilidades;
    }
       
     
    public EquivalenciaService getEquivalenciaService() {
        return equivalenciaService;
    }

    public void setEquivalenciaService(EquivalenciaService equivalenciaService) {
        this.equivalenciaService = equivalenciaService;
    }
    
    public MovilidadService getMovilidadService() {
        return movilidadService;
    }

    public void setMovilidadService(MovilidadService movilidadService) {
        this.movilidadService = movilidadService;
    }

   
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   

    public boolean isNuevo() {
        return nuevo;
    }

   
    
    
    

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public boolean isVisibleContratos() {
        return visibleContratos;
    }

    public void setVisibleContratos(boolean visibleContratos) {
        this.visibleContratos = visibleContratos;
    }

    public boolean isVerAceptado() {
        return verAceptado;
    }

    public void setVerAceptado(boolean verAceptado) {
        this.verAceptado = verAceptado;
    }
    
    

    public ArrayList<Contrato> getListaContratos() {
        return listaContratos;
    }

    public void setListaContratos(ArrayList<Contrato> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public ArrayList<Contrato> getFilteredContratos() {
        return filteredContratos;
    }

    public void setFilteredContratos(ArrayList<Contrato> filteredContratos) {
        this.filteredContratos = filteredContratos;
    }

    public Contrato getSelectedContrato() {
        return selectedContrato;
    }

    public void setSelectedContrato(Contrato selectedContrato) {
        this.selectedContrato = selectedContrato;
    }

    
    public Movilidad getSelectedMovilidad() {
        return selectedMovilidad;
    }

    public void setSelectedMovilidad(Movilidad selectedMovilidad) {
        this.selectedMovilidad = selectedMovilidad;
    }

    
    
    
    public String eliminarContrato(){
        
        try{
            
            equivalenciaService.eliminaContrato(selectedContrato);
            
           }catch(Exception ex){
               ex.printStackTrace();
               beanUtilidades.creaMensaje("error al eliminar contrato", FacesMessage.SEVERITY_ERROR);
               return null;
           }
        
        beanUtilidades.creaMensaje("contrato eliminado correctamente", FacesMessage.SEVERITY_INFO);
        listaContratos=(ArrayList<Contrato>)equivalenciaService.listaContratos(selectedMovilidad);
       verContratos();
        
        selectedContrato=null;
        //visibleContratos=false;
        
        return null;
    }
    
    
    public void verContratos(){
        verAceptado=true;
        visibleContratos=true;
        
        try{
        listaContratos=(ArrayList<Contrato>)equivalenciaService.listaContratos(selectedMovilidad);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        if(listaContratos.isEmpty()){
            nuevo=true;
    }else
            for (Contrato c: listaContratos){
                
        if(c.getEstado().equalsIgnoreCase("pendiente")||c.getEstado().equalsIgnoreCase("rechazado")||c.getEstado().equalsIgnoreCase("aceptado")){
            nuevo=false;
            break;
        }
    }
        
        for(Contrato c:listaContratos){
            
            if(c.getEstado().equalsIgnoreCase("pendiente")||c.getEstado().equalsIgnoreCase("rechazado")){
                verAceptado=false;
               
                break;
            }
            
        }
        
        
        
    }
    
     public void cerrarContratos(){
        
        visibleContratos=false;
    }
    
    
    public String crearContrato(){
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("movilidad", selectedMovilidad);
        return ("elaborarContrato.xhtml?faces-redirect=true");
        
        
    }
    
    public String editarContrato(){
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("movilidad", selectedMovilidad);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contrato", selectedContrato);
       
        
        return ("elaborarContratoEditadoB.xhtml?faces-redirect=true");
        
    }
    
    
     public String crearContratoDesdeAceptado(){
         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("movilidad",selectedMovilidad);
         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contrato", selectedContrato);
         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("comparado", "true");
         return ("crearContratoDesdeAceptado.xhtml?faces-redirect=true");
         
     }
    
    
    
    
    
    
   
    
    
    
  
    
    
}
