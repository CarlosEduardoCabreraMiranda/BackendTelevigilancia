package com.example.TvBackend.New.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@RequestMapping(path="/producto")
public interface ProductoRest {

    @PostMapping(path="/registerp")
    public ResponseEntity<String> register(@RequestBody(required = true) Map<String, String> requestMap);

}
