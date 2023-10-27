package com.example.TvBackend.New.ServiceImpl;

import com.example.TvBackend.New.pojo.Producto;
import com.example.TvBackend.New.Service.productoService;
import com.example.TvBackend.New.dao.ProductoDao;
import com.example.TvBackend.New.constants.maximusConstants;
import com.example.TvBackend.New.utils.maximusUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

import static java.lang.Float.parseFloat;

@Slf4j
@Service
public class productoServiceImpl implements productoService {

    @Autowired
    ProductoDao productoDao;
    @Override
    public ResponseEntity<String> register(Map<String, String> requestMap) {
        log.info("Dentro Registro {}", requestMap);
        try {
            if (validarRegistrarPMap(requestMap)) {
                Producto producto = productoDao.findProductoByCodigo_producto(requestMap.get("codigo"));
                if (Objects.isNull(producto)) {
                    productoDao.save(getProductoFromMap(requestMap));
                    return maximusUtils.getResponseEntity("Registro Producto Exitoso!", HttpStatus.OK);
                } else {
                    return maximusUtils.getResponseEntity("Producto ya existe!", HttpStatus.BAD_REQUEST);
                }
            } else {
                return maximusUtils.getResponseEntity(maximusConstants.NO_USABLE, HttpStatus.BAD_REQUEST);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return maximusUtils.getResponseEntity(maximusConstants.WE_ARE_SAD, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validarRegistrarPMap(Map<String, String> requestMap){
        if(requestMap.containsKey("nombre") && requestMap.containsKey("codigo")
                && requestMap.containsKey("costo") && requestMap.containsKey("tipo")){
            return true;
        }
        return false;
    }

    private Producto getProductoFromMap(Map<String, String> requestMap){
        Producto producto = new Producto();
        producto.setCodigo(requestMap.get("codigo"));
        producto.setNombre(requestMap.get("nombre"));
        producto.setCosto(parseFloat(requestMap.get("costo")));
        producto.setTipo(requestMap.get("tipo"));
        return producto;
    }
}
