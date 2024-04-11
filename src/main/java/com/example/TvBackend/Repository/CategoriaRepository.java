package com.example.TvBackend.Repository;

import com.example.TvBackend.Model.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    @Query(value = "SELECT * FROM categoria AS c WHERE c.nombre LIKE %?1%", nativeQuery = true)
    List<Categoria> getCategoriaByNombre(String nombre);
}
