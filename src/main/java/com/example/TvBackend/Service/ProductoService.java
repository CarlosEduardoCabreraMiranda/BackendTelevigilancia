package com.example.TvBackend.Service;

import com.example.TvBackend.Model.Producto;
import com.example.TvBackend.Repository.ProductoRepository;
import com.example.TvBackend.Utilidades.Utilidades;
import com.example.TvBackend.constantes.Constantes;
import com.example.TvBackend.interfaceService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoDao;

    @Override
    public List<Producto> obtenerProductos() {return (List<Producto>) productoDao.findAll();}

    @Override
    public Optional<Producto> ConseguirProductoPorId(int id, Producto product) {
        Optional<Producto> producto = productoDao.findById(id);
        if(producto.isPresent()){
            Producto productoActualizado = new Producto();
            productoActualizado.setCodigoProducto(id);
            productoActualizado.setNombre(product.getNombre());
            productoActualizado.setMarca(product.getMarca());
            productoActualizado.setCosto(product.getCosto());
            productoActualizado.setCaracteristicas(product.getCaracteristicas());
            productoActualizado.setGarantia(product.getGarantia());
            productoActualizado.setReferencia(producto.get().getReferencia());
            productoDao.save(productoActualizado);
            return producto;
        }else{
            throw new NoSuchElementException("No se encontró un producto con el ID especificado");
        }
    }

    @Override
    public ResponseEntity<String> registrarProducto(Map<String,String> producto) {
      try{
          if(validarInformacion(producto)){
              Producto productoReferencia = productoDao.findProductByReference(producto.get("referencia"));
              if(Objects.isNull(productoReferencia)){
                  productoDao.save(getFromMapProducto(producto));
                  return Utilidades.getResponseEntity("Registro Exitoso!", HttpStatus.OK);
              }
              return Utilidades.getResponseEntity("La referencia ya existe!", HttpStatus.BAD_REQUEST);
          }
          return Utilidades.getResponseEntity(Constantes.DATO_INVALIDO, HttpStatus.BAD_REQUEST);
      }catch (Exception e){
          e.printStackTrace();
      }
        return Utilidades.getResponseEntity(Constantes.ALGO_PASO_MAL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public void eliminarProducto(int id){
        productoDao.deleteById(id);
    }

    public boolean validarInformacion(Map<String, String> producto){
        if(producto.containsKey("nombre") && producto.containsKey("marca") && producto.containsKey("costo")
                && producto.containsKey("caracteristicas") && producto.containsKey("referencia")){
            return true;
        }
        return false;
    }
    public Producto getFromMapProducto(Map<String,String> productoMap){
        Producto producto = new Producto();
        producto.setNombre(productoMap.get("nombre"));
        producto.setMarca(productoMap.get("marca"));
        producto.setCosto(Float.parseFloat(productoMap.get("costo")));
        producto.setCaracteristicas(productoMap.get("caracteristicas"));
        producto.setGarantia(productoMap.get("garantia"));
        producto.setReferencia(productoMap.get("referencia"));
        return producto;
    }
}
