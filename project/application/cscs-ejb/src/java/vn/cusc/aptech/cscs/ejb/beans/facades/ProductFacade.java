/*
 * The MIT License
 *
 * Copyright 2021 Daomtthuan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package vn.cusc.aptech.cscs.ejb.beans.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import vn.cusc.aptech.cscs.ejb.entities.Brand;
import vn.cusc.aptech.cscs.ejb.entities.Category;
import vn.cusc.aptech.cscs.ejb.entities.CategoryGroup;
import vn.cusc.aptech.cscs.ejb.entities.Product;

/**
 *
 * @author Daomtthuan
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {

  @PersistenceContext(unitName = "cscs-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public ProductFacade() {
    super(Product.class);
  }

  @Override
  public List<Product> findByFilter(Object idBrand, Object idCategoryGroup, Object idCategory) {
    List<Product> products = em.createQuery("SELECT p FROM Product p WHERE (p.brand = :brand OR :idBrand = 0) AND (p.category.categoryGroup = :categoryGroup OR :idCategoryGroup = 0) AND (p.category = :category OR :idCategory = 0)")
      .setParameter("idBrand", idBrand)
      .setParameter("brand", em.find(Brand.class, idBrand))
      .setParameter("idCategoryGroup", idCategoryGroup)
      .setParameter("categoryGroup", em.find(CategoryGroup.class, idCategoryGroup))
      .setParameter("idCategory", idCategory)
      .setParameter("category", em.find(Category.class, idCategory))
      .getResultList();
    return products;
  }

}
