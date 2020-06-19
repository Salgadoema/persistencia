package ar.edu.unq.epers.bichomon.backend.dao.evolucion;

import ar.edu.unq.epers.bichomon.backend.dao.HibernateDAO;
import ar.edu.unq.epers.bichomon.backend.model.Evolucion;

public class HibernateEvolucionDAO extends HibernateDAO<Evolucion> implements EvolucionDAO {

    public HibernateEvolucionDAO() {
        super(Evolucion.class);
    }
}
