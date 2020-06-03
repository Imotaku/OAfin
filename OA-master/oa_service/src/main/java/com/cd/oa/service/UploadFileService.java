package com.cd.oa.service;

import com.cd.oa.entity.UploadFile;

import java.util.List;
import java.util.Map;

public interface UploadFileService {
    void add(UploadFile uploadFile);

    void delete(String id);

    void update(UploadFile uploadFile);

    List<UploadFile> selectUploadFileByMap(Map map);
}
