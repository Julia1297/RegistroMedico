package com.ucbcba.RegistroMedico.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class Observacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @NotEmpty(message = "Ingrese una descripcion")
    private String descripcion;

    @NotNull
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "registro_medico_id")
    private RegistroMedico registroMedico;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public RegistroMedico getRegistroMedico() { return registroMedico; }

    public void setRegistroMedico(RegistroMedico registroMedico) { this.registroMedico = registroMedico; }
}
