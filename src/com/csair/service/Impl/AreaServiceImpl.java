package com.csair.service.Impl;

import com.csair.entity.Area;
import com.csair.repository.AreaRepository;
import com.csair.repository.SaleSchoolRepository;
import com.csair.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dnys on 2016/12/3.
 */
@Service("areaService")
public class AreaServiceImpl implements AreaService{
    @Autowired
    AreaRepository areaRepository;
    @Override
    public void saveArea(Area area) {
        areaRepository.save(area);
    }
}
