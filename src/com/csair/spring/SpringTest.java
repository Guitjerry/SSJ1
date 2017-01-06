package com.csair.spring;

import com.csair.entity.Category;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by mac on 16/12/20.
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
        Category category = (Category) context.getBean("Category");
        System.out.println(category.getName());
    }
}
