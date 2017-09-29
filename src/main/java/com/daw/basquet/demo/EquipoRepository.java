package com.daw.basquet.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipoRepository extends JpaRepository <Equipo, Long> {

    List<Equipo> findByLocalidadEquals(String Localidad);
/*
    @Query("select new com.daw.basquet.demo.JugadorEquipo (j.equipo, j.nombre , max(j.nCanastas))" +
            "from Jugador j group by j.equipo where j.equipo = equipo")
    List<EstadisticasPosicion> jugadorMasCanastas(String equipo);
*/
}
