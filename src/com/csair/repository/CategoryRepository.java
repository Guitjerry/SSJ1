package com.csair.repository;

import com.csair.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by dnys on 2016/11/16.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {


}
