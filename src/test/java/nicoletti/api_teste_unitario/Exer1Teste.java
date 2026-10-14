package nicoletti.api_teste_unitario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Exer1Teste {
    @ParameterizedTest
    @ValueSource(ints = {0, 2, -2, 100, Integer.MIN_VALUE})
    void numerosPares(int numero) { assertTrue(new Exer_1().validaNumeroInformado(numero)); }

    @ParameterizedTest
    @ValueSource(ints = {1, -1, 3, -3, Integer.MAX_VALUE})
    void numerosImpares(int numero) { assertFalse(new Exer_1().validaNumeroInformado(numero)); }
}
