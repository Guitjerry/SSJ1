package com.csair.service.Impl;
import com.csair.entity.Category;
import com.csair.entity.CategoryChildren;
import com.csair.entity.CategoryVo;
import com.csair.repository.CategoryChildrenRepository;
import com.csair.repository.CategoryRepository;
import com.csair.service.CategoryService;
import com.csair.util.JPAUtils;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dnys on 2016/11/16.
 */
@Transactional
@Service(value = "categoryService")

public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryChildrenRepository categoryChildrenRepository;

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryChildrenRepository getCategoryChildrenRepository() {
        return categoryChildrenRepository;
    }

    public void setCategoryChildrenRepository(CategoryChildrenRepository categoryChildrenRepository) {
        this.categoryChildrenRepository = categoryChildrenRepository;
    }

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
    @Modifying@Transactional
    @Override
    public void updateCategory(Category category) {
        try {
            Query query = em.createQuery("update Category set name=?1,sort=?2 where id="+category.getId());
            query.setParameter(1,category.getName());
            query.setParameter(2,category.getSort());
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategoryById(int id) {
        categoryRepository.delete(id);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategoryChildren(CategoryChildren categoryChildren) {
        categoryChildrenRepository.save(categoryChildren);
    }

    @Override
    public List<CategoryVo> findAllCategoryAndChildren() {

       List<CategoryVo> categoryVos =  em.createQuery("select new com.csair.entity.CategoryVo(b.id as categorychildrenid,a.id as categoryid ,a.name as categoryname,b.name as categorychildrenname ) from Category a, CategoryChildren b where a.id=b.categoryid").getResultList();
        return categoryVos;
    }

    @Override
    public List<CategoryChildren> findAllCategoryChildrenByid(int id) {
        List<CategoryChildren> categoryChildrens = em.createQuery("select b  from Category a, CategoryChildren b where a.id=b.categoryid and a.id="+id).getResultList();
        return categoryChildrens;
    }


}
