package com.rabit.rabit.rabitmq.Dto;

public class MessagePayload {
    private String status;
    private String message;
    private String details;

    // Getter for status
    public String getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter for details
    public String getDetails() {
        return details;
    }

    // Setter for details
    public void setDetails(String details) {
        this.details = details;
    }
    @Override
    public String toString() {
        return "MessagePayload{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}

