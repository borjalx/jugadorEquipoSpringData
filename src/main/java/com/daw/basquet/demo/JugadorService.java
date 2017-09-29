package com.daw.basquet.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquipoRepository equipoRepository;


    public void testJugador() {

        Equipo minnesota = new Equipo(
                "Timberwolves",
                "Minnesota",
                LocalDate.of(1900,03,2));

        Equipo la = new Equipo(
                "Lakers",
                "Los Ángeles",
                LocalDate.of(1890,6,22));

        Jugador borja = new Jugador("Borja",
                LocalDate.of(1998, 12, 1),
                23,
                10,
                11,
                "B",
                minnesota
                );

        Jugador bryan = new Jugador("Bryan",
                LocalDate.of(1998, 3, 27),
                9,
                9,
                9,
                "A",
                minnesota);

        Jugador mati = new Jugador("Mati",
                LocalDate.of(2028, 12, 1),
                23,
                10,
                11,
                "E",
                minnesota);

        Jugador sofia = new Jugador("Sofía",
                LocalDate.of(2022, 5, 2),
                19,
                9,
                29,
                "P",
                minnesota);

        Jugador mabel = new Jugador("Mabel",
                LocalDate.of(2030, 11, 11),
                23,
                10,
                11,
                "AP",
                minnesota);

        Jugador marc = new Jugador("Marc",
                LocalDate.of(2004, 4, 17),
                3,
                16,
                20,
                "B",
                la);

        Jugador laia = new Jugador("Laia",
                LocalDate.of(1995, 6, 2),
                29,
                0,
                2,
                "A",
                la);

        Jugador raquel = new Jugador("Raquel",
                LocalDate.of(1998, 10, 4),
                11,
                11,
                11,
                "E",
                la);

        Jugador andres = new Jugador("Andrés",
                LocalDate.of(2022, 5, 2),
                12,
                12,
                4,
                "P",
                la);

        Jugador anthony = new Jugador("Anthony",
                LocalDate.of(2010, 7, 9),
                4,
                20,
                1,
                "AP",
                la);

        equipoRepository.save(minnesota);
        equipoRepository.save(la);
        jugadorRepository.save(borja);
        jugadorRepository.save(bryan);
        jugadorRepository.save(mati);
        jugadorRepository.save(sofia);
        jugadorRepository.save(mabel);
        jugadorRepository.save(marc);
        jugadorRepository.save(laia);
        jugadorRepository.save(raquel);
        jugadorRepository.save(andres);
        jugadorRepository.save(anthony);


    }

    public void ConsultasJugador() {
        System.out.println("Jugadores que se llamen Borja = ");
        System.out.println(jugadorRepository.findByNombreEquals("Borja"));
        System.out.println("*** FIN ***");

        System.out.println("Canastas >= 12 = ");
        System.out.println(jugadorRepository.findByNCanastasGreaterThanEqual(12.3));
        System.out.println("*** FIN ***");

        System.out.println("Aistencias entre 7 y 13 = ");
        System.out.println(jugadorRepository.findByNAsistenciasBetween(7.0, 13.0));
        System.out.println("*** FIN ***");

        System.out.println("Bases = ");
        System.out.println(jugadorRepository.findByPosicion("Base"));
        System.out.println("*** FIN ***");

        System.out.println("Fecha de nacimiento < 2000 = ");
        System.out.println(jugadorRepository.findByFechaNBefore(LocalDate.of(2000, 12, 12)));
        System.out.println("*** FIN ***");

        System.out.println("Media de canastas, asistencias y rebotes por posición = ");
        System.out.println(jugadorRepository.AvgCanastasAndAvgAndAsistenciasAndRebotesGroupBOrderByPosicion());
        System.out.println("*** FIN ***");

        System.out.println("Máximas canastas, asistencias y rebotes por posición = ");
        System.out.println(jugadorRepository.MaxCanastasAsistenciasRebotesGroupByPosicion());
        System.out.println("*** FIN ***");

        System.out.println("Mínimas canastas, asistencias y rebotes por posición = ");
        System.out.println(jugadorRepository.MinCanastasAsistenciasRebotesGroupByPosicion());
        System.out.println("*** FIN ***");


    }

    public void ConsultasEquipo(){

        System.out.println("Equipos de Minnesota = ");
        System.out.println(equipoRepository.findByLocalidadEquals("Minnesota"));
        System.out.println("*** FIN ***");

        System.out.println("Jugadores por equipo = ");
        System.out.println(jugadorRepository.findByEquipoNombre("Timberwolves"));
        System.out.println("*** FIN ***");

        System.out.println("Jugador que más canastas ha realizado por equipo = ");
        Pageable topPlayer = new PageRequest(0, 1);
        System.out.println(jugadorRepository.jugadormasCanastasEquipo("Timberwolves", topPlayer));
        System.out.println(jugadorRepository.findTopByEquipoNombreOrderByNCanastasDesc("Timberwolves"));
        System.out.println("*** FIN ***");


        //Me falta acabar la consulta del jugador con mas canastas por equipo, error al hacer la query, lo otro va bien
    }
}