package pojos;
// Generated 22-oct-2014 11:54:10 by Hibernate Tools 4.3.1


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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Contrato generated by hbm2java
 */
@Entity
@Table(name="contrato"
    ,catalog="pfc2"
)
public class Contrato  implements java.io.Serializable {


     private Integer idContrato;
     private Movilidad movilidad;
     private Date fecha;
     private String estado;
     private Set<Equivalencia> equivalencias = new HashSet<Equivalencia>(0);

    public Contrato() {
    }

    public Contrato(Movilidad movilidad, Date fecha, String estado, Set<Equivalencia> equivalencias) {
       this.movilidad = movilidad;
       this.fecha = fecha;
       this.estado = estado;
       this.equivalencias = equivalencias;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idContrato", unique=true, nullable=false)
    public Integer getIdContrato() {
        return this.idContrato;
    }
    
    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idMovilidad")
    public Movilidad getMovilidad() {
        return this.movilidad;
    }
    
    public void setMovilidad(Movilidad movilidad) {
        this.movilidad = movilidad;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="estado", length=10)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="contrato-equivalencia", catalog="pfc2", joinColumns = { 
        @JoinColumn(name="idContrato", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="idEquivalencia", nullable=false, updatable=false) })
    public Set<Equivalencia> getEquivalencias() {
        return this.equivalencias;
    }
    
    public void setEquivalencias(Set<Equivalencia> equivalencias) {
        this.equivalencias = equivalencias;
    }




}


