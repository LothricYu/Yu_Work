package com.demo.springmessage.dao;

import com.demo.springmessage.pojo.Permissionrole;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PermissionroleDao {

    @Select("SELECT * from role_permission where role_id=#{roleid}")
    @Results(id = "permissionResultMap",value = {
            @Result(property="rp_id",column="rp_id"),
            @Result(property="role_id",column="role_id"),
            @Result(property="search_m",column="search_m"),
            @Result(property="add_m",column="add_m"),
            @Result(property="delete_m_person",column="delete_m_person"),
            @Result(property="update_m_person",column="update_m_person"),
            @Result(property="update_m_group",column="update_m_group"),
            @Result(property="delete_m_all",column="delete_m_all"),
            @Result(property="update_m_all",column="update_m_all"),
            @Result(property="update_user_person",column="update_user_person"),
            @Result(property="update_user_all",column="update_user_all")
    })
    Permissionrole permissionByroleid(int roleid);


}
