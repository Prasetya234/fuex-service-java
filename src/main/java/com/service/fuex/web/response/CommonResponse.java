package com.service.fuex.web.response;

public class CommonResponse<T> {
    private String status;
    private String message;
    private T content;

    public CommonResponse() {
    }

    public CommonResponse(String status, String message, T content) {
        this.status = status;
        this.message = message;
        this.content = content;
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

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
