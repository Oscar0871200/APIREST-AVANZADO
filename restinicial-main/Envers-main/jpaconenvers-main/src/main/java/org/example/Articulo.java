package org.example;
import org.hibernate.annotations.Cascade;
import org.hibernate.envers.Audited;

import java.util.List;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table (name="articulo")
@Audited
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name= "denominacion")
    private String denominacion;

    @Column (name= "cantidad")
    private int cantidad;

    @Column (name= "precio")
    private int precio;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categoria = new ArrayList<Categoria>();

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.PERSIST)
    private List<DetalleFactura> detallesFactura = new ArrayList<DetalleFactura>();


    public Articulo(String denominacion, int cantidad, int precio) {
        this.denominacion = denominacion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Articulo(String denominacion, int cantidad, int precio, List<DetalleFactura> detallesFactura) {
        this.denominacion = denominacion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.detallesFactura = detallesFactura;
    }

    public Articulo () {

    }

    public List<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }

    public void setDetallesFactura(List<DetalleFactura> detallesFactura) {
        this.detallesFactura = detallesFactura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
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

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }
}