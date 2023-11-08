package com.example.TvBackend;

import com.example.TvBackend.Model.Cliente;
import com.example.TvBackend.Model.Direccion;
import com.example.TvBackend.Model.Producto;
import com.example.TvBackend.Model.Venta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Direccion direccion1 = new Direccion();
        Direccion direccion2 = new Direccion();
        List<Direccion>direcciones=new ArrayList<>();
        direccion1.setId(1);
        direccion1.setNombreCalle("CRA 32");
        direccion1.setNumeroLocal("8-85");
        direccion1.setCodigoPostal("2102");
        direccion2.setId(2);
        direccion2.setNombreCalle("Calle 8");
        direccion2.setNumeroLocal("3-43");
        direccion2.setCodigoPostal("2104");
        direcciones.add(direccion1);
        direcciones.add(direccion2);
       /* for (Direccion d:direcciones) {
            System.out.println(d.getNombreCalle());
            System.out.println(d.getNumeroLocal());
            System.out.println(d.getCodigoPostal());
        }*/
        System.out.println(direcciones);
        Venta venta1 = new Venta();
        Producto producto = new Producto();
        Producto producto2 = new Producto();
        cliente.setPrimerNombre("Juan");
        cliente.setSegundoNombre("José");
        cliente.setPrimerApellido("Urbano");
        cliente.setSegundoApellido("Perdomo");
        cliente.setFechaNacimiento("23/02/2005");
        cliente.setDireccion(direccion1);
        System.out.println(cliente.getDireccion());
        cliente.setTelefono("317 346 3133");
        cliente.setEmail("urbanoperdomoj@gmail.com");
        cliente.setUsuario("juanito123");
        cliente.setPassword("XXX");
        cliente.setOcupacion("Estudiante");
        cliente.setFechaCreacion(LocalDateTime.now());
        List productos = new ArrayList();
        producto.setCodigoProducto(12345);
        producto.setNombre("Camaras");
        producto.setCosto(1500000);
        producto2.setCodigoProducto(873485);
        producto2.setNombre("Alarmas");
        producto2.setCosto(500000);
        productos.add(producto);
        productos.add(producto2);
        venta1.setCodigo(2302);
        venta1.setCliente(cliente);
        venta1.setProducto(productos);
        System.out.println("Factura: ");
        for (int i = 0; i < productos.size(); i++) {
            System.out.print(productos.get(i) + " \n");
        }
        venta1.calcularValorTotal(productos);
        System.out.println("El total es: " +venta1.getValorTotal());

    }
}
