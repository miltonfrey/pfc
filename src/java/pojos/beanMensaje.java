/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
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
    private Usuario user;
    
    private boolean activaTexto;
    private String textArea;
    private String tema;
   private String aux;
    
    public beanMensaje() {
        
    }
    
    @PostConstruct
    public void init(){
        
       HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       user=(Usuario)session.getAttribute("user");
       
        setListaMensajesRecibidos((ArrayList<Mensaje>)mensajeService.mensajesEnviados("admin", user.getLogin()));
        setListaMensajesEnviados((ArrayList<Mensaje>)mensajeService.mensajesEnviados(user.getLogin(), "admin"));
        
        
    }

   
    
    
    
    

    public ArrayList<Mensaje> getListaMensajesRecibidos() {
        return listaMensajesRecibidos;
    }

    public void setListaMensajesRecibidos(ArrayList<Mensaje> ListaMensajesRecibidos) {
        this.listaMensajesRecibidos = ListaMensajesRecibidos;
    }

    public ArrayList<Mensaje> getListaMensajesEnviados() {
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

    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

   
    
    

    public void setActivaTexto(boolean activaTexto) {
        this.activaTexto = activaTexto;
    }

    public String getTextArea() {
        return textArea;
    }

    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    
    
    
    
    
    
    
    
    public void activarTexto(){
        
        activaTexto=true;
    }
    
    
    
    
    
    public void activaMensaje(){
        
        activaTexto=true;
        
    }
    
    public String enviarMensajeCoordinador(){
        
        Usuario destino=usuarioService.find("admin");
        
        
        Mensaje m=new Mensaje(user, destino, Calendar.getInstance().getTime(), tema, textArea, "sin leer");
        try{
        mensajeService.enviarMensaje(m);
        }catch(Exception ex){
            
            creaMensaje("se ha producido un error creando el mensaje", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        
        creaMensaje("mensaje enviado correctamente", FacesMessage.SEVERITY_WARN);
        textArea="";
        tema="";
        activaTexto=false;
        actualizar();
        return "";
    }
    
    public void actualizar(){
        
        setListaMensajesRecibidos((ArrayList<Mensaje>)mensajeService.mensajesEnviados("admin", user.getLogin()));
        setListaMensajesEnviados((ArrayList<Mensaje>)mensajeService.mensajesEnviados(user.getLogin(), "admin"));
        
    }
    
    
    
    
     public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
    
    
    
    
}
