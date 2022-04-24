package com.oms.exception.handler;





public class ResponseFormat {
    private Boolean successful;
    private String message;

    public ResponseFormat(Boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
