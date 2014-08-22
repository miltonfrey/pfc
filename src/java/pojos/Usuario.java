package pojos;
// Generated 20-ago-2014 18:45:29 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,catalog="pfc"
)
public class Usuario  implements java.io.Serializable {


     private String login;
     private String password;
     private short tipoUsuario;
     private String titulacion;
     private String nombre;
     private String apellido1;
     private String apellido2;
     private Set<Mensaje> mensajesForDestino = new HashSet<Mensaje>(0);
     private Set<Movilidad> movilidads = new HashSet<Movilidad>(0);
     private Set<Mensaje> mensajesForOrigen = new HashSet<Mensaje>(0);

    public Usuario() {
    }

	
    public Usuario(String login, String password, short tipoUsuario, String titulacion, String nombre, String apellido1) {
        this.login = login;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.titulacion = titulacion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
    }
    public Usuario(String login, String password, short tipoUsuario, String titulacion, String nombre, String apellido1, String apellido2, Set<Mensaje> mensajesForDestino, Set<Movilidad> movilidads, Set<Mensaje> mensajesForOrigen) {
       this.login = login;
       this.password = password;
       this.tipoUsuario = tipoUsuario;
       this.titulacion = titulacion;
       this.nombre = nombre;
       this.apellido1 = apellido1;
       this.apellido2 = apellido2;
       this.mensajesForDestino = mensajesForDestino;
       this.movilidads = movilidads;
       this.mensajesForOrigen = mensajesForOrigen;
    }
   
     @Id 

    
    @Column(name="login", unique=true, nullable=false, length=20)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="password", nullable=false, length=40)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="tipo_usuario", nullable=false)
    public short getTipoUsuario() {
        return this.tipoUsuario;
    }
    
    public void setTipoUsuario(short tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    
    @Column(name="titulacion", nullable=false, length=25)
    public String getTitulacion() {
        return this.titulacion;
    }
    
    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido1", nullable=false, length=45)
    public String getApellido1() {
        return this.apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    
    @Column(name="apellido2", length=45)
    public String getApellido2() {
        return this.apellido2;
    }
    
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuarioByDestino")
    public Set<Mensaje> getMensajesForDestino() {
        return this.mensajesForDestino;
    }
    
    public void setMensajesForDestino(Set<Mensaje> mensajesForDestino) {
        this.mensajesForDestino = mensajesForDestino;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set<Movilidad> getMovilidads() {
        return this.movilidads;
    }
    
    public void setMovilidads(Set<Movilidad> movilidads) {
        this.movilidads = movilidads;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuarioByOrigen")
    public Set<Mensaje> getMensajesForOrigen() {
        return this.mensajesForOrigen;
    }
    
    public void setMensajesForOrigen(Set<Mensaje> mensajesForOrigen) {
        this.mensajesForOrigen = mensajesForOrigen;
    }




}


