package ar.edu.unq.epers.bichomon.backend.dao;

import ar.edu.unq.epers.bichomon.backend.service.runner.TransactionRunner;
import org.hibernate.Session;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HibernateDAO<T> {

    private Class<T> entityType;

    public HibernateDAO(Class<T> entityType){
        this.entityType = entityType;
    }

    public void guardar(T item) {
        Session session = TransactionRunner.getCurrentSession();
        session.save(item);
    }

    public T recuperar(Long id) {
        Session session = TransactionRunner.getCurrentSession();
        return session.get(entityType, id);
    }

    public List<T> recuperarTodos(){
        Session session = TransactionRunner.getCurrentSession();
        return session.createQuery(getAllQueryString(), entityType).getResultList();
    }

    protected String getAllQueryString() {
        throw new NotImplementedException();
    }

    protected void setOrdering(CriteriaQuery<T> cq, CriteriaBuilder cb, Root<T> root) {

    }

    public void actualizar(T item){
        Session session = TransactionRunner.getCurrentSession();
        session.update(item);
    }

    public void borrar(T item){
        Session session = TransactionRunner.getCurrentSession();
        session.delete(item);
    }

    public void borrarTodos(){
        Session session = TransactionRunner.getCurrentSession();
        session.createQuery(session.getCriteriaBuilder().createQuery(entityType));
    }
}
