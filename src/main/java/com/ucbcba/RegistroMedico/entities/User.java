package com.ucbcba.RegistroMedico.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @NotEmpty(message = "Ingrese su email o un nombre de usuario")
    private String username;

    @NotNull
    @NotEmpty(message = "Ingrese su nombre")
    private String nombre;

    @NotNull
    @NotEmpty(message = "Ingrese su apellido")
    private String apellido;

    @NotNull
    @NotEmpty(message = "Ingrese su direccion")
    private String direccion;

    @NotNull(message = "Ingrese su telefono fijo")
    private Integer telefono;

    @NotNull(message = "Ingrese su numero de celular")
    private Integer celular;

    @NotNull
    @NotEmpty(message = "Ingrese su password")
    private String password;

    @NotNull
    @NotEmpty(message = "Confirme su password")
    private String passwordConfirm;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<RegistroMedico> registroMedicoList;

    private String role;

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public List<RegistroMedico> getRegistroMedicoList() {
        return registroMedicoList;
    }

    public void setRegistroMedicoList(List<RegistroMedico> registroMedicoList) { this.registroMedicoList = registroMedicoList; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public Integer getTelefono() { return telefono; }

    public void setTelefono(Integer telefono) { this.telefono = telefono; }

    public Integer getCelular() { return celular; }

    public void setCelular(Integer celular) { this.celular = celular; }
}
