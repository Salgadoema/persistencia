package ar.edu.unq.epers.bichomon.backend.model;

import ar.edu.unq.epers.bichomon.backend.model.bicho.Bicho;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String nombre;
    private List <Bicho> bichos;

}


