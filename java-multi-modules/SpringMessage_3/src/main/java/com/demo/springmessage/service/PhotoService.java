package com.demo.springmessage.service;

import com.demo.springmessage.aop.MyLog;
import com.demo.springmessage.dao.PhotoDao;
import com.demo.springmessage.pojo.photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    @Autowired
    private PhotoDao photoDao;

    @MyLog(value="查看所有上传图片")
    public List<photo> photoall() {
        return  photoDao.findAll();
    }

    @MyLog(value="上传图片")
    public boolean insertphoto(photo photo) {
        return photoDao.insertPhoto(photo) > 0 ? true : false;
    }

    @MyLog(value="修改头像")
    public boolean updatePhoto(String photo_path,int id) {
        return photoDao.updatePhoto(photo_path,id) > 0 ? true : false;
    }

    @MyLog(value="删除图片")
    public boolean DeletePhoto(int id) {
        return photoDao.deletePhoto(id) > 0 ? true : false;
    }
}
