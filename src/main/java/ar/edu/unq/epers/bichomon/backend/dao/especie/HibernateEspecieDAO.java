package ar.edu.unq.epers.bichomon.backend.dao.especie;
import ar.edu.unq.epers.bichomon.backend.dao.HibernateDAO;
import ar.edu.unq.epers.bichomon.backend.dao.exceptions.NombreEspecieExistente;
import ar.edu.unq.epers.bichomon.backend.model.especie.Especie;
import ar.edu.unq.epers.bichomon.backend.service.runner.TransactionRunner;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class HibernateEspecieDAO extends HibernateDAO<Especie> implements EspecieDAO {
    public HibernateEspecieDAO() {
        super(Especie.class);
    }

    public Especie recuperar(String nombre){
        return  TransactionRunner.getCurrentSession()
                .createQuery("from Especie where nombre = :nombre ", Especie.class)
                .setParameter("nombre", nombre)
                .getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void guardar(Especie item){
        try {
            super.guardar(item);
        }
        catch (ConstraintViolationException e){
            throw new NombreEspecieExistente(item.getNombre());
        }
    }

    @Override
    protected void setOrdering(CriteriaQuery<Especie> cq, CriteriaBuilder cb, Root<Especie> root) {
        cq.orderBy(cb.asc(root.get("nombre")));
    }

    @Override
    protected String getAllQueryString(){
        return "from Especie order by nombre";
    }
}