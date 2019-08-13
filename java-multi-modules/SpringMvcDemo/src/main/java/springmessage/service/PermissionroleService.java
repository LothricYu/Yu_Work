package springmessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmessage.dao.PermissionroleDao;
import springmessage.pojo.Permissionrole;

@Service
public class PermissionroleService {

    @Autowired
    private PermissionroleDao permissionroleDao;

    public Permissionrole permissionByroleid(int roleid) {
        return  permissionroleDao.permissionByroleid(roleid);
    }
}
