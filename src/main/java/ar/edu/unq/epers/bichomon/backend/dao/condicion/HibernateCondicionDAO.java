package ar.edu.unq.epers.bichomon.backend.dao.condicion;

import ar.edu.unq.epers.bichomon.backend.dao.HibernateDAO;
import ar.edu.unq.epers.bichomon.backend.model.condicion.Condicion;

public class HibernateCondicionDAO extends HibernateDAO<Condicion> implements CondicionDAO {
    public HibernateCondicionDAO() {
        super(Condicion.class);
    }
}
