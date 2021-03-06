

package pojos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import pojos.utillidades.beanUtilidades;


@ManagedBean
@ViewScoped
public class crearAsignaturaBean implements Serializable{
    
    @ManagedProperty(value="#{universidadService}")
    private UniversidadService universidadService;
    
    @ManagedProperty (value="#{asignaturaService}")
    private AsignaturaService asignaturaService;
    
    @ManagedProperty (value="#{beanUtilidades}")
    private beanUtilidades beanUtilidades;
    
    
    
    private String paisStr;
    private String universidadStr;
    
   
    
    
   
    
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

    public beanUtilidades getBeanUtilidades() {
        return beanUtilidades;
    }

    public void setBeanUtilidades(beanUtilidades beanUtilidades) {
        this.beanUtilidades = beanUtilidades;
    }
    
    
    
    @PostConstruct
    public void init(){
        
        setListaPaises((ArrayList<Pais>)universidadService.listaPaises());
        
    }
    
    
    public crearAsignaturaBean() {
        
        
    }

    public String getPaisStr() {
        return paisStr;
    }

    public void setPaisStr(String paisStr) {
        this.paisStr = paisStr;
    }

    

   

    public String getUniversidadStr() {
        return universidadStr;
    }

    public void setUniversidadStr(String universidadStr) {
        this.universidadStr = universidadStr;
    }

    
    
    
    public Pais getSelectedPais() {
        return selectedPais;
    }

    public void setSelectedPais(Pais selectedPais) {
        this.selectedPais = selectedPais;
    }

   
    public void onChangePaisUni(){
    
    
    listaUniversidades=(ArrayList < Universidad >)universidadService.listarPorPais(paisStr);
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
        //listaAsignaturas=(ArrayList<Asignatura>)asignaturaService.listarPorCriterio();
       checkDetalles=false;
       
        
    }
    
    public String creaAsignatura(){
        
       
        Universidad uni=universidadService.findUniversidad(universidadStr);
         AsignaturaId id=new AsignaturaId(codAsignatura,universidadStr);
        
        Asignatura a=new Asignatura(id,uni, nombreAsignatura, creditosAsignatura.shortValue(),periodoAsignatura,infoAsignatura,webAsignatura,facultadAsignatura,titulacionAsignatura,null,null);
        
        try{
            
            asignaturaService.crearAsignatura(a);
        }catch(Exception ex){
            
            beanUtilidades.creaMensaje("se ha producido un error creando la asignatura, el código ya existe", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        
        beanUtilidades.creaMensaje("asignatura creada correctamente", FacesMessage.SEVERITY_INFO);
        nombreAsignatura="";
        codAsignatura=null;
        creditosAsignatura=null;
        periodoAsignatura="";
        titulacionAsignatura="";
        facultadAsignatura="";
        infoAsignatura="";
        webAsignatura="";
        listaAsignaturas=(ArrayList<Asignatura>)asignaturaService.listarAsignaturasPorUniversidad(universidadStr);
        
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
            
            beanUtilidades.creaMensaje("error al editar la asignatura", FacesMessage.SEVERITY_INFO);
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
                
                beanUtilidades.creaMensaje("se ha producido un error eliminando asignatura", FacesMessage.SEVERITY_ERROR);
                return null;
            }
            
            
        }
        
        beanUtilidades.creaMensaje("se han eliminado correctamente las asignaturas",FacesMessage.SEVERITY_INFO);
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

}
