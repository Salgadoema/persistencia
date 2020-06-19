package ar.edu.unq.epers.bichomon.backend.dao.exceptions;

public class NombreEspecieExistente extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NombreEspecieExistente(String nombre) {
        super("El nombre [" + nombre + "] ya fue utilizado");
    }

}
