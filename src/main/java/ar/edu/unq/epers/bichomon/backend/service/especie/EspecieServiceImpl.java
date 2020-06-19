package ar.edu.unq.epers.bichomon.backend.service.especie;

import java.util.List;

import ar.edu.unq.epers.bichomon.backend.dao.bicho.BichoDAO;
import ar.edu.unq.epers.bichomon.backend.dao.especie.EspecieDAO;
import ar.edu.unq.epers.bichomon.backend.model.bicho.Bicho;
import ar.edu.unq.epers.bichomon.backend.model.especie.Especie;

import static ar.edu.unq.epers.bichomon.backend.service.runner.TransactionRunner.run;


public class EspecieServiceImpl implements EspecieService {

	private EspecieDAO especieDAO;
	private BichoDAO bichoDAO;

	public EspecieServiceImpl(EspecieDAO dao, BichoDAO bichoDAO){
		this.bichoDAO = bichoDAO;
		this.especieDAO = dao;
	}
	

	@Override
	public void crearEspecie(Especie especie){
		run(()->especieDAO.guardar(especie));
	}
	

	@Override
	public Especie getEspecie(String nombreEspecie){
		Especie especie = run(()->especieDAO.recuperar(nombreEspecie));
		if(especie == null){
			throw new EspecieNoExistente(nombreEspecie);
		}
		return especie;
	}


	@Override
	public List<Especie> getAllEspecies(){
		return run(()->especieDAO.recuperarTodos());
	}


	@Override
	public Bicho crearBicho(String nombreEspecie){
		Especie especie = especieDAO.recuperar(nombreEspecie);
		Bicho bicho = especie.crearBicho();
		especieDAO.actualizar(especie);
		bichoDAO.guardar(bicho);
		return bicho;
	}
}
