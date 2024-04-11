package com.example.TvBackend.Service;

import com.example.TvBackend.Model.Categoria;
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
    public List<Producto> buscarPorNombreOMarca(String filtro) {
        return productoDao.getProductosByNombreOrMarcaOrderByNombreDesc(filtro);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    public Producto conseguirPorId(int id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public Optional<Producto> actualizarProducto(int id, Producto product) {
        Optional<Producto> producto = productoDao.findById(id);
        if (producto.isPresent()) {
            Producto productoActualizado = new Producto();
            productoActualizado.setCodigo_producto(id);
            productoActualizado.setNombre(product.getNombre().toUpperCase());
            productoActualizado.setMarca(product.getMarca().toUpperCase());
            productoActualizado.setFoto(product.getFoto());
            productoActualizado.setCosto(product.getCosto());
            productoActualizado.setCaracteristicas(product.getCaracteristicas());
            productoActualizado.setGarantia(product.getGarantia().toUpperCase());
            productoActualizado.setReferencia(product.getReferencia().toUpperCase());
            productoActualizado.setCategoria(product.getCategoria());
            productoDao.save(productoActualizado);
            return producto;
        } else {
            throw new NoSuchElementException("No se encontró un producto con el ID especificado");
        }
    }

    @Override
    public ResponseEntity<String> registrarProducto(Producto productoJson) {
        try {
            productoDao.save(convertirAtributosToMayuscula(productoJson));
            return Utilidades.getResponseEntity("Producto guardado con exito. Status:" + HttpStatus.OK, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Utilidades.getResponseEntity("Ocurrio un error interno en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> eliminarProducto(int id) {
        Long id_long = (long) id;
        if (id_long != null) {
            productoDao.deleteById(id);
            return Utilidades.getResponseEntity("La categoria con el id: " + id + " se eliminó con exito", HttpStatus.OK);
        }
        return Utilidades.getResponseEntity("No se encontró la categoria con el ID especificado", HttpStatus.BAD_REQUEST);
    }
    public Producto convertirAtributosToMayuscula(Producto producto){
        Producto productoEnMayus = new Producto();
        productoEnMayus.setMarca(producto.getNombre().toUpperCase());
        productoEnMayus.setMarca(producto.getMarca().toUpperCase());
        productoEnMayus.setFoto(producto.getFoto());
        productoEnMayus.setCosto(producto.getCosto());
        productoEnMayus.setCaracteristicas(producto.getCaracteristicas().toUpperCase());
        productoEnMayus.setGarantia(producto.getGarantia());
        productoEnMayus.setReferencia(producto.getReferencia().toUpperCase());
        productoEnMayus.setCategoria(producto.getCategoria());
        return productoEnMayus;
    }
}
