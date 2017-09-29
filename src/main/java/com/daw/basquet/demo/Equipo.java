package com.daw.basquet.demo;


import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Equipo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nombre;

    private String localidad;
    private LocalDate fCreacion;

    public Equipo(){
    }

    public Equipo(String nombre, String localidad, LocalDate fCreacion) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.fCreacion = fCreacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipo equipo = (Equipo) o;

        if (id != null ? !id.equals(equipo.id) : equipo.id != null) return false;
        if (nombre != null ? !nombre.equals(equipo.nombre) : equipo.nombre != null) return false;
        if (localidad != null ? !localidad.equals(equipo.localidad) : equipo.localidad != null) return false;
        return fCreacion != null ? fCreacion.equals(equipo.fCreacion) : equipo.fCreacion == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (localidad != null ? localidad.hashCode() : 0);
        result = 31 * result + (fCreacion != null ? fCreacion.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public LocalDate getfCreacion() {
        return fCreacion;
    }

    public void setfCreacion(LocalDate fCreacion) {
        this.fCreacion = fCreacion;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", fCreacion=" + fCreacion +
                '}';
    }
}
