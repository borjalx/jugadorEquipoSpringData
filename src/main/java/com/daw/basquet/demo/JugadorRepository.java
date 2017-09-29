package com.daw.basquet.demo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import java.time.LocalDate;

import java.util.List;

public interface JugadorRepository extends JpaRepository <Jugador, Long> {

    List<Jugador> findByNombreEquals(String nombre);
    List<Jugador> findByNCanastasGreaterThanEqual(Double nCanastas);
    List<Jugador> findByNAsistenciasBetween(Double min, Double max);
    List<Jugador> findByPosicion(String posicion);
    List<Jugador> findByFechaNBefore(LocalDate fecha);

    @Query("select new com.daw.basquet.demo.EstadisticasPosicion (j.posicion, avg(j.nCanastas), avg(j.nAsistencias), avg(j.nRebotes)) " +
            "from Jugador j group by j.posicion")
    List<EstadisticasPosicion> AvgCanastasAndAvgAndAsistenciasAndRebotesGroupBOrderByPosicion();

    @Query("select new com.daw.basquet.demo.EstadisticasPosicion (j.posicion, max(j.nCanastas), max(j.nAsistencias), max(j.nRebotes))" +
            "from Jugador j group by j.posicion")
    List<EstadisticasPosicion> MaxCanastasAsistenciasRebotesGroupByPosicion();

    @Query("select new com.daw.basquet.demo.EstadisticasPosicion (j.posicion, min(j.nCanastas), min(j.nAsistencias), min(j.nRebotes))"+
            "from Jugador j group by j.posicion")
    List<EstadisticasPosicion> MinCanastasAsistenciasRebotesGroupByPosicion();

    List<Jugador> findByEquipoNombre(String nombre);

    @Query("select j from Jugador j where j.equipo.nombre = :nombreEquipo order by j.nCanastas desc")
    List<Jugador> jugadormasCanastasEquipo(@Param("nombreEquipo") String nombreEquipo, Pageable pageable);

    Jugador findTopByEquipoNombreOrderByNCanastasDesc(String nombreEquipo);
}
