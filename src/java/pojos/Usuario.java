package pojos;
// Generated 08-jul-2014 10:38:30 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,catalog="pfc"
    , uniqueConstraints = @UniqueConstraint(columnNames="email") 
)
public class Usuario  implements java.io.Serializable {


     private String login;
     private String password;
     private short tipoUsuario;
     private String email;
     private String titulacion;
     private Set<Contrato> contratos = new HashSet<Contrato>(0);

    public Usuario() {
    }

	
    public Usuario(String login, String password, short tipoUsuario, String email, String titulacion) {
        this.login = login;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.titulacion = titulacion;
    }
    public Usuario(String login, String password, short tipoUsuario, String email, String titulacion, Set<Contrato> contratos) {
       this.login = login;
       this.password = password;
       this.tipoUsuario = tipoUsuario;
       this.email = email;
       this.titulacion = titulacion;
       this.contratos = contratos;
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

    
    @Column(name="email", unique=true, nullable=false, length=30)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="titulacion", nullable=false, length=25)
    public String getTitulacion() {
        return this.titulacion;
    }
    
    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set<Contrato> getContratos() {
        return this.contratos;
    }
    
    public void setContratos(Set<Contrato> contratos) {
        this.contratos = contratos;
    }




}


