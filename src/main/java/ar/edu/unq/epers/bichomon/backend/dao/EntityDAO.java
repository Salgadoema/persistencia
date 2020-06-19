package ar.edu.unq.epers.bichomon.backend.dao;

import java.util.List;

public interface EntityDAO<T> {
    void guardar(T entity);

    void actualizar(T entity);

    T recuperar(Long entityId);

    List<T> recuperarTodos();

    void borrarTodos();
}
