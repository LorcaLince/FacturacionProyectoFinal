package com.proyecto.crud.models.requests;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proyecto.crud.models.schemas.Producto;
import com.proyecto.crud.models.schemas.Venta;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;

public class ClienteRequest {

    private Long cliente_id;
    private String nombre;
    private String apellido;
    private long dni;

    private long edad;

    private List<com.proyecto.crud.models.schemas.Venta> Venta;

    private List<com.proyecto.crud.models.schemas.Producto> Producto;

    public ClienteRequest() {
    }

    public ClienteRequest(Long cliente_id, String nombre, String apellido, long dni, long edad) {
        this.cliente_id = cliente_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public long getEdad() {
        return edad;
    }

    public void setEdad(long edad) {
        this.edad = edad;
    }

    public List<com.proyecto.crud.models.schemas.Venta> getVenta() {
        return Venta;
    }

    public void setVenta(List<com.proyecto.crud.models.schemas.Venta> venta) {
        Venta = venta;
    }

    public List<com.proyecto.crud.models.schemas.Producto> getProducto() {
        return Producto;
    }

    public void setProducto(List<com.proyecto.crud.models.schemas.Producto> producto) {
        Producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteRequest that = (ClienteRequest) o;
        return dni == that.dni && edad == that.edad && Objects.equals(cliente_id, that.cliente_id) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(Venta, that.Venta) && Objects.equals(Producto, that.Producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente_id, nombre, apellido, dni, edad, Venta, Producto);
    }

    @Override
    public String toString() {
        return "ClienteRequest{" +
                "cliente_id=" + cliente_id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", edad=" + edad +
                ", Venta=" + Venta +
                ", Producto=" + Producto +
                '}';
    }
}
