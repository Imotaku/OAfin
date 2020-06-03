package com.cd.oa.service.impl;

import com.cd.oa.dao.AdverstiseDao;
import com.cd.oa.dao.LogDao;
import com.cd.oa.entity.Adverstise;
import com.cd.oa.entity.Log;
import com.cd.oa.service.AdverstiseService;
import com.cd.oa.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adverstiseService")
public class AdverstiseServiceImpl implements AdverstiseService {

    @Autowired
    private AdverstiseDao adverstiseDao;

    @Override
    public void add(Adverstise adverstise) {
        adverstiseDao.add(adverstise);
    }

    @Override
    public void delete(String id) {
        adverstiseDao.delete(id);
    }

    @Override
    public void update(Adverstise adverstise) {
        adverstiseDao.update(adverstise);
    }

    @Override
    public List<Adverstise> selectAdverstiseByMap(Map map) {
        return adverstiseDao.selectAdverstiseByMap(map);
    }
}
