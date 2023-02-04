package org_cpl_cursos.java.modelos;

import java.util.Date;

public class Usuario {
    private Long id;
    private String usuario;
    private String clave;
    private String nombre;
    private String apellidos;
    private String emilio;
    private String tlf;
    private Date nacimiento;
    private String avatar;

    public Usuario() {
    }

    public Usuario(String clave, String nombre, String emilio) {
        this.clave = clave;
        this.nombre = nombre;
        this.emilio = emilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmilio() {
        return emilio;
    }

    public void setEmilio(String emilio) {
        this.emilio = emilio;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
