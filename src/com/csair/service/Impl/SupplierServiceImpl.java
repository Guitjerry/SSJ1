package com.csair.service.Impl;

import com.csair.entity.Supplier;
import com.csair.repository.SupplierRepository;
import com.csair.service.SupplierService;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by mac on 16/12/18.
 */
@Transactional
@Service(value = "supplierService")
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository  supplierRepository;
    @PersistenceContext
    protected EntityManager em;
    @Override
    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public Page listAllSuppliers(Pageable pageable) {
        return supplierRepository.findAll(pageable);
    }
    @Override
    public void editSuppler(Supplier supplier) {
        Query query = em.createQuery("update Supplier set name=?1,sort=?2 where id="+supplier.getId());
        query.setParameter(1,supplier.getName());
        query.setParameter(2,supplier.getSort());
        query.executeUpdate();

    }

    @Override
    public void delSuppler(int id) {
        supplierRepository.delete(id);
    }

    @Override
    public Supplier findSupplierById(int id) {
        return supplierRepository.findOne(id);
    }
}
