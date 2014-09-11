package pojos;
// Generated 11-sep-2014 19:42:43 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Movilidad generated by hbm2java
 */
@Entity
@Table(name="movilidad"
    ,catalog="pfc"
)
public class Movilidad  implements java.io.Serializable {


     private Integer codMovilidad;
     private Usuario usuario;
     private Universidad universidad;
     private Cursoacademico cursoacademico;
     private Date fechaInicio;
     private Date fechaFin;
     private String estado;
     private Set<Contrato> contratos = new HashSet<Contrato>(0);

    public Movilidad() {
    }

	
    public Movilidad(Usuario usuario, Universidad universidad, Date fechaInicio, Date fechaFin, String estado) {
        this.usuario = usuario;
        this.universidad = universidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }
    public Movilidad(Usuario usuario, Universidad universidad, Cursoacademico cursoacademico, Date fechaInicio, Date fechaFin, String estado, Set<Contrato> contratos) {
       this.usuario = usuario;
       this.universidad = universidad;
       this.cursoacademico = cursoacademico;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.estado = estado;
       this.contratos = contratos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="codMovilidad", unique=true, nullable=false)
    public Integer getCodMovilidad() {
        return this.codMovilidad;
    }
    
    public void setCodMovilidad(Integer codMovilidad) {
        this.codMovilidad = codMovilidad;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="loginUsuario", nullable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nombreUniversidad", nullable=false)
    public Universidad getUniversidad() {
        return this.universidad;
    }
    
    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cursoAcademico")
    public Cursoacademico getCursoacademico() {
        return this.cursoacademico;
    }
    
    public void setCursoacademico(Cursoacademico cursoacademico) {
        this.cursoacademico = cursoacademico;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaInicio", nullable=false, length=19)
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaFin", nullable=false, length=19)
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    
    @Column(name="estado", nullable=false, length=10)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="movilidad")
    public Set<Contrato> getContratos() {
        return this.contratos;
    }
    
    public void setContratos(Set<Contrato> contratos) {
        this.contratos = contratos;
    }




}


