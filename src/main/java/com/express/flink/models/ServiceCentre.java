package com.express.flink.models;

public class ServiceCentre {
    private String name;
    private String code;
    private Integer receivedCount;
    private Integer dispatchedCount;

    public ServiceCentre (String name, String code) {
        this.name = name;
        this.code = code;
        this.receivedCount = 0;
        this.dispatchedCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public Integer getReceivedCount() {
        return this.receivedCount;
    }

    public Integer getDispatchedCount() {
        return this.dispatchedCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setReceivedCount(Integer receivedCount) {
        this.receivedCount = receivedCount;
    }

    public void setDispatchedCount(Integer dispatchedCount) {
        this.dispatchedCount = dispatchedCount;
    }

    public void increaseReceivedCount(Integer count) {
        this.receivedCount += count;
    }

    public void increaseDispatchedCount(Integer count) {
        this.dispatchedCount += count;
    }
}