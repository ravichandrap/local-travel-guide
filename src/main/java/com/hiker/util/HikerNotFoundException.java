package com.hiker.util;

public class HikerNotFoundException extends  RuntimeException {
    public HikerNotFoundException(Long id) {
        super("Hiker "+id+" not found");
    }
}
