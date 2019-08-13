package springmessage.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import springmessage.pojo.Permission;

@Mapper
@Repository
public interface PermissionDao {
    @Select("SELECT id,username,search_m,add_m,delete_m_person,update_m_person,update_m_group,delete_m_all,update_m_all,update_user_person,update_user_all from role_permission,user where role_id=roleid and username=#{username}")
    @Results(id = "permissionResultMap",value = {
            @Result(property="user_id",column="id"),
            @Result(property="user_name",column="username"),
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
    Permission permissionByusername(@Param("username")String username);

    @Update("UPDATE role_permission SET search_m =#{search_m} , add_m =#{add_m}, delete_m_person =#{delete_m_person} , update_m_person =#{update_m_person} , update_m_group =#{update_m_group} , delete_m_all =#{delete_m_all} , update_m_all =#{update_m_all} , update_user_person =#{update_user_person} , update_user_all =#{update_user_all}  WHERE (rp_id = #{roleid});")
    int updatepermission(@Param("search_m")int search_m, @Param("add_m")int add_m,@Param("delete_m_person") int delete_m_person, @Param("update_m_person")int update_m_person, @Param("update_m_group")int update_m_group, @Param("delete_m_all")int delete_m_all, @Param("update_m_all")int update_m_all, @Param("update_user_person")int update_user_person, @Param("update_user_all")int update_user_all, @Param("roleid")int roleid);

}
