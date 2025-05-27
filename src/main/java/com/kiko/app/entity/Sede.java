package com.kiko.app.entity;// Sede.java
import jakarta.persistence.*;

@Entity
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private int capacidad;

    @OneToOne
    @JoinColumn(name = "curador_id")
    private Curador curador;


    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Curador getCurador() {
        return curador;
    }

    public void setCurador(Curador curador) {
        this.curador = curador;
    }
}
