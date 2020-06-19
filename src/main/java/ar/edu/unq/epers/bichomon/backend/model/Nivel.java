package ar.edu.unq.epers.bichomon.backend.model;

import javax.persistence.*;

@Entity
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String nombre;
    private int puntosMinimo;
    private int puntosMaximo;

}
