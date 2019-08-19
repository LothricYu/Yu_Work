package com.demo.springmessage.dao;

import com.demo.springmessage.pojo.photo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PhotoDao {


    @Select("SELECT * from photoshop ")
    @Results(id = "photoResultMap",value = {
            @Result(property="photo_id",column="photo_id"),
            @Result(property="photo_path",column="photo_path"),
    })
    List<photo> findAll();

    @Insert("INSERT INTO photoshop (photo_path) VALUES (#{photo_path})")
    int insertPhoto(photo photo);

    @Update("Update user set photo=#{photo_path} where id=#{id}")
    int updatePhoto(String photo_path,int id);

    @Delete("delete from photoshop where photo_id=#{id}")
    int deletePhoto(int id);
}