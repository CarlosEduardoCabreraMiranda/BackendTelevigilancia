package com.example.TvBackend.New.Service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface productoService {
    ResponseEntity<String> register (Map<String, String> requestMap);
}
