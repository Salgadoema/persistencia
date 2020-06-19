package ar.edu.unq.epers.bichomon.backend.service.bicho;

import ar.edu.unq.epers.bichomon.backend.dao.bicho.BichoDAO;
import ar.edu.unq.epers.bichomon.backend.dao.entrenador.EntrenadorDAO;
import ar.edu.unq.epers.bichomon.backend.model.Entrenador;
import ar.edu.unq.epers.bichomon.backend.model.bicho.Bicho;

import static ar.edu.unq.epers.bichomon.backend.service.runner.TransactionRunner.run;

public class BichoServiceImpl implements BichoService {

    private final BichoDAO bichoDAO;
    private final EntrenadorDAO entrenadorDAO;

    public BichoServiceImpl(EntrenadorDAO entrenadorDAO, BichoDAO bichoDAO){
        this.entrenadorDAO = entrenadorDAO;
        this.bichoDAO = bichoDAO;
    }

    @Override
    public Bicho buscar(String entrenador) {
        return null;
    }

    @Override
    public void abandonar(String entrenador, int bicho) {
        // validar si el bicho existe
        // vali si el entrenador existe
        // validar si el bicho pertenece al entrenador
        //validar si la ubicacion permite abandonar
        //abandonar



    }

    @Override
    public boolean puedeEvolucionar(String nombreEntrenador, long bichoId) {
        Entrenador entrenador = run(()-> this.entrenadorDAO.recuperar(nombreEntrenador));
        Bicho bicho = run(()-> this.bichoDAO.recuperar(bichoId));






        return bicho.puedeEvolucionar();
    }

    @Override
    public Bicho evolucionar(String entrenador, int bicho) {
        return null;
    }
}
