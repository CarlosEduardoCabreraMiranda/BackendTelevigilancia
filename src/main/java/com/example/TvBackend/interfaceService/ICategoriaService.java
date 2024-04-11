package com.example.TvBackend.interfaceService;

import com.example.TvBackend.Model.Categoria;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICategoriaService {

    List<Categoria> obtenerCategoriaPorNombre(String nombre);
    List<Categoria> obtenerCategorias();
    Optional<Categoria> obtenerPorId(Long id);
    public Optional<Categoria> actualizarCategoria(Long id, Categoria categoria);
    public ResponseEntity<String> registrarCategoria(Map<String,String> categoria);
    public ResponseEntity<String> deleteCategoria(Long id);
}
