package com.daw.basquet.demo;

public class EstadisticasPosicion {

    private String posicion;
    private double nCanastas;
    private double nAsistencias;
    private double nRebotes;

    public EstadisticasPosicion(String posicion, double nCanastas, double nAsistencias, double nRebotes) {
        this.posicion = posicion;
        this.nCanastas = nCanastas;
        this.nAsistencias = nAsistencias;
        this.nRebotes = nRebotes;
    }

    public EstadisticasPosicion() {
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public double getnCanastas() {
        return nCanastas;
    }

    public void setnCanastas(double nCanastas) {
        this.nCanastas = nCanastas;
    }

    public double getnAsistencias() {
        return nAsistencias;
    }

    public void setnAsistencias(double nAsistencias) {
        this.nAsistencias = nAsistencias;
    }

    public double getnRebotes() {
        return nRebotes;
    }

    public void setnRebotes(double nRebotes) {
        this.nRebotes = nRebotes;
    }

    @Override
    public String toString() {
        return "EstadisticasPosicion{" +
                "posicion='" + posicion + '\'' +
                ", nCanastas=" + nCanastas +
                ", nAsistencias=" + nAsistencias +
                ", nRebotes=" + nRebotes +
                '}';
    }
}
