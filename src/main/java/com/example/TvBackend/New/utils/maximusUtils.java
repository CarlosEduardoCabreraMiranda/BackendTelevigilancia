package com.example.TvBackend.New.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class maximusUtils {

    private maximusUtils(){

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"resultado\":\""+responseMessage+"\"}", httpStatus);
    }
}
