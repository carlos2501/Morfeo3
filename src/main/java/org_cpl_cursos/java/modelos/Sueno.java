package org_cpl_cursos.java.modelos;

import java.time.LocalDate;

public class Sueno {
    private Long id;
    private Long idCategoria;
    private String descripcion;
    private String titulo;
    private LocalDate fecha;
    private Long idPropietario;

    public Sueno() {
    }

    public Sueno(Long idCategoria, String descripcion, String titulo, LocalDate fecha, Long idPropietario) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.fecha = fecha;
        this.idPropietario = idPropietario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }
}
