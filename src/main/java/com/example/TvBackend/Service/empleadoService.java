package com.example.TvBackend.Service;


import com.example.TvBackend.Model.Empleado;
import com.example.TvBackend.Repository.EmpleadoRepository;
import com.example.TvBackend.Utilidades.Utilidades;
import com.example.TvBackend.constantes.Constantes;
import com.example.TvBackend.interfaceService.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


@Service
public class empleadoService implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoDao;

    @Override
    public List<Empleado> ConseguirEmpleados() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    public Optional<Empleado> ConseguirUnoPorId(int id) {
        Optional <Empleado> empleado = empleadoDao.findById(id);
        if(empleado.isPresent()){
            Empleado empleadoAcualizado = new Empleado();
            empleadoAcualizado.setPrimerNombre(empleado.get().getPrimerNombre());
            empleadoAcualizado.setSegundoNombre(empleado.get().getSegundoNombre());
            empleadoAcualizado.setPrimerApellido(empleado.get().getSegundoApellido());
            empleadoAcualizado.setFechaNacimiento(empleado.get().getFechaNacimiento());
            empleadoAcualizado.setTelefono(empleado.get().getTelefono());
            empleadoAcualizado.setDireccion(empleado.get().getDireccion());
            empleadoAcualizado.setPassword(empleado.get().getPassword());
            empleadoAcualizado.setFechaIngreso(empleado.get().getFechaIngreso());
            empleadoAcualizado.setCargo(empleado.get().getCargo());
            empleadoAcualizado.setSalario(empleado.get().getSalario());
            empleadoDao.save(empleadoAcualizado);
        }
        return empleado;
    }

    @Override
    public ResponseEntity<String> registrarEmpleado(Map<String, String> entidad) {
        try {
            if (entidad.containsKey("primer_nombre") && entidad.containsKey("primer_apellido") &&
                    entidad.containsKey("fecha_nacimiento") && entidad.containsKey("telefono") &&
                    entidad.containsKey("direccion") && entidad.containsKey("usuario") &&
                    entidad.containsKey("password") && entidad.containsKey("fecha_ingreso") &&
                    entidad.containsKey("cargo") && entidad.containsKey("salario")) {
                Empleado empleado = empleadoDao.obtenerPorEmail(entidad.get("usuario"));
                if (Objects.isNull(empleado)) {
                    empleadoDao.save(getEmpleadoFromMap(entidad));
                    return Utilidades.getResponseEntity("Registro Exitoso!", HttpStatus.OK);
                } else {
                    return Utilidades.getResponseEntity("Email ya existe!", HttpStatus.BAD_REQUEST);
                }
            } else {
                return Utilidades.getResponseEntity(Constantes.DATO_INVALIDO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Utilidades.getResponseEntity(Constantes.ALGO_PASO_MAL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public void delete(int id) {
        empleadoDao.deleteById(id);
    }
    public Empleado getEmpleadoFromMap(Map<String, String> entidad) {
        Empleado empleado = new Empleado();
        empleado.setPrimerNombre(entidad.get("primer_nombre"));
        empleado.setSegundoNombre(entidad.get("segundo_nombre"));
        empleado.setPrimerApellido(entidad.get("primer_apellido"));
        empleado.setFechaNacimiento(entidad.get("fecha_nacimiento"));
        empleado.setTelefono(entidad.get("telefono"));
        empleado.setDireccion(entidad.get("direccion"));
        empleado.setUsuario(entidad.get("usuario"));
        empleado.setPassword(entidad.get("password"));
        empleado.setFechaIngreso(entidad.get("fecha_ingreso"));
        empleado.setCargo(entidad.get("cargo"));
        empleado.setSalario(Float.parseFloat((entidad.get("salario"))));
        return empleado;
    }


}
