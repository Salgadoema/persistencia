package ar.edu.unq.epers.bichomon.backend.dao.especie;

import ar.edu.unq.epers.bichomon.backend.dao.EntityDAO;
import ar.edu.unq.epers.bichomon.backend.model.especie.Especie;

import java.sql.PreparedStatement;
import java.util.List;

public interface EspecieDAO extends EntityDAO<Especie> {
	Especie recuperar(String nombreEspecie);
}
