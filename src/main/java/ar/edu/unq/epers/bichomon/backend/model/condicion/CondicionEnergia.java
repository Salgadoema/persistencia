package ar.edu.unq.epers.bichomon.backend.model.condicion;

import ar.edu.unq.epers.bichomon.backend.model.bicho.Bicho;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CondicionEnergia extends Condicion {
    public CondicionEnergia(){}
    public CondicionEnergia(long value) {
        super(value);
    }

    @Override
    public boolean puedeEvolucionar(Bicho bicho) {
        return bicho.getEnergia()>=this.value;
    }

}
