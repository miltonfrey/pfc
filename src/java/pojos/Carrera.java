package pojos;
// Generated 14-jul-2014 17:58:38 by Hibernate Tools 3.6.0


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Carrera generated by hbm2java
 */
@Entity
@Table(name="carrera"
    ,catalog="pfc"
)
public class Carrera  implements java.io.Serializable {


     private CarreraId id;
     private String pais;
     private String info;
     private String web;

    public Carrera() {
    }

	
    public Carrera(CarreraId id, String pais) {
        this.id = id;
        this.pais = pais;
    }
    public Carrera(CarreraId id, String pais, String info, String web) {
       this.id = id;
       this.pais = pais;
       this.info = info;
       this.web = web;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="nombre", column=@Column(name="nombre", nullable=false, length=40) ), 
        @AttributeOverride(name="universidad", column=@Column(name="universidad", nullable=false, length=45) ) } )
    public CarreraId getId() {
        return this.id;
    }
    
    public void setId(CarreraId id) {
        this.id = id;
    }

    
    @Column(name="pais", nullable=false, length=15)
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }

    
    @Column(name="info")
    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }

    
    @Column(name="web", length=45)
    public String getWeb() {
        return this.web;
    }
    
    public void setWeb(String web) {
        this.web = web;
    }




}

