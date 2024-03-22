package com.example.TvBackend.interfaceService;

import com.example.TvBackend.Model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProductoService {
    public List<Producto> obtenerProductos();
    public Producto conseguirPorId(int id);
    public Producto registrarProducto(Map<String, String> productoMap);
    public Optional<Producto> actualizarProducto(int id, Producto producto);
    public void eliminarProducto(int id);
}
