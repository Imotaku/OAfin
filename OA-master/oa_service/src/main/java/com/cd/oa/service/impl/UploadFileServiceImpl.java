package com.cd.oa.service.impl;

import com.cd.oa.dao.LogDao;
import com.cd.oa.dao.UploadFileDao;
import com.cd.oa.entity.Log;
import com.cd.oa.entity.UploadFile;
import com.cd.oa.service.LogService;
import com.cd.oa.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("uploadFileService")
public class UploadFileServiceImpl implements UploadFileService {

    @Qualifier("uploadFileDao")
    @Autowired
    private UploadFileDao uploadFileDao;

    @Override
    public void add(UploadFile uploadFile) {
            uploadFileDao.add(uploadFile);
    }

    @Override
    public void delete(String id) {
        uploadFileDao.delete(id);
    }

    @Override
    public void update(UploadFile uploadFile) {
            uploadFileDao.update(uploadFile);
    }

    @Override
    public List<UploadFile> selectUploadFileByMap(Map map) {
        return uploadFileDao.selectUploadFileByMap(map);
    }
}
