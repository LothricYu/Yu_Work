package com.demo.springmessage.service;

import com.demo.springmessage.aop.MyLog;
import com.demo.springmessage.dao.PermissionroleDao;
import com.demo.springmessage.pojo.Permissionrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionroleService {

    @Autowired
    private PermissionroleDao permissionroleDao;

    @MyLog(value="查询角色权限")
    public Permissionrole permissionByroleid(int roleid) {
        return  permissionroleDao.permissionByroleid(roleid);
    }
}
