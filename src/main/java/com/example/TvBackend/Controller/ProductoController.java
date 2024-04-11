package com.example.TvBackend.Controller;

import com.example.TvBackend.Model.Producto;
import com.example.TvBackend.constantes.Constantes;
import com.example.TvBackend.interfaceService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
@RestController
@RequestMapping("/televigilancia")
@CrossOrigin(origins = "*")
public class ProductoController {
    @Autowired
    IProductoService productoService;

    @GetMapping("/productos/search")
    public List<Producto> buscarPorNombreOMarca(String filtro){
        return productoService.buscarPorNombreOMarca(filtro.toUpperCase());
    }

    @GetMapping("/getProductos")
    public List<Producto> index(){
        return productoService.obtenerProductos();
    }
    @GetMapping("/getProducto/{id}")
    public Producto getById(@PathVariable int id){
        return productoService.conseguirPorId(id);
    }
    @PostMapping("/saveProducto")
    public ResponseEntity<String> saveProducto(@RequestBody (required = true) Producto productoJson){
        try{
                return productoService.registrarProducto(productoJson);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        throw new NoSuchElementException(Constantes.ALGO_PASO_MAL + HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/updateProducto/{id}")
    public Optional<Producto> updateProducto(@PathVariable int id, @RequestBody Producto producto){
        return productoService.actualizarProducto(id, producto);
    }
    @DeleteMapping("/deleteProducto/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
       return  productoService.eliminarProducto(id);
    }
}
