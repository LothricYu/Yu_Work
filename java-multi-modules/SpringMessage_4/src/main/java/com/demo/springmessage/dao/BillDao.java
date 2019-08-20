package com.demo.springmessage.dao;

import com.demo.springmessage.pojo.Bill;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BillDao {
    @Select("select * from bill")
    @Results(id = "billResultMap", value = {
            @Result(property = "bill_id", column = "bill_id"),
            @Result(property = "bill_type", column = "bill_type"),
            @Result(property = "bill_amount", column = "bill_amount"),
            @Result(property = "bill_user_id", column = "bill_user_id"),
            @Result(property = "bill_date", column = "bill_date"),
    })
    List<Bill> findAll();

    @Select("select bill_id,bill_type,bill_amount,bill_user_id,bill_date from bill where bill_user_id=#{id} limit #{begin},#{end}")
    @ResultMap("billResultMap")
    List<Bill> findByuserid(int id,int begin, int end);

    @Select("select count(bill_id) from bill where bill_user_id=#{id}")
    int selectTotalNum(int id);

//    @Select("select op_id,op_user_id,op_user_name,op_type,time,cost_time,result from operation,user where op_user_id=id limit #{begin},#{end}")
//    @ResultMap("operationResultMap")
//    List<Operation> findfenyeOperation(int begin, int end);
//
//    @Select("select count(op_id) from operation")
//    int selectTotalNum();

    @Insert("INSERT INTO bill (bill_type, bill_amount, bill_user_id,bill_date) VALUES (#{bill_type}, #{bill_amount},#{bill_user_id},NOW() )")
    int insertBill(String bill_type,Double bill_amount,int bill_user_id);


}