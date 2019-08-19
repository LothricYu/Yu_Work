package com.demo.springmessage.service;

import com.demo.springmessage.aop.MyLog;
import com.demo.springmessage.dao.OperationDao;
import com.demo.springmessage.pojo.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationDao operationDao;

    @MyLog(value="查询操作记录")
    public List<Operation> findAll() {
        return operationDao.findAll();
    }

    public List<Operation> findfenyeOperation(int page) {
        int begin = (page - 1) * 10;
        int end =  10;
//        System.out.println(begin);
//        System.out.println(end);
        return operationDao.findfenyeOperation(begin,end);
    }

    public int pageNum(){
        return operationDao.selectTotalNum();
    }

    @MyLog(value="根据用户名查看操作记录")
    public List<Operation> queryoperationByUsername(String username) {
        return operationDao.queryoperationByUsername(username);
    }


   public boolean insertOperationLog(Operation operation){
        return operationDao.insertOperationLog(operation) > 0 ? true : false;
   }

}