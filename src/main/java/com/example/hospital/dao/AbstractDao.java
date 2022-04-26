package com.example.hospital.dao;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDao<C extends Serializable, Id extends Serializable>
    implements GenericRepository<C, Id> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected final Class<C> entityClass;

    //Genera un waring
    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.entityClass = (Class<C>) ((ParameterizedType)
                this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void save(C entity) {
        entityManager.persist(entity);
        flushAndClear();
    }

    @Override
    public void update(C entity) {
        entityManager.merge(entity);
        flushAndClear();
    }

    @Override
    public void delete(C entity) {
        // If entity is not manageg by the persistence context then it can't be removed from database
        // So, it must be checked and then removed
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        flushAndClear();
    }

    @Override
    public C findById(Id id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public void deleteById(Id id) {
        C entity = findById(id);
        delete(entity);
    }

    private void flushAndClear() {
        // Flush : Synchronize the persistence context to the underlying database.
        // Clear : Clear the persistence context, causing all managed entities to become detached.
        //         Changes made to entities that have not been flushed to the database will not be persisted.
        entityManager.flush();
        entityManager.clear();
    }

    @Override
    public List<C> getAll(){
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<C> query = builder.createQuery(this.entityClass);

        return this.entityManager.createQuery(
                query.select(query.from(this.entityClass))).getResultList();
    }
}
