package pojos;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import pojos.utillidades.beanUtilidades;


@ManagedBean
@ViewScoped
public class verContratosBean implements Serializable{

    @ManagedProperty(value="#{beanUtilidades}")
    private beanUtilidades beanUtilidades;
    
    @ManagedProperty(value="#{equivalenciaService}")
    private EquivalenciaService equivalenciaService;

    @ManagedProperty(value="#{movilidadService}")
    private MovilidadService movilidadService;
    
   private Usuario user;
    
   
    private HttpSession session;
    private ExternalContext context;
            
    
    
    
    
    private ArrayList<Contrato> listaContratos;
    private ArrayList<Contrato> filteredContratos;
    private ArrayList<Contrato> selectedContratos;
    private Contrato selectedContrato;
    
    private Movilidad selectedMovilidad;
  
    
    
    
    
    public verContratosBean() {
    }
    
    @PostConstruct
    public void init(){
        
       
       session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       user=(Usuario)session.getAttribute("admin");
       context=FacesContext.getCurrentInstance().getExternalContext();
       if(context.getSessionMap().containsKey("movilidad")==true){
           selectedMovilidad=(Movilidad)context.getSessionMap().get("movilidad");
           context.getSessionMap().remove("Movilidad");
           selectedMovilidad=movilidadService.findMovilidad(selectedMovilidad.getCodMovilidad());
           listaContratos=(ArrayList < Contrato >)equivalenciaService.listaContratos(selectedMovilidad);
           
       }
       else{
           try{
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/admin/verMovilidades.xhtml");
            }catch(IOException ex){
                    
                    }
       }
        }

    public beanUtilidades getBeanUtilidades() {
        return beanUtilidades;
    }

    public void setBeanUtilidades(beanUtilidades beanUtilidades) {
        this.beanUtilidades = beanUtilidades;
    }

    public MovilidadService getMovilidadService() {
        return movilidadService;
    }

    public void setMovilidadService(MovilidadService movilidadService) {
        this.movilidadService = movilidadService;
    }
    
    
    
    
    public EquivalenciaService getEquivalenciaService() {
        return equivalenciaService;
    }

    public void setEquivalenciaService(EquivalenciaService equivalenciaService) {
        this.equivalenciaService = equivalenciaService;
    }
   
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    

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

    public ArrayList<Contrato> getSelectedContratos() {
        return selectedContratos;
    }

    public void setSelectedContratos(ArrayList<Contrato> selectedContratos) {
        this.selectedContratos = selectedContratos;
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

    public String eliminarContratos(){
        
        if(selectedContratos.isEmpty()){
            return null;
        }
        
        for(Contrato c:selectedContratos){
        
        try{
            
            equivalenciaService.eliminaContrato(c);
            
           }catch(Exception ex){
               ex.printStackTrace();
               beanUtilidades.creaMensaje("error al eliminar contrato", FacesMessage.SEVERITY_ERROR);
               return null;
           }
        }
        beanUtilidades.creaMensaje("contrato eliminado correctamente", FacesMessage.SEVERITY_INFO);
        listaContratos=(ArrayList<Contrato>)equivalenciaService.listaContratos(selectedMovilidad);
        selectedContratos=null;
        
        return null;
    }
    
    public String seleccionarContratoAdmin(){
        
       FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contrato", selectedContratos.get(0));
       FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("movilidad",selectedMovilidad);
       return "gestionarContrato.xhtml?faces-redirect=true";
        
    }
    
    
    public String compararContratos(){
        
        if(selectedContratos.isEmpty()!=selectedContratos.size()>2){
            beanUtilidades.creaMensaje("hay que elegir uno o dos contratos", FacesMessage.SEVERITY_ERROR);
            return null;
        }
        if(selectedContratos.size()==1){
            
            
           return seleccionarContratoAdmin();
        }else{
            Contrato contratoComparado; 
            if(listaContratos.get(0).getFecha().compareTo(listaContratos.get(1).getFecha())<0){
                
            contratoComparado=listaContratos.get(0);
            selectedContrato=listaContratos.get(1);
            
                
            }else{
               contratoComparado=listaContratos.get(1);
            selectedContrato=listaContratos.get(0);
            }
            
            
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contrato", selectedContrato);
       FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("movilidad",selectedMovilidad);
       FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contratoComparado",contratoComparado);
       return "gestionarContrato.xhtml?faces-redirect=true";
        }
        }  
    
    
    
}

    
    


