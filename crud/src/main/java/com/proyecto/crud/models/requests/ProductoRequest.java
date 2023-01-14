package com.proyecto.crud.models.requests;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proyecto.crud.models.schemas.Cliente;
import com.proyecto.crud.models.schemas.Venta;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;

public class ProductoRequest {
    private Long cod_producto;
    private int codigo;
    private String descripcion ;
    private int cantidad;
    private int precio;

    private List<Cliente> ClientexD;

    private List<com.proyecto.crud.models.schemas.Venta> Venta;

    public ProductoRequest() {
    }
    public ProductoRequest(Long cod_producto, int codigo,String descripcion, int cantidad, int precio) {
        this.cod_producto= cod_producto;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this. cantidad = cantidad;
        this. precio = precio;

    }


    public Long getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(Long cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<Cliente> getClientexD() {
        return ClientexD;
    }

    public void setClientexD(List<Cliente> clientexD) {
        ClientexD = clientexD;
    }

    public List<com.proyecto.crud.models.schemas.Venta> getVenta() {
        return Venta;
    }

    public void setVenta(List<com.proyecto.crud.models.schemas.Venta> venta) {
        Venta = venta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoRequest that = (ProductoRequest) o;
        return codigo == that.codigo && cantidad == that.cantidad && precio == that.precio && Objects.equals(cod_producto, that.cod_producto) && Objects.equals(descripcion, that.descripcion) && Objects.equals(ClientexD, that.ClientexD) && Objects.equals(Venta, that.Venta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_producto, codigo, descripcion, cantidad, precio, ClientexD, Venta);
    }

    @Override
    public String toString() {
        return "ProductoRequest{" +
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
