package com.example.TvBackend.New.dao;


import com.example.TvBackend.New.pojo.Producto;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface ProductoDao extends JpaRepository<Producto, Integer> {
    Producto findProductoByCodigo_producto(@Param("codigo") String codigo);
}
