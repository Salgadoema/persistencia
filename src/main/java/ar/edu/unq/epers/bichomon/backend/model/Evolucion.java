package ar.edu.unq.epers.bichomon.backend.model;

import ar.edu.unq.epers.bichomon.backend.model.bicho.Bicho;
import ar.edu.unq.epers.bichomon.backend.model.condicion.Condicion;
import ar.edu.unq.epers.bichomon.backend.model.especie.Especie;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Evolucion {
    public int getId() {
        return id;
    }

    public Evolucion(){
        condiciones = new ArrayList<>();
    }
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private Especie desde;

    @OneToOne
    private Especie hasta;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Condicion> condiciones;

    public Especie getDesde() {
        return desde;
    }

    public void setDesde(Especie desde) {
        this.desde = desde;
    }

    public Especie getHasta() {
        return hasta;
    }

    public void setHasta(Especie hasta) {
        this.hasta = hasta;
    }

    public List<Condicion> getCondiciones() {
        return condiciones;
    }

    public void addCondicion(Condicion condicion) {
        this.condiciones.add(condicion);
    }


    public boolean puedeEvolucionar(Bicho bicho) {
        return this.condiciones.stream().allMatch(c -> c.puedeEvolucionar(bicho));
    }
}
