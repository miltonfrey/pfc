package pojos;
// Generated 22-oct-2014 10:55:47 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Estado generated by hbm2java
 */
@Entity
@Table(name="estado"
    ,catalog="pfc2"
)
public class Estado  implements java.io.Serializable {


     private String estado;

    public Estado() {
    }

    public Estado(String estado) {
       this.estado = estado;
    }
   
     @Id 

    
    @Column(name="estado", unique=true, nullable=false, length=15)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


