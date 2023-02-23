package com.example.springweb.servicios;

import com.example.springweb.modelos.Piloto;

import java.util.List;

public interface PilotoServicio {
    List<Piloto> findAllPilotos();
    Piloto findPiloto(String id);
    Piloto createPiloto(Piloto piloto);
    Piloto updatePiloto(Piloto piloto);
    void deletePiloto(String id);
}
