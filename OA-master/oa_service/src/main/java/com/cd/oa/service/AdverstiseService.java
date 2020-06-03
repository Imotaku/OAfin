package com.cd.oa.service;


import com.cd.oa.entity.Adverstise;

import java.util.List;
import java.util.Map;

public interface AdverstiseService {

    void add(Adverstise adverstise);

    void delete(String id);

    void update(Adverstise adverstise);

    List<Adverstise> selectAdverstiseByMap(Map map);


}
