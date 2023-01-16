package com.proyecto.crud.models.schemas;

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

    @Column(name = "codigo")
    private int codigo;

    @Column(name = "descripcion")
    private String descripcion ;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private int precio;

   /* @JsonManagedReference
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cliente> ClientexD;
*/
   /* @JsonManagedReference
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Venta> Venta;
*/
    public Producto() {}

    public Producto(Long cod_producto, int codigo,String descripcion, int cantidad, int precio) {
        this.cod_producto= cod_producto;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this. cantidad = cantidad;
        this. precio = precio;

    }

    public Producto(int codigo,String descripcion, int cantidad, int precio) {
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





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return cod_producto == producto.cod_producto && codigo == producto.codigo && cantidad == producto.cantidad && precio == producto.precio && Objects.equals(descripcion, producto.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_producto, codigo, descripcion, cantidad, precio);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "cod_producto=" + cod_producto +
                ", codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
