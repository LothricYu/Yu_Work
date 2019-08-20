package com.demo.springmessage.pojo;

public class Bill {
    private int bill_id;
    private int bill_user_id;
    private String bill_type;
    private Double bill_amount;
    private String bill_date;

    public String getBill_type() {
        return bill_type;
    }

    public void setBill_type(String bill_type) {
        this.bill_type = bill_type;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public Double getBill_amount() {
        return bill_amount;
    }

    public void setBill_amount(Double bill_amount) {
        this.bill_amount = bill_amount;
    }


    public int getBill_user_id() {
        return bill_user_id;
    }

    public void setBill_user_id(int bill_user_id) {
        this.bill_user_id = bill_user_id;
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }
}
