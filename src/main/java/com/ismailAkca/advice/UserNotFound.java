package com.ismailAkca.advice;

public class UserNotFound extends RuntimeException{
    private static final long serialVerionUID = 1L;
    public UserNotFound(String message){
        super(message);
    }
}
