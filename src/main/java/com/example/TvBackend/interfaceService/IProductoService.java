package com.example.TvBackend.interfaceService;

import com.example.TvBackend.Model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProductoService {

    List<Producto> buscarPorNombreOMarca(String filtro);

    public List<Producto> obtenerProductos();
    public Producto conseguirPorId(int id);
    public ResponseEntity<String> registrarProducto(Producto productoJson);
    public Optional<Producto> actualizarProducto(int id, Producto producto);
    public ResponseEntity<String> eliminarProducto(int id);
}
