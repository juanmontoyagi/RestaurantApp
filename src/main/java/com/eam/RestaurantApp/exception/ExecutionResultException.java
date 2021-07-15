package com.eam.RestaurantApp.exception;

public class ExecutionResultException extends BusinessException{

    public ExecutionResultException(String message, String ErrorCode){
        super(message, ErrorCode);
    }
}
