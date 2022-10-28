package com.adel.reactivewebclient.logs;


public class LogsDto {
    private String data;
    private Boolean success;

    public LogsDto() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
