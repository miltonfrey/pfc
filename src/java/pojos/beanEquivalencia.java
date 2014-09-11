/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import antlr.debug.Event;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.event.UnselectEvent;
//import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author abc
 */
@ManagedBean
@ViewScoped
public class beanEquivalencia implements Serializable{

     @ManagedProperty(value="#{movilidadService}")
    private MovilidadService movilidadService;
    
    @ManagedProperty(value="#{asignaturaService}")
    private AsignaturaService asignaturaService;
    
    @ManagedProperty(value="#{beanContrato}")
    private beanContrato beanContrato;
    
    @ManagedProperty(value="#{equivalenciaService}")
    private EquivalenciaService equivalenciaService;
   
    private Equivalencia equivalencia=new Equivalencia();
    private GrupoAsignatura grupoA=new GrupoAsignatura();
    private GrupoAsignatura grupoB=new GrupoAsignatura();
    
    private Set<MiembroGrupoAsignatura> setMiembrosGrupoAsignaturasA;
    private Set<MiembroGrupoAsignatura> setMiembrosGrupoAsignaturasB;
    
    private ArrayList<Equivalencia>listaEquivalencias;
    
    private ArrayList<Asignatura>selectedAsignaturasFic;
    private ArrayList<Asignatura> selectedAsignaturasUni;
    
    private ArrayList<Asignatura>selectedEquivalencias;
    
    public beanEquivalencia() {
        
    }
    
    @PostConstruct
    public void init(){
        
       listaEquivalencias=(ArrayList<Equivalencia>)equivalenciaService.listarEquivalencias();
       
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

    public void setSelectedAsignaturasFic(ArrayList<Asignatura> selectedAsignaturasFic) {
        this.selectedAsignaturasFic = selectedAsignaturasFic;
    }

    public ArrayList<Asignatura> getSelectedEquivalencias() {
        return selectedEquivalencias;
    }

    public void setSelectedEquivalencias(ArrayList<Asignatura> selectedEquivalencias) {
        this.selectedEquivalencias = selectedEquivalencias;
    }

    public ArrayList<Equivalencia> getListaEquivalencias() {
        return listaEquivalencias;
    }

    public void setListaEquivalencias(ArrayList<Equivalencia> listaEquivalencias) {
        this.listaEquivalencias = listaEquivalencias;
    }

    public Equivalencia getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(Equivalencia equivalencia) {
        this.equivalencia = equivalencia;
    }

    public ArrayList<Asignatura> getSelectedAsignaturasUni() {
        return selectedAsignaturasUni;
    }

    public void setSelectedAsignaturasUni(ArrayList<Asignatura> selectedAsignaturasUni) {
        this.selectedAsignaturasUni = selectedAsignaturasUni;
    }

    public GrupoAsignatura getGrupoA() {
        return grupoA;
    }

    public void setGrupoA(GrupoAsignatura grupoA) {
        this.grupoA = grupoA;
    }

    public GrupoAsignatura getGrupoB() {
        return grupoB;
    }

    public void setGrupoB(GrupoAsignatura grupoB) {
        this.grupoB = grupoB;
    }
    
    
    
    
    
    
    public String asignaturasTotales(){
       
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
        //equivalenciaService.crearGrupoAsignaturas(grupoA);  con cascade save-update no hace falta
        //equivalenciaService.crearMiembroGrupoAsignatura(m);// con cascade save-update no hace falta
        
        }
        
        for(Asignatura a:selectedAsignaturasUni){
            
        m=new MiembroGrupoAsignatura(a,grupoB);
        grupoB.getMiembroGrupoAsignaturas().add(m);
       // equivalenciaService.crearMiembroGrupoAsignatura(m);
            
        }
        
        
         
         crearEquivalencia();
         return null;
         
    }
    
    public void crearEquivalencia(){
        
        equivalencia.setGrupoAsignaturaByGrupoAsignaturaA(grupoA);
        grupoA.getEquivalenciasForGrupoAsignaturaA().add(equivalencia);
         
         equivalencia.setGrupoAsignaturaByGrupoAsignaturaB(grupoB);
         grupoB.getEquivalenciasForGrupoAsignaturaB().add(equivalencia);       
        
        
            creaMensaje(" "+equivalencia.getGrupoAsignaturaByGrupoAsignaturaA().getMiembroGrupoAsignaturas().size()+"  /   "+equivalencia.getGrupoAsignaturaByGrupoAsignaturaB().getMiembroGrupoAsignaturas().size(), FacesMessage.SEVERITY_INFO);
            
            equivalenciaService.crearGrupoAsignaturas(grupoA);
            equivalenciaService.crearGrupoAsignaturas(grupoB);
            equivalenciaService.crearEquivalencia(equivalencia);
            
            listaEquivalencias=(ArrayList < Equivalencia >)equivalenciaService.listarEquivalencias();
            grupoA=new GrupoAsignatura();
            grupoB=new GrupoAsignatura();
            equivalencia=new Equivalencia();
        
        
    }
    
    
    
    
    
    public String eliminaEquivalenciasLista(){
        
        
        return "";
        
    }
    
    
    
    
  /*  public void limpiar(){
        
        DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("formEquivalenciaFic:tablaFic");
        //dataTable.reset();
        //dataTable.resetValue();
       // dataTable.setFirst(10);
        //dataTable.reset();
        //dataTable.resetValue();
        //dataTable.setFilters(null);
        //dataTable.findSelectedRowKeys();
        
        
    }
    
    
    
    
    
    public void seleccionaFila(SelectEvent event){
        
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
    
     public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
    
}
