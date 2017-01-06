package com.csair.repository;

import com.csair.entity.CategoryChildren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dnys on 2016/12/8.
 */
@Transactional
public interface CategoryChildrenRepository extends JpaRepository<CategoryChildren,Integer> {
}
