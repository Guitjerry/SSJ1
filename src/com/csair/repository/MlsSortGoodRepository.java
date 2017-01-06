package com.csair.repository;

import com.csair.entity.Mls_sortgood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mac on 16/12/13.
 */
@Repository
public interface MlsSortGoodRepository extends JpaRepository<Mls_sortgood,Integer>{

}
