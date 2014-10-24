

package pojos;

import java.util.List;


public interface EquivalenciaService {
    
    
    public void crearEquivalencia(Equivalencia e);
    public void eliminarEquivalencia(Equivalencia e);
    public void actualizarEquivalencia(Equivalencia e);
    public List<Equivalencia> listarEquivalencias();
    
    public List<Equivalencia> listarEquivalenciasPorContrato(Integer id);
    public void crearGrupoAsignaturasA(GrupoAsignaturaA grupo);
     public void crearGrupoAsignaturasB(GrupoAsignaturaB grupo);
    //public void crearMiembroGrupoAsignatura(MiembroGrupoAsignatura m);
       
    
    public void creaContrato(Contrato c);
    public void modificaContrato(Contrato c);
    public List<Contrato> listaContratos(Movilidad m);
    public void eliminaContrato(Contrato c);
    public Contrato findContrato(Integer id);
   public List<Equivalencia> equivalenciasPublicas(String universidad);
   public List<Object[]> listaObject();
}


