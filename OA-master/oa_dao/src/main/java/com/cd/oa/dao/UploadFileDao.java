package com.cd.oa.dao;

import com.cd.oa.entity.Adverstise;
import com.cd.oa.entity.UploadFile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("uploadFileDao")
public interface UploadFileDao {

    void add(UploadFile uploadFile);

    void delete(String id);

    void update(UploadFile uploadFile);

    List<UploadFile> selectUploadFileByMap(Map map);
}
