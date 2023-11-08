package com.example.TvBackend.Service;

import com.example.TvBackend.Model.Producto;
import com.example.TvBackend.Repository.ProductoRepository;
import com.example.TvBackend.interfaceService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoDao;

    @Override
    public List<Producto> obtenerProductos() {return (List<Producto>) productoDao.findAll();}

    @Override
    public Optional<Producto> ConseguirProductoPorId(int id) {
        Optional<Producto> producto = productoDao.findById(id);
        if(producto.isPresent()){
            Producto productoActualizado = new Producto();
            productoActualizado.setNombre(producto.get().getNombre());
            productoActualizado.setMarca(producto.get().getMarca());
            productoActualizado.setCosto(producto.get().getCosto());
            productoActualizado.setCaracteristicas(producto.get().getCaracteristicas());
            productoActualizado.setGarantia(producto.get().getGarantia());
            productoActualizado.setReferencia(producto.get().getReferencia());
            productoDao.save(productoActualizado);
            return producto;
        }else{
            throw new NoSuchElementException("No se encontró un producto con el ID especificado");
        }
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        if (producto.getNombre() != null && producto.getMarca() != null && producto.getCosto() != 0
                && producto.getCaracteristicas() != null && producto.getGarantia() != null && producto.getReferencia() != null) {
            return productoDao.save(producto);
        }else {
            throw new IllegalArgumentException("Algunos atributos de Producto son nulos.");
        }
    }

    @Override
    public void eliminarProducto(int id){
        productoDao.deleteById(id);
    }
}
