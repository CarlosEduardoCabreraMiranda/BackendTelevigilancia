package com.example.TvBackend.Utilidades;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utilidades {
    private Utilidades(){}

    public static ResponseEntity<String> getResponseEntity(String mensajeRespuesta, HttpStatus httpStatus){
        return new ResponseEntity<String>("Respuesta: "+mensajeRespuesta+" Estado Http: "+httpStatus, httpStatus);
    }
}
