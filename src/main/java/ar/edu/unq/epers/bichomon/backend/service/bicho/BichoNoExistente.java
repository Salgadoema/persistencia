package ar.edu.unq.epers.bichomon.backend.service.bicho;


/**
 * Situación excepcional en que un bicho buscado no es
 * encontrado.
 */

public class BichoNoExistente extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BichoNoExistente(String bicho) {
        super("No se encuentra el bicho [" + bicho + "]");
    }

}
