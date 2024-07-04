package com.example.demo.modelo;

import jakarta.persistence.*;



@Entity
@Table(name = "TBL_PRODUCTOCL3")
public class Modelo_producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPRODUCTOCL3")
    private Integer id;

    @Column(name = "NOMBRECL3", length = 255, nullable = false)
    private String nombre;

    @Column(name = "PRECIOVENTACL3", nullable = false)
    private Double precioVenta;

    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Column(name = "PRECIOCOMPCL3", nullable = false)
    private Double precioCompra;

    @Column(name = "ESTADOCL3", length = 255, nullable = false)
    private String estado;

    @Column(name = "DESCRIPCL3", length = 255, nullable = true)
    private String descripcion;

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

