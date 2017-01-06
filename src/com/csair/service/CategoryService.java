package com.csair.service;

import com.csair.entity.Category;
import com.csair.entity.CategoryChildren;
import com.csair.entity.CategoryVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dnys on 2016/11/16.
 */
public interface CategoryService {
    //保存类目
    public void saveCategory(Category category);

    /**
     * 更新类目
     * @param category
     */
    public void updateCategory(Category category);
    //根据Id删除某个类目
    public void deleteCategoryById(int id);
    //根据id查找出类目
    public Category getCategoryById(int id);
    //查找所有类目
    public List<Category> findAll();

    /**
     * 保存子类别
     * @param categoryChildren
     */
    public void saveCategoryChildren(CategoryChildren categoryChildren);

    /**
     * 查找类目及子类目
     * @return
     */
    public  List<CategoryVo> findAllCategoryAndChildren();

    /**
     * 根据主类查找所有子类
     * @return
     */
    public List<CategoryChildren> findAllCategoryChildrenByid(int id);

}
