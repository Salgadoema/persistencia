package ar.edu.unq.epers.bichomon.backend.dao;

import ar.edu.unq.epers.bichomon.backend.dao.especie.EspecieDAO;
import ar.edu.unq.epers.bichomon.backend.dao.especie.HibernateEspecieDAO;
import ar.edu.unq.epers.bichomon.backend.dao.exceptions.NombreEspecieExistente;
import ar.edu.unq.epers.bichomon.backend.model.especie.Especie;
import ar.edu.unq.epers.bichomon.backend.model.especie.TipoBicho;
import ar.edu.unq.epers.bichomon.backend.service.runner.SessionFactoryProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static ar.edu.unq.epers.bichomon.backend.service.runner.TransactionRunner.run;
import static org.junit.Assert.*;

public class HibernateEspecieDAOTest {

    private EspecieDAO dao = new HibernateEspecieDAO();
    private Especie amarillo = new Especie("Amarillomon", TipoBicho.ELECTRICIDAD);

    @Before
    public void crearModelo() {
        amarillo.setAltura(170);
        amarillo.setPeso(69);
        amarillo.setEnergiaIncial(300);
        amarillo.setUrlFoto("/image/amarillomon.png");
    }
    @After
    public void borrarTodo(){
        SessionFactoryProvider.destroy();
    }

    @Test
    public void al_guardar_una_especie_y_recuperarla_no_cambio_su_estado() {
        run(()->this.dao.guardar(amarillo));
        Especie otroAmarillo = run(()->this.dao.recuperar("Amarillomon"));
        assertNotEquals(new Integer(0), otroAmarillo.getId());
        assertEquals(this.amarillo.getNombre(), otroAmarillo.getNombre());
        assertEquals(this.amarillo.getAltura(), otroAmarillo.getAltura());
        assertEquals(this.amarillo.getEnergiaInicial(), otroAmarillo.getEnergiaInicial());
        assertEquals(this.amarillo.getPeso(), otroAmarillo.getPeso());
        assertEquals(this.amarillo.getTipo(), otroAmarillo.getTipo());
        assertEquals(this.amarillo.getUrlFoto(), otroAmarillo.getUrlFoto());
        assertEquals(this.amarillo.getCantidadBichos(), otroAmarillo.getCantidadBichos());
        assertNotSame(amarillo, otroAmarillo);
    }

    @Test(expected=NombreEspecieExistente.class)
    public void al_guardar_dos_especies_con_el_mismo_nombre_tira_una_exception(){
        Especie mismoAmarillo = new Especie("Amarillomon", TipoBicho.ELECTRICIDAD);
        run(()->this.dao.guardar(this.amarillo));
        run(()->this.dao.guardar(mismoAmarillo));
    }

    @Test
    public void al_guardar_una_especie_y_actualizarla_al_recuperarla_cambia_su_estado() {
        run(()->this.dao.guardar(this.amarillo));

        amarillo.setPeso(120);
        amarillo.setCantidadBichos(2);
        amarillo.setAltura(120);
        run(()->this.dao.actualizar(this.amarillo));

        assertEquals(this.amarillo.getPeso(),120);


        Especie amarilloRecuperado = run(()->this.dao.recuperar("Amarillomon"));
        assertEquals(this.amarillo.getNombre(), amarilloRecuperado.getNombre());
        assertEquals(this.amarillo.getAltura(), amarilloRecuperado.getAltura());
        assertEquals(this.amarillo.getEnergiaInicial(), amarilloRecuperado.getEnergiaInicial());
        assertEquals(this.amarillo.getPeso(), amarilloRecuperado.getPeso());
        assertEquals(this.amarillo.getTipo(), amarilloRecuperado.getTipo());
        assertEquals(this.amarillo.getUrlFoto(), amarilloRecuperado.getUrlFoto());
        assertEquals(this.amarillo.getCantidadBichos(), amarilloRecuperado.getCantidadBichos());
        assertNotSame(amarillo, amarilloRecuperado);
    }

    @Test
    public void recuperar_todos_trae_todas_las_especies_ordenadas_por_nombre() {
        Especie otroAmarillo = new Especie("otroAmarillo", TipoBicho.AIRE);
        Especie naranja = new Especie("naranja", TipoBicho.AIRE);
        Especie naranja2 = new Especie("naranja2", TipoBicho.AIRE);
        run(()->this.dao.guardar(otroAmarillo));
        run(()->this.dao.guardar(naranja));
        run(()->this.dao.guardar(naranja2));

        List<Especie> especies = run(()->this.dao.recuperarTodos());

        assertEquals(3, especies.size());
        assertEquals("naranja", especies.get(0).getNombre());
        assertEquals("naranja2", especies.get(1).getNombre());
        assertEquals("otroAmarillo", especies.get(2).getNombre());
    }

    @Test()
    public void al_recuperar_una_especie_que_no_existe_devuelve_null() {
        Especie especietrucha = run(()->this.dao.recuperar("Nisman"));

        assertNull(especietrucha);
    }

}