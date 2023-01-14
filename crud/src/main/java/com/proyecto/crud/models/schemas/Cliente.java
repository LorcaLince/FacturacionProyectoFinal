package com.proyecto.crud.models.schemas;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "DNI")
    private long dni;

    @Column(name = "EDAD")
    private long edad;

    @JsonManagedReference
    @OneToMany(mappedBy = "clienteXD", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Venta> Venta;

    @JsonManagedReference
    @OneToMany(mappedBy = "clienteXD", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Producto> Producto;

    public Cliente() {}

    public Cliente(Long cliente_id, String nombre,String apellido,int dni, int edad) {
        this.cliente_id= cliente_id;
        this.nombre = nombre;
        this.dni = dni;
        this. edad = edad;

    }

    public Cliente(String nombre,String apellido,int dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this. edad = edad;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getDni() {
        return dni;
    }

    public long getEdad() {
        return edad;
    }

    public List<com.proyecto.crud.models.schemas.Venta> getVenta() {
        return Venta;
    }

    public List<Producto> getProducto() {
        return Producto;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void setEdad(long edad) {
        this.edad = edad;
    }

    public void setVenta(List<com.proyecto.crud.models.schemas.Venta> venta) {
        Venta = venta;
    }

    public void setProducto(List<Producto> producto) {
        Producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cliente_id == cliente.cliente_id && dni == cliente.dni && edad == cliente.edad && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(Venta, cliente.Venta) && Objects.equals(Producto, cliente.Producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente_id, nombre, apellido, dni, edad, Venta, Producto);
    }

    @Override
    public String toString() {
        return "Cliente{" +
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


