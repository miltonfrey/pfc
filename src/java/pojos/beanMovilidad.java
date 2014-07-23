/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import javax.annotation.PostConstruct;
//import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@Named(value = "beanMovilidad")
@SessionScoped
public class beanMovilidad implements Serializable{

   
    
    public beanMovilidad() {
        }
    
    //@ManagedProperty(value="#{movilidadService}")
    //private MovilidadService movilidadService;
    
    //@ManagedProperty(value="{carreraService}")
    //private CarreraService carreraService;

     @ManagedProperty(value="#{usuarioService}")  //  Bean injected
      private UsuarioService usuarioService;
    
    
    
    private String selectedPais;
    private String selectedUni;
    private String selectedCarrera;
    private ArrayList<Carrera> listaCarreras;
    private ArrayList<Movilidad>listaMovilidadades;
    private ArrayList<Usuario>listaUsuarios;
    
    private ArrayList<String> listaUniversidadesStr;
    private ArrayList<String> listaCarrerasStr;
   
    private boolean checkPais;
    private boolean checkUni;
    
    
    @PostConstruct
    public void init(){
        
        //listaCarreras=(ArrayList<Carrera>)carreraService.listar();
   //     listaMovilidadades=(ArrayList<Movilidad>)movilidadService.listarTodasMovilidades();
        setListaUsuarios((ArrayList < Usuario >)usuarioService.listar());
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    
    
    
    
    //public MovilidadService getMovilidadService() {
        //return movilidadService;
    //}

   //public void setMovilidadService(MovilidadService movilidadService) {
       // this.movilidadService = movilidadService;
    //}

    //public CarreraService getCarreraService() {
      //  return carreraService;
    //}

    //public void setCarreraService(CarreraService carreraService) {
      //  this.carreraService = carreraService;
    //}

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

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    

    public ArrayList<Movilidad> getListaMovilidadades() {
        return listaMovilidadades;
    }

    public void setListaMovilidadades(ArrayList<Movilidad> listaMovilidadades) {
        this.listaMovilidadades = listaMovilidadades;
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
    
    

   public void onDropboxChangePais(){
       
       checkPais=true;
       System.out.println(checkPais);
      // listaUniversidadesStr=(ArrayList<String>)carreraService.listarPorPaisStr(selectedPais);
      // creaMensaje(carreraService.prueba(),FacesMessage.SEVERITY_INFO);
       
       
   }

    public void onDropboxchangeUni(){
        
        
        checkUni=true;
        
        //listaCarrerasStr=(ArrayList<String>)carreraService.listarPorUniversidadStr(selectedUni);
       
        
    }

   
    
    public void crearMovilidad(){
        
        creaMensaje("movilidad creada, a la espera de aprobación por el coordinador", FacesMessage.SEVERITY_INFO);
        selectedCarrera="";
        selectedPais="";
        selectedUni="";
        checkPais=false;
        checkUni=false;
       // List<Movilidad>aux=movilidadService.listarTodasMovilidades();
    }
    
    
    
    
    
    public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
    
    
    
    
    
    }
    
