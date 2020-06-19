package ar.edu.unq.epers.bichomon.backend.service;

import ar.edu.unq.epers.bichomon.backend.dao.bicho.HibernateBichoDAO;
import ar.edu.unq.epers.bichomon.backend.dao.especie.HibernateEspecieDAO;
import ar.edu.unq.epers.bichomon.backend.model.especie.Especie;
import ar.edu.unq.epers.bichomon.backend.model.especie.TipoBicho;
import ar.edu.unq.epers.bichomon.backend.service.especie.EspecieNoExistente;
import ar.edu.unq.epers.bichomon.backend.service.especie.EspecieService;
import ar.edu.unq.epers.bichomon.backend.service.especie.EspecieServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EspecieServiceTest {

    private EspecieService service =new EspecieServiceImpl(new HibernateEspecieDAO(), new HibernateBichoDAO());
    private Especie especie =new Especie("Amarillomon", TipoBicho.ELECTRICIDAD);;

    @Before
    public void setUp(){
        this.especie.setAltura(120);
        this.especie.setCantidadBichos(12);
        this.especie.setPeso(89);
        this.especie.setEnergiaIncial(12345);
    }


    @Test(expected=EspecieNoExistente.class)
    public void al_buscar_una_especie_inexistente_retorna_una_excepcion() {
        this.service.getEspecie("jorgitomon");
    }

    @Test()
    public void al_buscar_una_especie_existente_retorna_esa_especie() {
        this.service.crearEspecie(this.especie);
       Especie existente= this.service.getEspecie("Amarillomon");
        assertEquals(existente.getNombre(),"Amarillomon" );
        assertEquals(existente.getAltura(), 120);
    }



}
