package com.proyecto.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_producto;

    @Column(name = "NOMBRE")
    private int codigo;

    @Column(name = "APELLIDO")
    private String descripcion ;

    @Column(name = "DNI")
    private int cantidad;

    @Column(name = "EDAD")
    private int precio;

    @JsonManagedReference
    @OneToMany(mappedBy = "clienteXD", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cliente> ClientexD;

    @JsonManagedReference
    @OneToMany(mappedBy = "clienteXD", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Venta> Venta;

    public Producto() {}

    public Producto(Long cod_producto, int codigo,String descripcion, int cantidad, int precio) {
        this.cod_producto= cod_producto;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this. cantidad = cantidad;
        this. precio = precio;

    }

    public Producto(int codigo,String descripcion, Cliente clienteXD, int cantidad, int precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this. cantidad = cantidad;
        this. precio = precio;
    }

    public Long getCod_producto() {
        return cod_producto;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public List<Cliente> getClientexD() {
        return ClientexD;
    }

    public List<com.proyecto.crud.entity.Venta> getVenta() {
        return Venta;
    }

    public void setCod_producto(Long cod_producto) {
        this.cod_producto = cod_producto;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setClientexD(List<Cliente> clientexD) {
        ClientexD = clientexD;
    }

    public void setVenta(List<com.proyecto.crud.entity.Venta> venta) {
        Venta = venta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return cod_producto == producto.cod_producto && codigo == producto.codigo && cantidad == producto.cantidad && precio == producto.precio && Objects.equals(descripcion, producto.descripcion) && Objects.equals(ClientexD, producto.ClientexD) && Objects.equals(Venta, producto.Venta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_producto, codigo, descripcion, cantidad, precio, ClientexD, Venta);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "cod_producto=" + cod_producto +
                ", codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", ClientexD=" + ClientexD +
                ", Venta=" + Venta +
                '}';
    }
}
