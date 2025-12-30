package je27_excessoes;

public class EstadoValidadeException extends Exception {

    public EstadoValidadeException() {
        super("O estado não foi localizado.");
    }

}
