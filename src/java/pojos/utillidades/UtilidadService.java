
package pojos.utillidades;

import java.util.List;
import pojos.Cursoacademico;
import pojos.Estado;
import pojos.EstadoMovilidad;

public interface UtilidadService {
    
    public void crearEstado(Estado e);
    public List<Estado> listaEstados();
    public void eliminaEstado(Estado e);
    
    public void crearEstadoMovilidad(EstadoMovilidad e);
    public List<EstadoMovilidad> listaEstadosMovilidad();
    public void eliminaEstadoMovilidad(EstadoMovilidad e);
    
    public void crearCursoAcademico(Cursoacademico c);
    public List<Cursoacademico> listaCursoAcademico();
    public void eliminaCursoAcademico(Cursoacademico c);
    
}
