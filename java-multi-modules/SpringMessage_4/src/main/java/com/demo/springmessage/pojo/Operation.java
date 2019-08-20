package com.demo.springmessage.pojo;

public class Operation {
    private int op_id;
    private int op_user_id;
    private String op_user_name;
    private String op_type;
    private String time;
    private Long cost_time;
    private String result;
    public int getOp_id() {
        return op_id;
    }

    public void setOp_id(int op_id) {
        this.op_id = op_id;
    }

    public int getOp_user_id() {
        return op_user_id;
    }

    public void setOp_user_id(int op_user_id) {
        this.op_user_id = op_user_id;
    }

    public String getOp_user_name() {
        return op_user_name;
    }

    public void setOp_user_name(String op_user_name) {
        this.op_user_name = op_user_name;
    }

    public String getOp_type() {
        return op_type;
    }

    public void setOp_type(String op_type) {
        this.op_type = op_type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getCost_time() {
        return cost_time;
    }

    public void setCost_time(Long cost_time) {
        this.cost_time = cost_time;
    }
}
