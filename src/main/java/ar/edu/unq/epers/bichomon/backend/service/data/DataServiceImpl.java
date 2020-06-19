package ar.edu.unq.epers.bichomon.backend.service.data;

import ar.edu.unq.epers.bichomon.backend.dao.especie.EspecieDAO;

import ar.edu.unq.epers.bichomon.backend.dao.especie.HibernateEspecieDAO;
import ar.edu.unq.epers.bichomon.backend.model.especie.Especie;
import ar.edu.unq.epers.bichomon.backend.model.especie.TipoBicho;

public class DataServiceImpl implements DataService {

    private EspecieDAO especieDAO = new HibernateEspecieDAO();
    @Override
    public void eliminarDatos() {
        this.especieDAO.borrarTodos();
    }

    @Override
    public void crearSetDatosIniciales() {

        this.especieDAO.guardar(new Especie("Jorgitomon", TipoBicho.ELECTRICIDAD));
    }
}
