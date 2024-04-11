package com.example.TvBackend.Controller;

import com.example.TvBackend.Model.Categoria;
import com.example.TvBackend.Utilidades.Utilidades;
import com.example.TvBackend.constantes.Constantes;
import com.example.TvBackend.interfaceService.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/televigilancia")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired
    ICategoriaService categoriaService;

    @GetMapping("/categoria/search")
    public List<Categoria> buscarPorNombreOMarca(String nombre){
        return categoriaService.obtenerCategoriaPorNombre(nombre.toUpperCase());
    }

    @GetMapping("/getCategorias")
    public List<Categoria> index(){
        return categoriaService.obtenerCategorias();
    }
    @GetMapping("/getCategoria/{id}")
    public Optional<Categoria> getById(@PathVariable Long id){
        return categoriaService.obtenerPorId(id);
    }
    @PostMapping("/saveCategoria")
    public ResponseEntity<String> saveCategoria(@RequestBody (required = true) Map<String,String> categoriaMap){
        try{
            return categoriaService.registrarCategoria(categoriaMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return Utilidades.getResponseEntity(Constantes.ALGO_PASO_MAL ,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/updateCategoria/{id}")
    public Optional<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
        return categoriaService.actualizarCategoria(id,categoria);
    }
    @DeleteMapping("/deleteCategoria/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return categoriaService.deleteCategoria(id);
    }
}
