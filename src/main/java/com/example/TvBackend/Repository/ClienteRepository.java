package com.example.TvBackend.Repository;

import com.example.TvBackend.Model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente,Integer> {
}
