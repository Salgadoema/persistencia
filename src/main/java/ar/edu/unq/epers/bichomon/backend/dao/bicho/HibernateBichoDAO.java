package ar.edu.unq.epers.bichomon.backend.dao.bicho;

import ar.edu.unq.epers.bichomon.backend.dao.HibernateDAO;
import ar.edu.unq.epers.bichomon.backend.model.bicho.Bicho;

public class HibernateBichoDAO extends HibernateDAO<Bicho> implements BichoDAO {
    public HibernateBichoDAO() {
        super(Bicho.class);
    }
}
