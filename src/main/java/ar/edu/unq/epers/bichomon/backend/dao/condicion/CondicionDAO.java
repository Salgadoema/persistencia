package ar.edu.unq.epers.bichomon.backend.dao.condicion;

import ar.edu.unq.epers.bichomon.backend.model.condicion.Condicion;

import java.util.List;

public interface CondicionDAO {
    void guardar(Condicion condicion);

    void actualizar(Condicion condicion);

    List<Condicion> recuperarTodos();

    void borrarTodos();
}
