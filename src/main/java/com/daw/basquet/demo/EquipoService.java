package com.daw.basquet.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public void testEquipo(){

        Equipo minnesota = new Equipo(
                "Timberwolves",
                "Minnesota",
                LocalDate.of(1900,03,2));

        Equipo la = new Equipo(
                "Lakers",
                "Los Ángeles",
                LocalDate.of(1890,6,22));

        equipoRepository.save(minnesota);
        equipoRepository.save(la);
    }

    /*public void ConsultasEquipo(){

        System.out.println("Equipos de Minnesota = ");
        System.out.println(equipoRepository.findByLocalidadEquals("Minnesota"));
        System.out.println("*** FIN ***");

        System.out.println("Jugadores por equipo = ");
        System.out.println(equipoRepository.JugadoresporEquipo());
        System.out.println("*** FIN ***");
    }
    */
}
