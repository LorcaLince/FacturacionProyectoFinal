package com.proyecto.crud.models.requests;

import java.util.List;
import java.util.Objects;

public class ClienteRequest {

    private Long cliente_id;
    private String nombre;
    private String apellido;
    private long dni;

    private long edad;



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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteRequest that = (ClienteRequest) o;
        return dni == that.dni && edad == that.edad && Objects.equals(cliente_id, that.cliente_id) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente_id, nombre, apellido, dni, edad);
    }

    @Override
    public String toString() {
        return "ClienteRequest{" +
                "cliente_id=" + cliente_id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", edad=" + edad +
                '}';
    }
}
