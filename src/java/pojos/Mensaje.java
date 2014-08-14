package pojos;
// Generated 11-ago-2014 23:00:43 by Hibernate Tools 3.6.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Mensaje generated by hbm2java
 */
@Entity
@Table(name="mensaje"
    ,catalog="pfc"
)
public class Mensaje  implements java.io.Serializable {


     private Integer idmensaje;
     private Usuario usuarioByOrigen;
     private Usuario usuarioByDestino;
     private Date fecha;
     private String tema;
     private String texto;
     private String leidoDestino;
     private String eliminadoOrigen;
     private String eliminadoDestino;

    public Mensaje() {
    }

    public Mensaje(Usuario usuarioByOrigen, Usuario usuarioByDestino, Date fecha, String tema, String texto, String leidoDestino, String eliminadoOrigen, String eliminadoDestino) {
       this.usuarioByOrigen = usuarioByOrigen;
       this.usuarioByDestino = usuarioByDestino;
       this.fecha = fecha;
       this.tema = tema;
       this.texto = texto;
       this.leidoDestino = leidoDestino;
       this.eliminadoOrigen = eliminadoOrigen;
       this.eliminadoDestino = eliminadoDestino;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idmensaje", unique=true, nullable=false)
    public Integer getIdmensaje() {
        return this.idmensaje;
    }
    
    public void setIdmensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="origen", nullable=false)
    public Usuario getUsuarioByOrigen() {
        return this.usuarioByOrigen;
    }
    
    public void setUsuarioByOrigen(Usuario usuarioByOrigen) {
        this.usuarioByOrigen = usuarioByOrigen;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="destino", nullable=false)
    public Usuario getUsuarioByDestino() {
        return this.usuarioByDestino;
    }
    
    public void setUsuarioByDestino(Usuario usuarioByDestino) {
        this.usuarioByDestino = usuarioByDestino;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=false, length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="tema", nullable=false, length=16777215)
    public String getTema() {
        return this.tema;
    }
    
    public void setTema(String tema) {
        this.tema = tema;
    }

    
    @Column(name="texto", nullable=false)
    public String getTexto() {
        return this.texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }

    
    @Column(name="leidoDestino", nullable=false, length=2)
    public String getLeidoDestino() {
        return this.leidoDestino;
    }
    
    public void setLeidoDestino(String leidoDestino) {
        this.leidoDestino = leidoDestino;
    }

    
    @Column(name="eliminadoOrigen", nullable=false, length=2)
    public String getEliminadoOrigen() {
        return this.eliminadoOrigen;
    }
    
    public void setEliminadoOrigen(String eliminadoOrigen) {
        this.eliminadoOrigen = eliminadoOrigen;
    }

    
    @Column(name="eliminadoDestino", nullable=false, length=2)
    public String getEliminadoDestino() {
        return this.eliminadoDestino;
    }
    
    public void setEliminadoDestino(String eliminadoDestino) {
        this.eliminadoDestino = eliminadoDestino;
    }




}


