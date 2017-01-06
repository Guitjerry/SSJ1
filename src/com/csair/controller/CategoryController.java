package com.csair.controller;

import com.csair.entity.Category;
import com.csair.entity.CategoryChildren;
import com.csair.entity.CategoryVo;
import com.csair.service.CategoryService;
import com.csair.service.UserService;
import com.csair.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by dnys on 2016/11/16.
 */
//@Controller
//@RequestMapping(value="/category")
//public class CategoryController {
//    @Autowired
//    private CategoryService categoryService;
//    @RequestMapping(name="/test")
//    public ModelAndView test(ModelAndView modelView){
//        Category category = new Category();
//        category.setName("jack");
//        category.setSort(1);
//        category.setStatus("1");
//        categoryService.saveCategory(category);
//        return new ModelAndView("login","category",category);
//    }
//}
@Controller
@RequestMapping(value="/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * 类目列表
     * @param request
     * @param msg
     * @return
     */
    @RequestMapping(value="/list")
    public String list(HttpServletRequest request,String msg){
        List<Category> categories =  categoryService.findAll();
        List<CategoryVo> categoryVoList = categoryService.findAllCategoryAndChildren();

        if(categories.size()>0){
            request.setAttribute("categories",categories);
            request.setAttribute("categoryVoList",categoryVoList);
        }
        tip(request,msg);
        return "category/category";
    }

    /**
     * 保存类目
     * @param request
     * @param category
     * @param response
     */
    @RequestMapping(value = "updateCategory")
    public void updateCategory(HttpServletRequest request,Category category,HttpServletResponse response){
        Category simcategory = null;
        if(category!=null){
           simcategory = categoryService.getCategoryById(category.getId());
            simcategory.setName(category.getName());
            simcategory.setSort(category.getSort());

        }
       if(simcategory!=null){
           categoryService.updateCategory(simcategory);
           try {
               JsonUtilTemp.returnSucessJson(response,"更新成功");
           } catch (Exception e) {
               e.printStackTrace();
           }
       }


    }

    /**
     * 添加分类
     * @param request
     * @param response
     */
    @RequestMapping(value = "/addCategory")
    public void addCategory(HttpServletRequest request,Category category,HttpServletResponse response){
        if(category!=null){
            category.setStatus(1);
            categoryService.saveCategory(category);

        }
        if(category.getId()!=null&&category.getId()>0){
            try {
                JsonUtilTemp.returnSucessJson(response,"添加成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 列出类目下的子类目
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/listCategoryChildren")
    public String listCategoryChildren(HttpServletRequest request,int id){
        List<CategoryChildren> categoryChildrens = categoryService.findAllCategoryChildrenByid(id);
        if(categoryChildrens!=null&&categoryChildrens.size()>0){
            request.setAttribute("categoryChildrens",categoryChildrens);
        }
        return  "categorychildren";
    }

    /***
     * 打开子类目页面
     * @param request
     * @param response
     *
     */
    @RequestMapping(value = "/addCategoryChildren")
    public String  addCategoryChildren(HttpServletRequest request, HttpServletResponse response,String categoryid){
        request.setAttribute("categoryid",categoryid);
        return "category/addCategoryChildren";
    }

    /**
     * 添加子类目到数据库
     * @param request
     * @param response
     * @param categoryChildren
     */
    @RequestMapping(value = "/addSureCategoryChildren")
    public  void addSureCategoryChildren(HttpServletRequest request, HttpServletResponse response, CategoryChildren categoryChildren){
        if(categoryChildren!=null){
            categoryChildren.setStatus(1);
            categoryService.saveCategoryChildren(categoryChildren);
        }
        if(categoryChildren.getId()>0){
            try {
                JsonUtilTemp.returnSucessJson(response,"添加子类目成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据id查找类目
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("editCategoryById")
    public String categoryById(HttpServletRequest request,Integer id){
        if(id!=null&&id>0){
            Category category = categoryService.getCategoryById(id);
            request.setAttribute("category",category);
        }
        return "category/editCategory";
    }



    /**
     * 前端标记方法
     * @param request
     * @param msg
     */
    public void tip(HttpServletRequest request,String msg){
        request.setAttribute("msg",msg);
    }
}
