package com.kiko.app.entity;// Exposicion.java
import jakarta.persistence.*;

@Entity
public class Exposicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "curador_id")
    private Curador curador;

    // Getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Curador getCurador() {
        return curador;
    }

    public void setCurador(Curador curador) {
        this.curador = curador;
    }
}
