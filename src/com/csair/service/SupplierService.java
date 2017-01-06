package com.csair.service;

import com.csair.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by mac on 16/12/18.
 */
public interface SupplierService {
    /**
     * 保存供货商
     * @param supplier
     */
    public void saveSupplier(Supplier supplier);

    /**
     * 列出所有的供货商
     * @return
     */
    public Page<Supplier> listAllSuppliers(Pageable pageable);

    /**
     * 编辑供货商
     * @param supplier
     */
    public void editSuppler(Supplier supplier);

    /**
     * 删除供货商信息,设置该供货商无效
     * @param id
     */
    public void delSuppler(int id);

    /**
     * 查找供货商
     * @param id
     * @return
     */
    public Supplier findSupplierById(int id);
}
