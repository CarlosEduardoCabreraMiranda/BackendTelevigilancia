package com.example.TvBackend.Controller;

import com.example.TvBackend.Model.Producto;
import com.example.TvBackend.Utilidades.Utilidades;
import com.example.TvBackend.constantes.Constantes;
import com.example.TvBackend.interfaceService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/televigilancia")
public class ProductoController {
    @Autowired
    IProductoService productoService;
    @GetMapping("/getProductos")
    public List<Producto> index(){
        return productoService.obtenerProductos();
    }
    @PostMapping("/saveProducto")
    public ResponseEntity<String> saveProducto(@RequestBody (required = true) Map<String,String>productoMap){
        try{
            return productoService.registrarProducto(productoMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return Utilidades.getResponseEntity(Constantes.ALGO_PASO_MAL, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/updateProducto/{id}")
    public Optional<Producto> updateProducto(@PathVariable int id, @RequestBody Producto producto){
        return productoService.ConseguirProductoPorId(id, producto);
    }
    @DeleteMapping("/deleteProducto/{id}")
    public void delete(@PathVariable int id){
        productoService.eliminarProducto(id);
    }
}
