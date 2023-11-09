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

import java.util.*;


@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoDao;

    @Override
    public List<Empleado> ConseguirEmpleados() {
        return (List<Empleado>) empleadoDao.findAll();
    }



    @Override
    public ResponseEntity<String> registrarEmpleado(Map<String, String> entidad) {
        try {
            if (entidad.containsKey("identificacion") && entidad.containsKey("primer_nombre") && entidad.containsKey("primer_apellido") &&
                    entidad.containsKey("fecha_nacimiento") && entidad.containsKey("telefono") &&
                    entidad.containsKey("direccion") && entidad.containsKey("usuario") &&
                    entidad.containsKey("password") && entidad.containsKey("fecha_ingreso") &&
                    entidad.containsKey("cargo") && entidad.containsKey("salario") && entidad.containsKey("estado")) {
                Empleado empleado = empleadoDao.empleadoPorUsuario(entidad.get("usuario"));
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
    public void deleteEmpleado(int id) {
        empleadoDao.deleteById(id);
    }
    public Empleado getEmpleadoFromMap(Map<String, String> entidad) {
        Empleado empleado = new Empleado();
        empleado.setIdentificacion(Integer.parseInt(entidad.get("identificacion")));
        empleado.setPrimerNombre(entidad.get("primer_nombre"));
        empleado.setSegundoNombre(entidad.get("segundo_nombre"));
        empleado.setPrimerApellido(entidad.get("primer_apellido"));
        empleado.setSegundoApellido(entidad.get("segundo_nombre"));
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

    @Override
    public ResponseEntity<String> actualizarEmpleado(int id, Map<String, String> entidad) {
        try {
            Optional<Empleado> empleadoOptional = empleadoDao.findById(id);
            if (empleadoOptional.isPresent()) {
                Empleado empleado = empleadoOptional.get();

                // Actualiza los campos si están presentes en el mapa
                if (entidad.containsKey("identificacion")) {
                    empleado.setIdentificacion(Integer.parseInt(entidad.get("identificacion")));
                }
                if (entidad.containsKey("primer_nombre")) {
                    empleado.setPrimerNombre(entidad.get("primer_nombre"));
                }
                if (entidad.containsKey("segundo_nombre")) {
                    empleado.setSegundoNombre(entidad.get("segundo_nombre"));
                }
                if (entidad.containsKey("primer_apellido")) {
                    empleado.setPrimerApellido(entidad.get("primer_apellido"));
                }
                if (entidad.containsKey("segundo_apellido")) {
                    empleado.setSegundoApellido(entidad.get("segundo_apellido"));
                }
                if (entidad.containsKey("fecha_nacimiento")) {
                    empleado.setFechaNacimiento(entidad.get("fecha_nacimiento"));
                }
                if (entidad.containsKey("telefono")) {
                    empleado.setTelefono(entidad.get("telefono"));
                }
                if (entidad.containsKey("direccion")) {
                    empleado.setDireccion(entidad.get("direccion"));
                }
                if (entidad.containsKey("usuario")) {
                    empleado.setUsuario(entidad.get("usuario"));
                }
                if (entidad.containsKey("password")) {
                    empleado.setPassword(entidad.get("password"));
                }
                if (entidad.containsKey("fecha_ingreso")) {
                    empleado.setFechaIngreso(entidad.get("fecha_ingreso"));
                }
                if (entidad.containsKey("cargo")) {
                    empleado.setCargo(entidad.get("cargo"));
                }
                if (entidad.containsKey("salario")) {
                    empleado.setSalario(Float.parseFloat(entidad.get("salario")));
                }

                empleadoDao.save(empleado);
                return Utilidades.getResponseEntity("Empleado actualizado correctamente.", HttpStatus.OK);
            } else {
                return Utilidades.getResponseEntity("Empleado no encontrado.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Utilidades.getResponseEntity(Constantes.ALGO_PASO_MAL, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
