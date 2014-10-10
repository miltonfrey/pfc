/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;



import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Calendar;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
//import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.RequestScoped;
//import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.event.RowEditEvent;




@ManagedBean
//@javax.faces.bean.SessionScoped
@ViewScoped
public class beanMovilidad implements Serializable{

   
    
    public beanMovilidad() {
        }
    
     @ManagedProperty(value="#{movilidadService}")
    private transient MovilidadService movilidadService;
    
    @ManagedProperty(value="#{universidadService}")
    private transient UniversidadService universidadService;

     @ManagedProperty(value="#{usuarioService}")
     private transient UsuarioService usuarioService;
     
     @ManagedProperty(value="#{mensajeService}")
     private transient MensajeService mensajeService;
  
    
    private Usuario usuario;
    private Date fechaInicio;
    private Date fechaFin;
    
   
    
    private Date fechaMin;
    private Date fechaMax;
    private Cursoacademico cursoacademico;
    
    private String texto;
    private String tema;
    private boolean activaTexto;
    
    private String changeEstado;
    
    private String selectedPais;
    
    private String selectedUniversidad;
    private Movilidad selectedMovilidad;
    private Movilidad antiguaMovilidad;
    private ArrayList<Universidad> listaUniversidades;
    private ArrayList<Movilidad>listaMovilidades;
    private ArrayList<Movilidad> listaMisMovilidades;
    private ArrayList<Movilidad> filteredMovilidades;
    private ArrayList<Movilidad> selectedMovilidades;
    private ArrayList<String> estados;
    
    
    
    
    private ArrayList<Object> listaObject;
    private ArrayList<Object> listaO;
    
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    
    private ArrayList<String> listaUniversidadesStr;
    private ArrayList<String> listaUniversidadsStr;
   
    
    
    private boolean checkPais;
    private boolean checkUni;
    private boolean checkUniversidad;
    
    
    @PostConstruct
    public void init(){
    
       HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
      // HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       
       if(session.getAttribute("user")!=null){
       usuario=(Usuario)session.getAttribute("user");
       fechaMin=movilidadService.fechaMin();
       fechaMax=movilidadService.fechaMax();
       listaMisMovilidades=(ArrayList < Movilidad >)movilidadService.listarMisMovilidades(usuario.getLogin());
       //listaObject=(ArrayList<Object>)movilidadService.doJoin();
       //Object[] lo=(Object[])listaObject.get(0);
      //listaO=(ArrayList<Object>)(List<Object>)Arrays.asList(lo);// no va
     // Universidad us=(Universidad)lo[1];
         //  creaMensaje(us.getNombre(), FacesMessage.SEVERITY_INFO);
        
    }else{
           usuario=(Usuario)session.getAttribute("admin");
           listaMovilidades=(ArrayList<Movilidad>)movilidadService.listarTodasMovilidades();
           
            }
           
       }

    public ArrayList<Object> getListaObject() {
        return listaObject;
    }

    public void setListaObject(ArrayList<Object> listaObject) {
        this.listaObject = listaObject;
    }

    public ArrayList<Object> getListaO() {
        return listaO;
    }

    public void setListaO(ArrayList<Object> listaO) {
        this.listaO = listaO;
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

    public UniversidadService getUniversidadService() {
        return universidadService;
    }

    public void setUniversidadService(UniversidadService universidadService) {
        this.universidadService = universidadService;
    }

    public String getSelectedPais() {
        return selectedPais;
    }

    public void setSelectedPais(String selectedPais) {
        this.selectedPais = selectedPais;
        //creaMensaje(selectedPais, FacesMessage.SEVERITY_INFO);
        
    }

    public Cursoacademico getCursoacademico() {
        return cursoacademico;
    }

    public void setCursoacademico(Cursoacademico cursoacademico) {
        this.cursoacademico = cursoacademico;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public boolean isActivaTexto() {
        return activaTexto;
    }

    public void setActivaTexto(boolean activaTexto) {
        this.activaTexto = activaTexto;
    }
    
    

   

    public String getSelectedUniversidad() {
        return selectedUniversidad;
    }

    public void setSelectedUniversidad(String selectedUniversidad) {
        this.selectedUniversidad = selectedUniversidad;
    }

    public Movilidad getSelectedMovilidad() {
        return selectedMovilidad;
    }

    public void setSelectedMovilidad(Movilidad selectedMovilidad) {
        this.selectedMovilidad = selectedMovilidad;
    }

    public ArrayList<Movilidad> getSelectedMovilidades() {
        return selectedMovilidades;
    }

    public void setSelectedMovilidades(ArrayList<Movilidad> selectedMovilidades) {
        this.selectedMovilidades = selectedMovilidades;
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    
    
    
    public ArrayList<Universidad> getListaUniversidades() {
        return listaUniversidades;
    }

    public void setListaUniversidades(ArrayList<Universidad> listaUniversidades) {
        this.listaUniversidades = listaUniversidades;
    }

   
    
    

    public ArrayList<Movilidad> getListaMovilidades() {
        Collections.reverse(listaMovilidades);
        return listaMovilidades;
    }

    public void setListaMovilidades(ArrayList<Movilidad> listaMovilidades) {
        this.listaMovilidades = listaMovilidades;
    }

    public ArrayList<Movilidad> getListaMisMovilidades() {
         Collections.reverse(listaMisMovilidades);
         return listaMisMovilidades;
    }

    public void setListaMisMovilidades(ArrayList<Movilidad> listaMisMovilidades) {
        this.listaMisMovilidades = listaMisMovilidades;
    }

    public ArrayList<Movilidad> getFilteredMovilidades() {
        return filteredMovilidades;
    }

    public void setFilteredMovilidades(ArrayList<Movilidad> filteredMovilidades) {
        this.filteredMovilidades = filteredMovilidades;
    }

    public Movilidad getAntiguaMovilidad() {
        return antiguaMovilidad;
    }

    public void setAntiguaMovilidad(Movilidad antiguaMovilidad) {
        this.antiguaMovilidad = antiguaMovilidad;
    }
    
    
    

    public ArrayList<String> getListaUniversidadesStr() {
        return listaUniversidadesStr;
    }

    public void setListaUniversidadesStr(ArrayList<String> listaUniversidadesStr) {
        this.listaUniversidadesStr = listaUniversidadesStr;
    }

    public ArrayList<String> getListaUniversidadsStr() {
        return listaUniversidadsStr;
    }

    public void setListaUniversidadsStr(ArrayList<String> listaUniversidadsStr) {
        this.listaUniversidadsStr = listaUniversidadsStr;
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
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

    public boolean isCheckUniversidad() {
        return checkUniversidad;
    }

    public void setCheckUniversidad(boolean checkUniversidad) {
        this.checkUniversidad = checkUniversidad;
    }

    public Date getFechaMin() {
        return fechaMin;
    }

    public void setFechaMin(Date fechaMin) {
        this.fechaMin = fechaMin;
    }

    public Date getFechaMax() {
        return fechaMax;
    }

    public void setFechaMax(Date fechaMax) {
        this.fechaMax = fechaMax;
    }

    public String getChangeEstado() {
        return changeEstado;
    }

    public void setChangeEstado(String changeEstado) {
        this.changeEstado = changeEstado;
    }

   
    
    
    
    
    

   public void onDropboxChangePais(){
       
       checkPais=true;
       //checkUni=false;
      
       listaUniversidades=(ArrayList<Universidad>)universidadService.listarPorPais(selectedPais);
       //Collections.sort(listaUniversidadesStr);
      
     /*  Object[] arrayObject=(Object[])listaObject.get(0);
       Movilidad m=(Movilidad)arrayObject[0];
       System.out.println(m.getEstado());
       Universidad u=(Universidad)arrayObject[1];
       System.out.println(u.getNombre());*/
       
       //listaO=(ArrayList<Object>)Arrays.asList((Object[])listaObject.get(0));
       
       
   }

    public void onDropboxchangeUni(){
        
        
        //checkUni=true;
        
        //listaUniversidades=(ArrayList<St>)universidadService.listarPorUniversidadStr(selectedUniversidad);
       // Collections.sort(listaUniversidadsStr);
      
        
    }
    
    public void onRowEditInit(RowEditEvent event){
        
        
        antiguaMovilidad=(Movilidad)event.getObject();
        creaMensaje("init", FacesMessage.SEVERITY_INFO);
        
    }
    
    
    
    public void onRowEdit(RowEditEvent event){
       
        Movilidad m=(Movilidad)event.getObject();
        
        if(changeEstado.equals(m.getEstado())==false){
            
        
        m.setEstado(changeEstado);
        try{
            
            movilidadService.crearMovilidad(m);
            
        }catch(Exception ex){
            
            creaMensaje("se ha producido un error", FacesMessage.SEVERITY_ERROR);
            
        }
        
       // Mensaje mensaje=new Mensaje(usuario,m.getUsuario() , Calendar.getInstance().getTime(), "movilidad: "+changeEstado,"el coordinador ha modificado la movilidad", "no");
        //mensajeService.enviarMensaje(mensaje);
       
        Mensaje mensaje=new Mensaje(m.getUsuario() ,usuario, Calendar.getInstance().getTime(),"cambio de estado de movilidad","destino:"+m.getUniversidad().getNombre()+" \n"+"fecha de inicio:"+sdf.format(m.getFechaInicio())+" \n"+"fecha fin:"+sdf.format(m.getFechaFin())+"\n\n"+ "el estado de la movilidad ahora es: "+m.getEstado(), "no","no","no");
        try{
            
            mensajeService.enviarMensaje(mensaje);
        }catch(Exception ex){
            
            creaMensaje("se ha producido un error enviando el mensaje", FacesMessage.SEVERITY_ERROR);
        }
        creaMensaje("estado de una movilidad modificado, se ha enviado un mensaje", FacesMessage.SEVERITY_INFO);
        }
               
    }
    
    public void onRowCancel(){
        
        
    }

   
    
    public String crearMovilidad(){
   
        checkPais=false;
        //checkUni=false;
        
        Calendar cal1=Calendar.getInstance();
        Calendar cal2=Calendar.getInstance();
                cal1.setTime(fechaInicio);
                cal2.setTime(fechaFin);
                if (cal2.compareTo(cal1)<1){
                    
                    creaMensaje("la fecha de inicio es igual o posterior a la fecha de fin", FacesMessage.SEVERITY_ERROR);
                    return "";
                }
                
                Calendar calAux=Calendar.getInstance();
                calAux.setTime(fechaInicio);
                calAux.add(2, 3);
                if(cal2.compareTo(calAux)<0){
                    
                    creaMensaje("la duración mínima de una movilidad son 3 meses", FacesMessage.SEVERITY_ERROR);
                    return "";
                }
                calAux.setTime(fechaInicio);
                calAux.add(2, 12);
                if(cal2.compareTo(calAux)>0){
                    creaMensaje("la duración máxima es de un año", FacesMessage.SEVERITY_ERROR);
                    return "";
                }
                
                 ArrayList<Movilidad> aux;
                try{
                    
                   aux=(ArrayList < Movilidad >)movilidadService.listarMisMovilidades(usuario.getLogin());
                }catch(Exception ex){
                    
                    creaMensaje("se ha producido un error",FacesMessage.SEVERITY_ERROR);
                    return "";
                        }            
                    
                    int i=0;
                    Movilidad enCurso=null;
                    
                    if(aux.size()>0){
                    for(Movilidad mov:aux){
                        
                        if(mov.getEstado().equalsIgnoreCase("pendiente")){
                            
                            creaMensaje("hay una movilidad pendiente que debe ser aceptada por el coordinador o eliminada", FacesMessage.SEVERITY_ERROR);
                            return null;
                        
                        }
                        
                       if(mov.getEstado().equalsIgnoreCase("aceptada")){
                           i=i+1;
                           enCurso=mov;
                           if(i>1){
                               
                               creaMensaje("solo se puede tener dos convocatorias aceptadas como máximo", FacesMessage.SEVERITY_ERROR);
                               return "";
                           }
                           
                       }
                  
                    }     
                    
                       if(i==1){
                           
                            if( (fechaInicio.compareTo(enCurso.getFechaInicio())>-1 && fechaInicio.compareTo(enCurso.getFechaFin())<1)||(fechaFin.compareTo(enCurso.getFechaInicio())>-1  && fechaFin.compareTo(enCurso.getFechaFin())<1)||(fechaInicio.compareTo(enCurso.getFechaInicio())<1  && fechaFin.compareTo(enCurso.getFechaFin())>-1)){
                                //creaMensaje(Boolean.toString((fechaInicio.compareTo(enCurso.getFechaInicio())<1  && fechaFin.compareTo(enCurso.getFechaFin())<1)), FacesMessage.SEVERITY_INFO);
                                creaMensaje("las fechas se solapan con otra movilidad", FacesMessage.SEVERITY_ERROR);
                           return "";
                       }
                       }
                    }
                    Cursoacademico ca=new Cursoacademico();
                    
                    if(cal1.get(2)>8){
                       
                        ca.setCursoAcademico(cal1.get(1)+"/"+(cal1.get(1)+1));
                    }else{
                        
                        ca.setCursoAcademico(cal1.get(1)-1+"/"+(cal1.get(1)));
                    }
              universidadService.crearCursoAcademico(ca);
              String estado="pendiente";
              Universidad u=universidadService.findUniversidad(selectedUniversidad);
              
             
              Movilidad m=new Movilidad(ca,u, usuario, fechaInicio, fechaFin, estado,null);
              try{
              movilidadService.crearMovilidad(m);
                    
                }catch(Exception ex){
                    creaMensaje("se ha producido un error creando la movilidad", FacesMessage.SEVERITY_ERROR);
                    return "";
                }
               
                
                
                Mensaje mensaje=new Mensaje(usuarioService.find("admin"),usuario,  Calendar.getInstance().getTime(), "movilidad creada", "el usuario "+usuario.getNombre()+" "+usuario.getApellido1()+""
                        + " ha creado una movilidad a "+selectedUniversidad+" entre el "+sdf.format(fechaInicio)+" y "+sdf.format(fechaFin) , "no","no","no");
                try{
                    mensajeService.enviarMensaje(mensaje);
                }catch(Exception ex){
                    creaMensaje("error al enviar el mensaje", FacesMessage.SEVERITY_ERROR);
                }
                
                creaMensaje("movilidad creada", FacesMessage.SEVERITY_INFO);
                creaMensaje(usuario.getLogin()+" a "+ selectedUniversidad+" "+selectedPais+" "+" " + " de "+sdf.format(fechaInicio)+" a "+ sdf.format(fechaFin), FacesMessage.SEVERITY_INFO);
                selectedUniversidad="";
                selectedPais="";
                selectedUniversidad="";
                fechaFin=null;
                fechaInicio=null;
                ca.setCursoAcademico("");
                
                return "";
        
    }
    
    
    public String eliminarMovilidad(){
        
        if(selectedMovilidad.getEstado().equalsIgnoreCase("pendiente")){
            
            try{
            movilidadService.eliminarMovilidad(selectedMovilidad);
            }catch(Exception ex){
                
                creaMensaje("se ha producido un error eliminando la movilidad", FacesMessage.SEVERITY_ERROR);
                
            }
            
            creaMensaje("movilidad eliminada correctamente, se ha enviado un mensaje al coordinador ", FacesMessage.SEVERITY_INFO);
            
            Mensaje mensaje=new Mensaje(usuarioService.find("admin"),usuario,  Calendar.getInstance().getTime(), "movilidad eliminada", "el usuario "+usuario.getLogin()+" ha eliminado una movilidad", "no","no","no");
            try{
                mensajeService.enviarMensaje(mensaje);
            }catch(Exception ex){
                creaMensaje("se ha producido un error enviando el mensaje", FacesMessage.SEVERITY_ERROR);
                return "";
            }
            
            
        }else
         
            if(selectedMovilidad.getEstado().equalsIgnoreCase("aceptada")){
                
                
                Mensaje mensaje=new Mensaje( usuarioService.find("admin"),usuario, Calendar.getInstance().getTime(), "movilidad eliminada", "el usuario "+usuario.getLogin()+" quiere cancelar una movilidad en curso en: "+selectedMovilidad.getUniversidad().getNombre()+" con fecha de inicio:"+ sdf.format(selectedMovilidad.getFechaInicio())+" y fecha fin:"+sdf.format(selectedMovilidad.getFechaFin()), "no","no","no");
            try{
                mensajeService.enviarMensaje(mensaje);
            }catch(Exception ex){
                creaMensaje("se ha producido un error enviando el mensaje", FacesMessage.SEVERITY_ERROR);
                    
            }
                creaMensaje("se ha enviado un mensaje al coordinador para su cancelación", FacesMessage.SEVERITY_INFO);
            return "";
        
             
        }else
                if(selectedMovilidad.getEstado().equalsIgnoreCase("rechazada")){
                    
                     try{
            movilidadService.eliminarMovilidad(selectedMovilidad);
            }catch(Exception ex){
                
                creaMensaje("se ha producido un error eliminando la movilidad", FacesMessage.SEVERITY_ERROR);
                return null;
            }
                  actualizar();
                  return null;  
                }
            
        
        return null;
        
    }
    
        
    public String eliminaMovilidadLista(){
        
        for(Movilidad m:selectedMovilidades){
        
        try{
            
            movilidadService.eliminarMovilidad(m);
            
        }catch(Exception ex){
            
            creaMensaje("se ha producido un error eliminando la movilidad", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        }
        
        actualizarTodasMovilidades();
        creaMensaje("movilidad eliminada correctamente", FacesMessage.SEVERITY_INFO);
        return null;
        
    }
    

    
    public void actualizar(){
        
        listaMisMovilidades=(ArrayList < Movilidad >)movilidadService.listarMisMovilidades(usuario.getLogin());
    }
    
    public void actualizarTodasMovilidades(){
        
        listaMovilidades=(ArrayList<Movilidad>)movilidadService.listarTodasMovilidades();
        
    }
    
    public void activaTexto(){
        
        if(selectedMovilidades.isEmpty()==false){
        activaTexto=true;
    }else{
            creaMensaje("hay que seleccionar al menos un usuario", FacesMessage.SEVERITY_ERROR);
        }
    }
    
    
    public String enviarMensajesVarios(){
    if(selectedMovilidades.isEmpty()){
        return "";
    }
    for(Movilidad m:selectedMovilidades){
        Mensaje mensaje=new Mensaje(m.getUsuario(),usuario,  Calendar.getInstance().getTime(), tema, texto, "no", "no", "no");
        try{
        mensajeService.enviarMensaje(mensaje);
        }catch(Exception ex){
            
            creaMensaje("error al enviar mensajes", FacesMessage.SEVERITY_ERROR);
            return "";
        }
    }
        creaMensaje("mensajes enviados correctamente", FacesMessage.SEVERITY_INFO);
        activaTexto=false;
        tema="";
        texto="";
        selectedMovilidades=null;
        
    return "";
}
    
    public void cancelar(){
        
        activaTexto=false;
    }
    
    
    public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
    
    
    
    
    
    }
    
