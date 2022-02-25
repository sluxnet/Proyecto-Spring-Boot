package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;
import java.util.Date;

public class ErrorResponse {
    // customizing timestamp serialization format
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private int code;

    private String status;

    private String message;

    private String stackTrace;

    private Object data;

    public ErrorResponse() {
        timestamp = new Date();
        
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message
    )
    {
        this();
    
        this.setCode(httpStatus.value());
        this.setStatus(httpStatus.name());
        this.setMessage(message);
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message,
            String stackTrace
    ) {
        this(
                httpStatus,
                message        
        );

        this.setStackTrace(stackTrace.substring(0,50));
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message,
        String stackTrace,
            Object data
    ) {
        this(
                httpStatus,
                message,
        stackTrace
        );

       // this.setData(data);
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}


}
