package org.wt.model;

public class Order {
    private String orderNo;

    public Order(){

    }
    public Order(String orderNo){
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
