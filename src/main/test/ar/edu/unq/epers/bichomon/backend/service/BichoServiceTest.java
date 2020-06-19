package ar.edu.unq.epers.bichomon.backend.service;




import ar.edu.unq.epers.bichomon.backend.service.bicho.BichoNoExistente;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.epers.bichomon.backend.dao.bicho.HibernateBichoDAO;
import ar.edu.unq.epers.bichomon.backend.dao.condicion.CondicionDAO;
import ar.edu.unq.epers.bichomon.backend.dao.condicion.HibernateCondicionDAO;
import ar.edu.unq.epers.bichomon.backend.dao.entrenador.EntrenadorDAO;
import ar.edu.unq.epers.bichomon.backend.dao.entrenador.HibernateEntrenadorDAO;
import ar.edu.unq.epers.bichomon.backend.dao.especie.EspecieDAO;
import ar.edu.unq.epers.bichomon.backend.dao.especie.HibernateEspecieDAO;
import ar.edu.unq.epers.bichomon.backend.dao.evolucion.EvolucionDAO;
import ar.edu.unq.epers.bichomon.backend.dao.evolucion.HibernateEvolucionDAO;
import ar.edu.unq.epers.bichomon.backend.model.condicion.Condicion;
import ar.edu.unq.epers.bichomon.backend.model.Entrenador;
import ar.edu.unq.epers.bichomon.backend.model.Evolucion;
import ar.edu.unq.epers.bichomon.backend.model.bicho.Bicho;
import ar.edu.unq.epers.bichomon.backend.model.condicion.CondicionEnergia;
import ar.edu.unq.epers.bichomon.backend.model.especie.Especie;
import ar.edu.unq.epers.bichomon.backend.model.especie.TipoBicho;
import ar.edu.unq.epers.bichomon.backend.service.bicho.BichoService;
import ar.edu.unq.epers.bichomon.backend.service.bicho.BichoServiceImpl;
import ar.edu.unq.epers.bichomon.backend.service.especie.EspecieService;
import ar.edu.unq.epers.bichomon.backend.service.especie.EspecieServiceImpl;
import ar.edu.unq.epers.bichomon.backend.service.runner.SessionFactoryProvider;
import org.junit.*;
import static org.junit.Assert.*;

import static ar.edu.unq.epers.bichomon.backend.service.runner.TransactionRunner.run;


public class BichoServiceTest {
    private EspecieDAO especieDAO = new HibernateEspecieDAO();
    private EntrenadorDAO entrenadorDAO = new HibernateEntrenadorDAO();
    private EvolucionDAO evolucionDAO = new HibernateEvolucionDAO();
    private CondicionDAO condicionDAO = new HibernateCondicionDAO();
    private HibernateBichoDAO bichoDAO = new HibernateBichoDAO();
    private BichoService service = new BichoServiceImpl(entrenadorDAO, bichoDAO);
    private EspecieService especieService = new EspecieServiceImpl(especieDAO, bichoDAO);




    @Before
    public void setUp(){

    }

    // validar si el bicho existe
    // vali si el entrenador existe
    // validar si el bicho pertenece al entrenador
    //validar si la ubicacion permite abandonar
    //abandonar
BichoNoExistente.class)
 //   public void le_digo_q_abandone_unBicho_que_no_existe_lanza_una_excepcion(){
       // Especie especie =new Especie(2, "Amarillomon", TipoBicho.ELECTRICIDAD);
  //  }


    @After
    public void borrarTodo(){
        SessionFactoryProvider.destroy();
    }

    @Test
    public void test_bicho_puede_evolucionar_si_su_especie_cumple_su_condicion_de_energia(){
        Especie especie = new Especie("Especiemon2", TipoBicho.AIRE);
        this.especieService.crearEspecie(especie);

        Especie especie2 = new Especie("Especievolucionmon", TipoBicho.AIRE);
        this.especieService.crearEspecie(especie2);

        Entrenador ashElLoco = new Entrenador();
        ashElLoco.setNombre("ash el loco");


        run(()->this.entrenadorDAO.guardar(ashElLoco));

        Bicho bicho = run(()->this.especieService.crearBicho("Especiemon2"));
        bicho.setEnergia(400);
        run(()->this.bichoDAO.guardar(bicho));

        Evolucion evolucion = new Evolucion();
        evolucion.setDesde(especie);
        evolucion.setHasta(especie2);
        Condicion condicion = new CondicionEnergia(230);
        run(()->this.condicionDAO.guardar(condicion));

        evolucion.addCondicion(condicion);

        run(()->this.evolucionDAO.guardar(evolucion));
        especie.setEvolucion(evolucion);
        run(()->this.especieDAO.actualizar(especie));

        assertTrue(service.puedeEvolucionar("ash el loco", bicho.getId()));
    }
}
