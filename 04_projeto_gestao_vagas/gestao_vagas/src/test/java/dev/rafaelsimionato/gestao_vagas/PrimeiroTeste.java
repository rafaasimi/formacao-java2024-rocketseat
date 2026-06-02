package dev.rafaelsimionato.gestao_vagas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PrimeiroTeste {

    @Test
    public void deveSerPossivelCalcularDoisValores() {
        var result = calculate(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void deveRetornarValoresIncorretos() {
        var result = calculate(2, 3);
        assertNotEquals(4, result);
    }

    public int calculate(int a, int b) {
        return a + b;
    }

}
