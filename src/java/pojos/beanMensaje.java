/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Collections;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;


/**
 *
 * @author abc
 */
@ManagedBean
@ViewScoped
public class beanMensaje implements Serializable{

    @ManagedProperty(value="#{usuarioService}")
    private transient UsuarioService usuarioService;
    
    @ManagedProperty(value="#{mensajeService}")
    private transient MensajeService mensajeService;
    
    
    private ArrayList<Mensaje> listaMensajesRecibidos;
    private ArrayList<Mensaje> listaMensajesEnviados;
    
    
    
    private ArrayList<String> estados;
    private Usuario user;
    
    
    
    private boolean activaRecibido;
    private String textAreaRecibido;
    private String temaRecibido;
    
    private boolean activaEnviado;
    private String textAreaEnviado;
    private String temaEnviado;
    
    private boolean activaTexto;
    private String tema;
    private String texto;
    
    private Mensaje selectedMensajeEnviado;
    private Mensaje selectedMensajeRecibido;
    private ArrayList<Mensaje> selectedMensajesEnviados;
    private ArrayList<Mensaje> selectedMensajesRecibidos;
    private ArrayList<Mensaje> filteredMensajesEnviados;
    private ArrayList<Mensaje> filteredMensajesRecibidos;
    private Usuario selectedUsuario;
    
    public beanMensaje() {
        
    }
    
    @PostConstruct
    public void init(){
        
        ArrayList<String> aux= new ArrayList<String>();
        aux.add("si");
        aux.add("no");
        setEstados(aux);
       HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       
       
       if((Usuario)session.getAttribute("user")!=null){
           user=(Usuario)session.getAttribute("user");
           setListaMensajesRecibidos((ArrayList<Mensaje>)mensajeService.mensajesRecibidos("admin", user.getLogin()));
        setListaMensajesEnviados((ArrayList<Mensaje>)mensajeService.mensajesEnviados(user.getLogin(), "admin"));
           
       }
       else{
           
           user=(Usuario)session.getAttribute("admin");
           setListaMensajesEnviados((ArrayList<Mensaje>)mensajeService.mensajesEnviadosTotal("admin"));
           setListaMensajesRecibidos((ArrayList<Mensaje>)mensajeService.mensajesRecibidosTotal("admin"));
          
           
       }
       
       
        
        
        
        
        
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }
    
    
    

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }

    public ArrayList<Mensaje> getSelectedMensajesEnviados() {
        return selectedMensajesEnviados;
    }

    public void setSelectedMensajesEnviados(ArrayList<Mensaje> selectedMensajesEnviados) {
        this.selectedMensajesEnviados = selectedMensajesEnviados;
    }

    public ArrayList<Mensaje> getSelectedMensajesRecibidos() {
        return selectedMensajesRecibidos;
    }

    public void setSelectedMensajesRecibidos(ArrayList<Mensaje> selectedMensajesRecibidos) {
        this.selectedMensajesRecibidos = selectedMensajesRecibidos;
    }

    public ArrayList<Mensaje> getFilteredMensajesEnviados() {
        return filteredMensajesEnviados;
    }

    public void setFilteredMensajesEnviados(ArrayList<Mensaje> filteredMensajesEnviados) {
        this.filteredMensajesEnviados = filteredMensajesEnviados;
    }

    public ArrayList<Mensaje> getFilteredMensajesRecibidos() {
        return filteredMensajesRecibidos;
    }

    public void setFilteredMensajesRecibidos(ArrayList<Mensaje> filteredMensajesRecibidos) {
        this.filteredMensajesRecibidos = filteredMensajesRecibidos;
    }

   
    
   
    
    
    
    

   
    

   
    
    
    
    

    public ArrayList<Mensaje> getListaMensajesRecibidos() {
        //Collections.reverse(listaMensajesRecibidos);
        return listaMensajesRecibidos;
    }

    public void setListaMensajesRecibidos(ArrayList<Mensaje> ListaMensajesRecibidos) {
        this.listaMensajesRecibidos = ListaMensajesRecibidos;
    }

    public ArrayList<Mensaje> getListaMensajesEnviados() {
        //Collections.reverse(listaMensajesEnviados);
        return listaMensajesEnviados;
    }

    public void setListaMensajesEnviados(ArrayList<Mensaje> listaMensajesEnviados) {
        this.listaMensajesEnviados = listaMensajesEnviados;
    }
    
    

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public MensajeService getMensajeService() {
        return mensajeService;
    }

    public void setMensajeService(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    public boolean isActivaTexto() {
        return activaTexto;
    }

    public boolean isActivaEnviado() {
        return activaEnviado;
    }

    public void setActivaEnviado(boolean activaEnviado) {
        this.activaEnviado = activaEnviado;
    }

    public boolean isActivaRecibido() {
        return activaRecibido;
    }

    public void setActivaRecibido(boolean activaRecibido) {
        this.activaRecibido = activaRecibido;
    }

    public String getTextAreaRecibido() {
        return textAreaRecibido;
    }

    public void setTextAreaRecibido(String textAreaRecibido) {
        this.textAreaRecibido = textAreaRecibido;
    }

    public String getTemaRecibido() {
        return temaRecibido;
    }

    public void setTemaRecibido(String temaRecibido) {
        this.temaRecibido = temaRecibido;
    }
    
    

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    
   
    
    

    public void setActivaTexto(boolean activaTexto) {
        this.activaTexto = activaTexto;
    }

    public String getTextAreaEnviado() {
        return textAreaEnviado;
    }

    public void setTextAreaEnviado(String textAreaEnviado) {
        this.textAreaEnviado = textAreaEnviado;
    }

    public String getTemaEnviado() {
        return temaEnviado;
    }

    public void setTemaEnviado(String temaEnviado) {
        this.temaEnviado = temaEnviado;
    }

    public Mensaje getSelectedMensajeEnviado() {
        return selectedMensajeEnviado;
    }

    public void setSelectedMensajeEnviado(Mensaje selectedMensajeEnviado) {
        this.selectedMensajeEnviado = selectedMensajeEnviado;
    }

    public Mensaje getSelectedMensajeRecibido() {
        return selectedMensajeRecibido;
    }

    public void setSelectedMensajeRecibido(Mensaje selectedMensajeRecibido) {
        this.selectedMensajeRecibido = selectedMensajeRecibido;
    }
    
    
    
    
    
    
    
    
    
    public void activarTexto(){
        
        activaTexto=true;
    }
    
    
    
    
    
    
    
    
    
    public String enviarMensajeCoordinador(){
        
        Usuario destino=usuarioService.find("admin");
        
        
        Mensaje m=new Mensaje(user, destino, Calendar.getInstance().getTime(), tema, texto, "no","no","no");
        try{
        mensajeService.enviarMensaje(m);
        }catch(Exception ex){
            
            creaMensaje("se ha producido un error creando el mensaje", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        
        creaMensaje("mensaje enviado correctamente", FacesMessage.SEVERITY_WARN);
        texto="";
        tema="";
        activaTexto=false;
        //actualizarEnviados();
        return "";
    }
    
    public String enviaMensajeUsuario(){
        
         Mensaje m=new Mensaje(user, selectedUsuario, Calendar.getInstance().getTime(), tema, texto, "no","no","no");
        try{
        mensajeService.enviarMensaje(m);
        }catch(Exception ex){
            
            creaMensaje("se ha producido un error creando el mensaje", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        
        creaMensaje("mensaje enviado correctamente", FacesMessage.SEVERITY_WARN);
        texto="";
        tema="";
        activaTexto=false;
        //actualizarEnviados();
        return "";
   
    }
    
   
    
    public void cancelarEnvioCoordinador(){
        
        activaTexto=false;
    }
    
   
    
    
    public void actualizarEnviados(){
        
        if(user.getLogin().equals("admin")==false){
            
        
        setListaMensajesEnviados((ArrayList<Mensaje>)mensajeService.mensajesEnviados(user.getLogin(), "admin"));
        
        
        for(Mensaje m:selectedMensajesEnviados){
            
            if(selectedMensajeEnviado!=null&&m.getIdmensaje().equals(selectedMensajeEnviado.getIdmensaje()))
             
            activaEnviado=false;
            
        }    
        
        
        }
        else if(user.getLogin().equals("admin")){
             
        setListaMensajesEnviados((ArrayList<Mensaje>)mensajeService.mensajesEnviadosTotal("admin"));
        for(Mensaje m:selectedMensajesEnviados){
            
            if(selectedMensajeEnviado!=null&&m.getIdmensaje().equals(selectedMensajeEnviado.getIdmensaje()))
             
            activaEnviado=false;
            
        }       
        
        }
              
    }
    
    
    public void actualizarRecibidos(){
        
        if(user.getLogin().equals("admin")==false){
            
        setListaMensajesRecibidos((ArrayList<Mensaje>)mensajeService.mensajesRecibidos("admin", user.getLogin()));
        for(Mensaje m:selectedMensajesRecibidos){
            
            if(selectedMensajeRecibido!=null&&m.getIdmensaje().equals(selectedMensajeRecibido.getIdmensaje()))
             
            activaRecibido=false;
            
        }     
         
        }
        else if(user.getLogin().equals("admin")){
            
        setListaMensajesRecibidos((ArrayList<Mensaje>)mensajeService.mensajesRecibidosTotal("admin"));
        for(Mensaje m:selectedMensajesRecibidos){
            
            if(selectedMensajeRecibido!=null&&m.getIdmensaje().equals(selectedMensajeRecibido.getIdmensaje()))
             
            activaRecibido=false;
            
        }    
   
        }
              
    }
    
    
   
    
    public String eliminarMensajesEnviados(){
        creaMensaje("en eliminarMensajeEnviado", FacesMessage.SEVERITY_INFO);
        if(selectedMensajesEnviados.isEmpty()){
            return "";
        }
        
        for(Mensaje m:selectedMensajesEnviados){
            creaMensaje(m.getEliminadoDestino(), FacesMessage.SEVERITY_INFO);
            
            
             Mensaje aux=mensajeService.find(m.getIdmensaje());
            
            if(aux!=null){
            aux.setEliminadoOrigen("si");
           
            try{
            
                if(aux.getEliminadoDestino().equals("si")){
                    
                    mensajeService.eliminarMensaje(aux);
                }else{
                    
                  mensajeService.enviarMensaje(aux);  
                }
                
            }catch(Exception ex){
                
                creaMensaje("se ha producido un error en el borrado de mensajes", FacesMessage.SEVERITY_ERROR);
                return "";
            }
            }
        }
     
        creaMensaje("mensajes eliminados correctamente", FacesMessage.SEVERITY_INFO);
        actualizarEnviados();
       // actualizarRecibidos();
        return "";
        
    }
    
    
     public String eliminarMensajesRecibidos(){
        
        if(selectedMensajesRecibidos.isEmpty()){
            return "";
        }
        
        for(Mensaje m:selectedMensajesRecibidos){
         
            Mensaje aux=mensajeService.find(m.getIdmensaje());
            
            if(aux!=null){
            aux.setEliminadoDestino("si");
                creaMensaje(aux.getEliminadoOrigen()+" "+aux.getEliminadoDestino(), FacesMessage.SEVERITY_INFO);
            
            try{
                
                if(aux.getEliminadoOrigen().equals("si")){
                    
                    mensajeService.eliminarMensaje(aux);
                }else{
                    
                     mensajeService.enviarMensaje(aux);
                }
                
            }catch(Exception ex){
                
                creaMensaje("se ha producido un error en el borrado de mensajes", FacesMessage.SEVERITY_ERROR);
                return "";
            }
            
        }
        }
         creaMensaje("mensajes eliminados correctamente", FacesMessage.SEVERITY_INFO);
         //actualizarEnviados();
        actualizarRecibidos();
        return "";
        
        
        
    }
    
    
    
    public void cerrarMensajeEnviado(){
        
        textAreaEnviado="";
        temaEnviado="";
        activaEnviado=false;
        
    }
    
    public String leerMensajeRecibido(){
        
        activaRecibido=true;
        temaRecibido=selectedMensajeRecibido.getTema();
        textAreaRecibido=selectedMensajeRecibido.getTexto();
        
       // if (filteredMensajesRecibidos!=null) filteredMensajesRecibidos.remove(selectedMensajeRecibido);
        
        Mensaje aux=mensajeService.find(selectedMensajeRecibido.getIdmensaje());
            
            if(aux!=null){
            aux.setLeidoDestino("si");
            selectedMensajeRecibido.setLeidoDestino("si");
        //if (filteredMensajesRecibidos!=null) filteredMensajesRecibidos.add(aux);
        try{
            
            mensajeService.enviarMensaje(aux);
            
        }catch(Exception ex){
            
            creaMensaje("se ha producido un error al leer mensaje", FacesMessage.SEVERITY_ERROR);
            return "";
        }
            }
       //listaMensajesEnviados=(ArrayList<Mensaje>)mensajeService.mensajesRecibidos(, texto)
        
      return "";
        
    }
    
     public void leerMensajeEnviado(){
        
        activaEnviado=true;
        textAreaEnviado=selectedMensajeEnviado.getTexto();
        temaEnviado=selectedMensajeEnviado.getTema();
        
    }
    
    
    public void cerrarMensajeRecibido(){
        
        textAreaRecibido="";
        temaRecibido="";
        activaRecibido=false;
        
    }   
    
    
    
     public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
    
   
}