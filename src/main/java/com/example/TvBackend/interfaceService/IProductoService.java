package com.example.TvBackend.interfaceService;


import com.example.TvBackend.Model.Producto;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    public List<Producto> obtenerProductos();
    public Producto guardarProducto(Producto producto);
    public Optional<Producto> ConseguirProductoPorId(int id);
    public void eliminarProducto(int id);
}
