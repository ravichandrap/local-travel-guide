package com.hiker.util;

public class HikerException {
    private String errorMessage;
    public HikerException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
