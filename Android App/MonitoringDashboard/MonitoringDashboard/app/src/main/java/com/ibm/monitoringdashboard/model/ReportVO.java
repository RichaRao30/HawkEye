package com.ibm.monitoringdashboard.model;

public class ReportVO {
    private int quantity;
    private String trxType;

    public ReportVO(int quantity, String trxType) {
        this.quantity = quantity;
        this.trxType = trxType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTrxType() {
        return trxType;
    }

    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }

    @Override
    public String toString() {
        return "ReportVO{" +
                "quantity=" + quantity +
                ", trxType='" + trxType + '\'' +
                '}';
    }
}
