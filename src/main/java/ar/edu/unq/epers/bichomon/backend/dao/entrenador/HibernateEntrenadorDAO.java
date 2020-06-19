package ar.edu.unq.epers.bichomon.backend.dao.entrenador;

import ar.edu.unq.epers.bichomon.backend.dao.HibernateDAO;
import ar.edu.unq.epers.bichomon.backend.model.Entrenador;
import ar.edu.unq.epers.bichomon.backend.service.runner.TransactionRunner;

public class HibernateEntrenadorDAO extends HibernateDAO<Entrenador> implements EntrenadorDAO{
    public HibernateEntrenadorDAO() {
        super(Entrenador.class);
    }

    @Override
    public Entrenador recuperar(String nombre) {
        return  TransactionRunner.getCurrentSession()
                .createQuery("from Entrenador where nombre = :nombre ", Entrenador.class)
                .setParameter("nombre", nombre)
                .getResultList().stream().findFirst().orElse(null);
    }
}
