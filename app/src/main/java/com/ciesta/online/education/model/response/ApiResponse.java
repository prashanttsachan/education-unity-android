package com.ciesta.online.education.model.response;

import com.google.gson.annotations.SerializedName;

public class ApiResponse<T> {

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("error")
    private String error;

    @SerializedName("data")
    private T data;

    public ApiResponse(String timestamp, String status, String message, String error, T data) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.error = error;
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
