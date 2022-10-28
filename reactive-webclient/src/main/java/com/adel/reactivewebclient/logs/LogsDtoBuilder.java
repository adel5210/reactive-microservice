package com.adel.reactivewebclient.logs;

public final class LogsDtoBuilder {
    private String data;
    private Boolean success;

    private LogsDtoBuilder() {
    }

    public static LogsDtoBuilder aLogsDto() {
        return new LogsDtoBuilder();
    }

    public LogsDtoBuilder data(String data) {
        this.data = data;
        return this;
    }

    public LogsDtoBuilder success(Boolean success) {
        this.success = success;
        return this;
    }

    public LogsDto build() {
        LogsDto logsDto = new LogsDto();
        logsDto.setData(data);
        logsDto.setSuccess(success);
        return logsDto;
    }
}
