package ar.edu.unq.epers.bichomon.backend.model.especie;

import ar.edu.unq.epers.bichomon.backend.model.Evolucion;
import ar.edu.unq.epers.bichomon.backend.model.bicho.Bicho;

import javax.persistence.*;

/**
 * Representa una {@link Especie} de bicho.
 * 
 * @author Charly Backend
 */
@Entity
public class Especie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String nombre;
	private int altura;
	private int peso;
	private TipoBicho tipo;
	private int energiaInicial;
	private String urlFoto;
	private int cantidadBichos;

	@OneToOne(fetch = FetchType.EAGER)
	private Evolucion evolucion;
	
	public Especie(){
	}
	
	public Especie(String nombre, TipoBicho tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public Especie(String nombre, int peso, int altura, int energiaInicial,TipoBicho tipo, String urlFoto,int cantidadBichos) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.altura = altura;
		this.energiaInicial = energiaInicial;
		this.peso = peso;
		this.urlFoto = urlFoto;
		this.cantidadBichos = cantidadBichos;
	}

	public Especie(String nombre, TipoBicho tipo, Evolucion evolucion){
		this(nombre, tipo);
		this.evolucion = evolucion;
	}

	/**
	 * @return el nombre de la especie (por ejemplo: Perromon)
	 */
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return la altura de todos los bichos de esta especie
	 */
	public int getAltura() {
		return this.altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	/**
	 * @return el peso de todos los bichos de esta especie
	 */
	public int getPeso() {
		return this.peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	/**
	 * @return una url que apunta al un recurso imagen el cual será
	 * utilizado para mostrar un thumbnail del bichomon por el frontend.
	 */
	public String getUrlFoto() {
		return this.urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	/**
	 * @return la cantidad de energia de poder iniciales para los bichos
	 * de esta especie.
	 */
	public int getEnergiaInicial() {
		return this.energiaInicial;
	}
	public void setEnergiaIncial(int energiaInicial) {
		this.energiaInicial = energiaInicial;
	}

	/**
	 * @return el tipo de todos los bichos de esta especie
	 */
	public TipoBicho getTipo() {
		return this.tipo;
	}
	public void setTipo(TipoBicho tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * @return la cantidad de bichos que se han creado para esta
	 * especie.
	 */
	public int getCantidadBichos() {
		return this.cantidadBichos;
	}
	public void setCantidadBichos(int i) {
		this.cantidadBichos = i;
	}

	public Integer getId() {
		return id;
	}

	public Bicho crearBicho(){
		this.cantidadBichos++;
		return new Bicho(this);
	}

	public Evolucion getEvolucion() {
		return evolucion;
	}

	public void setEvolucion(Evolucion evolucion) {
		this.evolucion = evolucion;
	}

	public boolean puedeEvolucionar(Bicho bicho) {
		return evolucion.puedeEvolucionar(bicho);
	}
}
