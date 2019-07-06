
package edu.blog.models.services;

import edu.blog.models.core.AbstractService;
import edu.blog.models.models.Publication;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class PublicationService extends AbstractService<Publication>{
    
    @PersistenceContext(unitName = "Blog-PU")
    EntityManager em;

    public PublicationService(){
        super(Publication.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Publication find(long id) {
        try{
           return em.createNamedQuery("find-publication-by-id",
                                Publication.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        
    }
    
    
}
