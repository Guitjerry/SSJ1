package com.csair.controller;

import com.csair.entity.Supplier;
import com.csair.service.SupplierService;
import com.csair.util.Const;
import com.csair.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mac on 16/12/18.
 * 供货信息
 */
@Controller
@RequestMapping(value = "/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @RequestMapping(value = "listSupplers")
    public String listSupplers(HttpServletRequest request,HttpServletResponse response,String msg,Integer pageNo){
        pageNo=pageNo==null?0:pageNo-1;
        Pageable pageable = new PageRequest(pageNo, Const.PAGE_SIZE);
        Page<Supplier> page =supplierService.listAllSuppliers(pageable);
        if(page.getSize()>0){
            request.setAttribute("supplierList",page.getContent());
            request.setAttribute("totalpage",page.getTotalPages());//总页数
            request.setAttribute("totalcount",page.getSize());//每页显示的数量
            request.setAttribute("pageNo",pageNo);//页数
            request.setAttribute("msg",msg);

        }
        return "supplier/supplier";
    }

    @RequestMapping(value = "/addSupplier")
    public void addSupplier(HttpServletRequest request,Supplier supplier,HttpServletResponse response){
        if(supplier!=null){
            supplier.setStatus(1);
            supplierService.saveSupplier(supplier);

        }
        if(supplier.getId()>0){
            try {
                JsonUtilTemp.returnSucessJson(response,"添加成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @RequestMapping(value = "/editSupplierById")
    public String editSupplierById(Integer id,HttpServletRequest request){
        if(id!=null&&id>0){
            Supplier supplier = supplierService.findSupplierById(id);
            request.setAttribute("supplier",supplier);
        }


         return "supplier/editSupplier";
    }
    @RequestMapping(value = "/editSupplier")
    public void editSupplier(Supplier supplier,HttpServletResponse response){
        Supplier simSupplier = null;
        if(simSupplier==null){
            simSupplier = supplierService.findSupplierById(supplier.getId());
            simSupplier.setName(supplier.getName());
            simSupplier.setSort(supplier.getSort());

        }
        if(simSupplier!=null){
            supplierService.editSuppler(simSupplier);
            try {
                JsonUtilTemp.returnSucessJson(response,"更新成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
