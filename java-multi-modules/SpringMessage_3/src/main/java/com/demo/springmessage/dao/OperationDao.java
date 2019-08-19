package com.demo.springmessage.dao;

import com.demo.springmessage.pojo.Operation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OperationDao {
    @Select("select * from operation")
    @Results(id = "operationResultMap",value = {
            @Result(property="op_id",column="op_id"),
            @Result(property="op_user_id",column="op_user_id"),
            @Result(property="op_user_name",column="op_user_name"),
            @Result(property="op_type",column="op_type"),
            @Result(property="time",column="time"),
            @Result(property="cost_time",column="cost_time"),
            @Result(property="result",column="result")
    })
    List<Operation> findAll();

    @Insert("insert into operation(op_user_id,op_user_name,op_type,time,cost_time,result) select id,#{op_user_name},#{op_type},NOW(),#{cost_time},#{result} from user where username=#{op_user_name}")
    int insertOperationLog(Operation operation);


    //分页查询
    @Select("select op_id,op_user_id,op_user_name,op_type,time,cost_time,result from operation,user where op_user_id=id limit #{begin},#{end}")
    @ResultMap("operationResultMap")
    List<Operation> findfenyeOperation(int begin, int end);

    @Select("select count(op_id) from operation")
    int selectTotalNum();


    @Select("select * from operation where op_user_name like #{username}")
    @ResultMap("operationResultMap")
    List<Operation> queryoperationByUsername(String username);

}
