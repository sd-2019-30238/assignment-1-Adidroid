package PersistenceLayer.impl;

import PersistenceLayer.CRUD;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public class AbstractDAO<T> implements CRUD<T> {

    protected SessionFactory sessionFactory = null;
    private Class<T> clazz;


    public AbstractDAO() {

    }

    public AbstractDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }


    @Override

    public T get(int id) {
        beginTransaction();
        T entity= sessionFactory.getCurrentSession().get(clazz, id);
        commitTransaction();
        return entity;

    }

    @Override

    @SuppressWarnings("unchecked")
    public List<T> getAll() {

        beginTransaction();
        List list= sessionFactory.getCurrentSession().createQuery("from " + clazz.getName()).getResultList();
        commitTransaction();
        return list;

    }

    @Override

    public void save(T entity) {
        beginTransaction();
        sessionFactory.getCurrentSession().save(entity);
        commitTransaction();

    }

    @Override

    public void update(T entity) {
        sessionFactory.getCurrentSession().merge(entity);

    }

    @Override

    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    private void beginTransaction(){
        sessionFactory.getCurrentSession().beginTransaction();
    }

    private void commitTransaction(){
        sessionFactory.getCurrentSession().getTransaction().commit();
    }


}