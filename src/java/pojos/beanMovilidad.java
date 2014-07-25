/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;



import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.Collections;
import java.util.Date;
import javax.annotation.PostConstruct;
//import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;



@ManagedBean
//@javax.faces.bean.SessionScoped
@ViewScoped
public class beanMovilidad implements Serializable{

   
    
    public beanMovilidad() {
        }
    
     @ManagedProperty(value="#{movilidadService}")
    private transient MovilidadService movilidadService;
    
    @ManagedProperty(value="#{carreraService}")
    private transient CarreraService carreraService;

     
  /*  private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
          stream.defaultReadObject();
          FacesContext context = FacesContext.getCurrentInstance();
          carreraService = (CarreraService)context.getApplication()                            //esto parece no ser necesario
                .evaluateExpressionGet(context, "#{carreraService}", CarreraService.class);
          movilidadService = (MovilidadService)context.getApplication()
                .evaluateExpressionGet(context, "#{movilidadService}", MovilidadService.class);
       }
    */
    
    private Usuario usuario;
    private Date fechaInicio;
    private Date fechaFin;
    
   
    
    private String fechaMin;
    private String fechaMax;
    
    private String selectedPais;
    private String selectedUni;
    private String selectedCarrera;
    private ArrayList<Carrera> listaCarreras;
    private ArrayList<Movilidad>listaMovilidades;
   
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    
    private ArrayList<String> listaUniversidadesStr;
    private ArrayList<String> listaCarrerasStr;
   
    private boolean checkPais;
    private boolean checkUni;
    private boolean checkCarrera;
    
    
    @PostConstruct
    public void init(){
        
       HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       usuario=(Usuario)session.getAttribute("user");
       fechaMin=movilidadService.fechaMin();
       fechaMax=movilidadService.fechaMax();
        //creaMensaje(" "+fechaMax, null);
       
       // listaCarreras=(ArrayList<Carrera>)carreraService.listar();
   //     listaMovilidadades=(ArrayList<Movilidad>)movilidadService.listarTodasMovilidades();
        //setListaMovilidades((ArrayList<Movilidad>)movilidadService.listarTodasMovilidades());
        
    }

   
    
    
    
    
    
    public MovilidadService getMovilidadService() {
        return movilidadService;
    }

    public void setMovilidadService(MovilidadService movilidadService) {
        this.movilidadService = movilidadService;
    }

    public CarreraService getCarreraService() {
        return carreraService;
    }

    public void setCarreraService(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    public String getSelectedPais() {
        return selectedPais;
    }

    public void setSelectedPais(String selectedPais) {
        this.selectedPais = selectedPais;
        //creaMensaje(selectedPais, FacesMessage.SEVERITY_INFO);
    }
    
    

    public String getSelectedUni() {
        return selectedUni;
    }

    public void setSelectedUni(String selectedUni) {
        this.selectedUni = selectedUni;
    }

    public String getSelectedCarrera() {
        return selectedCarrera;
    }

    public void setSelectedCarrera(String selectedCarrera) {
        this.selectedCarrera = selectedCarrera;
    }

    
    
    
    public ArrayList<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public void setListaCarreras(ArrayList<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

   
    
    

    public ArrayList<Movilidad> getListaMovilidades() {
        return listaMovilidades;
    }

    public void setListaMovilidades(ArrayList<Movilidad> listaMovilidades) {
        this.listaMovilidades = listaMovilidades;
    }
    
    
    

    public ArrayList<String> getListaUniversidadesStr() {
        return listaUniversidadesStr;
    }

    public void setListaUniversidadesStr(ArrayList<String> listaUniversidadesStr) {
        this.listaUniversidadesStr = listaUniversidadesStr;
    }

    public ArrayList<String> getListaCarrerasStr() {
        return listaCarrerasStr;
    }

    public void setListaCarrerasStr(ArrayList<String> listaCarrerasStr) {
        this.listaCarrerasStr = listaCarrerasStr;
    }

   

    
    
    
    
    

    public boolean isCheckPais() {
        return checkPais;
    }

    public void setCheckPais(boolean checkPais) {
        this.checkPais = checkPais;
    }

    public boolean isCheckUni() {
        return checkUni;
    }

    public void setCheckUni(boolean checkUni) {
        this.checkUni = checkUni;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isCheckCarrera() {
        return checkCarrera;
    }

    public void setCheckCarrera(boolean checkCarrera) {
        this.checkCarrera = checkCarrera;
    }

    public String getFechaMin() {
        return fechaMin;
    }

    public void setFechaMin(String fechaMin) {
        this.fechaMin = fechaMin;
    }

    public String getFechaMax() {
        return fechaMax;
    }

    public void setFechaMax(String fechaMax) {
        this.fechaMax = fechaMax;
    }

   
    
    
    
    
    

   public void onDropboxChangePais(){
       
       checkPais=true;
       checkUni=false;
       listaUniversidadesStr=(ArrayList<String>)carreraService.listarPorPaisStr(selectedPais);
       Collections.sort(listaUniversidadesStr);
       creaMensaje(" al cambiar pais "+checkPais+" selectedPais: "+selectedPais,FacesMessage.SEVERITY_INFO);
       
       
   }

    public void onDropboxchangeUni(){
        
        
        checkUni=true;
        
        listaCarrerasStr=(ArrayList<String>)carreraService.listarPorUniversidadStr(selectedUni);
        Collections.sort(listaCarrerasStr);
       creaMensaje(" al cambiar uni "+checkUni+" selectedUni: "+selectedUni,FacesMessage.SEVERITY_INFO);
        
    }

   
    
    public String crearMovilidad(){
        
        
        
        
        checkPais=false;
        checkUni=false;
        creaMensaje(selectedCarrera+" "+selectedPais+" "+selectedUni+" "+usuario.getLogin() + " "+fechaMax, FacesMessage.SEVERITY_INFO);
        Calendar cal1=Calendar.getInstance();
        Calendar cal2=Calendar.getInstance();
                cal1.setTime(fechaInicio);
                cal2.setTime(fechaFin);
                if (cal2.compareTo(cal1)<1){
                    
                    creaMensaje("la fecha de inicio es posterior a la fecha de fin", FacesMessage.SEVERITY_ERROR);
                    
                }
                String estado="pendiente";
                
                try{
              Carrera c=carreraService.find(selectedCarrera, selectedUni);
              Movilidad m=new Movilidad(usuario, c, fechaInicio, fechaFin, estado);
              movilidadService.crearMovilidad(m);
                }catch(Exception ex){
                    creaMensaje("se ha producido un error creando la movilidad", FacesMessage.SEVERITY_ERROR);
                    return "";
                }
                creaMensaje("movilidad creada, a la espera de aprobación por el coordinador", FacesMessage.SEVERITY_INFO);
                selectedCarrera="";
                selectedPais="";
                selectedUni="";
                fechaFin=null;
                fechaInicio=null;
                
                return "";
                
                
                
                
                
       // selectedCarrera="";
        //selectedPais="";
        //selectedUni="";
    }
    
    
    
    
    
    public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
    
    
    
    
    
    }
    
