package com.express.flink.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScanItem {

    private Integer operationId;
    private String parcelId;
    private String locationPostcode;
    private String operatorId;
    private Date operationDate;
    private String destinationPostcode;
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ScanItem() {}


    public Integer getOperationId() {
        return operationId;
    }

    public String getParcelId() {
        return parcelId;
    }

    public String getLocationPostcode() {
        return locationPostcode;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }

    public void setLocationPostcode(String locationPostcode) {
        this.locationPostcode = locationPostcode;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public void setDestinationPostcode(String destinationPostcode) {
        this.destinationPostcode = destinationPostcode;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public String getDestinationPostcode() {
        return destinationPostcode;
    }

    public ScanItem(String operationId, String parcelId,
                    String locationPostcode, String operatorId, String operationDate, String destinationPostcode) throws ParseException {
        this.operationId = Integer.parseInt(operationId);
        this.parcelId = parcelId;
        this.locationPostcode = locationPostcode;
        this.operatorId = operatorId;
        DateFormat format = new SimpleDateFormat("yyyyMMdd HHmmss");
        this.operationDate = format.parse(operationDate);
        this.destinationPostcode = destinationPostcode;
        this.amount = 1;
    }


    @Override
    public String toString() {
        return "(" + locationPostcode + "," + amount + ")";
    }

}
