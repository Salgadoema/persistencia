package ar.edu.unq.epers.bichomon.backend.service.bicho;

import ar.edu.unq.epers.bichomon.backend.model.bicho.Bicho;

public interface BichoService {
    Bicho buscar(String entrenador);
    void abandonar(String entrenador, int bicho);
    boolean puedeEvolucionar(String entrenador, long bicho);
    Bicho evolucionar(String entrenador, int bicho);
}
