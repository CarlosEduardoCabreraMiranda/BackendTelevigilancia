package com.example.TvBackend.New.restImpl;

import com.example.TvBackend.New.Service.productoService;
import com.example.TvBackend.New.rest.ProductoRest;
import com.example.TvBackend.New.utils.maximusUtils;
import com.example.TvBackend.New.constants.maximusConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class productoRestImpl implements ProductoRest {
    @Autowired
    productoService productoService;

    public productoRestImpl(com.example.TvBackend.New.Service.productoService productoService) {
        this.productoService = productoService;
    }

    @Override
    public ResponseEntity<String> register(Map<String, String> requestMap) {
        try{
            return productoService.register(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return maximusUtils.getResponseEntity(maximusConstants.WE_ARE_SAD, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
