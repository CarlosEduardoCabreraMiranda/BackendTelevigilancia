package com.example.TvBackend.Repository;

import com.example.TvBackend.Model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends CrudRepository<Producto,Integer>{
    Producto findProductByReference(@Param("referencia") String referencia);

}
