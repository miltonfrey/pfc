/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

//import antlr.debug.Event;
import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.component.datatable.DataTable;
//import org.primefaces.event.SelectEvent;
//import org.primefaces.event.ToggleSelectEvent;
//import org.primefaces.event.UnselectEvent;
//import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author abc
 */
@ManagedBean
@ViewScoped
public class beanEquivalencia implements Serializable{

     @ManagedProperty(value="#{movilidadService}")
    private transient MovilidadService movilidadService;
    
    @ManagedProperty(value="#{asignaturaService}")
    private transient AsignaturaService asignaturaService;
    
    @ManagedProperty(value="#{beanContrato}")
    private transient beanContrato beanContrato;
    
    @ManagedProperty(value="#{equivalenciaService}")
    private transient EquivalenciaService equivalenciaService;
    
    @ManagedProperty(value="#{mensajeService}")
    private transient MensajeService mensajeService;
   
    private Movilidad selectedMovilidad;
    private Contrato selectedContrato;
    private Contrato nuevoContrato;
    
    private ArrayList<Asignatura> listaAsignaturasFic;
    private ArrayList<Asignatura>listaAsignaturasUniversidad;
   
    private Asignatura selectedAsignatura;
    
    
    private ArrayList<Equivalencia>listaEquivalencias;
    ArrayList<Equivalencia> listaAuxEquivalencias=new ArrayList<Equivalencia>();
    
    private ArrayList<Asignatura>selectedAsignaturasFic;
    private ArrayList<Asignatura> selectedAsignaturasUni;
    
    private ArrayList<Equivalencia>selectedEquivalencias;
    
    private static int j=0;
    
    public beanEquivalencia() {
        
    }
    
    @PostConstruct
    public void init(){
        HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if(session.getAttribute("movilidad")!=null||session.getAttribute("contrato")!=null){
            
       
      if(session.getAttribute("nuevo")!=null)
      nuevoContrato=(Contrato)session.getAttribute("nuevo");
       
       selectedMovilidad=(Movilidad)session.getAttribute("movilidad");
       selectedContrato=(Contrato)session.getAttribute("contrato");
       //session.removeAttribute("movilidad");
       //session.removeAttribute("contrato");
       
       listaEquivalencias=(ArrayList<Equivalencia>)equivalenciaService.listarEquivalenciasPorContrato(selectedContrato);
       listaAsignaturasFic=(ArrayList<Asignatura>)asignaturaService.listarAsignaturasPorUniversidad("UDC");
       listaAsignaturasUniversidad=(ArrayList<Asignatura>)asignaturaService.listarAsignaturasPorUniversidad(selectedMovilidad.getUniversidad().getNombre());
    }
    }

    public MensajeService getMensajeService() {
        return mensajeService;
    }

    public void setMensajeService(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
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

    public beanContrato getBeanContrato() {
        return beanContrato;
    }

    public void setBeanContrato(beanContrato beanContrato) {
        this.beanContrato = beanContrato;
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

    public Contrato getNuevoContrato() {
        return nuevoContrato;
    }

    public void setNuevoContrato(Contrato nuevoContrato) {
        this.nuevoContrato = nuevoContrato;
    }

    
    
    
    
     public String asignaturasTotales(){
       
         
                 
         
         
         Equivalencia equivalencia=new Equivalencia();
         GrupoAsignatura grupoA=new GrupoAsignatura();
         GrupoAsignatura grupoB=new GrupoAsignatura();
        
        DataTable dataTable=(DataTable)FacesContext.getCurrentInstance().getViewRoot().findComponent("formEquivalenciaFic:tablaFic");
        DataTable dataTable2=(DataTable)FacesContext.getCurrentInstance().getViewRoot().findComponent("formEquivalenciaFic:tablaUniversidad");
        
        selectedAsignaturasFic=(ArrayList < Asignatura >)dataTable.getSelection();
        selectedAsignaturasUni=(ArrayList<Asignatura>)dataTable2.getSelection();
        
        if(selectedAsignaturasFic.isEmpty()){
            
            creaMensaje("No hay asignaturas de origen", FacesMessage.SEVERITY_ERROR);
            return null;
        }
        
        if(selectedAsignaturasUni.isEmpty()){
            creaMensaje("No hay asignaturas de destino", FacesMessage.SEVERITY_ERROR);
            return null;
        }
       
        MiembroGrupoAsignatura m;
        
        for(Asignatura a:selectedAsignaturasFic){
       
        m=new MiembroGrupoAsignatura(a,grupoA);
        grupoA.getMiembroGrupoAsignaturas().add(m);
                                                // con cascade save-update no hace falta salvar el miembro_grupo_asignaturas
        
        }
        
        for(Asignatura a:selectedAsignaturasUni){
            
        m=new MiembroGrupoAsignatura(a,grupoB);
        grupoB.getMiembroGrupoAsignaturas().add(m);
       
            
        }
        
        equivalencia.setGrupoAsignaturaByGrupoAsignaturaA(grupoA);
        grupoA.getEquivalenciasForGrupoAsignaturaA().add(equivalencia);
         
         equivalencia.setGrupoAsignaturaByGrupoAsignaturaB(grupoB);
         grupoB.getEquivalenciasForGrupoAsignaturaB().add(equivalencia); 
         
         
        
            creaMensaje(" "+equivalencia.getGrupoAsignaturaByGrupoAsignaturaA().getMiembroGrupoAsignaturas().size()+"  /   "+equivalencia.getGrupoAsignaturaByGrupoAsignaturaB().getMiembroGrupoAsignaturas().size(), FacesMessage.SEVERITY_INFO);
            
            //equivalenciaService.crearGrupoAsignaturas(grupoA);
            //equivalenciaService.crearGrupoAsignaturas(grupoB);
            //equivalenciaService.crearEquivalencia(equivalencia);
            equivalencia.setIdequivalencia(j+1);
            listaAuxEquivalencias.add(equivalencia);
            j++;
            
            //listaEquivalencias=(ArrayList < Equivalencia >)equivalenciaService.listarEquivalenciasPorContrato(selectedContrato);
            
            return null;      
         
         
         
    }
    
    public void confirmarContrato(){
        
        
        
    }
    
    
    
    
    
    public String eliminaEquivalenciasLista(){
        if(selectedEquivalencias.isEmpty()==false){
            
           for(int i=0;i<selectedEquivalencias.size();i++){
               
               creaMensaje(selectedEquivalencias.get(i).getVisible(), FacesMessage.SEVERITY_INFO);
          //listaAuxEquivalencias.remove(selectedEquivalencias.get(i));
          
        }
        }
        
        return null;
        
    }
    
    
    
    
   /* public void limpiar(){
        
        DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("formEquivalenciaFic:tablaFic");
        dataTable.getRowIndex();
        creaMensaje(""+dataTable.getRowIndex(), FacesMessage.SEVERITY_INFO);
        //dataTable.resetValue();
       // dataTable.setFirst(10);
        //dataTable.reset();
        //dataTable.resetValue();
        //dataTable.setFilters(null);
        //dataTable.findSelectedRowKeys();
        
        
    }
    
    
    
    
    
   /* public void seleccionaFila(SelectEvent event){
        
        Asignatura a=(Asignatura)event.getObject();
        creaMensaje(a.getNombreAsignatura(), FacesMessage.SEVERITY_INFO);
        
        
    }
    
    public void deseleccionarFila(UnselectEvent event){
        
        Asignatura a=(Asignatura)event.getObject();
        creaMensaje(a.getNombreAsignatura(), FacesMessage.SEVERITY_INFO);
        
    }
    
    public void unToggle(ToggleSelectEvent event){
        
      DataTable dataTable=(DataTable)event.getSource();
      
      ArrayList<Asignatura> aux=(ArrayList < Asignatura >)dataTable.getSelection();
      for(Asignatura a:aux){
          
          creaMensaje(a.getNombreAsignatura(), FacesMessage.SEVERITY_INFO);
      }
    }
    */
    
    public String detallesAsign(){
         
        return "detallesAsign.xhtml";
        
    }
    
    
    public String volver(){
        return "crearContrato.xhtml?faces-redirect=true";
        
    }
    
     public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
    
}
