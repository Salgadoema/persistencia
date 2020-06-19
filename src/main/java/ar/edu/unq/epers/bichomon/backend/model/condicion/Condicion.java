package ar.edu.unq.epers.bichomon.backend.model.condicion;

import ar.edu.unq.epers.bichomon.backend.model.bicho.Bicho;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class Condicion {
    @Id
    @GeneratedValue
    private int id;
    protected long value;
    public Condicion(){}

    public Condicion(long value){
        this.value = value;
    }
    public abstract boolean puedeEvolucionar(Bicho bicho);
}
