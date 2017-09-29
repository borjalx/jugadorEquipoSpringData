package com.daw.basquet.demo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Jugador {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private LocalDate fechaN;
    private double nCanastas;
    private double nRebotes;
    private double nAsistencias;
    private String posicion;

    @ManyToOne
    private Equipo equipo;

    public Jugador() {
    }

    public Jugador(String nombre, LocalDate fechaN, double nCanastas, double nRebotes, double nAsistencias, String posicion, Equipo equipo) {
        this.nombre = nombre;
        this.fechaN = fechaN;
        this.nCanastas = nCanastas;
        this.nRebotes = nRebotes;
        this.nAsistencias = nAsistencias;
        this.posicion = posicion;
        this.equipo = equipo;
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

    public LocalDate getFechaN() {
        return fechaN;
    }

    public void setFechaN(LocalDate fechaN) {
        this.fechaN = fechaN;
    }

    public double getnCanastas() {
        return nCanastas;
    }

    public void setnCanastas(double nCanastas) {
        this.nCanastas = nCanastas;
    }

    public double getnRebotes() {
        return nRebotes;
    }

    public void setnRebotes(double nRebotes) {
        this.nRebotes = nRebotes;
    }

    public double getnAsistencias() {
        return nAsistencias;
    }

    public void setnAsistencias(double nAsistencias) {
        this.nAsistencias = nAsistencias;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;

        if (Double.compare(jugador.nCanastas, nCanastas) != 0) return false;
        if (Double.compare(jugador.nRebotes, nRebotes) != 0) return false;
        if (Double.compare(jugador.nAsistencias, nAsistencias) != 0) return false;
        if (id != null ? !id.equals(jugador.id) : jugador.id != null) return false;
        if (nombre != null ? !nombre.equals(jugador.nombre) : jugador.nombre != null) return false;
        if (fechaN != null ? !fechaN.equals(jugador.fechaN) : jugador.fechaN != null) return false;
        if (posicion != null ? !posicion.equals(jugador.posicion) : jugador.posicion != null) return false;
        return equipo != null ? equipo.equals(jugador.equipo) : jugador.equipo == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (fechaN != null ? fechaN.hashCode() : 0);
        temp = Double.doubleToLongBits(nCanastas);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(nRebotes);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(nAsistencias);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (posicion != null ? posicion.hashCode() : 0);
        result = 31 * result + (equipo != null ? equipo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaN=" + fechaN +
                ", nCanastas=" + nCanastas +
                ", nRebotes=" + nRebotes +
                ", nAsistencias=" + nAsistencias +
                ", posicion='" + posicion + '\'' +
                ", equipo='" + equipo + '\'' +
                '}' + System.lineSeparator();
    }


}
