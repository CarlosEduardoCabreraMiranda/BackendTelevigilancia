package com.example.TvBackend.Repository;

import com.example.TvBackend.Model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends CrudRepository<Cliente,Integer> {
    Cliente obtenerPorUsuario(@Param("usuario")String usuario);
}
