package ar.edu.unq.epers.bichomon.backend.model;

import javax.persistence.*;

@Entity
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String nombre;
    private int experiencia;

    public Integer getId(){return id;}

    public String getNombre(){return nombre;}
    public void setNombre(String nombrenuevo){nombre = nombrenuevo;}

    public int getExperiencia() {return experiencia;}
    public void setExperiencia(int experiencia) {this.experiencia = experiencia;}

}
