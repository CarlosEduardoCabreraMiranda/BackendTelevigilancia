package com.example.TvBackend.Repository;

import com.example.TvBackend.Model.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto,Integer>{

    @Query("SELECT p FROM Producto p JOIN p.categoria c WHERE p.nombre LIKE %:filtro% OR p.marca LIKE %:filtro% OR c.nombre LIKE %:filtro%")
    List<Producto> getProductosByNombreOrMarcaOrderByNombreDesc(@Param("filtro") String filtro);
}
