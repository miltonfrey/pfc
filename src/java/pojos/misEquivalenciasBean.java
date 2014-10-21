/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

//import antlr.debug.Event;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.component.datatable.DataTable;
import pojos.utillidades.beanUtilidades;


/**
 *
 * @author abc
 */
@ManagedBean
@ViewScoped
public class misEquivalenciasBean implements Serializable{

    @ManagedProperty(value="#{beanUtilidades}")
    private beanUtilidades beanUtilidades;
    
    @ManagedProperty(value="#{usuarioService}")
    private transient UsuarioService usuarioService;
    
     @ManagedProperty(value="#{movilidadService}")
    private transient MovilidadService movilidadService;
    
    @ManagedProperty(value="#{asignaturaService}")
    private transient AsignaturaService asignaturaService;
    
    @ManagedProperty(value="#{equivalenciaService}")
    private transient EquivalenciaService equivalenciaService;
    
    @ManagedProperty(value="#{mensajeService}")
    private transient MensajeService mensajeService;
    
   
    private ExternalContext context;
    private HttpSession session;
    private Movilidad selectedMovilidad;
    private Contrato selectedContrato;
    private Usuario user;
    
    Equivalencia equivalencia;
    
    
    private ArrayList<Asignatura> listaAsignaturasFic;
    private ArrayList<Asignatura>listaAsignaturasUniversidad;
   
    private ArrayList<Equivalencia>listaEquivalencias;
    private ArrayList<Equivalencia> listaAuxEquivalencias=new ArrayList<Equivalencia>();
    private ArrayList<Equivalencia> listaAuxEquivalenciasComparado;
    
    
    private Asignatura selectedAsignatura;
    private ArrayList<Asignatura>selectedAsignaturasFic;
    private ArrayList<Asignatura> selectedAsignaturasUni;
    
    private ArrayList<Asignatura>filteredAsignaturasFic;
    private ArrayList<Asignatura>filteredAsignaturasUni;
    
    private ArrayList<Equivalencia>selectedEquivalencias;
    
    private static int j=0;
    private boolean verInfo;
    private boolean verConfirmar=true;
    
    
    
    public misEquivalenciasBean() {
        
    }
    
    @PostConstruct
    public void init(){
        context=FacesContext.getCurrentInstance().getExternalContext();
        session=(HttpSession)context.getSession(false);
        
        
       
      
        user=(Usuario)session.getAttribute("user");
        
        if(context.getSessionMap().containsKey("movilidad")){
        selectedMovilidad=(Movilidad)context.getSessionMap().get("movilidad");
        context.getSessionMap().remove("movilidad");
        listaAsignaturasFic=(ArrayList<Asignatura>)asignaturaService.listarAsignaturasPorUniversidad("UDC");
        listaAsignaturasUniversidad=(ArrayList<Asignatura>)asignaturaService.listarAsignaturasPorUniversidad(selectedMovilidad.getUniversidad().getNombre());
        
         if(context.getSessionMap().containsKey("contrato")){
        selectedContrato=(Contrato)context.getSessionMap().get("contrato");
             
        listaAuxEquivalencias=(ArrayList<Equivalencia>)equivalenciaService.listarEquivalenciasPorContrato(selectedContrato.getIdContrato());
        listaAuxEquivalenciasComparado=(ArrayList<Equivalencia>)equivalenciaService.listarEquivalenciasPorContrato(selectedContrato.getIdContrato());
        if(context.getSessionMap().containsKey("comparado")){
        listaAuxEquivalenciasComparado=(ArrayList<Equivalencia>)equivalenciaService.listarEquivalenciasPorContrato(selectedContrato.getIdContrato());
        context.getSessionMap().remove("comparado");
        }
        context.getSessionMap().remove("contrato");
         }
        }
        
        
        else{
             try{
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/usuario/verMisMovilidades.xhtml");
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
    

    public MensajeService getMensajeService() {
        return mensajeService;
    }

    public void setMensajeService(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public MovilidadService getMovilidadService() {
        return movilidadService;
    }

    public void setMovilidadService(MovilidadService movilidadService) {
        this.movilidadService = movilidadService;
    }

    public AsignaturaService getAsignaturaService() {
        return asignaturaService;
    }

    public void setAsignaturaService(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }


    public EquivalenciaService getEquivalenciaService() {
        return equivalenciaService;
    }

    public void setEquivalenciaService(EquivalenciaService equivalenciaService) {
        this.equivalenciaService = equivalenciaService;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Asignatura> getSelectedAsignaturasFic() {
        return selectedAsignaturasFic;
    }

    public Asignatura getSelectedAsignatura() {
        return selectedAsignatura;
    }

    public void setSelectedAsignatura(Asignatura selectedAsignatura) {
        this.selectedAsignatura = selectedAsignatura;
    }

   

    public void setSelectedAsignaturasFic(ArrayList<Asignatura> selectedAsignaturasFic) {
        this.selectedAsignaturasFic = selectedAsignaturasFic;
    }

    public ArrayList<Asignatura> getFilteredAsignaturasFic() {
        return filteredAsignaturasFic;
    }

    public void setFilteredAsignaturasFic(ArrayList<Asignatura> filteredAsignaturasFic) {
        this.filteredAsignaturasFic = filteredAsignaturasFic;
    }

    public ArrayList<Asignatura> getFilteredAsignaturasUni() {
        return filteredAsignaturasUni;
    }

    public void setFilteredAsignaturasUni(ArrayList<Asignatura> filteredAsignaturasUni) {
        this.filteredAsignaturasUni = filteredAsignaturasUni;
    }

    
    
    
    
    public ArrayList<Equivalencia> getSelectedEquivalencias() {
        return selectedEquivalencias;
    }

    public void setSelectedEquivalencias(ArrayList<Equivalencia> selectedEquivalencias) {
        this.selectedEquivalencias = selectedEquivalencias;
    }

    public ArrayList<Equivalencia> getListaEquivalencias() {
        return listaEquivalencias;
    }

    public void setListaEquivalencias(ArrayList<Equivalencia> listaEquivalencias) {
        this.listaEquivalencias = listaEquivalencias;
    }

    public ArrayList<Equivalencia> getListaAuxEquivalencias() {
        return listaAuxEquivalencias;
    }

    public void setListaAuxEquivalencias(ArrayList<Equivalencia> listaAuxEquivalencias) {
        this.listaAuxEquivalencias = listaAuxEquivalencias;
    }

    public ArrayList<Equivalencia> getListaAuxEquivalenciasComparado() {
        return listaAuxEquivalenciasComparado;
    }

    public void setListaAuxEquivalenciasComparado(ArrayList<Equivalencia> listaAuxEquivalenciasComparado) {
        this.listaAuxEquivalenciasComparado = listaAuxEquivalenciasComparado;
    }

    

    public ArrayList<Asignatura> getSelectedAsignaturasUni() {
        return selectedAsignaturasUni;
    }

    public void setSelectedAsignaturasUni(ArrayList<Asignatura> selectedAsignaturasUni) {
        this.selectedAsignaturasUni = selectedAsignaturasUni;
    }

    public ArrayList<Asignatura> getListaAsignaturasFic() {
        return listaAsignaturasFic;
    }

    public void setListaAsignaturasFic(ArrayList<Asignatura> listaAsignaturasFic) {
        this.listaAsignaturasFic = listaAsignaturasFic;
    }

    public ArrayList<Asignatura> getListaAsignaturasUniversidad() {
        return listaAsignaturasUniversidad;
    }

    public void setListaAsignaturasUniversidad(ArrayList<Asignatura> listaAsignaturasUniversidad) {
        this.listaAsignaturasUniversidad = listaAsignaturasUniversidad;
    }

    public Movilidad getSelectedMovilidad() {
        return selectedMovilidad;
    }

    public void setSelectedMovilidad(Movilidad selectedMovilidad) {
        this.selectedMovilidad = selectedMovilidad;
    }

    public Contrato getSelectedContrato() {
        return selectedContrato;
    }

    public void setSelectedContrato(Contrato selectedContrato) {
        this.selectedContrato = selectedContrato;
    }

  
    

    
    
   

    public boolean isVerInfo() {
        return verInfo;
    }

    public void setVerInfo(boolean verInfo) {
        this.verInfo = verInfo;
    }

    public boolean isVerConfirmar() {
        return verConfirmar;
    }

    public void setVerConfirmar(boolean verConfirmar) {
        this.verConfirmar = verConfirmar;
    }

    
     public String asignaturasTotales(){
       
          equivalencia=new Equivalencia();
         GrupoAsignaturaA grupoA=new GrupoAsignaturaA();
         GrupoAsignaturaB grupoB=new GrupoAsignaturaB();
          MiembroGrupoAsignaturaA ma;
          MiembroGrupoAsignaturaB mb;
        
        DataTable dataTable=(DataTable)FacesContext.getCurrentInstance().getViewRoot().findComponent("formEquivalenciaFic:tablaFic");
        DataTable dataTable2=(DataTable)FacesContext.getCurrentInstance().getViewRoot().findComponent("formEquivalenciaFic:tablaUniversidad");
        
        
        selectedAsignaturasFic=(ArrayList < Asignatura >)dataTable.getSelection();
        selectedAsignaturasUni=(ArrayList<Asignatura>)dataTable2.getSelection();
        
        if(selectedAsignaturasFic.isEmpty()){
            
            beanUtilidades.creaMensaje("No hay asignaturas de origen", FacesMessage.SEVERITY_ERROR);
            return null;
        }
        
        if(selectedAsignaturasUni.isEmpty()){
            beanUtilidades.creaMensaje("No hay asignaturas de destino", FacesMessage.SEVERITY_ERROR);
            return null;
        }
       
        
        
        for(Asignatura a:selectedAsignaturasFic){
       
        ma=new MiembroGrupoAsignaturaA(a, grupoA);
        grupoA.getMiembroGrupoAsignaturaAs().add(ma);
                                                // con cascade save-update no hace falta salvar el miembro_grupo_asignaturas
        
        }
        
        for(Asignatura a:selectedAsignaturasUni){
            
        mb=new MiembroGrupoAsignaturaB(a,grupoB);
        grupoB.getMiembroGrupoAsignaturaBs().add(mb);
       
            
        }
        equivalencia.setVisible("no");
        equivalencia.setIdequivalencia(j);
        
        equivalencia.setGrupoAsignaturaA(grupoA);
        grupoA.setEquivalencia(equivalencia);
         
         equivalencia.setGrupoAsignaturaB(grupoB);
         grupoB.setEquivalencia(equivalencia); 
        
            
           
            listaAuxEquivalencias.add(equivalencia);
            j++;
            
            
            
            return null;      
         
         
         
    }
    
    public String confirmarContrato(){
        if(listaAuxEquivalencias.isEmpty()){
            
            beanUtilidades.creaMensaje("el contrato está vacío", FacesMessage.SEVERITY_ERROR);
            return null;
        }
        
        
        Contrato c=new Contrato();
        c.setMovilidad(selectedMovilidad);
        c.setFecha(Calendar.getInstance().getTime());
        //Set<Equivalencia>setE=new HashSet<Equivalencia>(listaAuxEquivalencias); no hace falta ya que se van a añadir luego
        //c.setEquivalencias(setE);
        c.setEstado("pendiente");
        try{
        equivalenciaService.creaContrato(c);
        }catch(Exception ex){
            
            beanUtilidades.creaMensaje("error creando el contrato", FacesMessage.SEVERITY_ERROR);
            return null;
        }
        
        try{
        for(Equivalencia e:listaAuxEquivalencias){
          
            
            e.setContrato(c);
            equivalenciaService.crearEquivalencia(e);
            equivalenciaService.crearGrupoAsignaturasA(e.getGrupoAsignaturaA());
            equivalenciaService.crearGrupoAsignaturasB(e.getGrupoAsignaturaB());
          
        }
        }catch(Exception ex){
            beanUtilidades.creaMensaje("se ha producido  un error guardando el contrato", FacesMessage.SEVERITY_ERROR);
            return null;
        } 
        
        beanUtilidades.creaMensaje("se ha registrado el contrato correctamente", FacesMessage.SEVERITY_INFO);
        Mensaje m=new Mensaje(usuarioService.find("admin"), user, Calendar.getInstance().getTime(),"contrato creado", "el usuario "+user.getLogin()+" ha creado un contrato","no","no","no");
        mensajeService.enviarMensaje(m);
        verConfirmar=false;
        
        return null;
        
    }
    
    public String editarContrato(){
        if(listaAuxEquivalencias.isEmpty()){
            
            beanUtilidades.creaMensaje("el contrato está vacío", FacesMessage.SEVERITY_ERROR);
            return null;
        }
        
        selectedContrato.setFecha(Calendar.getInstance().getTime());
        selectedContrato.setEstado("pendiente");
        try{
        equivalenciaService.modificaContrato(selectedContrato);
        }catch(Exception ex){
            
            beanUtilidades.creaMensaje("error creando el contrato", FacesMessage.SEVERITY_ERROR);
            return null;
        }
        Contrato c=equivalenciaService.findContrato(selectedContrato.getIdContrato());
        
        
        for(Equivalencia e:c.getEquivalencias()){
            
            if(listaAuxEquivalencias.contains(e)==false){
                equivalenciaService.eliminarEquivalencia(e);
            }
           
        }
        
        for(Equivalencia e:listaAuxEquivalencias){
            
         if(c.getEquivalencias().contains(e)==false){   
            try{
            e.setContrato(c);
            equivalenciaService.crearEquivalencia(e);
            equivalenciaService.crearGrupoAsignaturasA(e.getGrupoAsignaturaA());
            equivalenciaService.crearGrupoAsignaturasB(e.getGrupoAsignaturaB());
         }catch(Exception ex){
            ex.printStackTrace();
            beanUtilidades.creaMensaje("se ha producido  un error guardando el contrato", FacesMessage.SEVERITY_ERROR);
            return null;
        } 
           
            
        }
       
    }
     beanUtilidades.creaMensaje("se ha registrado el contrato correctamente", FacesMessage.SEVERITY_INFO);
     Mensaje m=new Mensaje(usuarioService.find("admin"), user, Calendar.getInstance().getTime(),"contrato modificado", "el usuario "+user.getLogin()+" ha modificado un contrato","no","no","no");
     
        verConfirmar=false;
        return null;
    
    }
    
    
  public String  crearContratoDesdeAceptado(){
        if(listaAuxEquivalencias.isEmpty()){
            
            beanUtilidades.creaMensaje("el contrato está vacío", FacesMessage.SEVERITY_ERROR);
            return null;
        }
        
        //selectedContrato.setFecha(Calendar.getInstance().getTime());
        Contrato cNuevo=new Contrato();
        cNuevo.setFecha(Calendar.getInstance().getTime());
        cNuevo.setMovilidad(selectedMovilidad);
        cNuevo.setEstado("pendiente");
        
        try{
        equivalenciaService.creaContrato(cNuevo);
        }catch(Exception ex){
            
            beanUtilidades.creaMensaje("error creando el contrato", FacesMessage.SEVERITY_ERROR);
            return null;
        }
        
        
        
        for(Equivalencia e:listaAuxEquivalencias){
            Equivalencia eNueva=new Equivalencia();
             GrupoAsignaturaA auxA=new GrupoAsignaturaA();
             GrupoAsignaturaB auxB=new GrupoAsignaturaB();
             GrupoAsignaturaA gA=e.getGrupoAsignaturaA();
             GrupoAsignaturaB gB=e.getGrupoAsignaturaB();
             
                for(MiembroGrupoAsignaturaA mA:gA.getMiembroGrupoAsignaturaAs()){
                    
                    MiembroGrupoAsignaturaA a=new MiembroGrupoAsignaturaA(mA.getAsignatura(), auxA);
                    auxA.getMiembroGrupoAsignaturaAs().add(a);
                    
                }
                for(MiembroGrupoAsignaturaB mB:gB.getMiembroGrupoAsignaturaBs()){
                    
                    MiembroGrupoAsignaturaB b=new MiembroGrupoAsignaturaB(mB.getAsignatura(), auxB);
                    auxB.getMiembroGrupoAsignaturaBs().add(b);
                
        
        }
           
            try{
                eNueva.setContrato(cNuevo);
                eNueva.setVisible("no");
                equivalenciaService.crearEquivalencia(eNueva);
                auxA.setEquivalencia(eNueva);
                auxB.setEquivalencia(eNueva);
                equivalenciaService.crearGrupoAsignaturasA(auxA);
                equivalenciaService.crearGrupoAsignaturasB(auxB);
                
                
            }catch(Exception ex){
                ex.printStackTrace();
                beanUtilidades.creaMensaje("se ha producido un error", FacesMessage.SEVERITY_ERROR);
                return null;
            }
            
            
        
        
    }
        beanUtilidades.creaMensaje("contrato creado correctamente", FacesMessage.SEVERITY_INFO);
        verConfirmar=false;
        return null;
  }
    
    
    
    public String eliminaEquivalenciasLista(){
        if(selectedEquivalencias.isEmpty()==false){
            
           for(int i=0;i<selectedEquivalencias.size();i++){
           
          listaAuxEquivalencias.remove(selectedEquivalencias.get(i));
          
        }
        }
        
        return null;
        
    }
    
    public void detallesAsign(){
         
        verInfo=true;
        
    }
    
    public void cerrarDetallesAsign(){
        
        verInfo=false;
    }
   
    
    
     
     
    
}
