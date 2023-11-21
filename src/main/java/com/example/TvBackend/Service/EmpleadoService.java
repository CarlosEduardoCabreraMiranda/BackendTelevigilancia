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

import java.time.LocalDateTime;
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
    public Optional<Empleado> ConseguirUnoPorId(int id,Empleado emp) {
        Optional<Empleado> empleado = empleadoDao.findById(id);
        if (empleado.isPresent()) {
            Empleado empleadoActualizado = new Empleado();
            empleadoActualizado.setIdentificacion(id);
            empleadoActualizado.setPrimerNombre(emp.getPrimerNombre());
            empleadoActualizado.setSegundoNombre(emp.getSegundoNombre());
            empleadoActualizado.setPrimerApellido(emp.getPrimerApellido());
            empleadoActualizado.setSegundoApellido(emp.getSegundoApellido());
            empleadoActualizado.setFechaNacimiento(emp.getFechaNacimiento());
            empleadoActualizado.setTelefono(emp.getTelefono());
            empleadoActualizado.setDireccion(emp.getDireccion());
            empleadoActualizado.setUsuario(empleado.get().getUsuario());
            empleadoActualizado.setPassword(emp.getPassword());
            empleadoActualizado.setFechaIngreso(emp.getFechaIngreso());
            empleadoActualizado.setCargo(emp.getCargo());
            empleadoActualizado.setSalario(emp.getSalario());
            empleadoActualizado.setEstado(empleado.get().getEstado());
            empleadoActualizado.setFechaCreacion(empleado.get().getFechaCreacion());
            empleadoActualizado.setFechaModificacion(LocalDateTime.now());
            empleadoDao.save(empleadoActualizado);
            return empleado;
        } else {
            throw new NoSuchElementException("No se encontró un empleado con el ID especificado");
        }
    }

    @Override
    public ResponseEntity<String> registrarEmpleado(Map<String, String> entidad) {
        try {
            if (validarInformacion(entidad)) {
                Empleado empleado = empleadoDao.empleadoPorUsuario(entidad.get("usuario"));
                if(Objects.isNull(empleado)) {
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

    public boolean validarInformacion(Map<String,String> entidad){
        if(entidad.containsKey("identificacion") && entidad.containsKey("primer_nombre") && entidad.containsKey("primer_apellido") &&
                entidad.containsKey("fecha_nacimiento") && entidad.containsKey("telefono") &&
                entidad.containsKey("direccion") && entidad.containsKey("usuario") &&
                entidad.containsKey("password") && entidad.containsKey("fecha_ingreso") &&
                entidad.containsKey("cargo") && entidad.containsKey("salario")){
            return true;
        }
        return false;
    }

    public Empleado getEmpleadoFromMap(Map<String, String> entidad) {
        Empleado empleado = new Empleado();
        empleado.setIdentificacion(Integer.parseInt(entidad.get("identificacion")));
        empleado.setPrimerNombre(entidad.get("primer_nombre"));
        empleado.setSegundoNombre(entidad.get("segundo_nombre"));
        empleado.setPrimerApellido(entidad.get("primer_apellido"));
        empleado.setSegundoApellido(entidad.get("segundo_apellido"));
        empleado.setFechaNacimiento(entidad.get("fecha_nacimiento"));
        empleado.setTelefono(entidad.get("telefono"));
        empleado.setDireccion(entidad.get("direccion"));
        empleado.setUsuario(entidad.get("usuario"));
        empleado.setPassword(entidad.get("password"));
        empleado.setFechaIngreso(entidad.get("fecha_ingreso"));
        empleado.setCargo(entidad.get("cargo"));
        empleado.setSalario(Float.parseFloat((entidad.get("salario"))));
        empleado.setFechaCreacion(LocalDateTime.now());
        empleado.setEstado(true);
        return empleado;
    }


}
