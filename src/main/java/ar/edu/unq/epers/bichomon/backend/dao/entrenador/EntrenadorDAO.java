package ar.edu.unq.epers.bichomon.backend.dao.entrenador;

import ar.edu.unq.epers.bichomon.backend.dao.EntityDAO;
import ar.edu.unq.epers.bichomon.backend.model.Entrenador;

public interface EntrenadorDAO extends EntityDAO<Entrenador> {
    Entrenador recuperar(String nombreEntrenador);
}
