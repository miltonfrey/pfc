package pojos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author cba
 */
public interface UniversidadService {
    
    
    public List<Pais>listaPaises();
    public List<Universidad>listaUniversidades();
    public Pais findPais(String pais);
    
    
    
    public void insertarPais(String pais);
    public void deletePais(Pais p);
    public List<Universidad> listar();
    public void delete(Universidad u);
    
    public void insertarUniversidad(Universidad u);
    public void actualizar(Universidad u);
    public List<Universidad> listarPorUniversidad(String universidad);
    public List<Universidad> listarPorPais(String pais);
    public List<String> listarPorUniversidadStr(String universidad);
    public List<String> listarPorPaisStr(String pais);
    public void crearCursoAcademico(Cursoacademico cursoAcademico);
    public void eliminarCursoAcademico(String c);
    public List<Cursoacademico> listaCursosAcademicos();
    public Universidad findUniversidad(String universidad);
    public Cursoacademico buscarCursoAcademico(Date fechaInicio,Date fechaFin);
}
