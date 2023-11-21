package com.example.TvBackend.interfaceService;

import com.example.TvBackend.Model.Producto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProductoService {
    public List<Producto> obtenerProductos();
    public ResponseEntity<String> registrarProducto(Map<String, String> productoMap);
    public Optional<Producto> ConseguirProductoPorId(int id, Producto producto);

    public void eliminarProducto(int id);
}
