package com.demo.springmessage.service;

import com.demo.springmessage.aop.MyLog;
import com.demo.springmessage.dao.PermissionDao;
import com.demo.springmessage.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @MyLog(value="查询登录用户的所有权限")
    public Permission permissionByname(String name) {
        return  permissionDao.permissionByusername(name);

    }

    @MyLog(value="修改角色权限")
    public int updatepermission(int search_m,int add_m,int delete_person,int update_m_person,int update_m_group,int delete_m_all,int update_me_all,int update_user_person,int update_user_all, int roleid){
        return permissionDao.updatepermission( search_m, add_m, delete_person, update_m_person, update_m_group, delete_m_all, update_me_all, update_user_person, update_user_all, roleid);
    }

}
