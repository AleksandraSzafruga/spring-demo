package pl.sda.javalondek4springdemo.dto;

import java.time.LocalDateTime;

public final class ExceptionResponse {

    private LocalDateTime timeStamp;
    private int responseStatus;
    private String error;
    private String message;
    private String path;

    public ExceptionResponse(LocalDateTime timeStamp, int responseStatus, String error, String message, String path) {
        this.timeStamp = timeStamp;
        this.responseStatus = responseStatus;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "timeStamp=" + timeStamp +
                ", responseStatus=" + responseStatus +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
