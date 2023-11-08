package com.example.TvBackend.Repository;
import com.example.TvBackend.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmpleadoRepository extends CrudRepository<Empleado,Integer>{
    Empleado obtenerPorEmail(@Param("email")String email);

}
