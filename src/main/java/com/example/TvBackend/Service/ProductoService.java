package com.example.TvBackend.Service;

import com.example.TvBackend.Model.Producto;
import com.example.TvBackend.Repository.ProductoRepository;
import com.example.TvBackend.constantes.Constantes;
import com.example.TvBackend.interfaceService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoDao;

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
            productoDao.save(productoActualizado);
            return producto;
        } else {
            throw new NoSuchElementException("No se encontró un producto con el ID especificado");
        }
    }

    @Override
    public Producto registrarProducto(Map<String, String> producto) {
        try {
            if (validarInformacion(producto)) {
                return productoDao.save(getFromMapProducto(producto));
            } else {
                throw new NoSuchElementException("Datos invalidos" + HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new NoSuchElementException(Constantes.ALGO_PASO_MAL + HttpStatus.BAD_REQUEST);
    }

    @Override
    public void eliminarProducto(int id) {
        productoDao.deleteById(id);
    }

    public boolean validarInformacion(Map<String, String> producto) {
        if (producto.containsKey("nombre") && producto.containsKey("marca") && producto.containsKey("costo")
                && producto.containsKey("caracteristicas") && producto.containsKey("referencia")) {
            return true;
        }
        return false;
    }

    public Producto getFromMapProducto(Map<String, String> productoMap) {
        Producto producto = new Producto();
        producto.setNombre(productoMap.get("nombre").toUpperCase());
        producto.setFoto((productoMap.get("foto")));
        producto.setMarca(productoMap.get("marca").toUpperCase());
        producto.setCosto(Float.parseFloat(productoMap.get("costo")));
        producto.setCaracteristicas(productoMap.get("caracteristicas"));
        producto.setGarantia(productoMap.get("garantia").toUpperCase());
        producto.setReferencia(productoMap.get("referencia").toUpperCase());
        return producto;
    }
}
