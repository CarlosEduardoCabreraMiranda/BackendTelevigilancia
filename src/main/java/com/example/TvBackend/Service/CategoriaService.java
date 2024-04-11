package com.example.TvBackend.Service;

import com.example.TvBackend.Model.Categoria;
import com.example.TvBackend.Repository.CategoriaRepository;
import com.example.TvBackend.Utilidades.Utilidades;
import com.example.TvBackend.interfaceService.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> obtenerCategoriaPorNombre(String nombre) {
        return categoriaRepository.getCategoriaByNombre(nombre);
    }

    @Override
    public List<Categoria> obtenerCategorias() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> obtenerPorId(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (!categoria.isPresent()) {
            return categoria;
        }
        throw new NoSuchElementException("No se encontró el cliente con el ID especificado\nHttpStatus: " + HttpStatus.NOT_FOUND);
    }

    @Override
    public Optional<Categoria> actualizarCategoria(Long id, Categoria categoria) {
        Optional<Categoria> categoriaById = categoriaRepository.findById(id);
        if (categoriaById.isPresent()) {
            Categoria categoriaActualizada = new Categoria();
            categoriaActualizada.setId(id);
            categoriaActualizada.setNombre(categoria.getNombre());
            categoriaActualizada.setDescripcion(categoria.getDescripcion());
            categoriaRepository.save(categoriaActualizada);
            return categoriaById;
        }
        throw new NoSuchElementException("No se encontró el cliente con el ID especificado\nHttpStatus: " + HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> registrarCategoria(Map<String, String> jsonCategoria) {
       if(validarDatos(jsonCategoria)){
           categoriaRepository.save(convertirMapaCategoria(jsonCategoria));
           return Utilidades.getResponseEntity("Proceso de guardado con exito",HttpStatus.OK);
       }
       return Utilidades.getResponseEntity("Datos invalidos",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> deleteCategoria(Long id) {
        if (id != null) {
            categoriaRepository.deleteById(id);
            return Utilidades.getResponseEntity("La categoria con el id: " + id + " se eliminó con exito", HttpStatus.OK);
        }
        return Utilidades.getResponseEntity("No se encontró la categoria con el ID especificado",HttpStatus.BAD_REQUEST);
    }
    public boolean validarDatos(Map<String,String> jsonCategoria){
        if(jsonCategoria.containsKey("nombre") && jsonCategoria.containsKey("descripcion")){
            return true;
        }
        return false;
    }

    public Categoria convertirMapaCategoria(Map<String,String> jsonCategoria){
        Categoria categoria = new Categoria();
        categoria.setNombre(jsonCategoria.get("nombre").toUpperCase());
        categoria.setDescripcion(jsonCategoria.get("descripcion").toUpperCase());
        return categoria;
    }
}
