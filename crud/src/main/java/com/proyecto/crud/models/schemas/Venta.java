package com.proyecto.crud.models.schemas;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Venta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_venta;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private float precio;

    @Column(name = "CANTIDAD")
    private float cantidad;



    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente Cliente;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Producto Producto;

    public Venta() {}

    public Venta(Long cod_venta, String descripcion, int precio, int cantidad) {
        this.cod_venta= cod_venta;
        this.descripcion = descripcion;
        this.precio = precio;
        this. cantidad = cantidad;

    }

    public Venta(String descripcion, int precio, int cantidad) {
        this.descripcion = descripcion;
        this.precio = precio;
        this. cantidad = cantidad;
    }

    public Long getCod_venta() {
        return cod_venta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public float getCantidad() {
        return cantidad;
    }

    public com.proyecto.crud.models.schemas.Cliente getCliente() {
        return Cliente;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setCod_venta(Long cod_venta) {
        this.cod_venta = cod_venta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public void setCliente(com.proyecto.crud.models.schemas.Cliente cliente   ) {
        Cliente = cliente;
    }

    public void setProducto(Producto producto) {
        Producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return cod_venta == venta.cod_venta && Float.compare(venta.precio, precio) == 0 && Float.compare(venta.cantidad, cantidad) == 0 && Objects.equals(descripcion, venta.descripcion) && Objects.equals(Cliente, venta.Cliente) && Objects.equals(Producto, venta.Producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_venta, descripcion, precio, cantidad, Cliente, Producto);
    }

    @Override
    public String toString() {
        return "Venta{" +
                "cod_venta=" + cod_venta +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", Cliente=" + Cliente +
                ", Producto=" + Producto +
                '}';
    }
}
