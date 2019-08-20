package com.demo.springmessage.service;

import com.demo.springmessage.dao.BillDao;
import com.demo.springmessage.pojo.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillDao billDao;

    public List<Bill> findBillByuserid(int page,int userid) {
        int begin = (page - 1) * 10;
        int end =  10;
//        System.out.println(begin);
//        System.out.println(end);
        return billDao.findByuserid(userid,begin,end);
    }

    public int pageNum(int id){
        return billDao.selectTotalNum(id);
    }

    public boolean insertBill(String bill_type,Double bill_amount,int bill_user_id){
        return billDao.insertBill(bill_type,bill_amount,bill_user_id) > 0 ? true : false;
    }




}
