package com.csair.repository;

import com.csair.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mac on 16/12/18.
 */
@Repository
public interface SupplierRepository extends PagingAndSortingRepository<Supplier,Integer> {

}
