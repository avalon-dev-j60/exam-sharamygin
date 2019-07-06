
package edu.blog.models.core;

import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractService<E> implements CRUD<E>{
 
    private final Class<E> cls;

    public AbstractService(Class<E> cls) {
        this.cls = cls;
    }

    protected abstract EntityManager getEntityManager();
    
    @Override
    public void delete(E entity){
    getEntityManager().detach(entity);
}

    @Override
    public void update(E entity){
    getEntityManager().merge(entity);
}

    @Override
    public void create(E entity){
    getEntityManager().persist(entity);
    /*
    EntityManager em = getEntityManager(); 
    em.persist(entity);
    em.joinTransaction()
    em.flush();
    */
}
    
    //поиск всех
    public List<E> list(){
        try{
        EntityManager em = getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<E> query = builder.createQuery(cls);
        Root<E> root = query.from(cls);
        query.select(root);
        return em.createQuery(query).getResultList();
    } catch (NoResultException e) {
        return Collections.emptyList();
    }
    }
}


