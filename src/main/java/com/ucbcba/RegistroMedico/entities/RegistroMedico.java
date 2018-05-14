package com.ucbcba.RegistroMedico.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
public class RegistroMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @NotEmpty(message = "Ingrese un titulo")
    private String titulo;

    @NotNull
    private Date fecha;

    @NotNull
    @NotEmpty(message = "Ingrese una descripcion")
    private String descripcion;

    @NotNull
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "registroMedico",cascade = CascadeType.ALL)
    private List<FotoRegistro> fotoRegistroList;

    @OneToMany(mappedBy = "registroMedico",cascade = CascadeType.ALL)
    private List<Observacion> observacionList;

    public List<FotoRegistro> getFotoRegistroList() {
        return fotoRegistroList;
    }

    public void setFotoRegistroList(List<FotoRegistro> fotoRegistroList) {
        this.fotoRegistroList = fotoRegistroList;
    }

    public List<Observacion> getObservacionList() {
        return observacionList;
    }

    public void setObservacionList(List<Observacion> observacionList) {
        this.observacionList = observacionList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
