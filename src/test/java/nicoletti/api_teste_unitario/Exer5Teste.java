package nicoletti.api_teste_unitario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Exer5Teste {
    @ParameterizedTest
    @CsvSource({"0,0", "4000,0", "4000.01,232", "4001,232.06", "9000,522", "9000.01,1350",
        "9001,1350.15", "25000,3750", "25000.01,6875", "25001,6875.28",
        "35000,9625", "35000.01,10500", "35001,10500.30", "40000,12000", "50000,15000", "4500.25,261.01"})
    void calculaImpostoPorFaixaELimites(double renda, double esperado) {
        assertEquals(esperado, new Exer_5().calcularImposto(renda), 0.000001);
    }
    @ParameterizedTest
    @ValueSource(doubles = {-0.01, -1, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void rendaInvalida(double renda) {
        assertThrows(IllegalArgumentException.class, () -> new Exer_5().calcularImposto(renda));
    }
    @ParameterizedTest
    @ValueSource(strings = {"SC", "PR", "RS"})
    void imprimeImpostoEmVezDeRendaLiquida(String uf) {
        assertEquals("Imposto a pagar do contribuinte: Bernardo inscrito no CPF: 11111111111 localizado em - "
            + uf + "\nImposto a pagar: R$15000,00",
            new Exer_5().impostoPagar("Bernardo", "11111111111", uf, 50000));
    }
    @Test
    void dadosDoContribuinteInvalidos() {
        Exer_5 exercicio = new Exer_5();
        assertThrows(IllegalArgumentException.class, () -> exercicio.impostoPagar(null, "123", "SC", 0));
        assertThrows(IllegalArgumentException.class, () -> exercicio.impostoPagar(" ", "123", "SC", 0));
        assertThrows(IllegalArgumentException.class, () -> exercicio.impostoPagar("Ana", null, "SC", 0));
        assertThrows(IllegalArgumentException.class, () -> exercicio.impostoPagar("Ana", " ", "SC", 0));
        assertThrows(IllegalArgumentException.class, () -> exercicio.impostoPagar("Ana", "123", null, 0));
        assertThrows(IllegalArgumentException.class, () -> exercicio.impostoPagar("Ana", "123", "SP", 0));
    }
}
