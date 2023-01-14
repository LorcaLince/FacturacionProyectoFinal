package com.proyecto.crud.models.requests;

import com.proyecto.crud.models.schemas.Cliente;

import java.util.Objects;

public class VentaRequest {
    private Long cod_venta;
    private String descripcion;
    private float precio;
    private float cantidad;

    private Cliente Cliente;



    public VentaRequest() {}
    public VentaRequest(Long cod_venta, String descripcion, int precio, int cantidad) {

        this.cod_venta= cod_venta;
        this.descripcion = descripcion;
        this.precio = precio;
        this. cantidad = cantidad;

    }

    public Long getCod_venta() {
        return cod_venta;
    }

    public void setCod_venta(Long cod_venta) {
        this.cod_venta = cod_venta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public com.proyecto.crud.models.schemas.Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(com.proyecto.crud.models.schemas.Cliente cliente) {
        Cliente = cliente;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VentaRequest that = (VentaRequest) o;
        return Float.compare(that.precio, precio) == 0 && Float.compare(that.cantidad, cantidad) == 0 && Objects.equals(cod_venta, that.cod_venta) && Objects.equals(descripcion, that.descripcion) && Objects.equals(Cliente, that.Cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_venta, descripcion, precio, cantidad, Cliente);
    }

    @Override
    public String toString() {
        return "VentaRequest{" +
                "cod_venta=" + cod_venta +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", Cliente=" + Cliente +
                '}';
    }
}