package vn.cusc.aptech.cuscshop.coresystem.ejb.facade;

import java.util.List;
import javax.ejb.Local;
import vn.cusc.aptech.cuscshop.coresystem.ejb.entity.CategoryGroup;

@Local
public interface CategoryGroupFacadeLocal {

    void create(CategoryGroup categoryGroup);

    void edit(CategoryGroup categoryGroup);

    void remove(CategoryGroup categoryGroup);

    CategoryGroup find(Object id);

    List<CategoryGroup> findAll();

    List<CategoryGroup> findRange(int[] range);

    int count();
    
}
