package com.example.TvBackend.Repository;
import com.example.TvBackend.Model.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpleadoRepository extends CrudRepository<Empleado,Integer>{

        @Query("SELECT e FROM Empleado AS e WHERE e.identificacion LIKE %:filtro% OR e.primer_nombre LiKE %:filtro% OR e.primer_apellido LIKE %:filtro%")
        List<Empleado> getEmpleadosByIdentificacionOrPrimer_nombreOrPrimer_apellido(@Param("filtro") String palabraClave);
        @Query("SELECT e FROM Empleado AS e WHERE e.identificacion=:identificacion")
        Empleado getByIdentificacion (@Param("identificacion") String identificacion);
}
