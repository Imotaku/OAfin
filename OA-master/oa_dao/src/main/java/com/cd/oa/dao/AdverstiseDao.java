package com.cd.oa.dao;

import com.cd.oa.entity.Adverstise;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("adverstiseDao")
public interface AdverstiseDao {

    void add(Adverstise adverstise);

    void delete(String id);

    void update(Adverstise adverstise);

    List<Adverstise> selectAdverstiseByMap(Map map);
}
