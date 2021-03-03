package vn.cusc.aptech.cuscshop.coresystem.ejb.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import vn.cusc.aptech.cuscshop.coresystem.ejb.entities.CategoryGroup;

@Stateless
public class CategoryGroupFacade extends AbstractFacade<CategoryGroup> implements CategoryGroupFacadeLocal {

    @PersistenceContext(unitName = "core-system-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryGroupFacade() {
        super(CategoryGroup.class);
    }
    
}
