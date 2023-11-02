package com.example.house_pe.Models;

import java.math.BigDecimal;

public class HouseModel {

    private int houseId;
    private String houseNo;
    private String houseOwnerName;
    private int noOfRoom;
    private BigDecimal housePrice;
    private String houseDescription;

    public HouseModel() {
    }

    public HouseModel(int houseId, String houseNo, String houseOwnerName, int noOfRoom, BigDecimal housePrice, String houseDescription) {
        this.houseId = houseId;
        this.houseNo = houseNo;
        this.houseOwnerName = houseOwnerName;
        this.noOfRoom = noOfRoom;
        this.housePrice = housePrice;
        this.houseDescription = houseDescription;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getHouseOwnerName() {
        return houseOwnerName;
    }

    public void setHouseOwnerName(String houseOwnerName) {
        this.houseOwnerName = houseOwnerName;
    }

    public int getNoOfRoom() {
        return noOfRoom;
    }

    public void setNoOfRoom(int noOfRoom) {
        this.noOfRoom = noOfRoom;
    }

    public BigDecimal getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(BigDecimal housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }
}
